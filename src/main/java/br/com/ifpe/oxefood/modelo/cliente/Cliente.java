package br.com.ifpe.oxefood.modelo.cliente;

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
public class Cliente extends EntidadeAuditavel {

	private static final long serialVersionUID = -6085010525880815346L;

	@Column(nullable = false)
	private String chaveEmpresa;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Usuario usuario;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String sobrenome;

	@Column(nullable = false)
	private String fone;

	public void updateFrom(Cliente param) {

		this.setChaveEmpresa(param.getChaveEmpresa());
		this.setNome(param.getNome());
		this.setSobrenome(param.getSobrenome());
		this.setFone(param.getFone());
	}
}
