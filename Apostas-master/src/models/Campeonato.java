package models;

import java.util.List;

public class Campeonato {
    private int id;
    private String nome;
    private String local;
    private List<Jogo> jogos;

    public Campeonato(String nome) {
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

    public void setLocal(String local) {
        this.local = local;
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
