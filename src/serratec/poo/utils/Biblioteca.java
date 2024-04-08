package serratec.poo.utils;

import java.io.IOException;

public class Biblioteca {

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
