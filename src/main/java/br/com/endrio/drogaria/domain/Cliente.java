package br.com.endrio.drogaria.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Cliente extends GenericDomain {
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;
	@Column(nullable = false)
	private Boolean liberado;
	@JoinColumn(nullable = false) // a chave estrangeira deve ficar na classe
									// Cliente ao invés de Pessoa, pq um cliente
									// está obrigatoriamente atrelado a uma
									// pessoa, mas uma pessoa não
									// necessariamente possui uma conta de
									// cliente.
	@OneToOne // uma pessoa pode ter apenas uma conta de cliente e uma conta de
				// cliente só pode estar atrelada a uma pessoa.
	private Pessoa pessoa;
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Boolean getLiberado() {
		return liberado;
	}
	public void setLiberado(Boolean liberado) {
		this.liberado = liberado;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
