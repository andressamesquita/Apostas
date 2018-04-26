package app;
import models.Aposta;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import models.Apostador;
import models.Banco;
import models.Bilhete;
import models.Resultado;

import java.awt.Dimension;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import javax.swing.JTextArea;

public class TesteSistema {
	public static void main(String[] args) {
    	List<Aposta> apostas = new ArrayList<>();
    	List<Bilhete> bilhetes = new ArrayList<>();
        Banco banco = new Banco();
        banco.criarCampeonatos();
        banco.criarJogos();
        
        
        
        Object[] opcoes = {"Comprar Bilhete","Finalizar Jogos","Mostrar Bilhete","Mostrar valor a ser pago para cada vencedor", "Sair"};
		Object opMenu;
		
        do {
    	    opMenu = JOptionPane.showInputDialog(null,"Menu", "Apostas BET", JOptionPane.PLAIN_MESSAGE, null, opcoes, "Comprar Bilhete");
    	   
	        //int opMenu = ler.nextInt();
	        if(opMenu == opcoes[0]) {
	        	
	        	//confirmando ação
	        	int confirmar = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja executar esta ação?","OPTION",JOptionPane.YES_NO_OPTION);
				
	        	//executando ações
	        	if (confirmar == JOptionPane.YES_OPTION){
	        		Bilhete bilhete = new Bilhete();
	        		
	        		Apostador apostador = new Apostador();
	        		newApostador(apostador);
	        		bilhete.setApostador(apostador);
										
					for (int i = 1; i <= 5; i++) {
		            	
		            	Aposta aposta = new Aposta();
		            	int campeonato = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Brasileiro\n2 - Espanhol\n3 - Inglês\n\n\nNº referente a escolha", "CAMPEONATOS",
		            			JOptionPane.PLAIN_MESSAGE));
							                
		                
		                if (campeonato == 1){//se for brasileiro printa os jogos e escolhe o numero referente
		                	
		                	validandoPartida(banco, aposta, apostas,"brasileiro", -1);
		                	
		               }else if (campeonato == 2){
		                	
		                	validandoPartida(banco, aposta, apostas,"espanhol", 9);
		               
		               }else if (campeonato == 3){
	                	
		                	validandoPartida(banco, aposta, apostas,"ingles", 19);
	                   }
		                
		                apostas.add(aposta);
		                
					}
					JOptionPane.showMessageDialog(null, "Apostas feitas com sucesso!\n Fique de olho no bilhete!");
					bilhete.setData(dataHorarioLocal());
		        	bilhete.setApostas(apostas);
		            bilhetes.add(bilhete);
		            apostas = new ArrayList<>();
	        	}
	        }
        	
