package models;

import java.util.List;

public class Campeonato {
    private int id;
    private String nome;
    private String local;
    private List<Jogo> jogos;

    public Campeonato(String nome, String local) {
        this.nome = nome;
        this.local = local;
        this.id += 1;
    }
    
    

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }


    public String getLocal() {
        return local;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }

    public List<Jogo> getJogos() {
        
    	return jogos;
    }
}
