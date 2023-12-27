/**
 * 
 */
package br.com.victor.dao;

import br.com.victor.domain.Produto;

import java.util.List;

/**
 * @author victor.vianna
 *
 */
public interface IProdutoDao {

	public Produto cadastrar(Produto curso);

	public void excluir(Produto cur);

	public List<Produto> buscarTodos();
}
