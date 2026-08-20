import java.util.Scanner;

public class Exercicio08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite a altura de cada degrau (em metros): ");
        double alturaDegrau = scanner.nextDouble();
        
        System.out.print("Digite a altura que deseja subir (em metros): ");
        double alturaDesejada = scanner.nextDouble();
        
        // Calcular quantidade de degraus necessários
        int quantidadeDegraus = (int) Math.ceil(alturaDesejada / alturaDegrau);
        
        System.out.println("Serão necessários " + quantidadeDegraus + " degraus.");
        
        scanner.close();
    }
}