import java.util.Scanner;

public class Exercicio05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double soma = 0;
        
        for (int i = 1; i <= 5; i++) {
            System.out.print("Digite a temperatura " + i + ": ");
            double temperatura = scanner.nextDouble();
            soma += temperatura;
        }
        
        double media = soma / 5;
        System.out.printf("Média das temperaturas: %.2f°C%n", media);
        
        scanner.close();
    }
}