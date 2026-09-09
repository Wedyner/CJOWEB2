import javax.swing.JOptionPane;

public class TesteData {
    public static void main(String[] args) {
        Data data = new Data(15, 8, 2023);
        JOptionPane.showMessageDialog(null, 
            "Data inicial: " + data.getDataFormatada());
        
        String inputDia = JOptionPane.showInputDialog("Digite o novo dia (1-30):");
        String inputMes = JOptionPane.showInputDialog("Digite o novo mês (1-12):");
        String inputAno = JOptionPane.showInputDialog("Digite o novo ano (>= 1900):");
        
        try {
            int novDia = Integer.parseInt(inputDia);
            int novMes = Integer.parseInt(inputMes);
            int novAno = Integer.parseInt(inputAno);
            
            data.setData(novDia, novMes, novAno);
            
            JOptionPane.showMessageDialog(null, 
                "Nova data: " + data.getDataFormatada());
                
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, 
                "Erro! Digite apenas números válidos.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, 
                "Erro: " + e.getMessage());
        }
    }
}