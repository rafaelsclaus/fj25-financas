package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaSalvaMovimentacaoComConta {

	public static void main(String[] args) {
		
		EntityManager manager =  new JPAUtil().getEntityManager();
		
		MovimentacaoDao dao = new MovimentacaoDao(manager);
		
		Movimentacao movimentacao = new Movimentacao();
		
		manager.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setBanco("Banco Santander");
		conta.setNumero("99999-9");
		conta.setAgencia("0099");
		conta.setTitular("maria");
		
		movimentacao.setConta(conta);
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Conta de luz - Abril 2010");
		movimentacao.setValor(new BigDecimal("54"));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		
		dao.adiciona(movimentacao);
		
		manager.getTransaction().commit();
		manager.close();
		
	}
}
