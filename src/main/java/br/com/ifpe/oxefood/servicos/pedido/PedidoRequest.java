package br.com.ifpe.oxefood.servicos.pedido;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.ifpe.oxefood.modelo.pedido.Endereco;
import br.com.ifpe.oxefood.modelo.pedido.Pedido;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoRequest {
	
	@NotNull
    @NotEmpty
	private Date data;
	
	@NotNull
    @NotEmpty
	private Double valorTotal;
	
	@NotNull
    @NotEmpty
	private Endereco endereco;
	
	
	private String observacao;
	
	@NotNull
    @NotEmpty
	private String situacaoPagamento;
	
	public Pedido buildPedido() {
		return Pedido.builder()
				.data(data)
				.valorTotal(valorTotal)
				.observacao(observacao)
				.situacaoPagamento(situacaoPagamento)
				.build();
	}
	
}
