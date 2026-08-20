import java.util.Scanner;

public class Exercicio07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o peso da pessoa (em kg): ");
        double peso = scanner.nextDouble();
        
        // Calcular novo peso se engordar 15%
        double pesoEngordar = peso * 1.15;
        
        // Calcular novo peso se emagrecer 20%
        double pesoEmagrecer = peso * 0.80;
        
        System.out.println("Se engordar 15%: " + pesoEngordar + " kg");
        System.out.println("Se emagrecer 20%: " + pesoEmagrecer + " kg");
        
        scanner.close();
    }
}