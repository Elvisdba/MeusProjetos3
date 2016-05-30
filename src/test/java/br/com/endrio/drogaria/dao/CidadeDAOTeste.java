package br.com.endrio.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.endrio.drogaria.domain.Cidade;
import br.com.endrio.drogaria.domain.Estado;

public class CidadeDAOTeste {
	@Test
	//@Ignore // ignorar o resultado e não vai salvar
	public void salvar() {
		EstadoDAO estadoDAO = new EstadoDAO();// chave estrangeira
		Estado estado = estadoDAO.buscar(2L);// objeto da chave estrangeira deve
												// buscar
												// o código da cidade que ele
												// quer que Cidade receba como
												// chave
												// estrangeira
		Cidade cidade = new Cidade();
		cidade.setNome("Belo Horizonte");
		cidade.setEstado(estado);// Aqui vai receber o 1L.

		CidadeDAO cidadeDAO = new CidadeDAO();
		cidadeDAO.salvar(cidade);
		

	}

	@Test
	@Ignore
	public void listar() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.listar();

		for (Cidade cidade : resultado) {
			System.out.println("Código da Cidade: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNome());
			System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
			System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
			System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
			System.out.println("-------------------------------------------------");
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		if (cidade == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			System.out.println("Registro encontrado.");
			System.out.println("Código da Cidade: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNome());
			System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
			System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
			System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
			System.out.println("-------------------------------------------------");
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 7L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		if (cidade == null) {
			System.out.println("Essa cidade não foi encontrada nos registros.");
		} else {
			cidadeDAO.excluir(cidade);// Não dá pra remover um Estado com
										// Cidades atreladas a ele, portanto
										// deve-se excluir as cidades primeiro
										// antes de excluir um estado.

			System.out.println("Ítem removido: ");
			System.out.println("Código da Cidade: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNome());
			System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
			System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
			System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
			System.out.println("-------------------------------------------------");
		}

	}

	@Test
	@Ignore
	public void editar() {
		Long codigo = 1L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);

		Long codigoCidade = 2L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigoCidade);
		
		if (estado == null || cidade == null){
			System.out.println("Nenhum registro encontrado.");
		} else{
		System.out.println("Nome do Estado: " + estado.getNome());
		System.out.println("Nome da Cidade: " + cidade.getNome());
		cidade.setNome("Rio Pomba");
		cidade.setEstado(estado);

		cidadeDAO.editar(cidade);

		System.out.println("Nome cidade editado: " + cidade.getNome());
		System.out.println("Nome estado editado: " + estado.getNome());
		}

	}
}
