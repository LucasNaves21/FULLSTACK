package Principal;

import java.time.Instant;
import java.util.Date;
import java.util.Scanner;

import dominio.Categoria;
import dominio.Conta;
import dominio.ContaEspecial;
import dominio.ContaPoupanca;
import dominio.Pessoa;
import dominio.PessoaFisica;
import dominio.PessoaJuridica;

public class Menu {

	Categoria categoria = null;

	public void menuPrincipal(Scanner sc) {
		Integer escolha = 1;
		Conta conta;
		do {
			this.showMenuPrincipal();
			try {
				escolha = sc.nextInt();
				switch (escolha) {
				case 1:
					this.abriNovaConta(sc);
					break;

				case 2:
					conta = this.buscarConta(sc);
					this.menuConta(sc, conta);
					break;

				case 3:
					this.cadatrarCliente(sc);
					break;

				case 4:
					System.out.println("Implentar Relatórios");
					break;

				case 5:
					System.out.println("5 – Sair");
					break;

				default:
					System.out.println("Opção Incorreta");
				}
			} catch (Exception e) {
				System.out.println("Opção Incorreta, sair.");
				escolha = 5;
			}
		} while (escolha != 5);

	}

	
	private void abriNovaConta(Scanner sc) {
				
		System.out.println("------ Nova Conta -------\n");
		System.out.println("------ Digite os dados do Cliente -------\n");

		
		System.out.println("Digite o id: ");
		Integer id = sc.nextInt();
		
		System.out.println("Nome do Cliente: ");
		String nome = sc.next();
		
		System.out.println("Endereço: ");
		String endereco = sc.next();
		
		Pessoa novoCliente = new Pessoa(id, nome, endereco);
		
		System.out.println("Numero da Conta: ");
		Integer nrConta = sc.nextInt();

		System.out.println("--------Categorias------------\n");
		System.out.println("1 - Simples");
		System.out.println("2 - Executiva");
		System.out.println("3 - Premiun");
		System.out.println("4 - Personalite");
		
		Integer Cat = sc.nextInt();
		
		if (Cat == 1) {
			categoria = Categoria.SIMPLES;
		}

		if (Cat == 2) {
			 categoria = Categoria.EXECUTIVA;
		}
		
		if (Cat == 3) {
			categoria = Categoria.PREMIUN;
		}
		
		if (Cat == 4) {
			categoria = Categoria.PERSONALITE;
		}
		
		System.out.println("Informe o saldo: ");
		Double saldo = sc.nextDouble();
		
		System.out.println("Selecione o tipo de Conta para abertura");
		System.out.println("1 - Conta Poupança");
		System.out.println("2 - Conta Especial");
		
		Integer tipo = sc.nextInt();
		
		if (tipo == 1) {
			
			System.out.println("Informe a Taxa de Correção: ");
			Double taxa = sc.nextDouble();
			
			Main.contas.add(new ContaPoupanca(novoCliente, nrConta, categoria, saldo, taxa));
			
			System.out.println("\n-----------Conta Criada com sucesso---------\n");

		}
		
		if (tipo == 2) {
			System.out.println("Informe o Limite especial: ");
			Double limite = sc.nextDouble();
			
		  Main.contas.add(new ContaEspecial(novoCliente, nrConta, categoria, saldo,  limite));
		
		  System.out.println("\n-----------Conta Criada com sucesso---------\n");
		}
	
		
	}
	
	
	private void cadatrarCliente(Scanner sc) {

		System.out.println("--- Novo Cliente-----");
		System.out.println("Selecione o tipo de Pessoa");
		System.out.println("1 - Pessoa Física");
		System.out.println("2 - Pessoa Jurídica");
		
		Integer tipo = sc.nextInt();
		
		
		System.out.println("--- Informe o ID -----");
		Integer id = sc.nextInt();

		System.out.println("--- Informe o Nome -----");
		String nome = sc.nextLine();
		
		System.out.println("--- Informe o Endereço -----");
		String endereco = sc.nextLine();
		
		if(tipo == 1) {
			System.out.println("--- Informe o CPF -----");
			String cpf = sc.nextLine();
			
			System.out.println("--- Informe a Data de Nascimento -----");
			String[] dtAux = sc.next().trim().split("/");
			
			Date dtNascimento = Date.from(Instant.parse(dtAux[2]+"-"+dtAux[2]+"-"+dtAux[0]+"T00:00:00Z"));

			
					
			System.out.println("--- Informe o Genero (M/F) -----");
			String genero = sc.next();
			
			Main.clientes.add(new PessoaFisica(id, nome, endereco, cpf, dtNascimento, genero));
			
		}else {
			System.out.println("--- Informe o Nome -----");
			String cnpj = sc.nextLine();
			
			System.out.println("--- Informe o Endereço -----");
			String atividade = sc.nextLine();
			
			Main.clientes.add(new PessoaJuridica(id, nome, endereco, cnpj, atividade));
		}

	}

