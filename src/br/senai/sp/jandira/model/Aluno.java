package br.senai.sp.jandira.model;

public class Aluno {
	private String matricula;
	private String nome;
	private Periodos periodo;
	  
	/*
	public Aluno(String matricula, String nome, Periodos periodo) {
		this.matricula = matricula;
		this.nome = nome;
		this.periodo = periodo;
	}
	 */
	
	// SET & GET
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Periodos getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodos periodo) {
		this.periodo = periodo;
	}
}
