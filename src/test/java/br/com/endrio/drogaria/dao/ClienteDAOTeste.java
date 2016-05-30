package br.com.endrio.drogaria.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import br.com.endrio.drogaria.domain.Cliente;
import br.com.endrio.drogaria.domain.Cliente;
import br.com.endrio.drogaria.domain.Pessoa;
//import br.com.endrio.drogaria.domain.Cliente;

public class ClienteDAOTeste {
	@Test
	//@Ignore // ignorar o resultado e não vai salvar
	public void salvar() throws ParseException {
		PessoaDAO pessoaDAO = new PessoaDAO();// chave estrangeira
		Pessoa pessoa = pessoaDAO.buscar(2L);// objeto da chave estrangeira deve
		
		Cliente cliente = new Cliente();
		//cliente.setDataCadastro(new Date());//data do sistema
		cliente.setDataCadastro(new SimpleDateFormat("dd/MM/yyyy").parse("29/05/2016"));
		cliente.setLiberado(false);
		cliente.setPessoa(pessoa);

		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente);
		System.out.println("Cliente Salvo!");
	}
	
	@Test
	@Ignore
	public void excluir() {
		Long codigo = 2L;
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigo);
		if (cliente == null) {
			System.out.println("Essa cliente não foi encontrada nos registros.");
		} else {
			clienteDAO.excluir(cliente);// Não dá pra remover um Estado com
										// Clientes atreladas a ele, portanto
										// deve-se excluir as clientes primeiro
										// antes de excluir um estado.

			System.out.println("Ítem removido: ");
			
		}

	}

}
