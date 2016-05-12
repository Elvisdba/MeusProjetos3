package br.com.endrio.drogaria.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Venda extends GenericDomain {
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP) // timestamp é para data e hora
	private Date horario;
	@Column(nullable = false, precision = 7, scale = 2)
	private BigDecimal precoTotal;
	@ManyToOne
	@JoinColumn(nullable = true) // join column com nullable true é a mesma
									// coisa que se não tivesse nada. A relação
									// entre venda e cliente não é obrigatória,
									// portanto é uma relação de agregação. Uma
									// venda pode existir sem um cliente, o que
									// configura uma venda a vista.

	private Cliente cliente;
	@ManyToOne // uma venda tem um funcionário, mas um funcionário pode
	// participar de várias vendas.
	@JoinColumn(nullable = true)
	private Funcionario funcionario;

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public BigDecimal getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(BigDecimal precoTotal) {
		this.precoTotal = precoTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
