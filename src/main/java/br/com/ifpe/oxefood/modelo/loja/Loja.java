package br.com.ifpe.oxefood.modelo.loja;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import br.com.ifpe.oxefood.modelo.item.Item;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Loja")
@Where(clause = "habilitado = true")
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Loja extends EntidadeAuditavel {

	private static final long serialVersionUID = 2819481163306535449L;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String categoria;

	@Column
	private String imagem;

	@Column(nullable = false)
	private double valorFrete;
	
	@OneToMany(mappedBy = "loja", orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Item> itens;

	public void updateFrom(Loja param) {

		this.setNome(param.getNome());
		this.setCategoria(param.getCategoria());
		this.setImagem(param.getImagem());
		this.setValorFrete(param.getValorFrete());
	}

}
