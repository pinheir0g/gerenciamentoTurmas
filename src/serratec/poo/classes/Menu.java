package serratec.poo.classes;

import java.util.Scanner;

public class Menu {
	
	public static double lerNotaProva(int prova) {
		boolean notaCerta = false;
		double nota = 0.0;
		Scanner s = new Scanner(System.in);
		
		do {
			notaCerta = false;
			System.out.println("Informe a nota da prova " + prova + ":");
			
			if (s.hasNextDouble()) {
				 nota = s.nextDouble();
			 } else {
				 nota = -1.0;
			 }
			
			s.nextLine();
			
			if (nota > 10.0 || nota < 0.0) {
				System.out.println("Nota invalida! ");
			} else {
				notaCerta = true;
			}
		}while (!notaCerta);
		return nota;
		
	}
}