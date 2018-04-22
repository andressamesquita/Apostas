package models;

public class Aposta {
    private int id;
    private Jogo jogo;
    private String palpite;
    private Bilhete bilhete;

    public Aposta() {
        this.id += 1;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setPalpite(String palpite) {
        this.palpite = palpite;
    }

    public String getPalpite() {
        return palpite;
    }

    public void setBilhete(Bilhete bilhete) {
        this.bilhete = bilhete;
    }

    public Bilhete getBilhete() {
        return bilhete;
    }
}
