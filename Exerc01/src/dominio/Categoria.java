package dominio;

public enum Categoria {

	
	SIMPLES("Simples"),
	EXECUTIVA("Executiva"),
	PREMIUN("Premiun"),
	PERSONALITE("Personalite");
	
	private String descricao;
	
	Categoria(String descricao) {
		// TODO Auto-generated constructor stub
	this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
