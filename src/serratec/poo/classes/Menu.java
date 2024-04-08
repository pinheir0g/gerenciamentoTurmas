package serratec.poo.classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import serratec.poo.utils.Biblioteca;

public class Menu {
	
	public static void menuEscolha() {
		Scanner s = new Scanner(System.in);
		int opcao = -1;
		
		Menu.exibeMenu();
		
		while (opcao != 8) {
			
			opcao = Menu.leMenu();
			
			switch(opcao) {
			case 1:
				List<Double> notas = new ArrayList<>();
				
				String nome = Menu.leNome();
				LocalDate data = Menu.leDataNascimento();
				int turma = Menu.leTurma();
				
				System.out.println("Informe as 3 notas do Aluno: ");
				
				notas.add(Menu.leNotaProva(1));
				notas.add(Menu.leNotaProva(2));
				notas.add(Menu.leNotaProva(3));
				
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
	
	public static String exibeMenu() {
		return """
		---------------------------------------
			GERENCIAMENTO DE TURMAS
		---------------------------------------
		  1 - Cadastrar Aluno
		  2 - Cadastrar Turma
		  3 - Média da Turma
		  4 - Situação Aluno
		  5 - Exibir Alunos
		  6 - Editar Aluno
		  7 - Mural de Aniversariantes
		  8 - Encerrar Programa
		
		Escolha uma opção: 
		""";
	}
	
	public static int leMenu() {
		Scanner  s = new Scanner(System.in);
		
		int opcao = 0;
		
		do {
			System.out.println(Menu.exibeMenu());
			
			 if (s.hasNextInt()) {
				 opcao = s.nextInt();
			 } else {
				 opcao = -1;
			 }
			
			if(opcao < 1 || opcao > 8 ) {
				System.out.println("Opção inválida!");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return opcao;
		}while(opcao < 1 || opcao > 8 );	
	}
	
	public static String leNome() {
		Scanner s = new Scanner(System.in);
		String nome;
        while (true) {
            System.out.println("Digite o nome do aluno: ");
            nome = s.nextLine();

            Pattern pattern = Pattern.compile("^[a-zA-ZÀ-ÿ]+(\\s+[a-zA-ZÀ-ÿ]+)*$");
            Matcher matcher = pattern.matcher(nome);

            if (matcher.matches()) {
                break;
            } else {
                System.out.println("Nome inválido. Use apenas letras e espaços.");
            }
        }
        return nome;
    }
	
	public static LocalDate leDataNascimento(){
		Scanner  s = new Scanner(System.in);
		boolean dataCorreta = false;
		LocalDate data = null;
		String dataNascimento = "";
		
		while(!dataCorreta) {
			System.out.println("Digite a Data de Nascimento: (no formato dd-MM-yyyy)");
			dataNascimento = s.nextLine();
			
			DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			
			try {
				data = LocalDate.parse(dataNascimento, df);
				
				if (data.getYear() >= (LocalDate.now().getYear() - 140) && data.getYear() <= LocalDate.now().getYear()) {
                    dataCorreta = true;
                } else {
                    System.out.println("Ano inválido. O ano deve estar entre " + (LocalDate.now().getYear() - 140) +  " e " + LocalDate.now().getYear());
                }
			}catch(Exception e) {
				System.out.println("Formato de data inválido. Use o formato dd-MM-yyyy.");
			}
		}
		return data;
	}
	
	public static int leTurma() {
		Scanner s = new Scanner(System.in);
		int turma = 0;
		boolean turmaCerta = false;
		while (!turmaCerta){
			System.out.println("Qual é a turma do aluno? \nTurma 1, 2 ou 3");
			if(s.hasNextInt()) {
				turma = s.nextInt();
			} else {
				s.nextLine();
			}	
			if(turma < 1 || turma > 3) {
				System.out.println("Esta Turma não existe!");
			} else {
				turmaCerta = true;
			}	
		}
		return turma;
	}
	
	public static double leNotaProva(int prova) {
		Scanner  s = new Scanner(System.in);
		boolean notaCerta = false;
		double nota = 0.0;
		
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