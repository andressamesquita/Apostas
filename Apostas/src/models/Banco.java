package models;

import java.util.ArrayList;

public class Banco {
    private ArrayList<Jogo> jogos = new ArrayList<Jogo>();
    private ArrayList<Campeonato> campeonatos = new ArrayList<Campeonato>();
    private ArrayList<Bilhete> bilhetes = new ArrayList<Bilhete>();

    public Banco() {}
    
    
    public void criarCampeonatos(){
    	Campeonato brasileiro = new Campeonato("Brasileiro","Brasil");
    	this.campeonatos.add(brasileiro);
    	Campeonato espanhol = new Campeonato("Espanhol","Espanha");
    	this.campeonatos.add(espanhol);
    	Campeonato ingles = new Campeonato("Ingles","Inglaterra");
    	this.campeonatos.add(ingles);
    	
    }

    public void criarJogos() {
    	jogos = this.jogos;
    	jogos.add(new Jogo("Palmeiras", "Corinthians",campeonatos.get(0)));
    	jogos.add(new Jogo("Fluminense", "S�o Paulo",campeonatos.get(0)));
    	jogos.add(new Jogo("Flamengo", "Cruzeiro",campeonatos.get(0)));
    	jogos.add(new Jogo("Atl�tico Paranaense", "Botafogo",campeonatos.get(0)));
    	jogos.add(new Jogo("Bahia", "Atl�tico Mineiro",campeonatos.get(0)));
    	jogos.add(new Jogo("Vitoria", "Coritiba",campeonatos.get(0)));
    	jogos.add(new Jogo("Santos", "Paran�",campeonatos.get(0)));
    	jogos.add(new Jogo("Vasco", "Am�rica Mineiro",campeonatos.get(0)));
    	jogos.add(new Jogo("Chapecoense", "Internacional",campeonatos.get(0)));
    	jogos.add(new Jogo("Gr�mio", "Cear�",campeonatos.get(0)));
    	jogos.add(new Jogo("Real Madrid", "Barcelona",campeonatos.get(1)));
    	jogos.add(new Jogo("Atl�tico de Madrid", "Villarreal",campeonatos.get(1)));
    	jogos.add(new Jogo("Sevilla", "Valencia",campeonatos.get(1)));
    	jogos.add(new Jogo("Real Betis", "La coruna",campeonatos.get(1)));
    	jogos.add(new Jogo("Alav�s", "Espanyol",campeonatos.get(1)));
    	jogos.add(new Jogo("Real Sociedad", "Celta de Vigo",campeonatos.get(1)));
    	jogos.add(new Jogo("M�laga", "Las Palmas",campeonatos.get(1)));
    	jogos.add(new Jogo("Levante", "Getafe",campeonatos.get(1)));
    	jogos.add(new Jogo("Osasuna", "Sporting de Gij�n",campeonatos.get(1)));
    	jogos.add(new Jogo("Girona", "Legan�s",campeonatos.get(1)));
    	jogos.add(new Jogo("Manchester City", "Liverpool",campeonatos.get(2)));
    	jogos.add(new Jogo("Manchester United", "Chelsea",campeonatos.get(2)));
    	jogos.add(new Jogo("Arsenal", "Tottenham",campeonatos.get(2)));
    	jogos.add(new Jogo("Aston Vila", "Everton",campeonatos.get(2)));
    	jogos.add(new Jogo("Swansea", "Hull City",campeonatos.get(2)));
    	jogos.add(new Jogo("Sunderland", "Leicester City",campeonatos.get(2)));
    	jogos.add(new Jogo("Southampton", "West Bromwich",campeonatos.get(2)));
    	jogos.add(new Jogo("Crystal Palace", "Newcastle",campeonatos.get(2)));
    	jogos.add(new Jogo("Fulham", "Stoke City",campeonatos.get(2)));
    	jogos.add(new Jogo("Wigan", "West Ham",campeonatos.get(2)));
        
    }

    public ArrayList<Jogo> getJogos() {
        return jogos;
    }


    public ArrayList<Campeonato> getCampeonatos() {
        return campeonatos;
    }

    public void setBilhetes(ArrayList<Bilhete> bilhetes) {
        this.bilhetes = bilhetes;
    }

    public ArrayList<Bilhete> getBilhetes() {
        return bilhetes;
    }

 /*   public void setTimes(List<Time> times) {
        this.times.add(new Time("Corinthians"));
        this.times.add(new Time("Palmeiras"));
        this.times.add(new Time("S�o Paulo"));
        this.times.add(new Time("Flamengo"));

        this.times.add(new Time("Real Madrid"));
        this.times.add(new Time("Barcelona"));
        this.times.add(new Time("Sevilla"));
        this.times.add(new Time("Valencia"));
        
        
        if(this.campeonatos.get(0).getNome().equals("Brasileirao")) {
        	
            
        }else if (this.campeonatos.get(1).getNome().equals("Espanhol")) {
        	
        	
        }else if(this.campeonatos.get(2).getNome().equals("Ingles")){
        	
        }
    }

    public List<Time> getTimes() {
        return times;
    }*/
}
