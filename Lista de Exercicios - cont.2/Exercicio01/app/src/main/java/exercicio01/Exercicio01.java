import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o peso do saco de ração em quilos: ");
        double pesoRacaoKg = scanner.nextDouble();
        
        System.out.print("Digite a quantidade de ração para o gato 1 (em gramas): ");
        double racaoGato1 = scanner.nextDouble();
        
        System.out.print("Digite a quantidade de ração para o gato 2 (em gramas): ");
        double racaoGato2 = scanner.nextDouble();
        
        // Converter peso do saco para gramas
        double pesoRacaoGramas = pesoRacaoKg * 1000;
        
        // Calcular consumo diário total em gramas
        double consumoDiario = racaoGato1 + racaoGato2;
        
        // Calcular consumo em 5 dias
        double consumo5Dias = consumoDiario * 5;
        
        // Calcular resto da ração
        double restoRacao = pesoRacaoGramas - consumo5Dias;
        
        System.out.println("Após 5 dias restarão " + restoRacao + " gramas de ração.");
        
        scanner.close();
    }
}