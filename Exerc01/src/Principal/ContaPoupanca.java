package Principal;

import java.util.Calendar;
import java.util.Date;

public class ContaPoupanca extends Conta {
	
	Double txCorrecao;
	Date dataDeAbertura;
	Date DataTeste;
	int meses;
	
	public ContaPoupanca(Pessoa cliente, Integer nrConta, Double saldo, Double txCorrecao) {
		super(cliente, nrConta, saldo);
		// TODO Auto-generated constructor stub
		this.txCorrecao = txCorrecao;
	}
	
	   
	public Double getTxCorrecao() {
		return txCorrecao;
	}

	public void setTxCorrecao(Double txCorrecao) {
		this.txCorrecao = txCorrecao;
	}

	
	public int getMeses() {
		
		//Cria uma instancia da Classe Calendar
		Calendar dataCadastro = Calendar.getInstance();
		
		//Passa o parametro da data da abertura
		dataCadastro.setTime(this.dataDeAbertura);
		
		//Cria uma instancia da Classe Calendar e passa o parametro da data atual
		Calendar hoje = Calendar.getInstance();
		hoje.setTime(DataTeste);

		//calcula diferença e retorna 
		return meses = (hoje.get(Calendar.YEAR) * 12 + hoje.get(Calendar.MONTH))
		        - (dataCadastro.get(Calendar.YEAR) * 12 + dataCadastro.get(Calendar.MONTH));
	}

	public void setMeses(int meses) {
		this.meses = meses;
	}


	public Date getDataTeste() {
		return DataTeste;
	}


	public void setDataTeste(Date dataTeste) {
		DataTeste = dataTeste;
	}


	public double GerarTaxa() {
	
		return this.saldo += this.saldo * (this.txCorrecao * this.getMeses());
	}
}
			
