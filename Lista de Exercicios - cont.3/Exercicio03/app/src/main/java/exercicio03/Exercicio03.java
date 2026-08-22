import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o valor da compra: R$ ");
        double valorCompra = scanner.nextDouble();
        
        if (valorCompra > 500.00) {
            double desconto = valorCompra * 0.15;
            double valorFinal = valorCompra - desconto;
            System.out.printf("Desconto de 15%% aplicado! Valor final: R$ %.2f%n", valorFinal);
        } else {
            System.out.printf("Valor final: R$ %.2f (sem desconto)%n", valorCompra);
        }
        
        scanner.close();
    }
}