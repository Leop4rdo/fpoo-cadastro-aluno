package br.senai.sp.jandira.model;

public enum Periodos { 
	MANHA("Manh�"),
	TARDE("Tarde"),
	NOITE("Noite");
	
	private String descricao;

	private Periodos(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
