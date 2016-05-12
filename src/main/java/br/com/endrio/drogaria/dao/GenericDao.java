package br.com.endrio.drogaria.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.endrio.drogaria.util.HibernateUtil;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericDao<Entidade> {
	
	private Class<Entidade> classe; //capturar classe
	
	
	public GenericDao(){
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	

	public void salvar(Entidade entidade) {

		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession(); //abrir sessão
		Transaction transacao = null; // transaction garante que duas entidades
										// de
										// transação devem ocorrer ao mesmo
										// tempo
		try {
			transacao = sessao.beginTransaction();
			sessao.save(entidade);//salvar
			transacao.commit();// confirmar transação
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();//desfazer operação

			}
			throw erro;// avisar camadas superiores que o erro
						// ocorreu.
		} finally {
			sessao.close();//encerrar ligação
		}

	}
	
	@SuppressWarnings("unchecked")
	public List<Entidade> listar(){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession(); //abrir sessão
		try{
			Criteria consulta = sessao.createCriteria(classe);//Consulta 
			List<Entidade> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro){
			throw erro;
			
		} finally {
			sessao.close();//encerrar ligação
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public Entidade buscar(long codigo){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession(); //abrir sessão
		try{
			Criteria consulta = sessao.createCriteria(classe);//Consulta 
			consulta.add(Restrictions.idEq(codigo));//idEq= id equals. Restrição
													//pra filtrar a pesquisa
			Entidade resultado = (Entidade) consulta.uniqueResult();//buscar apenas um resultado
			return resultado;
		} catch (RuntimeException erro){
			throw erro;
			
		} finally {
			sessao.close();//encerrar ligação
		}
		
	}
	
	public void excluir(Entidade entidade) {

		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession(); //abrir sessão
		Transaction transacao = null; // transaction garante que duas entidades
										// de
										// transação devem ocorrer ao mesmo
										// tempo
		try {
			transacao = sessao.beginTransaction();
			sessao.delete(entidade);//deletar
			transacao.commit();// confirmar transação
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();//desfazer operação

			}
			throw erro;// avisar camadas superiores que o erro
						// ocorreu.
		} finally {
			sessao.close();//encerrar ligação
		}

	}
	
	public void editar(Entidade entidade) {

		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession(); //abrir sessão
		Transaction transacao = null; // transaction garante que duas entidades
										// de
										// transação devem ocorrer ao mesmo
										// tempo
		try {
			transacao = sessao.beginTransaction();
			sessao.update(entidade);//deletar
			transacao.commit();// confirmar transação
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();//desfazer operação

			}
			throw erro;// avisar camadas superiores que o erro
						// ocorreu.
		} finally {
			sessao.close();//encerrar ligação
		}

	}

}
