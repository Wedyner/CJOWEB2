public class Aluno {
    private String prontuario;
    private String nome;
    private double nota;
    
    public Aluno(String prontuario, String nome, double nota) {
        this.prontuario = prontuario;
        this.nome = nome;
        this.nota = nota;
    }
    
    public String getProntuario() {
        return prontuario;
    }
    
    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public double getNota() {
        return nota;
    }
    
    public void setNota(double nota) {
        this.nota = nota;
    }
    
    public boolean isAprovado() {
        return nota >= 6.0;
    }
    
    @Override
    public String toString() {
        return "Prontuário: " + prontuario + " | Nome: " + nome + " | Nota: " + nota;
    }
}