package br.com.endrio.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.endrio.drogaria.domain.Estado;

public class EstadoDAOTeste {
	@Test
	@Ignore//ignorar o resultado e não vai salvar
	public void salvar(){
		Estado estado = new Estado();
		estado.setNome("Distrito Federal");
		estado.setSigla("DF");
		
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
	}
	
	@Test
	@Ignore
	public void listar (){
		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.listar();
		
		for(Estado estado : resultado){
			System.out.println(estado.getSigla() +" - "+estado.getNome());
			
		}
	}
	
	@Test
	@Ignore
	public void buscar (){
		Long codigo = 2L; //2L: esse "L" é pra mostrar que é long e não int por exemplo
						  //o "2" é o código que eu quero buscar
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		if (estado == null){
			System.out.println("Nenhum registro encontrado.");
		} else{
		System.out.println("Registro encontrado.");
		System.out.println(estado.getCodigo()+"-"+estado.getNome()+"-"+estado.getSigla());
		}
	}
	
	@Test
	@Ignore
	public void exluir(){
		Long codigo = 3L; //3L: esse "L" é pra mostrar que é long e não int por exemplo
		  //o "2" é o código que eu quero buscar
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		if (estado == null){
			System.out.println("Nenhum registro encontrado.");
		} else{
		estadoDAO.excluir(estado);
		System.out.println("Registro removido.");
		System.out.println(estado.getCodigo()+"-"+estado.getNome()+"-"+estado.getSigla());
		}
		
	}
	@Test
	public void editar(){
		Long codigo = 6L; //6L: esse "L" é pra mostrar que é long e não int por exemplo
		  //o "2" é o código que eu quero buscar
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		if (estado == null){
			System.out.println("Nenhum registro encontrado.");
		} else{
			System.out.println(estado.getCodigo()+"-"+estado.getNome()+"-"+estado.getSigla());
			estado.setNome("Esprito Santo");
			estado.setSigla("ES");
			estadoDAO.editar(estado);
			System.out.println(estado.getCodigo()+"-"+estado.getNome()+"-"+estado.getSigla());
			System.out.println("Dados Modificados.");
		}
		
	}
	
	
}
