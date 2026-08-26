import javax.swing.JOptionPane;

// Classe Data
public class Data {
    // Atributos privados para encapsulamento
    private int dia;
    private int mes;
    private int ano;
    
    // Construtor - valida os valores antes de instanciar
    public Data(int dia, int mes, int ano) {
        if (validarData(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            throw new IllegalArgumentException("Data inválida! Dia: 1-30, Mês: 1-12, Ano: >= 1900");
        }
    }
    
    // Método privado para validar os dados
    private boolean validarData(int dia, int mes, int ano) {
        return (dia >= 1 && dia <= 30) && 
               (mes >= 1 && mes <= 12) && 
               (ano >= 1900);
    }
    
    // Métodos getters e setters com validação
    public int getDia() {
        return dia;
    }
    
    public void setDia(int dia) {
        if (dia >= 1 && dia <= 30) {
            this.dia = dia;
        } else {
            JOptionPane.showMessageDialog(null, "Dia inválido! Deve ser entre 1 e 30.");
        }
    }
    
    public int getMes() {
        return mes;
    }
    
    public void setMes(int mes) {
        if (mes >= 1 && mes <= 12) {
            this.mes = mes;
        } else {
            JOptionPane.showMessageDialog(null, "Mês inválido! Deve ser entre 1 e 12.");
        }
    }
    
    public int getAno() {
        return ano;
    }
    
    public void setAno(int ano) {
        if (ano >= 1900) {
            this.ano = ano;
        } else {
            JOptionPane.showMessageDialog(null, "Ano inválido! Deve ser >= 1900.");
        }
    }
    
    // Método para modificar a data completa com validação
    public void setData(int dia, int mes, int ano) {
        if (validarData(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            JOptionPane.showMessageDialog(null, "Data inválida! Verifique os valores.");
        }
    }
    
    // Método para retornar a data no formato "dd/mm/aaaa"
    public String getDataFormatada() {
        return String.format("%02d/%02d/%04d", dia, mes, ano);
    }
}