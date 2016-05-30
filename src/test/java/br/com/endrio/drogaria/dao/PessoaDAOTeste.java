package br.com.endrio.drogaria.dao;

import org.junit.Ignore;
import org.junit.Test;

import br.com.endrio.drogaria.domain.Pessoa;
import br.com.endrio.drogaria.domain.Cidade;

public class PessoaDAOTeste {
	@Test
	//@Ignore // ignorar o resultado e não vai salvar
	public void salvar() {
		CidadeDAO cidadeDAO = new CidadeDAO();// chave estrangeira
		Cidade cidade = cidadeDAO.buscar(2L);// objeto da chave estrangeira deve
												// buscar
												// o código da cidade que ele
												// quer que Pessoa receba como
												// chave
												// estrangeira, então essa pessoa é de BH
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Endrio");
		pessoa.setEmail("endrio.souza@hotmail.com");
		pessoa.setCpf("080.093.606.00");
		pessoa.setRua("Rua 20");
		pessoa.setBairro("Valparaíso");
		pessoa.setNumero(new Short("102"));
		pessoa.setComplemento("");
		pessoa.setCidade(cidade);// Aqui vai receber o 1L.
		pessoa.setCep("33125-070");
		pessoa.setCelular("61 8541-5005");
		pessoa.setTelefone("31 3636-9819");
		pessoa.setRg("13100004");

		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.salvar(pessoa);

	}
	
	@Test
	@Ignore
	public void excluir() {
		Long codigo = 2L;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);
		if (pessoa == null) {
			System.out.println("Essa pessoa não foi encontrada nos registros.");
		} else {
			pessoaDAO.excluir(pessoa);// Não dá pra remover um Estado com
										// Cidades atreladas a ele, portanto
										// deve-se excluir as cidades primeiro
										// antes de excluir um estado.

			System.out.println("Ítem removido: ");
			System.out.println("-------------------------------------------------");
		}

	}

}
