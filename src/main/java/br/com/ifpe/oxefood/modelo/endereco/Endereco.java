package br.com.ifpe.oxefood.modelo.endereco;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import br.com.ifpe.oxefood.modelo.acesso.Usuario;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Cliente")
@Where(clause = "habilitado = true")
public class Endereco extends EntidadeAuditavel {

	private static final long serialVersionUID = 8648241655458475570L;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Usuario usuario;

	@Column
	private String cep;

	@Column
	private String logradouro;

	@Column
	private String numero;

	@Column
	private String bairro;

	@Column
	private String cidade;

	@Column
	private String uf;

	@Column
	private String complemento;

	public void updateFrom(Endereco param) {

		this.setCep(param.getCep());
		this.setLogradouro(param.getLogradouro());
		this.setNumero(param.getNumero());
		this.setBairro(param.getBairro());
		this.setCidade(param.getCidade());
		this.setUf(param.getUf());
		this.setComplemento(param.getComplemento());
	}
}
