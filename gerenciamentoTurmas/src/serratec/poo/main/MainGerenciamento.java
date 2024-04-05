package serratec.poo.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import serratec.poo.classes.Aluno;

public class MainGerenciamento {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		List<Double> notas = new ArrayList<>();
		int opcao = -1;
		
		var menu = """
					---------------------------------------
						GERENCIAMENTO DE TURMAS
					---------------------------------------
					1 - Cadastrar Aluno
					2 - Média da Turma
					3 - Situação Aluno
					4 - Exibir Alunos
					5 - Editar Aluno
					6 - Mural de Aniversariantes
					7 - Encerrar Programa
					
					Escolha uma opção: 
					""";
		while (opcao != 7) {
			
			do {
				System.out.println(menu);
				
				opcao = s.nextInt();
				s.nextLine();
				
				if(opcao < 1 || opcao > 7) {
					System.out.println("Opção inválida!");
				}
			}while(opcao < 1 || opcao > 7);
			
			switch(opcao) {
			case 1:
				System.out.println("Digite o nome do Aluno: ");
				String nome = s.nextLine();
				System.out.println("Digite a Data de Nascimento: (no formato dd-MM-yyyy)");
				String dataNascimento = s.nextLine();
				
				DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				LocalDate data = null;
				try {
					data = LocalDate.parse(dataNascimento, df);
				}catch(Exception e) {
					System.out.println("Dormato de data inválido. Use o formato dd-MM-yyyy.");
				}
				System.out.println("Digite a turma: ");
				int turma = s.nextInt();
				s.nextLine();
				System.out.println("Informe as 3 notas do Aluno: ");
				Double nota1 = s.nextDouble();
				Double nota2 = s.nextDouble();
				Double nota3 = s.nextDouble();
				notas.add(nota1);
				notas.add(nota2);
				notas.add(nota3);
				
				Aluno aluno = new Aluno(nome, data, turma, notas);
				System.out.println(aluno);
			}
		}
		s.close();
	}
}
