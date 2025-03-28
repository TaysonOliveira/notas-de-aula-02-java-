import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Produto produto = new Produto();

        System.out.println("Digite o código do produto: ");
        produto.setCodigo(sc.nextInt());

        System.out.println("Digite o nome do produto: ");
        sc.nextLine();
        produto.setNome(sc.nextLine());

        System.out.println("Digite o tamanho/peso do produto: ");
        produto.setTamanhoPeso(sc.nextDouble());

        System.out.println("Digite a cor do produto: ");
        sc.nextLine();
        produto.setCor(sc.nextLine());

        System.out.println("Digite o valor do produto: ");
        produto.setValor(sc.nextDouble());

        System.out.println("Digite a quantidade disponível em estoque: ");
        produto.setQuantidade(sc.nextInt());

        int opcao = 0;

        while (opcao != 4) {
            System.out.println("\nMENU:");
            System.out.println("1 - Consultar Produto");
            System.out.println("2 - Vender Produto");
            System.out.println("3 - Consultar Estoque");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\nProduto: " + produto.getNome());
                    System.out.println("Valor: R$" + produto.getValor());
                    System.out.println("Estoque: " + produto.getQuantidade() + " unidades");
                    break;

                case 2:
                    System.out.print("Quantas unidades deseja vender? ");
                    int quantidadeVendida = sc.nextInt();

                    if (quantidadeVendida <= produto.getQuantidade()) {
                        produto.venderProduto(quantidadeVendida);

                        double valorTotal = produto.getValor() * quantidadeVendida;
                        System.out.println("\nValor total da venda: R$" + valorTotal);

                        System.out.println("Escolha a forma de pagamento:");
                        System.out.println("1 - Pix / Espécie / Transferência / Débito (com 5% de desconto)");
                        System.out.println("2 - Crédito (parcelado em até 3x sem juros)");
                        int formaPagamento = sc.nextInt();

                        double valorComDesconto = produto.aplicarDesconto(valorTotal, formaPagamento);

                        System.out.println("Valor com desconto: R$" + valorComDesconto);

                        switch (formaPagamento) {
                            case 1:
                                System.out.print("Valor pago: R$ ");
                                double pago = sc.nextDouble();
                                if (pago > valorComDesconto) {
                                    System.out.println("Troco: R$" + (pago - valorComDesconto));
                                } else {
                                    System.out.println("Pagamento insuficiente!");
                                }
                                break;

                            case 2:
                                System.out.println("Pagamento em até 3x no crédito. Sem juros!");
                                break;

                            default:
                                System.out.println("Opção de pagamento inválida!");
                        }
                    } else {
                        System.out.println("Estoque insuficiente para a venda!");
                    }
                    break;

                case 3:
                    System.out.println("Quantidade em estoque: " + produto.getQuantidade());
                    break;

                case 4:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }

        sc.close();
    }
}
