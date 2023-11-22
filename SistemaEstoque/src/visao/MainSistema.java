package visao;

import java.util.Scanner;

import controle.ProdutoDAO;
import modelo.Produto;

public class MainSistema {

	private static ProdutoDAO dao = ProdutoDAO.getInstancia();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Integer opcaoSelecionada = Integer.MAX_VALUE;

		while (opcaoSelecionada != 0) {

			System.out.println("------ Qual Operação deseja realizar? ------");
			System.out.println("[0] SAIR");
			System.out.println("[1] CADASTRAR");
			System.out.println("[2] EDITAR");
			System.out.println("[3] EXCLUIR");
			System.out.println("[4] LISTAR");

			opcaoSelecionada = Integer.valueOf(sc.nextLine());

			switch (opcaoSelecionada) {
			case 0: {
				System.out.println("Penguim anao mandou tchau");
				break;
			}
			case 1: {
				System.out.println("Cadastro");
				cadastrar();
				break;
			}
			case 2: {
				editar();
				break;

			}
			case 3: {
				System.out.println("Digite o ID do produto a ser excluído:");
				long idProduto = Long.valueOf(sc.nextLine());
				System.out.println("VOCÊ TEM CERTEZA QUE QUER APAGAR " + idProduto + "?");
				System.out.println("[S] Sim");
				System.out.println("[N] Não");
				String certeza = sc.nextLine();

				if (!certeza.isEmpty()) {

					certeza = certeza.toUpperCase();

					if (certeza.equals("S")) {
						listagem();
						excluir(idProduto);
						break;
					} else {
						System.out.println("Operacao cancelada");
					}
				}
			}
			case 4: {
				listagem();
				break;
			}

			} // fim do switch
		}
		// fim while
		sc.close();
	}// end do main

	public static void cadastrar() {
		String nome, marca;
		Integer qtdEstoque;
		Float preco;
		Produto produto = new Produto();

		System.out.println("Nome: ");
		nome = sc.nextLine();
		produto.setNome(nome);
		System.out.println("Marca: ");
		marca = sc.nextLine();
		produto.setMarca(marca);
		System.out.println("Preço: ");
		preco = Float.valueOf(sc.nextLine());
		produto.setPreco(preco);
		System.out.println("Quantidade de Estoque: ");
		qtdEstoque = Integer.valueOf(sc.nextLine());
		produto.setQtdEstoque(qtdEstoque);

		boolean validacao = dao.inserir(produto);
		if (validacao == true) {
			System.out.println("Cadastrado com sucesso!");
		} else {
			System.out.println("Erro ao cadastrar.");
		}

	}// fim do cadastrar

	Integer campoSelecionado = Integer.MAX_VALUE;

	// EDITAR
	public static void editar() {
		Integer campoSelecionado = Integer.MAX_VALUE;
		listagem();

		System.out.println("Digite o id do Produto que deseja Editar:");
		Long id = Long.valueOf(sc.nextLine());

		Produto produto = dao.buscaProdutoPorId(id);
		if (produto != null) {
			System.out.println("------ Qual campo você deseja editar? ------");
			System.out.println("[0] NOME");
			System.out.println("[1] MARCA");
			System.out.println("[2] PREÇO");
			System.out.println("[3] QUANTIDADE EM ESTOQUE");
			campoSelecionado = Integer.valueOf(sc.nextLine());

			switch (campoSelecionado) {
			case 0: // nome
			{
				String nome;
				System.out.println("Qual será o novo nome? ");
				nome = sc.nextLine();
				produto.setNome(nome);
				break;
			}
			case 1:// marca
			{
				String marca;
				System.out.println("Qual será o novo nome da marca? ");
				marca = sc.nextLine();
				produto.setMarca(marca);
				break;
			}
			case 2: {
				Float preco;
				System.out.println("Qual será o novo Preço? ");
				preco = Float.valueOf(sc.nextLine());
				produto.setPreco(preco);
				break;
			}
			case 3: {
				Integer qtdEstoque;
				System.out.println("Qual será a nova quantidade no estoque? ");
				qtdEstoque = Integer.valueOf(sc.nextLine());
				produto.setQtdEstoque(qtdEstoque);
				break;
			}

			}// fim do switch
			dao.alterar(produto, id);
			System.out.println("Produto editado com sucesso!");
		}

	} // fim do editar

	// LISTAGEM
	public static void listagem() {

		System.out.println("Listagem dos produtos cadastrados: ");
		for (Produto produto : dao.listar()) {
			System.out.println("Nome: " + produto.getNome());
			System.out.println("Id: " + produto.getId());
			System.out.println("Marca: " + produto.getMarca());
			System.out.println("Preço: " + produto.getPreco());
			System.out.println("Quantidade em estoque: " + produto.getQtdEstoque());
			System.out.println("------");
		}

		if (dao.listar().size() == 0) {
			System.out.println("-- Nenhum item cadastrado --");
		}
	} // fim da listagem

	// EXCLUIR
	public static void excluir(long idProduto) {
		dao.excluir(idProduto);

	} // fim do excluir

} // fim do programa