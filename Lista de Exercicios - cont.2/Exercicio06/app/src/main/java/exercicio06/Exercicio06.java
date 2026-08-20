import java.util.Scanner;

public class Exercicio06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o valor do quilowatt: R$ ");
        double valorQuilowatt = scanner.nextDouble();
        
        System.out.print("Digite a quantidade consumida (em kWh): ");
        double consumo = scanner.nextDouble();
        
        // Calcular valor a pagar
        double valorPagar = valorQuilowatt * consumo;
        
        // Calcular valor com desconto de 15%
        double valorComDesconto = valorPagar * 0.85;
        
        System.out.println("Valor a pagar: R$ " + valorPagar);
        System.out.println("Valor com desconto de 15%: R$ " + valorComDesconto);
        
        scanner.close();
    }
}