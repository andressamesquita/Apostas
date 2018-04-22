package models;

import java.util.List;

public class Bilhete {
    private int id;
    private double valor = 5.00;
    private List<Aposta> apostas;
    private String nomeDoApostador;
    private String cpfDoApostador;

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

    public void setNomeDoApostador(String nomeDoApostador) {
        this.nomeDoApostador = nomeDoApostador;
    }

    public String getNomeDoApostador() {
        return nomeDoApostador;
    }

	private String getCpfDoApostador() {
		return cpfDoApostador;
	}

	private void setCpfDoApostador(String cpfDoApostador) {
		this.cpfDoApostador = cpfDoApostador;
	}
    
    
}
