package models;

public class Resultado {
    private int id;
    private String definicao;
    private Jogo jogo;

    public Resultado(String definicao) {
        this.id += 1;
        this.definicao = definicao;
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
