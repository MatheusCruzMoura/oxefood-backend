package br.com.ifpe.oxefood.servicos.pedido;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.ifpe.oxefood.modelo.itemPedido.ItemPedido;
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
	private Double valorTotal;

	private String observacao;
	
	@NotBlank(message = "A situacaoPagamento é de preenchimento obrigatório")
	private String situacaoPagamento;
	
	@NotNull
	private List<ItemPedido> items;
	
	public Pedido buildPedido() {
		
		return Pedido.builder()
				.data(LocalDate.now())
				.valorTotal(valorTotal)
				.observacao(observacao)
				.situacaoPagamento(situacaoPagamento)
				.itens(items)
				.build();
	}
	
}
