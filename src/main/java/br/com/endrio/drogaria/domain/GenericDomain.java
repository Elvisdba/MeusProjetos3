package br.com.endrio.drogaria.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@SuppressWarnings("serial") // ignorar warnings(avisos) do tipo Serial
@MappedSuperclass // não deixar que a classe pai, no caso essa, ser usada como
					// tabela, somente as filhas serão tabelas
public class GenericDomain implements Serializable {
	@Id // dizendo para o código que essa é uma chave primária
	@GeneratedValue(strategy = GenerationType.AUTO) // autoincremento da chave
													// primária (código) no
													// banco
	private Long codigo;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

}
