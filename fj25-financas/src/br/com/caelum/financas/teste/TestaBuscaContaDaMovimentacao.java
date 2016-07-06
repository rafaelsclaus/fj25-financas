package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaBuscaContaDaMovimentacao {

	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();

		MovimentacaoDao dao = new MovimentacaoDao(manager);

		List<Movimentacao> lista = dao.lista();

		for (Movimentacao movimentacao : lista) {
			System.out.println(movimentacao.getConta().getTitular());
		}

	}

}
