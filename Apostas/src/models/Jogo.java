package models;


public class Jogo {
    private int id;
    private String timeDeCasa;
    private String timeDeFora;
    private Resultado resultado;
    private Campeonato campeonato;
    

    public Jogo(String timeDeCasa, String timeDeFora, Campeonato campeonato) {
        this.timeDeCasa = timeDeCasa;
        this.timeDeFora = timeDeFora;
        this.campeonato = campeonato;
        this.id += 1;
    }
    
    

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public Resultado getResultado() {
        return resultado;
    }



	public Campeonato getCampeonato() {
		return campeonato;
	}



	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}



	private String getTimeDeCasa() {
		return timeDeCasa;
	}



	private void setTimeDeCasa(String timeDeCasa) {
		this.timeDeCasa = timeDeCasa;
	}



	public String getTimeDeFora() {
		return timeDeFora;
	}



	public void setTimeDeFora(String timeDeFora) {
		this.timeDeFora = timeDeFora;
	}
	
	public String partida(){
		return timeDeCasa + " X " + timeDeFora;
	}
}
