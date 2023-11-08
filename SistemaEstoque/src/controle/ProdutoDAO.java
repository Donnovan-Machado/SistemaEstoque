package controle;

import java.util.ArrayList;

import modelo.IProdutoDAO;
import modelo.Produto;

public class ProdutoDAO implements IProdutoDAO {

	@Override
	public boolean alterar(Produto p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean inserir(Produto p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluir(Produto p) {
		for (Produto produto : produtos) {
			if (produto.getId() == idProduto) {
				produtos.remove(produto);
				return true;
			} else {
				return false;
			}
		}
		
	}

	
	
	
	
	@Override
	public ArrayList<Produto> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
