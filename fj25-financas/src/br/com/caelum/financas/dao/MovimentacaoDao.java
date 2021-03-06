package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Movimentacao;

public class MovimentacaoDao {

	private EntityManager manager;

	public MovimentacaoDao(EntityManager manager) {
		this.manager = manager;
	}

	public void adiciona(Movimentacao movimentacao) {
		manager.persist(movimentacao);
	}

	public void remove(Movimentacao movimentacao) {
		manager.remove(movimentacao);
	}

	public List<Movimentacao> lista() {
		return this.manager.createQuery("select m from Movimentacao m",
				Movimentacao.class).getResultList();
	}

	public Movimentacao busca(Integer id) {
		return this.manager.find(Movimentacao.class, id);
	}
}
