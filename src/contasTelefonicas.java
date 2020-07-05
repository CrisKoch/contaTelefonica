import java.util.Locale;
import java.util.Scanner;

public class contasTelefonicas {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		// Leitura da quantidade de clientes

		System.out.print("INFORME A QUANTIDADE DE CLIENTES: ");
		int N = sc.nextInt();

		// Leitura dos dados dos clientes

		String[] nome = new String[N];
		String[] telefone = new String[N];
		int[] tipo = new int[N];
		int[] minutos = new int[N];

		for (int i = 0; i < N; i++) {

			System.out.println("Dados do " + (i + 1) + "º cliente:");
			System.out.print("Nome: ");
			sc.nextLine();
			nome[i] = sc.nextLine();
			System.out.print("Telefone: ");
			//sc.nextLine();
			telefone[i] = sc.next();
			System.out.print("Tipo: ");
			tipo[i] = sc.nextInt();
			System.out.print("Minutos: ");
			minutos[i] = sc.nextInt();
			System.out.println();
		}

		// Matriz de assinatura

		System.out.println("Informe o preco basico e excedente de cada tipo de conta:");

		double matriz1[][] = new double[3][2];
		for (int i = 0; i < 3; i++) {
			System.out.print("Tipo " + i + ": ");
			
			for (int j = 0; j < 2; j++) {
				matriz1[i][j] = sc.nextDouble();
			}
			
		}

		// Calculo da conta individual

		double[] valorConta = new double[N];
		for (int i = 0; i < N; i++) {
			if (minutos[i] <= 90.0) {
				if (tipo[i] == 0) {
					valorConta[i] = matriz1[0][0];
				} else if (tipo[i] == 1) {
					valorConta[i] = matriz1[1][0];
				} else {
					valorConta[i] = matriz1[2][0];
				}
			} else {
				if (tipo[i] == 0) {
					valorConta[i] = matriz1[0][0] + (matriz1[0][1] * (minutos[i] - 90));
				} else if (tipo[i] == 1) {
					valorConta[i] = matriz1[1][0] + (matriz1[1][1] * (minutos[i] - 90));
				} else {
					valorConta[i] = matriz1[2][0] + (matriz1[2][1] * (minutos[i] - 90));
				}

			}

		}

		// Cálculos do Menu
		System.out.println();

		double receita = 0;
		int opcao = 0;
		int consumo1 = 0;
		int cont1 = 0;
		do {
			System.out.println("MENU DE OPCOES:");
			System.out.println("1) Relatorio de clientes");
			System.out.println("2) A receita total");
			System.out.println("3) Conta foi mais barata");
			System.out.println("4) Consumo medio de clientes tipo 1.");
			System.out.println("5) Clientes que consumiram acima de 120 pulsos");
			System.out.println("6) A porcentagem de clientes tipo 2");
			System.out.println("7) Sair");
			System.out.print("Informe uma opção: ");
			opcao = sc.nextInt();
			System.out.println();
			
			if (opcao == 1) {
				for (int i = 0; i < N; i++) {
					System.out.print(nome[i] + ", ");
					System.out.print(telefone[i] + ", ");
					System.out.print("Tipo " + tipo[i] + ", ");
					System.out.print("Minutos: " + minutos[i] + ", ");
					System.out.printf("Conta = R$ %.2f%n", valorConta[i]);
				}

			} else if (opcao == 2) {
				for (int i = 0; i < N; i++) {
					receita = receita + valorConta[i];
				}
				System.out.printf("Receita total: R$ %.2f%n", receita);
			} else if (opcao == 3) {
				double barata = valorConta[0];
				String nomeEconomico = nome[0];
				for (int i = 1; i < N; i++) {
					if (valorConta[i] < barata) {
						barata = valorConta[i];
						nomeEconomico = nome[i];
					}

				}
				System.out.print("Conta mais barata: " + nomeEconomico);
				System.out.printf(" no valor de R$ %.2f%n", barata);
			}

			else if (opcao == 4) {
				for (int i = 0; i < N; i++) {
					if (tipo[i] == 1) {
						consumo1 = consumo1 + minutos[i];
						cont1++;
					}
				}
				int media1 = consumo1 / cont1;
				System.out.println("Consumo medio de clientes tipo 1: " + media1 + " minutos");
			}

			else if (opcao == 5) {
				System.out.print("Consumo acima de 120 pulsos: ");
				for (int i = 0; i < N; i++) {
					if (minutos[i] > 120) {
						System.out.print(nome[i] + " ");
					}
				}
				System.out.println();
			} else if (opcao == 6) {
				int cont2 = 0;
				for (int i = 0; i < N; i++) {
					if (tipo[i] == 2) {
						cont2++;
					}
				}
				double porcentagem2 = cont2 * 100 / N;
				System.out.printf("Porcentagem de clientes tipo 2: %.2f%%%n", porcentagem2);
			}
			System.out.println();
		} while (opcao != 7);
		
		System.out.print("FIM DO PROGRAMA!");
		sc.close();

	}

}
