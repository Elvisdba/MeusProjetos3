package br.com.endrio.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.endrio.drogaria.domain.Fabricante;
import br.com.endrio.drogaria.domain.Fabricante;


public class FabricanteDAOTeste {
	@Test
	@Ignore
	public void salvar(){
		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("Monta coisas");
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.salvar(fabricante);
		
		
	}
	@Test
	@Ignore
	public void listar (){
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		List<Fabricante> resultado = fabricanteDAO.listar();
		
		for(Fabricante fabricante : resultado){
			System.out.println(fabricante.getDescricao());
			
		}
	}
	
	@Test
	@Ignore
	public void buscar (){
		Long codigo = 2L; //2L: esse "L" é pra mostrar que é long e não int por exemplo
						  //o "2" é o código que eu quero buscar
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		
		if (fabricante == null){
			System.out.println("Nenhum registro encontrado.");
		} else{
		System.out.println("Registro encontrado.");
		System.out.println(fabricante.getDescricao());
		}
	}
	
	@Test
	@Ignore
	public void exluir(){
		Long codigo = 6L; //3L: esse "L" é pra mostrar que é long e não int por exemplo
		  //o "2" é o código que eu quero buscar
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		if (fabricante == null){
			System.out.println("Nenhum registro encontrado.");
		} else{
		fabricanteDAO.excluir(fabricante);
		System.out.println("Registro removido.");
		System.out.println(fabricante.getDescricao());
		}
		
	}
	@Test
	
	public void editar(){
		Long codigo = 2L; //6L: esse "L" é pra mostrar que é long e não int por exemplo
		  //o "2" é o código que eu quero buscar
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		if (fabricante == null){
			System.out.println("Nenhum registro encontrado.");
		} else{
			System.out.println(fabricante.getDescricao());
			fabricante.setDescricao("quebra coisas");;
			fabricanteDAO.editar(fabricante);
			System.out.println(fabricante.getDescricao());
			System.out.println("Dados Modificados.");
		}
	}
}
