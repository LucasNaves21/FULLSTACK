package dominio;

public class Conta {

	Pessoa cliente;
	Integer nrConta;
	Categoria categoria;
	Double saldo;
	

	public Conta(Pessoa cliente, Integer nrConta, Categoria categoria, Double saldo) {
		this.categoria = categoria;
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
	
	
	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
    
     
    public void alterar(Integer nrConta, Categoria categoria, Double saldo) {
    	this.nrConta = nrConta;
    	this.categoria = categoria;
    	this.saldo = saldo;
    }
    
    
    public double getsaldo() {
    	return this.saldo;
    }
}
