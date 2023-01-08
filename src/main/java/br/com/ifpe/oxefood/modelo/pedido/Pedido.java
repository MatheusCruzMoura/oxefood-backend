package br.com.ifpe.oxefood.modelo.pedido;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import br.com.ifpe.oxefood.modelo.empresa.Empresa;
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
@Table(name = "pedido")
@Where(clause = "habilitado = true")
public class Pedido extends EntidadeAuditavel{

	private static final long serialVersionUID = -4487581760503814730L;
	
	@JsonIgnore
    @ManyToOne
    private Cliente cliente;
	
	@JsonIgnore
    @ManyToOne
    private Empresa empresa;
	
	@Column(nullable = false)
	private Date data;
	
	@Column(nullable = false)
	private Double valorTotal;
	
	@Column(nullable = false)
	private Endereco endereco;
	
	@Column(nullable = false)
	private String observacao;
	
	@Column(nullable = false)
	private String situacaoPagamento;
	
	@OneToMany(mappedBy = "pedido", orphanRemoval = true, fetch = FetchType.EAGER)
	@Column(nullable = false)
	private List<ItemPedido> itemsPedido;
	
	public void updateFrom(Pedido param) {
		this.setData(param.getData());
		this.setValorTotal(param.getValorTotal());
		this.setObservacao(param.getObservacao());
		this.setSituacaoPagamento(param.getSituacaoPagamento());
	}
	
}
