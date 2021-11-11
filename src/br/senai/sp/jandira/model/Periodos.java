package br.senai.sp.jandira.model;

public enum Periodos { 
	MANHA("Manh�"),
	TARDE("Tarde"),
	NOITE("Noite"),
	SABADO("Sabado"),
	EAD("EAD");
	
	private String descricao;

	private Periodos(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
