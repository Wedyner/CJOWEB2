import java.util.Scanner;

public class Exercicio09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o valor do salário: R$ ");
        double salario = scanner.nextDouble();
        
        System.out.print("Digite o valor da primeira conta: R$ ");
        double conta1 = scanner.nextDouble();
        
        System.out.print("Digite o valor da segunda conta: R$ ");
        double conta2 = scanner.nextDouble();
        
        // Calcular contas com multa de 2%
        double conta1ComMulta = conta1 * 1.02;
        double conta2ComMulta = conta2 * 1.02;
        
        // Calcular total das contas
        double totalContas = conta1ComMulta + conta2ComMulta;
        
        // Calcular saldo restante
        double saldoRestante = salario - totalContas;
        
        System.out.println("Saldo restante: R$ " + saldoRestante);
        
        scanner.close();
    }
}