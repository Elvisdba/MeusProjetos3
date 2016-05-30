package br.com.endrio.drogaria.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.endrio.drogaria.domain.Produto;
import br.com.endrio.drogaria.domain.Produto;
import br.com.endrio.drogaria.domain.Fabricante;
import br.com.endrio.drogaria.domain.Fabricante;
import br.com.endrio.drogaria.domain.Produto;

public class ProdutoDAOTeste {
	@Test
	@Ignore // ignorar o resultado e não vai salvar
	public void salvar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(2L);

		Produto produto = new Produto();
		produto.setFabricante(fabricante);
		produto.setDescricao("Novalgina");
		produto.setPreco(new BigDecimal("1.8"));// é preciso instanciar um
												// objeto para
												// para poder colocar um valor
												// BigDecimal(autoboxing)
		produto.setQuantidade(new Short("6"));
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto);

		System.out.println("salvo");
	}

	@Test
	@Ignore
	public void listar() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> resultado = produtoDAO.listar();

		for (Produto produto : resultado) {
			System.out.println("Descrição do Produto: " + produto.getDescricao());
			System.out.println("Quantidade do Produto: " + produto.getQuantidade());
			System.out.println("Preço do Produto: " + produto.getPreco());
			System.out.println("Fabricante do Produto: " + produto.getFabricante().getDescricao());
			System.out.println("-------------------------------------------------");
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);
		if (produto == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			System.out.println("Registro encontrado.");
			System.out.println("Descrição da Produto: " + produto.getDescricao());
			System.out.println("Código do Fabricante: " + produto.getFabricante().getCodigo());
			System.out.println("Descrição do Fabricante: " + produto.getFabricante().getDescricao());
		
			System.out.println("-------------------------------------------------");
		}
	}
	
	@Test
	@Ignore
	public void excluir() {
		Long codigo = 3L;
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);
		if (produto == null) {
			System.out.println("Essa produto não foi encontrada nos registros.");
		} else {
			produtoDAO.excluir(produto);// Não dá pra remover um Fabricante com
										// Produtos atreladas a ele, portanto
										// deve-se excluir as produtos primeiro
										// antes de excluir um fabricante.

			System.out.println("Ítem removido: ");
			System.out.println("Descrição do Produto: " + produto.getDescricao());
			System.out.println("Código do Fabricante: " + produto.getFabricante().getCodigo());
			System.out.println("Descrição do Fabricante: " + produto.getFabricante().getDescricao());
			System.out.println("-------------------------------------------------");
		}

	}

	@Test
	@Ignore
	public void editar() {
		Long codigo = 3L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);

		Long codigoProduto = 2L;
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigoProduto);
		
		if (fabricante == null || produto == null){
			System.out.println("Nenhum registro encontrado.");
		} else{
		System.out.println("Descrição do Fabricante: " + fabricante.getDescricao());
		System.out.println("Descrição do Produto: " + produto.getDescricao());
		produto.setDescricao("Colírio");
		produto.setFabricante(fabricante);

		produtoDAO.editar(produto);

		System.out.println("Descrição do produto editado: " + produto.getDescricao());
		System.out.println("Descrição do fabricante editado: " + fabricante.getDescricao());
		}

	}

}
