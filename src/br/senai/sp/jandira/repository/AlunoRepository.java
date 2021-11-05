package br.senai.sp.jandira.repository;

import br.senai.sp.jandira.model.Aluno;

public class AlunoRepository {
	private Aluno[] turma;
	
	public AlunoRepository() {
		turma = new Aluno[32];
	}
	
	public AlunoRepository(int alunosLength) {
		turma = new Aluno[alunosLength];
	}
	
	public void gravar(Aluno aluno, int index) {
		turma[index] = aluno;
	}
	
	public Aluno listarAluno(int index) {
		 return turma[index];
	}
	
	public Aluno[] listarTodos() {
		return turma;
	}
}
