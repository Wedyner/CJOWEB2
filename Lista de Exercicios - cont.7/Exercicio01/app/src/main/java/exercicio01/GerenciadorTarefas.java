import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorTarefas {
    private ArrayList<Tarefa> listaTarefas;
    private Scanner scanner;
    
    public GerenciadorTarefas() {
        listaTarefas = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    
    public void adicionarTarefa() {
        System.out.print("Digite o código da tarefa: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // limpar buffer
        
        System.out.print("Digite o título da tarefa: ");
        String titulo = scanner.nextLine();
        
        Tarefa novaTarefa = new Tarefa(codigo, titulo);
        listaTarefas.add(novaTarefa);
        System.out.println("Tarefa adicionada com sucesso!");
    }
    
    public void removerTarefa() {
        System.out.print("Digite o código da tarefa a ser removida: ");
        int codigo = scanner.nextInt();
        
        boolean encontrada = false;
        for (int i = 0; i < listaTarefas.size(); i++) {
            if (listaTarefas.get(i).getCodigo() == codigo) {
                listaTarefas.remove(i);
                encontrada = true;
                System.out.println("Tarefa removida com sucesso!");
                break;
            }
        }
        
        if (!encontrada) {
            System.out.println("Tarefa com código " + codigo + " não encontrada.");
        }
    }
    
    public void listarTarefas() {
        if (listaTarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }
        
        System.out.println("\n=== LISTA DE TAREFAS ===");
        for (Tarefa tarefa : listaTarefas) {
            System.out.println(tarefa);
        }
        System.out.println("Total de tarefas: " + listaTarefas.size());
    }
    
    public void exibirMenu() {
        int opcao;
        
        do {
            System.out.println("\n=== GERENCIADOR DE TAREFAS ===");
            System.out.println("a. Adicionar uma tarefa");
            System.out.println("b. Remover uma tarefa");
            System.out.println("c. Listar todas as tarefas");
            System.out.println("d. Sair do programa");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.next().charAt(0);
            scanner.nextLine(); // limpar buffer
            
            switch (opcao) {
                case 'a':
                    adicionarTarefa();
                    break;
                case 'b':
                    removerTarefa();
                    break;
                case 'c':
                    listarTarefas();
                    break;
                case 'd':
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 'd');
    }
    
    public static void main(String[] args) {
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();
        gerenciador.exibirMenu();
    }
}