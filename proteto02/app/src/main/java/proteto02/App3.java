package proteto02;

import javax.swing.JOptionPane;

public class App3 {
    public static void main(String[] args) {
        try {
            int number1, number2, sum;
            
            number1 = Integer.parseInt(JOptionPane.showInputDialog("Digite um número"));
            number2 = Integer.parseInt(JOptionPane.showInputDialog("Digite outro número"));
            sum = number1 + number2;
            
            JOptionPane.showMessageDialog(null, "Soma = " + sum);
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, 
                "Erro: Por favor, digite apenas números válidos!", 
                "Erro de Entrada", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
}