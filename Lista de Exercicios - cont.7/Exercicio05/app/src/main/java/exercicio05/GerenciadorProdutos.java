import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorProdutos {
    private ArrayList<Produto> produtos;
    private Scanner scanner;
    
    public GerenciadorProdutos() {
        produtos = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    
    public boolean produtoExiste(int codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }
    
    public void adicionarProduto() {
        System.out.print("Digite o código do produto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // limpar buffer
        
        if (produtoExiste(codigo)) {
            System.out.println("Produto com código " + codigo + " já existe no sistema.");
            return;
        }
        
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        
        System.out.print("Digite a quantidade em estoque: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // limpar buffer
        
        Produto novoProduto = new Produto(codigo, nome);
        novoProduto.setQuantidadeEstoque(quantidade);
        produtos.add(novoProduto);
        System.out.println("Produto adicionado com sucesso!");
    }
    
    public void consultarProdutoPorCodigo() {
        System.out.print("Digite o código do produto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // limpar buffer
        
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                System.out.println("\nProduto encontrado:");
                System.out.println(produto);
                return;
            }
        }
        
        System.out.println("Produto com código " + codigo + " não encontrado.");
    }
    
    public void atualizarQuantidadeEstoque() {
        System.out.print("Digite o código do produto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // limpar buffer
        
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                System.out.print("Digite a nova quantidade em estoque: ");
                int novaQuantidade = scanner.nextInt();
                scanner.nextLine(); // limpar buffer
                
                produto.setQuantidadeEstoque(novaQuantidade);
                System.out.println("Estoque atualizado com sucesso!");
                return;
            }
        }
        
        System.out.println("Produto com código " + codigo + " não encontrado.");
    }
    
    public void listarProdutosEstoqueBaixo() {
        boolean encontrouEstoqueBaixo = false;
        System.out.println("\n=== PRODUTOS COM ESTOQUE BAIXO (Menor que 5 unidades) ===");
        
        for (Produto produto : produtos) {
            if (produto.isEstoqueBaixo()) {
                System.out.println(produto);
                encontrouEstoqueBaixo = true;
            }
        }
        
        if (!encontrouEstoqueBaixo) {
            System.out.println("Nenhum produto com estoque baixo encontrado.");
        }
    }
    
    public void exibirMenu() {
        char opcao;
        
        do {
            System.out.println("\n=== GERENCIADOR DE PRODUTOS ===");
            System.out.println("a. Adicionar produto");
            System.out.println("b. Consultar produto por código");
            System.out.println("c. Atualizar quantidade em estoque");
            System.out.println("d. Listar produtos com estoque baixo");
            System.out.println("e. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.next().charAt(0);
            scanner.nextLine(); // limpar buffer
            
            switch (opcao) {
                case 'a':
                    adicionarProduto();
                    break;
                case 'b':
                    consultarProdutoPorCodigo();
                    break;
                case 'c':
                    atualizarQuantidadeEstoque();
                    break;
                case 'd':
                    listarProdutosEstoqueBaixo();
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
        GerenciadorProdutos gerenciador = new GerenciadorProdutos();
        gerenciador.exibirMenu();
    }
}