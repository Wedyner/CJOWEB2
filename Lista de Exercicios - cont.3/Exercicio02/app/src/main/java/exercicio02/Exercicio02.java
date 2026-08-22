import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o nome de um mês: ");
        String mes = scanner.nextLine().toLowerCase();
        
        switch (mes) {
            case "dezembro":
            case "janeiro":
            case "fevereiro":
                System.out.println("Verão");
                break;
            case "março":
            case "abril":
            case "maio":
                System.out.println("Outono");
                break;
            case "junho":
            case "julho":
            case "agosto":
                System.out.println("Inverno");
                break;
            case "setembro":
            case "outubro":
            case "novembro":
                System.out.println("Primavera");
                break;
            default:
                System.out.println("Mês não reconhecido!");
        }
        
        scanner.close();
    }
}