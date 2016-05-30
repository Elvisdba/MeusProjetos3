package br.com.endrio.drogaria.dao;

import org.junit.Ignore;
import org.junit.Test;

import br.com.endrio.drogaria.domain.Usuario;
import br.com.endrio.drogaria.domain.Pessoa;

public class UsuarioDAOTeste {
	
	@Test
	//@Ignore//ignorar o resultado e não vai salvar
	public void salvar(){
		Usuario usuario = new Usuario();
		PessoaDAO pessoaDAO = new PessoaDAO();// chave estrangeira
		Pessoa pessoa = pessoaDAO.buscar(1L);// objeto da chave estrangeira deve
		
		System.out.println("Pessoa Encontrada!");
		System.out.println(pessoa.getNome());
		
		usuario.setAtivo(true);
		usuario.setPessoa(pessoa);
		usuario.setSenha("senha");
		usuario.setTipo('A');
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);
		System.out.println("Usuário Salvo!");
	}
	
	@Test
	@Ignore
	public void excluir() {
		Long codigo = 2L;
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigo);
		if (usuario == null) {
			System.out.println("Essa usuario não foi encontrada nos registros.");
		} else {
			usuarioDAO.excluir(usuario);// Não dá pra remover um Estado com
										// Usuarios atreladas a ele, portanto
										// deve-se excluir as usuarios primeiro
										// antes de excluir um estado.

			System.out.println("Ítem removido: ");
			
		}

	}

}
