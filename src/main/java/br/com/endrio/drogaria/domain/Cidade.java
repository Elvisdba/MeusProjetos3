package br.com.endrio.drogaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Cidade extends GenericDomain {
	@Column(length = 50, nullable = false)
	private String nome;
	@ManyToOne // relação de cidades e estados. Um Estado contém várias cidades,
				// uma cidade só pode estar atrelada a um estado.
	@JoinColumn(nullable = false) // personalizar as propeiedades de colunas
									// estrangeiras
	private Estado estado;// chave estrangeira

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
