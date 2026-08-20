import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o valor da compra: R$ ");
        double valorCompra = scanner.nextDouble();
        
        // Calcular valor das prestações
        double valorPrestacao = valorCompra / 5;
        
        System.out.println("Valor de cada prestação: R$ " + valorPrestacao);
        
        scanner.close();
    }
}