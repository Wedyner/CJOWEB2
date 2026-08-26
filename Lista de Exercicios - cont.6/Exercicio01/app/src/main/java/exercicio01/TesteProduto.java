// Classe Principal para testar o Produto
public class TesteProduto {
    public static void main(String[] args) {
        // a. Instanciar um produto com valores predefinidos
        System.out.println("=== PRODUTO INICIAL ===");
        Produto produto = new Produto(1001, "Notebook Dell", 3500.00);
        produto.exibirDados();
        
        // b. Modificar nome e preço do produto instanciado
        System.out.println("=== PRODUTO MODIFICADO ===");
        produto.setNome("Notebook Dell Inspiron");
        produto.setPreco(3299.90);
        produto.exibirDados();
    }
}