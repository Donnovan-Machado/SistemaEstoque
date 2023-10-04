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
						editar(produtos);
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
				String certeza = String.valueOf(sc.nextLine());
				while (certeza != "S" && certeza != "N") {
					System.out.println("Resposta inválida. Tente novamente");
					certeza = String.valueOf(sc.nextLine());
				}
				if (certeza == "S")

					excluir(produtos, idProduto);
				else
					break;
				else
					System.out.println("Resposta inválida. Tente novamente");
			}
			case 4: {
				listagem(produtos);
				break;
			}

			} // fim do switch
		} // fim while
		sc.close();
	}// fim do main

	// CADASTRAR
	public static void cadastrar(ArrayList<Produto> produtos) {
		Scanner sc = new Scanner(System.in);
		String nome, marca;
		Integer qtdEstoque;
		Float preco;
		for (Produto produto : produtos) {
			System.out.println("Nome: ");
			nome = sc.nextLine();
			produto.setNome(nome);
			System.out.println("Marca: ");
			marca = sc.nextLine();
			produto.setMarca(marca);
			System.out.println("Preço: ");
			preco = sc.nextFloat();
			produto.setPreco(preco);
			System.out.println("Quantidade de Estoque: ");
			qtdEstoque = sc.nextInt();
			produto.setQtdEstoque(qtdEstoque);
		}
		sc.close();
	}
	}// fim do main

	// EDITAR
	public static void editar(ArrayList<Produto> produtos) {
		Scanner sc = new Scanner(System.in);
		String campo;
		listagem(produtos);
		System.out.println("Qual campo você deseja editar?");
		campo = sc.nextLine();
		Integer campoNumber = Integer.valueOf(campo);
		Float campoNumberF = Float.valueOf(campo);

	// EXCLUIR
	public static void excluir(ArrayList<Produto> produtos, long idProduto) {
		for (Produto produto : produtos) {
			
			if (campo.toLowerCase() == produto.getNome()) {
				String nome;
				System.out.println("Qual será o novo nome? ");
				nome = sc.nextLine();
				produto.setNome(nome);
			} 
			else if (campo.toLowerCase() == produto.getMarca()) {
				String marca;
				marca = sc.nextLine();
				produto.setMarca(marca);
			}
			else if (campoNumberF == produto.getPreco()) {
				Float preco;
				preco = sc.nextFloat();
				produto.setPreco(preco);
				
			}
			else if (campoNumber == produto.getQtdEstoque()) {
				Integer qtdEstoque;
				qtdEstoque = sc.nextInt();
				produto.setQtdEstoque(qtdEstoque);
			}
			
		}
		
		sc.close();
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

}