package models;

import java.util.List;

public class Apostador {
    private int id;
    private String nome;
    private String cpf;
    
    public Apostador(){ }
    
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


	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
    
    

	
}
