public class ItemCarrinho {
    private String nomeProduto;
    private double precoUnitario;
    private int quantidade;
    
    public ItemCarrinho(String nomeProduto, double precoUnitario, int quantidade) {
        this.nomeProduto = nomeProduto;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
    }
    
    public String getNomeProduto() {
        return nomeProduto;
    }
    
    public double getPrecoUnitario() {
        return precoUnitario;
    }
    
    public int getQuantidade() {
        return quantidade;
    }
    
    public double getSubtotal() {
        return precoUnitario * quantidade;
    }
    
    @Override
    public String toString() {
        return String.format("Produto: %s | Quantidade: %d | Preço Unitário: R$ %.2f | Subtotal: R$ %.2f",
                nomeProduto, quantidade, precoUnitario, getSubtotal());
    }
}