package br.com.ifpe.oxefood.servicos.item;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.ifpe.oxefood.modelo.item.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequest {
	
	@NotNull(message = "O Nome é de preenchimento obrigatório")
	@NotBlank(message = "O Nome é de preenchimento obrigatório")
	@Length(max = 100, message = "O Nome deverá ter no máximo {max} caracteres")
	private String nome;
	
	@NotNull(message = "O Valor é de preenchimento obrigatório")
	private Double valor;
	
	private String descricao;
	
	@NotBlank(message = "A descrição é de preenchimento obrigatório")
	private String porcao;
	
	public Item buildItem() {
		return Item.builder()
				.nome(nome)
				.valor(valor)
				.descricao(descricao)
				.porcao(porcao)
				.build();
	}
}
