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
				sc.close();
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
				cadastrar(produtos);

			}
			case 3: {
				System.out.println("Digite o ID do produto a ser editado:");
				long idProduto = Long.valueOf(sc.nextLong());
				System.out.println("VOCÊ TEM CERTEZA QUE QUER APAGAR " + idProduto + "?");
				System.out.println("[S] Sim");
				System.out.println("[N] Não");
				sc.nextLine();
				String certeza = sc.nextLine();
				if (certeza.equals("S"))
					excluir(produtos, idProduto);
				else if(certeza.equals("N"))
					break;
				else
					System.out.println("Resposta inválida. Tente novamente");
			}
			case 4: {
				listagem(produtos);
				break;
			}
			} // fim do switch

		}
	}// fim do main

	// EXCLUIR
	public static void excluir(ArrayList<Produto> produtos, long idProduto) {
		for (Produto produto : produtos) {
			if (produto.getId() == idProduto) {
				produtos.remove(produto);
				System.out.println("Processo realizado com sucesso!");
				break;
			} else {
				System.out.println("Ocorreu um erro. Verifique se o produto existe e tente novamente.");
				break;
			}
		}
	}

	public static void editar(ArrayList<Produto> produtos) {

	}

	// CADASTRAR
	public static void cadastrar(ArrayList<Produto> produtos) {

		for (Produto produto : produtos) {
			System.out.println("Nome: " + produto.getNome());
			System.out.println("Marca: " + produto.getNome());
			System.out.println("Preço: " + produto.getNome());
			System.out.println("Quantidade de Estoque: " + produto.getNome());
		}
	}

	// LISTAGEM
	public static void listagem(ArrayList<Produto> produtos) {
		System.out.println("Listagem dos produtos cadastrados: ");
		for (Produto produto : produtos) {
			System.out.println("Nome: " + produto.getNome());
			System.out.println("Id: " + produto.getId());
			System.out.println("Marca: " + produto.getMarca());
			System.out.println("Preço: " + produto.getPreco());
			System.out.println("Quantidade em estoque: " + produto.getQtdEstoque());
			System.out.println("------");
		}
	}
}