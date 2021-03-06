package models;

public class Aposta {
    private int id;
    public Jogo jogo;
    private String palpite;
    private Bilhete bilhete;
    private boolean acertou;
    
    public Aposta() {
        this.id += 1;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setPalpite(String palpite) {
        this.palpite = palpite;
    }

    public String getPalpite() {
        return palpite;
    }

    public void setBilhete(Bilhete bilhete) {
        this.bilhete = bilhete;
    }

    public Bilhete getBilhete() {
        return bilhete;
    }

	public boolean getAcertou() {
		return acertou;
	}

	public void setAcertou() {
		if(this.jogo.getResultado().getDefinicao().equals(this.getPalpite())) {
            this.acertou = true;
        }
	}

	


}
