import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorAlunos {
    private ArrayList<Aluno> listaAlunos;
    private Scanner scanner;
    
    public GerenciadorAlunos() {
        listaAlunos = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    
    public void cadastrarAluno() {
        System.out.print("Digite o prontuário do aluno: ");
        String prontuario = scanner.nextLine();
        
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        
        System.out.print("Digite a nota do aluno: ");
        double nota = scanner.nextDouble();
        scanner.nextLine(); // limpar buffer
        
        Aluno novoAluno = new Aluno(prontuario, nome, nota);
        listaAlunos.add(novoAluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }
    
    public void exibirAlunosAprovados() {
        boolean encontrouAprovado = false;
        System.out.println("\n=== ALUNOS APROVADOS (Nota >= 6.0) ===");
        
        for (Aluno aluno : listaAlunos) {
            if (aluno.isAprovado()) {
                System.out.println(aluno);
                encontrouAprovado = true;
            }
        }
        
        if (!encontrouAprovado) {
            System.out.println("Nenhum aluno aprovado encontrado.");
        }
    }
    
    public void exibirMediaTurma() {
        if (listaAlunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado para calcular a média.");
            return;
        }
        
        double soma = 0;
        for (Aluno aluno : listaAlunos) {
            soma += aluno.getNota();
        }
        
        double media = soma / listaAlunos.size();
        System.out.printf("Média da turma: %.2f\n", media);
    }
    
    public void removerAlunoPorProntuario() {
        System.out.print("Digite o prontuário do aluno a ser removido: ");
        String prontuario = scanner.nextLine();
        
        boolean removido = false;
        for (int i = 0; i < listaAlunos.size(); i++) {
            if (listaAlunos.get(i).getProntuario().equals(prontuario)) {
                listaAlunos.remove(i);
                removido = true;
                System.out.println("Aluno removido com sucesso!");
                break;
            }
        }
        
        if (!removido) {
            System.out.println("Aluno com prontuário " + prontuario + " não encontrado.");
        }
    }
    
    public void exibirMenu() {
        char opcao;
        
        do {
            System.out.println("\n=== GERENCIADOR DE ALUNOS ===");
            System.out.println("a. Cadastrar aluno");
            System.out.println("b. Exibir alunos aprovados");
            System.out.println("c. Exibir média da turma");
            System.out.println("d. Remover aluno por prontuário");
            System.out.println("e. Sair do programa");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.next().charAt(0);
            scanner.nextLine(); // limpar buffer
            
            switch (opcao) {
                case 'a':
                    cadastrarAluno();
                    break;
                case 'b':
                    exibirAlunosAprovados();
                    break;
                case 'c':
                    exibirMediaTurma();
                    break;
                case 'd':
                    removerAlunoPorProntuario();
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
        GerenciadorAlunos gerenciador = new GerenciadorAlunos();
        gerenciador.exibirMenu();
    }
}