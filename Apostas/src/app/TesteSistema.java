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
    	List<Aposta> apostas = new ArrayList<Aposta>();
    	List<Bilhete> bilhetes = new ArrayList<Bilhete>();
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
		                	validandoPartida(banco, aposta, apostas,"brasileiro", -1);
		               }
		                
		                else if (campeonato == 2){
		                	validandoPartida(banco, aposta, apostas,"espanhol", 9);
		                }
		                
		                else if (campeonato == 3){
		                	validandoPartida(banco, aposta, apostas,"ingles", 19);
		                }	              
		                apostas.add(aposta);
					}	            
					
	        	}
	        	bilhete.setApostas(apostas);
	            bilhetes.add(bilhete);
	            apostas = new ArrayList();
	            JOptionPane.showMessageDialog(null, "Apostas feitas com sucesso!\n Fique de olho no bilhete!");
	        }
        	
	        else if(opMenu == opcoes[1]) {
	        	JOptionPane.showMessageDialog(null, mostrarBilhetes(bilhetes),"BILHETE",JOptionPane.PLAIN_MESSAGE);
        	}
	        

        }while(opMenu == null || opMenu != "Sair");
   }
	
	private static void validandoPartida(Banco banco,Aposta aposta, List<Aposta> apostas,String campeonato, int index) {
		boolean jogoRepetido = false;
		int jogo;
		if (campeonato.equals("brasileiro")){
			jogo = Integer.parseInt(JOptionPane.showInputDialog(null,jogosBrasileirao(banco)+"\n\nFaça sua escolha","JOGOS DO BRASILEIRÃO",
	    			JOptionPane.PLAIN_MESSAGE));
		}
		else if(campeonato.equals("espanhol")){
			jogo = Integer.parseInt(JOptionPane.showInputDialog(null,jogosCampEspanhol(banco)+"\n\nFaça sua escolha","JOGOS DO CAMPEONATO ESPANHOL",
	    			JOptionPane.PLAIN_MESSAGE));
		}else{
			jogo = Integer.parseInt(JOptionPane.showInputDialog(null,jogosCampIngles(banco)+"\n\nFaça sua escolha","JOGOS DO CAMPEONATO INGLÊS",
	    			JOptionPane.PLAIN_MESSAGE));
		}
		
		if (!apostas.isEmpty()){
			for (int i = 0; i<apostas.size();i++){
				if (banco.getJogos().get(jogo + index).partida().equals(apostas.get(i).getJogo().partida())){
					jogoRepetido = true;
					break;
				}
			}
		}
		
		if (jogoRepetido){
			JOptionPane.showMessageDialog(null, "OPS, Você já apostou nesse jogo \n Tente apostar em outro");
			validandoPartida(banco, aposta, apostas,campeonato, index);
		}else{
			aposta.setPalpite(JOptionPane.showInputDialog(null,
        			"CASA\nEMPATE\nFORA\n\nDigite sua opção:",
        			"PALPITES", JOptionPane.PLAIN_MESSAGE));
        	aposta.setJogo(banco.getJogos().get(jogo + index));
		}
		
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
        String apostasBilhete = "";
        String todasApostas = "";
		
        for (int i = 0; i<bilhetes.size();i++){
        	apostasBilhete = "";
        	
        	todasApostas += "Nome : " + bilhetes.get(i).getApostador().getNome()+"\nCPF : " + bilhetes.get(i).getApostador().getCpf()+"\n\nAPOSTAS\n";
        	for(int j = 0; j<bilhetes.get(i).getApostas().size();j++){
        		apostasBilhete += ("Jogo : " + bilhetes.get(i).getApostas().get(j).getJogo().partida()+ " - Palpite: " + bilhetes.get(i).getApostas().get(j).getPalpite()+"\n");
        	}
        	todasApostas += apostasBilhete + "\n"; 
        }
        return todasApostas;
        
	}

}