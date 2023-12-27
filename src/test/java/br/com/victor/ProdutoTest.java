package br.com.victor;

import br.com.victor.dao.ProdutoDAO;
import br.com.victor.dao.IProdutoDao;
import br.com.victor.domain.Produto;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * @author victor.vianna
 *
 */
public class ProdutoTest {

	private IProdutoDao produtoDao;

	public ProdutoTest() {
		produtoDao = new ProdutoDAO();
	}

	@Test
	public void cadastrar() {
		Produto produto = new Produto();
		produto.setCodigo("A1");
		produto.setNome("Enxaguante Bucal");
		produto.setTipo("Colgate");
		produto = produtoDao.cadastrar(produto);

		assertNotNull(produto);
		assertNotNull(produto.getId());
	}

}
