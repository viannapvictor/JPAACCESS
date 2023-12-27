/**
 * 
 */
package br.com.victor.dao;

import br.com.victor.domain.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


/**
 * @author victor.vianna
 *
 */
public class ProdutoDAO implements IProdutoDao {


	@Override
	public Produto cadastrar(Produto produto) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = emf.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(produto);
		entityManager.getTransaction().commit();

		entityManager.close();
		emf.close();

		return produto;
	}

	@Override
	public void excluir(Produto produto) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = emf.createEntityManager();

		entityManager.getTransaction().begin();
		produto = entityManager.merge(produto);
		entityManager.remove(produto);
		entityManager.getTransaction().commit();

		entityManager.close();
		emf.close();
	}

	@Override
	public List<Produto> buscarTodos() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = emf.createEntityManager();


		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
		Root<Produto> root = query.from(Produto.class);
		query.select(root);

		TypedQuery<Produto> tpQuery =
				entityManager.createQuery(query);
		List<Produto> list = tpQuery.getResultList();

		entityManager.close();
		emf.close();
		return list;
	}
}