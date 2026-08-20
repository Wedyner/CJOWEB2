import java.util.Scanner;

public class Exercicio05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite a quantidade de dólares guardados: US$ ");
        double quantDolares = scanner.nextDouble();
        
        System.out.print("Digite a cotação do dólar: R$ ");
        double cotacaoDolar = scanner.nextDouble();
        
        // Calcular valor em reais
        double valorReais = quantDolares * cotacaoDolar;
        
        System.out.println("Valor em reais: R$ " + valorReais);
        
        scanner.close();
    }
}