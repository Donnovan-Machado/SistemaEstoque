package modelo;

import java.util.ArrayList;

public interface IProdutoDAO {

	public boolean inserir(Produto p);

	public boolean alterar(Produto p, long id);

	public boolean excluir(long id);

	public ArrayList<Produto> listar();

	public Produto buscaProdutoPorId(long id);

}
