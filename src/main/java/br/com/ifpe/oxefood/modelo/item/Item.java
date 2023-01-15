package br.com.ifpe.oxefood.modelo.item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ifpe.oxefood.modelo.loja.Loja;
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
@Table(name = "Item")
@Where(clause = "habilitado = true")
public class Item extends EntidadeAuditavel {
	
	private static final long serialVersionUID = 7605458690359516249L;

	@JsonIgnore
	@ManyToOne
	private Loja loja;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private Double valor;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column()
	private String imagem;
	
	@Column(nullable = false)
	private String porcao;
	
	
	public void updateFrom(Item param) {
		
		this.setNome(param.getNome());
		this.setValor(param.getValor());
		this.setDescricao(param.getDescricao());
		this.setImagem(param.getImagem());
		this.setPorcao(param.getPorcao());
		
	}
}
