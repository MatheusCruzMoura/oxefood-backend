package br.com.ifpe.oxefood.modelo.pedido;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import br.com.ifpe.oxefood.modelo.endereco.Endereco;
import br.com.ifpe.oxefood.modelo.itemPedido.ItemPedido;
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
@Table(name = "Pedido")
@Where(clause = "habilitado = true")
public class Pedido extends EntidadeAuditavel{

	private static final long serialVersionUID = -3711655655251987179L;
	
	@JsonIgnore
	@ManyToOne
	private Loja loja;
	
	@JsonIgnore
	@ManyToOne
	private Cliente cliente;
	
	@Column(nullable = false)
	private LocalDate data;
	
	@Column(nullable = false)
	private Double valorTotal;
	
	@Column(nullable = false)
	private Endereco enderecoEntrega;
	
	@Column
	private String observacao;
	
	@Column(nullable = false)
	private String situacaoPagamento;
	
	@OneToMany(mappedBy = "pedido", orphanRemoval = true, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ItemPedido> itens;
	
	public void updateFrom(Pedido param) {
		this.setData(param.getData());
		this.setValorTotal(param.getValorTotal());
		this.setEnderecoEntrega(param.getEnderecoEntrega());
		this.setObservacao(param.getObservacao());
		this.setSituacaoPagamento(param.getSituacaoPagamento());
	}

}