	        else if(opMenu == opcoes[1]) {
	        	finalizarJogos(banco);    	
	        	
	       
	        }else if(opMenu == opcoes[2]){
	        	mostrandoBilhetes(bilhetes);
	        
        	}else if(opMenu == opcoes[3]){
        		distribuirValores(bilhetes);

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
	
	private static void mostrandoBilhetes(List<Bilhete> bilhetes) {
		int confirmar = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja executar esta ação?","OPTION",JOptionPane.YES_NO_OPTION);
    	
    	if (confirmar == JOptionPane.YES_OPTION){
        	JTextArea infomacoesBilhete = new JTextArea(mostrarBilhetes(bilhetes));
        	JScrollPane scrollPane = new JScrollPane(infomacoesBilhete);  
        	infomacoesBilhete.setLineWrap(true);  
        	infomacoesBilhete.setWrapStyleWord(true); 
    		scrollPane.setPreferredSize( new Dimension( 500, 400 ) );//tamanho da caixa de dialog message(largura, altura)
    		JOptionPane.showMessageDialog(null, scrollPane, "BILHETES", JOptionPane.INFORMATION_MESSAGE);
        	
    	}   	
		
	}


	private static void distribuirValores(List<Bilhete> bilhetes) {
		
		int confirmar = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja executar esta ação?","OPTION",JOptionPane.YES_NO_OPTION);
    	
    	if (confirmar == JOptionPane.YES_OPTION){
		
			double valorTotal = 0.0;
	        double valorPago = 0.0;
	        List<Bilhete> bilhetesPremiados = new ArrayList<>();
	
	        for (int i = 0; i < bilhetes.size(); i++) {
	            valorTotal += bilhetes.get(i).getValor();
	
	            for (int j = 0; j < bilhetes.get(i).getApostas().size(); j++) {
	                bilhetes.get(i).getApostas().get(j).setAcertou();
	            }
	
	            verificarBilhetePremiado(bilhetes.get(i));
	
	            if (bilhetes.get(i).getPremiado()) {
	                bilhetesPremiados.add(bilhetes.get(i));
	            }
	        }
	        if (bilhetesPremiados.size()==0){
	        	JOptionPane.showMessageDialog(null, "Não houve ganhadores");
	        }else{
	        	valorPago = (valorTotal * 0.8) / bilhetesPremiados.size();
		        
		        JOptionPane.showMessageDialog(null, "Valor a ser pago para cada apostador: R$ " + valorPago);
	        }
	        
    	}
  
	}


	private static void verificarBilhetePremiado(Bilhete bilhete) {
		
		for (int i = 0; i < bilhete.getApostas().size(); i++) {
            bilhete.getApostas().get(i).setAcertou();

            if (bilhete.getApostas().get(i).getAcertou()) {
                bilhete.setPremiado(true);
            }

            else {
                bilhete.setPremiado(false);
                break;
            }
        }
		
	}


	private static void finalizarJogos(Banco banco) {
		
		int confirmar = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja executar esta ação?","OPTION",JOptionPane.YES_NO_OPTION);
    	
    	if (confirmar == JOptionPane.YES_OPTION){
		
			banco.criarJogos();
	
	        for (int i = 0; i < 5; i++) {
	            banco.getJogos().get(i).setResultado(new Resultado("empate"));
	        }
	
	        for (int i = 5; i < 10; i++) {
	            banco.getJogos().get(i).setResultado(new Resultado("casa"));
	        }
	
	        for (int i = 10; i < 15; i++) {
	            banco.getJogos().get(i).setResultado(new Resultado("fora"));
	        }
	
	        for (int i = 15; i < 20; i++) {
	            banco.getJogos().get(i).setResultado(new Resultado("empate"));
	        }
	
	        for (int i = 20; i < 25; i++) {
	            banco.getJogos().get(i).setResultado(new Resultado("casa"));
	        }
	
	        for (int i = 25; i < 30; i++) {
	            banco.getJogos().get(i).setResultado(new Resultado("fora"));
	        }
	        JOptionPane.showMessageDialog(null, "Jogos Finalizados!"); 
    	}    
        		
	}

	private static void newApostador(Apostador apostador) {
		
		apostador.setNome(JOptionPane.showInputDialog(null,"Nome do Apostador", "DADOS", JOptionPane.PLAIN_MESSAGE));
		if(apostador.getNome().equals("")){
			while(apostador.getNome().equals("")){
				JOptionPane.showMessageDialog(null, "Campo vazio, por favor preencha corretamente.","AVISO",JOptionPane.WARNING_MESSAGE);
				apostador.setNome(JOptionPane.showInputDialog(null,"Nome do Apostador", "DADOS", JOptionPane.PLAIN_MESSAGE));
			}
		}
		
	
		apostador.setCpf(JOptionPane.showInputDialog(null,"CPF","DADOS", JOptionPane.PLAIN_MESSAGE));
		if(apostador.getCpf().equals("")){
			while(apostador.getCpf().equals("")){
				JOptionPane.showMessageDialog(null, "Campo vazio, por favor preencha corretamente.","AVISO",JOptionPane.WARNING_MESSAGE);
				apostador.setCpf(JOptionPane.showInputDialog(null,"CPF (format: xxxyyykkkaa)","DADOS", JOptionPane.PLAIN_MESSAGE));
				//validandoCpf(apostador.getCpf());
			}
		}
		
		
	
	}
	
	

	private static String dataHorarioLocal() {
		Locale locale = new Locale("pt","BR");
		GregorianCalendar calendar = new GregorianCalendar(); 
		SimpleDateFormat formatador = new SimpleDateFormat("dd' de 'MMMMM' de 'yyyy' - 'HH':'mm' h'",locale);
		return formatador.format(calendar.getTime());
		
	}

	private static String jogosBrasileirao(Banco banco){
		
		String jogosCampeonatos ="";
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
	
        
        String infoApostadorBilhete = "";
        		
        for (int i = 0; i<bilhetes.size();i++){
        	
        	String infoApostasBilhete = "";
        	infoApostadorBilhete += "\t\tBILHETE nº: "+ bilhetes.get(i).getId() +"\nNOME: " + bilhetes.get(i).getApostador().getNome()+"\nCPF: " + bilhetes.get(i).getApostador().getCpf()+"\nDATA: "+bilhetes.get(i).getData()+"\nVALOR: R$ " + bilhetes.get(i).getValor()+"\n\nAPOSTAS\n"; 
        			
        	for(int j = 0; j<bilhetes.get(i).getApostas().size();j++){
        		
        		infoApostasBilhete += ("\nJogo : " + bilhetes.get(i).getApostas().get(j).jogo.partida()+ " - Palpite: " + bilhetes.get(i).getApostas().get(j).getPalpite());
        		bilhetes.get(i).getApostas().get(j).setAcertou();//true?
        		
        		if (bilhetes.get(i).getApostas().get(j).getAcertou()) {
        			String statusAposta = "\nStatus da aposta: Acertou";
        			infoApostasBilhete += statusAposta;
        		
        		}else{
        			 String statusAposta = "\nStatus da aposta: Errou";
        			 infoApostasBilhete += statusAposta;
        		}
        		
        		
        		
        	}
        	verificarBilhetePremiado(bilhetes.get(i));
    		if(bilhetes.get(i).getPremiado()) {
    			String statusBilhete = "\nStatus do bilhete: Bilhete Premiado!!!";
    			infoApostasBilhete += statusBilhete;
    		}else{
    			String statusBilhete = "\nStatus do bilhete: Bilhete não premiado";
    			infoApostasBilhete += statusBilhete;
    		}
        	infoApostadorBilhete += infoApostasBilhete + "\n"; 
        }
        return infoApostadorBilhete;
        
	}
           

}