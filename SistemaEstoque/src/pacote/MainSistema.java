package pacote;

import java.util.ArrayList;
import java.util.Scanner;

public class MainSistema {

	public static void main(String[] args) {

		Integer opcaoSelecionada = Integer.MAX_VALUE;
		Scanner sc = new Scanner(System.in);
		ArrayList<Produto> produtos = new ArrayList<>();

		while (opcaoSelecionada != 0) {

			System.out.println("------ Qual Operação deseja realizar? ------");
			System.out.println("0 SAIR");
			System.out.println("1 EDITAR");
			System.out.println("2 CADASTRAR");
			System.out.println("3 EXCLUIR");
			System.out.println("4 LISTAR");

			opcaoSelecionada = Integer.valueOf(sc.nextLine());

			switch (opcaoSelecionada) {
			case 0: {
				break;
			}
			case 1: {

				System.out.println("Digite o id do Produto que deseja Editar:");
				Long id = Long.valueOf(sc.nextLine());
				for (Produto produto : produtos) {
					if (id == produto.getId()) {
						// editar();
					} else {
						System.out.println("Id inválido");
					}
				}
			}
			case 2: {
				// cadastrar();

			}
			case 3: {
				System.out.println("Digite o id do Produto que deseja excluir:");

			}
			case 4: {
				// Saida de dados (output)
				System.out.println("Listagem de pessoas cadastradas: ");

			 }

			}

		}
		sc.close();

	}
	
	public static void editar() {
		
	}
	public static void cadastrar() {
		
		for (Produto produto : produtos) {
			System.out.println("Nome: " + produto.getNome());
			System.out.println("Marca: " + produto.getNome());
			System.out.println("Preço: " + produto.getNome());
			System.out.println("Quantidade de Estoque: " + produto.getNome());
		}
	}
	

}
