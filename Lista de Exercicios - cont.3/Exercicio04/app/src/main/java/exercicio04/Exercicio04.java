import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String senhaCorreta = "1234";
        String senhaDigitada;
        
        System.out.println("=== SISTEMA DE AUTENTICAÇÃO ===");
        
        while (true) {
            System.out.print("Digite a senha: ");
            senhaDigitada = scanner.nextLine();
            
            if (senhaDigitada.equals(senhaCorreta)) {
                System.out.println("Senha correta! Acesso liberado.");
                break;
            } else {
                System.out.println("Senha incorreta! Tente novamente.");
            }
        }
        
        scanner.close();
    }
}