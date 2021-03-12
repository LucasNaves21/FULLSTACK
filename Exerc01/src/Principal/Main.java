package Principal;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println("\n-------Executando---------------------------\n");
		
		@SuppressWarnings("deprecation")
		PessoaFisica Jo�o = new PessoaFisica(1, "Jo�o", "Goi�nia", "9999", new Date(1995-1900, 10-1, 11), "Masculino");
		
		@SuppressWarnings("deprecation")
		PessoaFisica Maria = new PessoaFisica(2, "Maria", "An�polis", "8888", new Date(2001-1900, 12-1, 1), "Feminino");
		
		System.out.println("-------Calculando Idade Pessoa Fisica---------\n");

		//System.out.println(Jo�o.toString());
		System.out.println("Idade: "+Jo�o.getIdade()+" anos");
		System.out.println("Idade: "+Maria.getIdade()+" anos");
		
		System.out.println("----------------------");
		
		PessoaJuridica Apple = new PessoaJuridica(3, "Apple SA", "California", "1111", "Tecnologia");
		PessoaJuridica Ferragista = new PessoaJuridica(4, "Imperio", "Goi�nia",  "2222", "Varejista");
	
		ContaEspecial ceJo�o = new ContaEspecial(Jo�o, 1, 400.0, 500.0);
		ContaPoupanca cpMaria = new ContaPoupanca(Maria, 2, 500.0, 0.02);
		ContaEspecial ceApple = new ContaEspecial(Apple, 3, 1000000.0, 10000.0);
		ContaPoupanca cpFerragista = new ContaPoupanca(Ferragista, 4, 1500.0, 0.03);
		
		//Objeto para capturar a data do sistema para cria��o da conta 
		Date data = new Date();
		
		//Objeto teste para verificar a diferen�a de meses
		@SuppressWarnings("deprecation")
		Date dataTeste = new Date(2021-1900, 5-1, 12);
		
		//Atribui a data do sistema para o atributo Data de Abertura na classe Conta Poupan�a
		cpMaria.dataDeAbertura = data;
		
		//Atribui uma data para teste do metodo de calculo de meses
		cpMaria.DataTeste = dataTeste;
		
		cpFerragista.dataDeAbertura = data;

		System.out.println("\nMeses acumulados Conta Poupan�a Maria: "+cpMaria.getMeses());
		System.out.println("Saldo conta Maria atualizado com taxa: "+cpMaria.GerarTaxa());
		
		System.out.println("----------------------------------------");
		
		ceApple.transferir(1000.0, cpMaria);
		
		System.out.println("\nSaldo conta Apple: "+ceApple.getsaldo());
		System.out.println("Saldo conta Maria: "+cpMaria.getsaldo());
		
		ceJo�o.sacar(450.0);
		cpMaria.sacar(500);
		
		List<Conta> listConta = new ArrayList<Conta>();
		
		listConta.add(cpFerragista);
		listConta.add(ceJo�o);
		listConta.add(ceApple);
		listConta.add(cpMaria);
		
		Double total = 0.0;
		
		for (Conta c : listConta) {
			
			System.out.println("Nome: "+c.getCliente().getNome()+", saldo: R$ "+c.getsaldo());
			total += c.getSaldo();
			
		}
		
		System.out.println("-----------------------");
		System.out.println("Soma dos Saldos: "+total);
	}
}

