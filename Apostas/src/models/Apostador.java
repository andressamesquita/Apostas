package models;

import java.util.List;

public class Apostador {
    private int id;
    private String nome;
    private String cpf;
    private Bilhete bilhete;

    public Apostador(String nome) {
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

    public void setBilhete(Bilhete bilhete) {
        this.bilhete = bilhete;
    }

    public Bilhete getBilhete() {
        return bilhete;
    }

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
    
    

	
}
