package br.senai.sp.jandira.model;

public enum Periodos { 
	MANHA("Manhã"),
	TARDE("Tarde"),
	NOITE("Noite"),
	SABADO("Sabado"),
	EAD("EAD");
	
	private String descricao;

	private Periodos(String descricao) {
		this.descricao = descricao;
	}
	
	/*
	public static Periodos getValueWithDescricao(String descricao) {
		for (Periodos p : Periodos.values()) {
			if (p.descricao.equalsIgnoreCase(descricao)) {
				return p;
			}
		}
		
		return null;
	}
	*/

	public String getDescricao() {
		return descricao;
	}
}
