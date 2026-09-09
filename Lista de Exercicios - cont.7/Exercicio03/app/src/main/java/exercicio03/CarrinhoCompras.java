import java.util.ArrayList;
import java.util.Scanner;

public class CarrinhoCompras {
    private ArrayList<ItemCarrinho> carrinho;
    private Scanner scanner;
    
    public CarrinhoCompras() {
        carrinho = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    
    public void adicionarItem() {
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        
        System.out.print("Digite o preço unitário: R$ ");
        double preco = scanner.nextDouble();
        
        System.out.print("Digite a quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // limpar buffer
        
        ItemCarrinho item = new ItemCarrinho(nome, preco, quantidade);
        carrinho.add(item);
        System.out.println("Item adicionado ao carrinho!");
    }
    
    public void exibirDetalhesCarrinho() {
        if (carrinho.isEmpty()) {
            System.out.println("Carrinho vazio.");
            return;
        }
        
        System.out.println("\n=== DETALHES DO CARRINHO ===");
        for (ItemCarrinho item : carrinho) {
            System.out.println(item);
        }
    }
    
    public void exibirValorTotal() {
        if (carrinho.isEmpty()) {
            System.out.println("Carrinho vazio. Valor total: R$ 0,00");
            return;
        }
        
        double total = 0;
        for (ItemCarrinho item : carrinho) {
            total += item.getSubtotal();
        }
        
        System.out.printf("Valor total da compra: R$ %.2f\n", total);
    }
    
    public void limparCarrinho() {
        carrinho.clear();
        System.out.println("Carrinho limpo com sucesso!");
    }
    
    public void exibirMenu() {
        char opcao;
        
        do {
            System.out.println("\n=== CARRINHO DE COMPRAS ===");
            System.out.println("a. Adicionar item ao carrinho");
            System.out.println("b. Exibir detalhes do carrinho");
            System.out.println("c. Exibir valor total da compra");
            System.out.println("d. Limpar carrinho");
            System.out.println("e. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.next().charAt(0);
            scanner.nextLine(); // limpar buffer
            
            switch (opcao) {
                case 'a':
                    adicionarItem();
                    break;
                case 'b':
                    exibirDetalhesCarrinho();
                    break;
                case 'c':
                    exibirValorTotal();
                    break;
                case 'd':
                    limparCarrinho();
                    break;
                case 'e':
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 'e');
    }
    
    public static void main(String[] args) {
        CarrinhoCompras carrinho = new CarrinhoCompras();
        carrinho.exibirMenu();
    }
}