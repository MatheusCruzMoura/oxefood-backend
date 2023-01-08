package br.com.ifpe.oxefood.modelo.empresa;

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

@Entity
@Table(name = "Empresa")
@Where(clause = "habilitado = true")
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Empresa extends EntidadeAuditavel {

	private static final long serialVersionUID = 2030862184597799865L;

	@Column
	private String chave;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Usuario usuario;

	@Column
	private String site;

	@Column(nullable = false)
	private String cnpj;

	@Column(nullable = false)
	private String inscricaoEstadual;

	@Column(nullable = false)
	private String nomeEmpresarial;

	@Column(nullable = false)
	private String nomeFantasia;

	@Column(nullable = false)
	private String fone;

	@Column
	private String foneAlternativo;

	public void updateFrom(Empresa param) {
		this.setChave(param.getChave());
		this.setSite(param.getSite());
		this.setCnpj(param.getCnpj());
		this.setInscricaoEstadual(param.getInscricaoEstadual());
		this.setNomeEmpresarial(param.getNomeEmpresarial());
		this.setNomeFantasia(param.getNomeFantasia());
		this.setFone(param.getFone());
		this.setFoneAlternativo(param.getFoneAlternativo());
	}

}
