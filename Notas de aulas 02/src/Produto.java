public class Produto {
    private int codigo;
    private String nome;
    private double tamanhoPeso;
    private String cor;
    private double valor;
    private int quantidade;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getTamanhoPeso() {
        return tamanhoPeso;
    }

    public void setTamanhoPeso(double tamanhoPeso) {
        this.tamanhoPeso = tamanhoPeso;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }


    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void venderProduto(int quantidadeVendida) {
        if (quantidadeVendida <= quantidade) {
            quantidade -= quantidadeVendida;
            System.out.println(quantidadeVendida + " unidade(s) vendida(s) com sucesso!");
        } else {
            System.out.println("Estoque insuficiente!");
        }
    }

    public double aplicarDesconto(double valorTotal, int formaPagamento) {
        double valorComDesconto = valorTotal;

        if (formaPagamento == 1) {
            valorComDesconto = valorTotal * 0.95;
        }

        else if (formaPagamento == 2) {
            valorComDesconto = valorTotal;
        }

        return valorComDesconto;
    }
}
