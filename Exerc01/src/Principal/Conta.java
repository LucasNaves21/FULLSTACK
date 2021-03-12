package Principal;

public class Conta {

	
	Pessoa cliente;
	Integer nrConta;
	Double saldo;
	

	public Conta(Pessoa cliente, Integer nrConta, Double saldo) {
	
		this.cliente = cliente;
		this.nrConta = nrConta;
		this.saldo = saldo;
	}

	
	public Pessoa getCliente() {
		return cliente;
	}
	
	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}
	
	public Integer getNrConta() {
		return nrConta;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	
	
	public boolean depositar(double valor) {
		this.saldo += valor;
		return true;
	}
	
	
	//saca o valor da conta e retorna true se operação bem sucedido
    public boolean sacar(double valor) {
    	if (valor < saldo) {
    		this.saldo -= valor;
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    
    public boolean transferir(double valor, Conta contaDestino){
        boolean retirou = sacar(valor);
        	if (retirou) {
        		contaDestino.depositar(valor);
        		return true;
        	}
        		else {
        			return false;
        		}
      }
    
   
    
    public double getsaldo() {
    	return this.saldo;
    }
}
