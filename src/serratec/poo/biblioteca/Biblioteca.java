package serratec.poo.biblioteca;

import java.io.IOException;

public class Biblioteca {
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

	 public static void clearConsole() throws IOException, InterruptedException{
	        try {
	            final String os = System.getProperty("os.name");

	            if (os.contains("Windows")) {
	                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	            } else {
	                System.out.print("\033[H\033[2J");
	                System.out.flush();
	            }
	            Thread.sleep(100);
	        } catch (final Exception e) {
	            System.out.println("Erro ao tentar limpar o console: " + e.getMessage());
	        }
	    }
}
