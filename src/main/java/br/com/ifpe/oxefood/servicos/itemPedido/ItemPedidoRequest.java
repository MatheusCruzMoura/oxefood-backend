package br.com.ifpe.oxefood.servicos.itemPedido;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.ifpe.oxefood.modelo.item.Item;
import br.com.ifpe.oxefood.modelo.item.ItemService;
import br.com.ifpe.oxefood.modelo.itemPedido.ItemPedido;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoRequest {
	@Autowired
	private ItemService itemService;
	
	@NotNull(message = "O Valor é de preenchimento obrigatório")
	private int quantidade;
	
	@NotNull(message = "O Valor é de preenchimento obrigatório")
	private Long itemId;
	
	private Item item = itemService.obterItemPorID(itemId);
	
	public ItemPedido buildItemPedido() {
		return ItemPedido.builder()
				.nome(item.getNome())
				.valor(item.getValor())
				.descricao(item.getDescricao())
				.porcao(item.getPorcao())
				.imagem(item.getImagem())
				.build();
	}
}
