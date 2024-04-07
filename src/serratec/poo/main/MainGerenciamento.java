package serratec.poo.main;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import serratec.poo.classes.*;
import serratec.poo.utils.Biblioteca;


public class MainGerenciamento {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		List<Double> notas = new ArrayList<>();
		int opcao = -1;
		
		Biblioteca.exibeMenu();
		
		while (opcao != 8) {
			
			do {
				System.out.println(Biblioteca.exibeMenu());
				
				 if (s.hasNextInt()) {
					 opcao = s.nextInt();
				 } else {
					 opcao = -1;
				 }
				
				s.nextLine();
				
				if(opcao < 1 || opcao > 8 ) {
					System.out.println("Opção inválida!");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}while(opcao < 1 || opcao > 8 );
			
			switch(opcao) {
			case 1:
				
				System.out.println("Digite o nome do Aluno: ");
				String nome = s.nextLine();
				boolean dataCorreta = false;
				LocalDate data = null;
				while(!dataCorreta) {
					System.out.println("Digite a Data de Nascimento: (no formato dd-MM-yyyy)");
					String dataNascimento = s.nextLine();
					
					DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					
					try {
						data = LocalDate.parse(dataNascimento, df);
						dataCorreta = true;
					}catch(Exception e) {
						System.out.println("Formato de data inválido. Use o formato dd-MM-yyyy.");
					}
				}
				System.out.println("Qual é a turma do aluno? \nTurma 1, 2 ou 3");
				int turma = s.nextInt();
				
				s.nextLine();
				System.out.println("Informe as 3 notas do Aluno: ");
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				notas.add(Menu.lerNotaProva(1));
				notas.add(Menu.lerNotaProva(2));
				notas.add(Menu.lerNotaProva(3));
				
				Aluno aluno = new Aluno(nome, data, turma, notas);
				System.out.println(aluno);
				break;
				
			case 2:
				break;
			case 3:
				break;
			case 4:				
				break;
			}
		}
		s.close();
	}
}
