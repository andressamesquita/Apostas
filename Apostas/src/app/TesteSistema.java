package app;
import models.Aposta;
import javax.swing.JOptionPane;

import models.Apostador;
import models.Banco;
import models.Bilhete;
import models.Campeonato;
import models.Jogo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TesteSistema {
	public static void main(String[] args) throws IOException{
    	List<Aposta> apostas = new ArrayList<>();
    	List<Bilhete> bilhetes = new ArrayList<>();
        Banco banco = new Banco();
        banco.criarCampeonatos();
        banco.criarJogos();
        
        
        Object[] opcoes = {"Comprar Bilhete","Mostrar Bilhete", "Finalizar Rodada", "Sair"};
		Object opMenu;
		
        do {
    	    opMenu = JOptionPane.showInputDialog(null,"Menu",
					"Apostas BET", JOptionPane.PLAIN_MESSAGE, null,
					opcoes, "Comprar Bilhete");
    	   
	        //int opMenu = ler.nextInt();
	        if(opMenu == opcoes[0]) {
	        	Bilhete bilhete = new Bilhete();
	        	
	        	//confirmando ação
	        	int confirmar = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja executar esta ação?");
				
	        	//executando ações
	        	if (confirmar == JOptionPane.YES_OPTION){
					Apostador apostador = new Apostador(JOptionPane.showInputDialog(null,"Nome do Apostador", "DADOS", JOptionPane.PLAIN_MESSAGE));
					apostador.setCpf(JOptionPane.showInputDialog(null,"CPF","DADOS", JOptionPane.PLAIN_MESSAGE));
					bilhete.setApostador(apostador);
					
					for (int i = 1; i <= 5; i++) {
		            	
		            	Aposta aposta = new Aposta();
		            	int campeonato = Integer.parseInt(JOptionPane.showInputDialog(null,
		            			"1 - Brasileiro\n2 - Espanhol\n3 - Inglês\n\n\nNº referente a escolha",
		            			"CAMPEONATOS", JOptionPane.PLAIN_MESSAGE));
							                
		                
		                if (campeonato == 1){//se for brasileiro printa os jogos e escolhe o numero referente
		                	
		                	int jogo = Integer.parseInt(JOptionPane.showInputDialog(null,
		                			jogosBrasileirao(banco)+"\n\nFaça sua escolha","JOGOS DO BRASILEIRÃO",
		                			JOptionPane.PLAIN_MESSAGE));
		                	
		                	aposta.setPalpite(JOptionPane.showInputDialog(null,
			            			"CASA\nEMPATE\nFORA\n\nDigite sua opção:",
			            			"PALPITES", JOptionPane.PLAIN_MESSAGE));
		                	aposta.setJogo(banco.getJogos().get(jogo-1));
	                    	apostas.add(aposta);  	
		                	
		               }
		                
		                else if (campeonato == 2){
		                	
		                	int jogo = Integer.parseInt(JOptionPane.showInputDialog(null,
		                			jogosCampEspanhol(banco)+"\n\nFaça sua escolha","JOGOS DO CAMPEONATO ESPANHOL",
		                			JOptionPane.PLAIN_MESSAGE));
		                	
		                	aposta.setPalpite(JOptionPane.showInputDialog(null,
			            			"CASA\nEMPATE\nFORA\n\nDigite sua opção:",
			            			"PALPITES", JOptionPane.PLAIN_MESSAGE));
		                	aposta.setJogo(banco.getJogos().get(jogo+9));
	                    	apostas.add(aposta);
		                }
		                
		                else if (campeonato == 3){
	                	
		                	int jogo = Integer.parseInt(JOptionPane.showInputDialog(null,
		                			jogosCampIngles(banco)+"\n\nFaça sua escolha","JOGOS DO CAMPEONATO INGLÊS",
		                			JOptionPane.PLAIN_MESSAGE));
		                	
		                	aposta.setPalpite(JOptionPane.showInputDialog(null,
			            			"CASA\nEMPATE\nFORA\n\nDigite sua opção:",
			            			"PALPITES", JOptionPane.PLAIN_MESSAGE));
		                	aposta.setJogo(banco.getJogos().get(jogo+19));
	                    	apostas.add(aposta);
		                }	              
		    
					}	            
					
	        	}
	        	bilhete.setApostas(apostas);
	            bilhetes.add(bilhete);	
	            JOptionPane.showMessageDialog(null, "Apostas feitas com sucesso!\n Fique de olho no bilhete!");
	        }
        	
	        else if(opMenu == opcoes[1]) {
	        	
	        	JOptionPane.showMessageDialog(null, mostrarBilhetes(bilhetes),"BILHETE",JOptionPane.PLAIN_MESSAGE);
        	}

        }while(opMenu == null || opMenu != "Sair");
   }
	
	private static String jogosBrasileirao(Banco banco){
		String jogosCampeonatos ="";
		
		//ajeitar o loop do for
		for ( int j = 0; j< banco.getJogos().size();j++){          		
    		if (banco.getJogos().get(j).getCampeonato().getNome().equals("Brasileiro")){
    			jogosCampeonatos += ((j+1) + " - " + banco.getJogos().get(j).partida() + "\n");	
    		}
    	}
		return jogosCampeonatos;
	}
	
	private static String jogosCampEspanhol(Banco banco){
		
		String jogosCampeonatos = "";
		int cont = 1;
		//ajeitar o loop do for
		for ( int j = 0; j< banco.getJogos().size();j++){          		
    		if (banco.getJogos().get(j).getCampeonato().getNome().equals("Espanhol")){
    			jogosCampeonatos += (cont + " - " + banco.getJogos().get(j).partida() + "\n");	
    			cont++;
    		}
    	}
		return jogosCampeonatos;
	}
	
	private static String jogosCampIngles(Banco banco){
		
		String jogosCampeonatos = "";
		int cont = 1;
		for ( int j = 0; j< banco.getJogos().size();j++){          		
    		if (banco.getJogos().get(j).getCampeonato().getNome().equals("Ingles")){
    			jogosCampeonatos += ((cont) + " - " + banco.getJogos().get(j).partida() + "\n");	
    			cont++;
    		}
    	}
		return jogosCampeonatos;
	}
	
	private static String mostrarBilhetes(List<Bilhete> bilhetes){
		
		String bbbb = "";
        String aaaa = "";
        int cont=0;
		
        for (int i = 0; i<bilhetes.size();i++){
        	
        	bbbb += "Nome : " + bilhetes.get(i).getApostador().getNome()+"\nCPF : " + bilhetes.get(i).getApostador().getCpf()+"\n\nAPOSTAS\n";
        	for(int j = 0; j<bilhetes.get(i).getApostas().size();j++){
        		cont++;
        		aaaa += ("Jogo : " + bilhetes.get(i).getApostas().get(j).jogo.partida()+ " - Palpite: " + bilhetes.get(i).getApostas().get(j).getPalpite()+"\n");
        	}
        	bbbb += aaaa + "\n"; 
        }
        return bbbb;
        
	}

}