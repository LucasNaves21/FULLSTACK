package dominio;

public class ContaEspecial extends Conta{

	
	Double limite;

	
	public ContaEspecial(Pessoa cliente, Integer nrConta, Categoria categoria, Double saldo, Double limite) {
		super(cliente, nrConta, categoria, saldo);
		// TODO Auto-generated constructor stub
		this.limite = limite;
	}


	public Double getLimite() {
		return limite;
	}

	public void setLimite(Double limite) {
		this.limite = limite;
	}
	
	 
	public boolean sacar(double valor) {
	    	
		 if (valor < saldo) {
	    		this.saldo -= valor;
	    		return true;
	    	}
	    	
		 if (valor <= this.limite) {
			 this.saldo -= valor;
			 return true;
	    	}
		 else {
			 
			 return false;
		 }
	  }
}
