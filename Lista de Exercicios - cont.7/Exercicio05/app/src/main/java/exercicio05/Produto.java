public class Produto {
    private int codigo;
    private String nome;
    private int quantidadeEstoque;
    
    public Produto(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantidadeEstoque = 0;
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public String getNome() {
        return nome;
    }
    
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
    
    public void setQuantidadeEstoque(int quantidadeEstoque) {
        if (quantidadeEstoque >= 0) {
            this.quantidadeEstoque = quantidadeEstoque;
        } else {
            System.out.println("Quantidade não pode ser negativa.");
        }
    }
    
    public boolean isEstoqueBaixo() {
        return quantidadeEstoque < 5;
    }
    
    @Override
    public String toString() {
        return "Código: " + codigo + " | Nome: " + nome + " | Estoque: " + quantidadeEstoque;
    }
}