package pacote;

import java.util.ArrayList;
import java.util.Scanner;

public class MainSistema {

	public static void main(String[] args) {
		
		Integer opcaoSelecionada = Integer.MAX_VALUE;
		Scanner sc = new Scanner(System.in);
		ArrayList<Produto> produtos = new ArrayList<>();
		
		while (opcaoSelecionada != 0) {
			/**
			 * Voce nao precisa seguir esta ordem, desde que seu sistema respeite a logica
			 * de incluir, alterar, listar e excluir de alguma forma.
			 */
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
				
				System.out.println("Nome: ");
				String nome = sc.nextLine();
				System.out.println("Marca: ");
				String marca = sc.nextLine();

				System.out.println("Preço: ");
				String preco = sc.nextLine();
				System.out.println("Estoque: ");
				String qtdEstoque = sc.nextLine();
				
				
				Produto produto = new Produto();
				produto.setNome(nome);
				produto.setPreco(Float.valueOf(preco));
				/*TERMINAR
				 * 
				 
				

				produto.add(produtos);

			}
			case 2: {
				System.out.println("Digite o cpf da pessoa que deseja alterar:");
				// finalizar codigo
			}
			case 3: {
				System.out.println("Digite o cpf da pessoa que deseja excluir:");
				// finalizar codigo
			}
			case 4: {
				// Saida de dados (output)
				System.out.println("Listagem de pessoas cadastradas: ");
				for (Pessoa pessoa : pessoas) {
					System.out.println("Cpf: " + pessoa.getCpf());
					System.out.println("Nome: " + pessoa.getNome());
				}
			}

			}
				*/
		}
		sc.close();
		
	}

}
