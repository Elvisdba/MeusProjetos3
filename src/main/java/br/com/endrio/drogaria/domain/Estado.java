package br.com.endrio.drogaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity // diz que a classe Estado é uma entidade do Hibernate. Vai gerar uma
		// tabela.
public class Estado extends GenericDomain {
	@Column(length = 2, nullable = false) // personaliza o tamanho do campo. O
											// nullable diz que o campo não pode
											// ser vazio
	private String sigla;
	@Column(length = 50, nullable = false)
	private String nome;

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
