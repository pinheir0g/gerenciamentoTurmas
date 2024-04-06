package serratec.poo.classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Aluno {
	private String nome;
	private LocalDate dataNascimento;
	private int turma;
	private List<Double> notas = new ArrayList<>();
	private double mediaAluno;
	private String situacao;

	public Aluno(String nome, LocalDate dataNascimento, int turma, List<Double> notas) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.turma = turma;
		this.notas = notas;
		
	}
	public String getNome() {
		return nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public int getTurma() {
		return turma;
	}

	public List<Double> getNotas() {
		return notas;
	}
	public void setNotas(List<Double> notas) {
		this.notas = notas;
	}
	
	
	
	public String getSituacao() {
		if(getMediaAluno() > 6) {
			this.situacao = "Aprovado";
			return situacao;
		}
		this.situacao = "Reprovado";
		return situacao;
	}
	public double getMediaAluno() {
		mediaAluno = (notas.get(0) + notas.get(1) + notas.get(2)) / 3;
		return mediaAluno;
	}
	
	@Override
	public String toString() {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		return "Aluno [nome=" + nome + ", dataNascimento=" + df.format(dataNascimento) + ", turma=" + turma + ", notas=" + notas+ "]";
	}
	
	
	
}
