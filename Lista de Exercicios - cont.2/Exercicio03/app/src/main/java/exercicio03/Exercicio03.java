import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o valor da diária: R$ ");
        double valorDiaria = scanner.nextDouble();
        
        System.out.print("Digite o percentual de desconto: ");
        double percentualDesconto = scanner.nextDouble();
        
        // Calcular valor com desconto
        double valorDesconto = valorDiaria * (percentualDesconto / 100);
        double valorFinal = valorDiaria - valorDesconto;
        
        System.out.println("Valor da diária com desconto: R$ " + valorFinal);
        
        scanner.close();
    }
}