
package Principal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PessoaFisica extends Pessoa {
	
	String cpf;
	Date dtNascimento;
	String genero;
	int idade;

	
	public PessoaFisica(Integer id, String nome, String endereco, String cpf, Date dtNascimento, String genero) {
	super(id, nome, endereco);
		// TODO Auto-generated constructor stub
	this.cpf = cpf;
	this.dtNascimento = dtNascimento;
	this.genero = genero;
	}
	
	
	private static final DateFormat FORMATO = new SimpleDateFormat("dd/MM/yyyy");

	public String getCpf() {
		return cpf;
	}
	
	
	public int getIdade() {
		
		Calendar cData = Calendar.getInstance();
		Calendar cHoje= Calendar.getInstance();
		
		cData.setTime(this.dtNascimento);
	
		cData.set(Calendar.YEAR, cHoje.get(Calendar.YEAR));
		
		int idade = cData.after(cHoje) ? -1 : 0;
		cData.setTime(this.dtNascimento);
		
		idade += cHoje.get(Calendar.YEAR) - cData.get(Calendar.YEAR);
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}


	public String getDtNascimento() {
		return FORMATO.format(dtNascimento);
	}
	
	public void setDtNascimento(Date dtNascimento) {
	
		this.dtNascimento = dtNascimento;
	}
}
