package controle;

import java.util.ArrayList;

import modelo.IProdutoDAO;
import modelo.Produto;

public class ProdutoDAO implements IProdutoDAO {

	private static ArrayList<Produto> tabelaProdutos;
	private static ProdutoDAO instancia;
	// CADASTRAR
	private static long contador = 0;

	public static long geradorId() {
		return contador++;
	}

	/**
	 * Torna o construtor da classe privado Para impedir que a classe seja
	 * instanciada
	 */
	private ProdutoDAO() {
	}

	/**
	 * Metodo utilizando padrao Singleton impossibilitando que se criem diversos
	 * objetos em memoria RAM apenas se crie um uma unica vez e se manipule o mesmo
	 * 
	 * 
	 * @return
	 */
	public static ProdutoDAO getInstancia() {

		if (instancia == null) {
			instancia = new ProdutoDAO();
			tabelaProdutos = new ArrayList<>();

			Produto penguim = new Produto();
			penguim.setId(geradorId());
			penguim.setNome("PenguimAnao");
			penguim.setMarca("Club PinGuins");
			penguim.setPreco(999f);
			penguim.setQtdEstoque(1);
			tabelaProdutos.add(penguim);
		}

		return instancia;
	}

	@Override
	public boolean alterar(Produto prodNovosDados, long id) {
		for (Produto prodAntigo : tabelaProdutos) {
			if (prodAntigo.getId() == id) {
				prodAntigo = prodNovosDados;
			}
		}
		return false;
	}

	@Override
	public boolean inserir(Produto p) {
		p.setId(geradorId());
		return tabelaProdutos.add(p);
	}

	@Override
	public boolean excluir(long id) {
		for (Produto produto : tabelaProdutos) {
			if (produto.getId() == id) {
				tabelaProdutos.remove(produto);
				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<Produto> listar() {
		return tabelaProdutos;
	}

	@Override
	public Produto buscaProdutoPorId(long id) {
		for (Produto produto : tabelaProdutos) {
			if (produto.getId() == id) {
				return produto;
			}
		}
		return null;
	}

}
