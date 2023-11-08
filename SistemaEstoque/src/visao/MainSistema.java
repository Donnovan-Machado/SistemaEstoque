package visao;

import java.util.ArrayList;
import java.util.Scanner;

import controle.ProdutoDAO;
import modelo.Produto;

public class MainSistema {

	private static ArrayList<Produto> produtos = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Integer opcaoSelecionada = Integer.MAX_VALUE;

		Produto penguim = new Produto();
		penguim.setId(geradorId());
		penguim.setNome("PenguimAnao");
		penguim.setMarca("Club PinGuins");
		penguim.setPreco(999f);
		penguim.setQtdEstoque(1);
		produtos.add(penguim);
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

	// CADASTRAR
	private static long contador = 0;

	public static long geradorId() {
		return contador++;
	}

	public static void cadastrar() {
		String nome, marca;
		Integer qtdEstoque;
		Float preco;
		Produto produto = new Produto();
		System.out.println("O id do produto vai ser: ");
		produto.setId(geradorId());
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

		ProdutoDAO dao = new ProdutoDAO();
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
		for (Produto produto : produtos) {
			if (id == produto.getId()) {
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
			}
		}

		System.out.println("Produto editado com sucesso!");

	} // fim do editar

	// LISTAGEM
	public static void listagem() {
		System.out.println("Listagem dos produtos cadastrados: ");
		for (Produto produto : produtos) {
			System.out.println("Nome: " + produto.getNome());
			System.out.println("Id: " + produto.getId());
			System.out.println("Marca: " + produto.getMarca());
			System.out.println("Preço: " + produto.getPreco());
			System.out.println("Quantidade em estoque: " + produto.getQtdEstoque());
			System.out.println("------");
		}

		if (produtos.size() == 0) {
			System.out.println("-- Nenhum item cadastrado --");
		}
	} // fim da listagem

	// EXCLUIR
	public static void excluir(long idProduto) {
		ProdutoDAO dao = new ProdutoDAO();
		dao.excluir(idProduto);

	} // fim do excluir

} // fim do programa