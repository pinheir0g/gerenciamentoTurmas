package serratec.poo.main;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import serratec.poo.biblioteca.Biblioteca;
import serratec.poo.classes.Aluno;

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
			}while(opcao < 1 || opcao > 8);
			
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
				boolean nota1Certa = false;
				boolean nota2Certa = false;
				boolean nota3Certa = false;
				double nota1 = 0.0;
				double nota2 = 0.0;
				double nota3 = 0.0;
				
				while (!nota1Certa) {
					System.out.println("Informe a nota da prova 1:  ");
					nota1 = s.nextDouble();
					if (nota1 > 10 || nota1 < 0) {
						System.out.println("Nota invalida! ");
					} else {
						nota1Certa = true;
					}
				}
				while (!nota2Certa) {
					System.out.println("Informe a nota da prova 2:  ");
					nota2 = s.nextDouble();
					if (nota2 > 10 || nota2 < 0) {
						System.out.println("Nota invalida! ");
					} else {
						nota2Certa = true;
					}
				}
				while (!nota3Certa) {
					System.out.println("Informe a nota da prova 3:  ");
					nota3 = s.nextDouble();
					if (nota3 > 10 || nota3 < 0) {
						System.out.println("Nota invalida! ");
					} else {
						nota3Certa = true;
					}
				}
				notas.add(nota1);
				notas.add(nota2);
				notas.add(nota3);
				
				
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