	private void menuConta(Scanner sc, Conta conta) {
		
		Integer escolha = 1;
		do {
			this.showMenuConta(conta);
			try {
				escolha = sc.nextInt();
				Double vr;
				switch (escolha) {
				case 1: 
					System.out.println("Digite novos dados para alterar a conta selecionada\n");
					
					System.out.println("Novo número da Conta: ");
					Integer nrConta = sc.nextInt();
					
					System.out.println("--------Categorias------------\n");
					System.out.println("1 - Simples");
					System.out.println("2 - Executiva");
					System.out.println("3 - Premiun");
					System.out.println("4 - Personalite");
					
					Integer Cat = sc.nextInt();
					
					if (Cat == 1) {
						categoria = Categoria.SIMPLES;
					}

					if (Cat == 2) {
						 categoria = Categoria.EXECUTIVA;
					}
					
					if (Cat == 3) {
						categoria = Categoria.PREMIUN;
					}
					
					if (Cat == 4) {
						categoria = Categoria.PERSONALITE;
					}
					
					System.out.println("Digite o novo saldo: ");
					Double saldo = sc.nextDouble();
					
					conta.alterar(nrConta, categoria, saldo);
					
					System.out.println("-------Conta alterada com sucesso----");
					
					break;
				case 2: 
					System.out.println("Informe o Valor do Depósito");
					vr = sc.nextDouble();
					conta.depositar(vr);
					break;
				case 3: 
					System.out.println("Informe o Valor para Saque");
					vr = sc.nextDouble();
					conta.sacar(vr);
					
					break;
				case 4: 
					
					System.out.println("Informe o Valor para Transferência");
					vr = sc.nextDouble();
					
					Conta dest = this.buscarConta(sc);
					
					conta.transferir(vr, dest);
			
					break;
				case 5:
					System.out.println("-------------------------");
					System.out.println("--- SALDO: R$ "+conta.getSaldo());
					System.out.println("-------------------------");
					
					break;
				}

			}  catch (Exception e) {
				System.out.println("Opção Incorreta, sair.");
				escolha = 6;
			}
		}while (escolha != 6);
	}

	private void showMenuPrincipal() {
		System.out.println("-------------------------");
		System.out.println("---Selecione Uma Opção---");
		System.out.println("-------------------------");
		System.out.println("1 – Abrir Nova Conta");
		System.out.println("2 – Selecionar Conta");
		System.out.println("3 – Cadastrar Cliente");
		System.out.println("4 – Relatórios");
		System.out.println("5 – Sair");
		System.out.println("-------------------------");
	}

	private void showMenuConta(Conta conta) {
		System.out.println("-------------------------");
		System.out.println("Cliente: " + conta.getCliente().getNome());
		System.out.println("Nr Conta: " + conta.getNrConta());
		System.out.println("-------------------------");
		System.out.println("---Selecione Uma Opção---");
		System.out.println("-------------------------");
		System.out.println("1 – Alterar Conta");
		System.out.println("2 – Deposito");
		System.out.println("3 – Saque");
		System.out.println("4 – Transferência");
		System.out.println("5 – Saldo");
		System.out.println("6 – Sair");
		System.out.println("-------------------------");
	}

	
	

	public Conta buscarConta(Scanner sc) {

		Conta conta = null;
		do {
			System.out.println("------------------------------");
			System.out.println("---Digite o número da Conta---");
			System.out.println("------------------------------");
			Integer escolha = sc.nextInt();
			for (Conta c : Main.contas) {

				if (c.getNrConta().equals(escolha)) {
					conta = c;
					break;
				}
			}
			if (conta == null) {
				System.out.println("------------------------------");
				System.out.println("-----Conta Não Encontrada-----");
				System.out.println("------------------------------");				
			}

		} while (conta == null);

		return conta;
	}
}
