package br.com.ifpe.oxefood.modelo.itemPedido;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ifpe.oxefood.modelo.pedido.Pedido;
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
@Table(name = "ItemPedido")
@Where(clause = "habilitado = true")
public class ItemPedido extends EntidadeAuditavel{

	private static final long serialVersionUID = -2600297080276180827L;

	@JsonIgnore
	@ManyToOne
	private Pedido pedido;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private Double valor;
	
	@Column(nullable = false)
	private int quantidade;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column()
	private String imagem;
	
	@Column(nullable = false)
	private String porcao;
	
	public void updateFrom(ItemPedido param) {
		
		this.setNome(param.getNome());
		this.setValor(param.getValor());
		this.setQuantidade(param.getQuantidade());
		this.setDescricao(param.getDescricao());
		this.setImagem(param.getImagem());
		this.setPorcao(param.getPorcao());
		
	}
}
