import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o custo do espetáculo teatral: R$ ");
        double custo = scanner.nextDouble();
        
        System.out.print("Digite o preço do convite: R$ ");
        double precoConvite = scanner.nextDouble();
        
        // Calcular quantidade de convites necessários
        int quantidadeConvites = (int) Math.ceil(custo / precoConvite);
        
        System.out.println("Devem ser vendidos " + quantidadeConvites + " convites.");
        
        scanner.close();
    }
}