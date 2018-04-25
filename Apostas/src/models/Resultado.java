package models;

public class Resultado {
    private int id;
    private String definicao;
    private Jogo jogo;

    public Resultado() {
        this.id += 1;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setDefinicao(String definicao) {
        this.definicao = definicao;
    }

    public String getDefinicao() {
        return definicao;
    }


    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public Jogo getJogo() {
        return jogo;
    }
}
