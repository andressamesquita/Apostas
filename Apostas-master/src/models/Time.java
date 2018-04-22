package models;

public class Time {
    private int id;
    private String nome;
    private Jogo jogo;

    public Time(String nome) {
        this.nome = nome;
        this.id += 1;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public Jogo getJogo() {
        return jogo;
    }
}
