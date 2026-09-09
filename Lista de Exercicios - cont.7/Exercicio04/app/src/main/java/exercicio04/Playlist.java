import java.util.ArrayList;
import java.util.Scanner;

public class Playlist {
    private ArrayList<Musica> playlist;
    private Scanner scanner;
    
    public Playlist() {
        playlist = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    
    public void adicionarMusica() {
        System.out.print("Digite o título da música: ");
        String titulo = scanner.nextLine();
        
        System.out.print("Digite o nome do artista: ");
        String artista = scanner.nextLine();
        
        System.out.print("Digite a duração em segundos: ");
        int duracao = scanner.nextInt();
        scanner.nextLine(); // limpar buffer
        
        Musica musica = new Musica(titulo, artista, duracao);
        playlist.add(musica);
        System.out.println("Música adicionada à playlist!");
    }
    
    public void buscarMusicaPorTitulo() {
        System.out.print("Digite o título da música a ser buscada: ");
        String titulo = scanner.nextLine();
        
        boolean encontrada = false;
        for (Musica musica : playlist) {
            if (musica.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("\nMúsica encontrada:");
                System.out.println(musica);
                encontrada = true;
                break;
            }
        }
        
        if (!encontrada) {
            System.out.println("Música '" + titulo + "' não está na playlist.");
        }
    }
    
    public void removerMusicaPorTitulo() {
        System.out.print("Digite o título exato da música a ser removida: ");
        String titulo = scanner.nextLine();
        
        boolean removida = false;
        for (int i = 0; i < playlist.size(); i++) {
            if (playlist.get(i).getTitulo().equals(titulo)) {
                playlist.remove(i);
                removida = true;
                System.out.println("Música removida da playlist!");
                break;
            }
        }
        
        if (!removida) {
            System.out.println("Música '" + titulo + "' não encontrada na playlist.");
        }
    }
    
    public void listarPlaylistETempoTotal() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist vazia.");
            return;
        }
        
        System.out.println("\n=== PLAYLIST ===");
        int tempoTotal = 0;
        
        for (Musica musica : playlist) {
            System.out.println(musica);
            tempoTotal += musica.getDuracaoSegundos();
        }
        
        int minutos = tempoTotal / 60;
        int segundos = tempoTotal % 60;
        
        System.out.println("\nTempo total da playlist: " + minutos + " minutos e " + segundos + " segundos");
    }
    
    public void exibirMenu() {
        char opcao;
        
        do {
            System.out.println("\n=== PLAYLIST ===");
            System.out.println("a. Adicionar música");
            System.out.println("b. Buscar música por título");
            System.out.println("c. Remover música por título");
            System.out.println("d. Listar playlist e tempo total");
            System.out.println("e. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.next().charAt(0);
            scanner.nextLine(); // limpar buffer
            
            switch (opcao) {
                case 'a':
                    adicionarMusica();
                    break;
                case 'b':
                    buscarMusicaPorTitulo();
                    break;
                case 'c':
                    removerMusicaPorTitulo();
                    break;
                case 'd':
                    listarPlaylistETempoTotal();
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
        Playlist playlist = new Playlist();
        playlist.exibirMenu();
    }
}