package sistemaBancario;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Conta {
	private String nome;
	private double saldo;
	
	Conta(String nome) {
		this.nome = nome; 
		this.saldo = 0;
	}
	
	void depositar(double valor) {
		if (valor > 0) {
			saldo += valor;
			System.out.printf("Depósito de R$" + valor + " realizado com sucesso.");
		}
		else
			System.out.println("Depósito inválido.");
	}
	
	void retirar(double valor) {
		if (valor > 0 && valor <= saldo) {
			saldo -= valor;
			System.out.println("Saque de R$" + valor + " realizado com sucesso.");
		}
		else
			System.out.println("Saque não realizado.");
	}
	
	double verificarSaldo() {
		return saldo;
	}
	
	String getNome() {
		return nome;
	}
	

}

public class main {
	
	private static List<Conta> contas = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opcao;
		String nome;
		do {
			System.out.println("\nEscolha uma opção: \n1. Criar nova conta \n2. Depositar \n3. Retirar \n4. Verificar saldo \n5. Sair");
			opcao = scanner.nextInt();
			switch(opcao) {
			case 1:
				System.out.println("Digite o nome do titular da conta: ");
				nome = scanner.next();
				Conta conta = new Conta(nome);
				contas.add(conta);
				System.out.printf("Conta criada para " + nome + ".");
				break;
			case 2:
				System.out.println("Digite o nome do titular da conta: ");
				nome = scanner.next();
				Conta contaDeposito = encontrarConta(nome);
				if (contaDeposito != null) {
					System.out.println("Digite a quantia a ser depositada: ");
					double deposito = scanner.nextDouble();
					contaDeposito.depositar(deposito);
				}
				else {
					System.out.println("Conta não encontrada");
				}
				break;
			case 3: 
				System.out.println("Digite o nome do titular da conta: ");
				nome = scanner.next();
				Conta contaRetirada = encontrarConta(nome);
				if (contaRetirada != null) {
					System.out.println("Digite a quantia a ser retirada: ");
					double valor = scanner.nextDouble();
					contaRetirada.retirar(valor);
				}
				else {
					System.out.println("Conta não encontrada");
				}
				break;
			case 4:
				System.out.println("Digite o nome do titular da conta: ");
				nome = scanner.next();
				Conta contaSaldo = encontrarConta(nome);
				if (contaSaldo != null) {
					double saldo = contaSaldo.verificarSaldo();
					System.out.printf("Saldo atual: R$" + saldo);
							}
				else {
					System.out.println("Conta não encontrada");
				}
				break;
			case 5:
				System.out.println("Obrigada por usar o sistema bancário.");
				scanner.close();
				break;
			default:
				System.out.println("Opção inválida.");
				break;
			}
		} while (opcao != 5);
	}
	
	private static Conta encontrarConta(String nome) {
		for (Conta conta : contas) {
			if(conta.getNome().equalsIgnoreCase(nome)) {
				return conta;
			}
		}
		return null;
	}

}


