package serratec.poo.classes;

import java.util.ArrayList;
import java.util.List;

public class Turma {
	private int codigo;
	private List<Aluno> alunos = new ArrayList<>();
	
	public Turma(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Aluno aluno) {
		alunos.add(aluno);
	}
	
	
}
