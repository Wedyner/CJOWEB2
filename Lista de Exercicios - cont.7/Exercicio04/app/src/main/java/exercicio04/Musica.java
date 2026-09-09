public class Musica {
    private String titulo;
    private String artista;
    private int duracaoSegundos;
    
    public Musica(String titulo, String artista, int duracaoSegundos) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracaoSegundos = duracaoSegundos;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public String getArtista() {
        return artista;
    }
    
    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }
    
    public String getDuracaoFormatada() {
        int minutos = duracaoSegundos / 60;
        int segundos = duracaoSegundos % 60;
        return minutos + "m" + segundos + "s";
    }
    
    @Override
    public String toString() {
        return "Título: " + titulo + " | Artista: " + artista + " | Duração: " + getDuracaoFormatada();
    }
}