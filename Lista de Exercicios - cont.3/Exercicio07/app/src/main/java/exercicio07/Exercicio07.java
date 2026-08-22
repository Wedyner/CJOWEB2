import java.util.Random;
import java.util.Scanner;

public class Exercicio07 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        
        // Gera dois números aleatórios entre 1 e 10
        int num1 = random.nextInt(10) + 1;
        int num2 = random.nextInt(10) + 1;
        int resultadoCorreto = num1 + num2;
        
        System.out.println("=== SISTEMA DE SEGURANÇA ===");
        System.out.println("Para acessar, resolva a operação abaixo:");
        System.out.println(num1 + " + " + num2 + " = ?");
        
        System.out.print("Digite o resultado: ");
        int respostaUsuario = scanner.nextInt();
        
        if (respostaUsuario == resultadoCorreto) {
            System.out.println("Resposta correta! Acesso liberado.");
        } else {
            System.out.println("Resposta incorreta! Acesso negado.");
            System.out.println("O resultado correto é: " + resultadoCorreto);
        }
        
        scanner.close();
    }
}