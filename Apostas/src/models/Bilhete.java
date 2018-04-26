package models;

import java.util.List;

public class Bilhete {
    private int id;
    private double valor = 5.00;
    private List<Aposta> apostas;
    private Apostador apostador;
    private boolean premiado;

    public Bilhete() {
        this.id += 1;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setApostas(List<Aposta> apostas) {
        this.apostas = apostas;
    }

    public List<Aposta> getApostas() {
        return apostas;
    }

    public void setApostador(Apostador apostador) {
        this.apostador = apostador;
    }

    public Apostador getApostador() {
        return apostador;
    }

	public boolean isPremiado() {
		return premiado;
	}

	public void setPremiado(boolean premiado) {
		this.premiado = premiado;
	}

	
    
}
