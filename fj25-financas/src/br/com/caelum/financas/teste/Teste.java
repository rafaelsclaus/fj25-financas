package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class Teste {
	
	public static void main(String[] args) {
		
		Movimentacao movimentacao = new Movimentacao();
		
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Conta de luz - Abril 2010");
		movimentacao.setValor(new BigDecimal("54"));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		manager.persist(movimentacao);
		manager.getTransaction().commit();
		
		manager.close();
		
		
	}
}
