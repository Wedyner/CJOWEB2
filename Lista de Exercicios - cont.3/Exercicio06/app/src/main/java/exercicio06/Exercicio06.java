import java.util.Random;

public class Exercicio06 {
    public static void main(String[] args) {
        Random random = new Random();
        int idCliente = random.nextInt(100) + 1; // Números de 1 a 100
        
        System.out.println("O cliente com ID " + idCliente + " ganhou um brinde!");
    }
}