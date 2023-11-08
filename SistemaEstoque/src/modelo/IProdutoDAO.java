package modelo;

import java.util.ArrayList;

public interface IProdutoDAO {

	public boolean alterar(Produto p);

	public int inserir(Produto p);

	public boolean excluir(Produto p);

	public ArrayList<Produto> listar();

}
