package app;
import models.Aposta;
import models.Apostador;
import models.Banco;
import models.Bilhete;
import models.Campeonato;
import models.Jogo;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException{
    	List<Aposta> apostas = new ArrayList<>();
    	List<Bilhete> bilhetes = new ArrayList<>();
        Banco banco = new Banco();
       

        // TXT JAVA talvez use
        Scanner ler = new Scanner(System.in);
        FileWriter arquivo = new FileWriter("D:/TADS/3PERIODO/CORPORATIVA/Apostas-master/banco.txt");
        PrintWriter gravaArquivo = new PrintWriter(arquivo);

        System.out.println("*** Menu ***");
        System.out.println("1 - Comprar Bilhete");
        System.out.println("2 - Sair");
        int opMenu = ler.nextInt();

        if(opMenu == 1) {
        	Bilhete bilhete = new Bilhete();
        	
            System.out.println("Nome do Apostador: ");
            Apostador apostador = new Apostador(ler.next());
            System.out.println("Cpf do Apostador: ");
            apostador.setCpf(ler.next());
            Jogo jogo = new Jogo("Palmeiras", "Corinthians");
            
            for (int i = 1; i <= 5; i++) {
            	Aposta aposta = new Aposta();
                System.out.println("Aposta nº " + i);
                System.out.println(">>> Campeonato");
                System.out.println("1 - Brasileirão");
                System.out.println("2 - Espanhol");
                System.out.println("3 - Inglês");
                int opMenuCampeonato = ler.nextInt();
                
                if (opMenuCampeonato == 1){
                	System.out.println(">>> Jogos do Brasileirão");
                    //mostrar jogos
                	
                	
                	apostas.add(aposta);
                	
                	for(int z = 0; z < apostas.size(); z++) {
                		System.out.println(apostas.get(z));
                	}
                }
                
                if (opMenuCampeonato == 2){
                	System.out.println(">>> Jogos do Campeonato Espanhol");
                    //mostrar jogos
                	
                	apostas.add(aposta);
                }
                
                if (opMenuCampeonato == 3){
                	System.out.println(">>> Jogos do Campeonato Inglês");
                    //mostrar jogos
                	
                	apostas.add(aposta);
                }
                
                
            }
            bilhete.setApostas(apostas);
            bilhetes.add(bilhete);     
        }

       
        else if(opMenu == 2) {
            System.exit(0);
        }
    }
    
}
