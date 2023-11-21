package impiccato;

import java.util.Scanner;

public class Impiccato {

	public static void main(String[] args) {
		//Acquisiamo la parola che dovrà essere indovinata
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci la parola da indovinare: ");
        String parolaDaIndovinare = scanner.next();

        //questa variabile servirà per far comparire graficamente le parole man mano che si va avanti con il gioco
        String risultato = "__________";

        int scelta;
		
		 //variabile delle vite che verrà decrementata ogni volta che il ciclo ricomincia
		 int vite = 5;
		 //variabile che conterà i tentativi dell'utente
		 int contaTentativi = 0;
		 
		 //Queste variabili serviranno per far comparire graficamente l'omino dell'impiccato per poterlo rimuovere man mano che le vite finiscono
		 String testa = "O";
		 String braccioSx = "/";
		 String braccioDx = "\\";
		 String corpo = "|";
		 String gambaSx = "/";
		 String gambaDx = "\\";
        //menù
        do{
           vite--;
		   contaTentativi++;
		   System.out.println("╔══════════════════════════════════════════╗");
           System.out.println("║ 1. Prova a indovinare.                   ║");
		   System.out.println("╠══════════════════════════════════════════╣");
           System.out.println("║2. Rivela una lettera perdendo una vita   ║");
		   System.out.println("╠══════════════════════════════════════════╣");
           System.out.println("║0. Arrenditi ed esci dal programma        ║");
           System.out.println("╠══════════════════════════════════════════╣");
           System.out.println("║                                          ║");
           System.out.println("║         ┌--------------┐                 ║");
           System.out.println("║         |              |                 ║");
           System.out.println("║         |              "+testa+"                 ║");
           System.out.println("║         |             "+braccioSx+corpo+braccioDx+"                ║");
           System.out.println("║         |             "+gambaSx+" "+gambaDx+"                ║");
           System.out.println("║     ____|____                            ║");
           System.out.println("║                                          ║");
           System.out.println("║                   "+risultato+"             ║");
           System.out.println("║                                          ║");
           System.out.println("╚══════════════════════════════════════════╝");
           System.out.println("Ti rimangono ancora altre "+(vite+1)+" vite");
           System.out.print("Scegli cosa fare: ");
           scelta = scanner.nextInt();
		   
		   switch(scelta){
		   	case 1:
			   System.out.print("Prova ad indovinare: ");
			   String tentativo = scanner.next();
			   if(parolaDaIndovinare.equalsIgnoreCase(tentativo)){
			   		System.out.println("COMPLIMENTI!! Hai indovinato in "+contaTentativi+" tentativi");
			   		return;
			   }else{
			   		System.out.println("Peccato, non hai idovinato, ti rimangono ancora "+vite+" vite");
			   		if(vite == 4) {
			   			gambaDx= gambaDx.replace("\\", " ");
			   		}else if(vite == 3) {
			   			gambaSx = gambaSx.replace("/", " ");
			   		}else if(vite == 2){
			   			braccioDx = braccioDx.replace("\\", " ");
			   		}else if(vite == 1) {
			   			braccioSx = braccioSx.replace("/", " ");
			   		}else if (vite == 0) {
			   			corpo = corpo.replace("|"," ");
			 		   System.out.println("╔══════════════════════════════════════════╗");
			           System.out.println("║                                          ║");
			           System.out.println("║         ┌--------------┐                 ║");
			           System.out.println("║         |              |                 ║");
			           System.out.println("║         |              "+testa+"                 ║");
			           System.out.println("║         |             "+braccioSx+corpo+braccioDx+"                ║");
			           System.out.println("║         |             "+gambaSx+" "+gambaDx+"                ║");
			           System.out.println("║     ____|____                            ║");
			           System.out.println("║                                          ║");
			           System.out.println("║                   "+risultato+"             ║");
			           System.out.println("║                                          ║");
			           System.out.println("╚══════════════════════════════════════════╝");
			   		}
			   }
			break;
			case 2:
				int indiceRandomico;
				String parolaInDecomposizione = parolaDaIndovinare;
				indiceRandomico = (int) Math.floor(Math.random()*parolaDaIndovinare.length());
				char lettera = parolaDaIndovinare.charAt(indiceRandomico);
				String letteraCasuale =""+lettera;
				risultato = new StringBuilder(risultato).replace(indiceRandomico,indiceRandomico+1,letteraCasuale).toString(); 
				parolaInDecomposizione = new StringBuilder(parolaInDecomposizione).delete(indiceRandomico, indiceRandomico+1).toString();
				if(vite == 4) {
		   			gambaDx= gambaDx.replace("\\", " ");
		   		}else if(vite == 3) {
		   			gambaSx = gambaSx.replace("/", " ");
		   		}else if(vite == 2){
		   			braccioDx = braccioDx.replace("\\", " ");
		   		}else if(vite == 1) {
		   			braccioSx = braccioSx.replace("/", " ");
		   		}else if (vite == 0) {
		   			corpo = corpo.replace("|"," ");
		 		   System.out.println("╔══════════════════════════════════════════╗");
		           System.out.println("║                                          ║");
		           System.out.println("║         ┌--------------┐                 ║");
		           System.out.println("║         |              |                 ║");
		           System.out.println("║         |              "+testa+"                 ║");
		           System.out.println("║         |             "+braccioSx+corpo+braccioDx+"                ║");
		           System.out.println("║         |             "+gambaSx+" "+gambaDx+"                ║");
		           System.out.println("║     ____|____                            ║");
		           System.out.println("║                                          ║");
		           System.out.println("║                   "+risultato+"             ║");
		           System.out.println("║                                          ║");
		           System.out.println("╚══════════════════════════════════════════╝");
		   		}
			break;
			case 0:
				System.out.println("Peccato, la prossima volta sarai piu fortunato, la parola misteriosa era: "+parolaDaIndovinare);
				return;
			default:
				System.out.println("Inserisci un valore valido per la scelta");	
		   }
        }while(vite!=0);
        
		System.out.println("Hai finito le vite e sei stato impiccato, la parola misteriosa era: "+parolaDaIndovinare);
		}
	}
