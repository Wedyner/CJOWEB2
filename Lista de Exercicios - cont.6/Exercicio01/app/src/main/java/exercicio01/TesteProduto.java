<<<<<<< HEAD
public class TesteProduto {
    
}
=======
>>>>>>> f4505226750583bfbcf9d0213c2dbc9caddaae74
public class TesteProduto {
    public static void main(String[] args) {
          System.out.println("=== PRODUTO INICIAL ===");
        Produto produto = new Produto(1001, "Notebook Dell", 3500.00);
        produto.exibirDados();
        
        System.out.println("=== PRODUTO MODIFICADO ===");
        produto.setNome("Notebook Dell Inspiron");
        produto.setPreco(3299.90);
        produto.exibirDados();
    }
}