package dominio;

public class PessoaJuridica extends Pessoa {

	
	String cnpj;
	String atividade;
	
	public PessoaJuridica(Integer id, String nome, String endereco, String cnpj, String atividade) {
		super(id, nome, endereco);
		// TODO Auto-generated constructor stub
		
		this.cnpj = cnpj;
		this.atividade = atividade;
	}

	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getAtividade() {
		return atividade;
	}
	
	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}


	@Override
	public String toString() {
		return "PessoaJuridica [cnpj=" + cnpj + ", atividade=" + atividade + ", id=" + id + ", nome=" + nome
				+ ", endereco=" + endereco + "]";
	}	
}
