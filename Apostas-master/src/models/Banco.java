package models;

import java.util.List;

public class Banco {
    private List<Jogo> jogos;
    private List<Campeonato> campeonatos;
    private List<Bilhete> bilhetes;
    private List<Time> times;

    public Banco() {}


    public void setJogos(List<Jogo> jogos) {
        if(this.campeonatos.get(0).getNome() == "Brasileirao") {
            
        }
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public void setCampeonatos() {
        this.campeonatos.add(new Campeonato("Brasileirao"));
        this.campeonatos.add(new Campeonato("Espanhol"));
    }

    public List<Campeonato> getCampeonatos() {
        return campeonatos;
    }

    public void setBilhetes(List<Bilhete> bilhetes) {
        this.bilhetes = bilhetes;
    }

    public List<Bilhete> getBilhetes() {
        return bilhetes;
    }

    public void setTimes(List<Time> times) {
        this.times.add(new Time("Corinthians"));
        this.times.add(new Time("Palmeiras"));
        this.times.add(new Time("São Paulo"));
        this.times.add(new Time("Flamengo"));

        this.times.add(new Time("Real Madrid"));
        this.times.add(new Time("Barcelona"));
        this.times.add(new Time("Não sei 1"));
        this.times.add(new Time("Não sei 2"));
    }

    public List<Time> getTimes() {
        return times;
    }
}
