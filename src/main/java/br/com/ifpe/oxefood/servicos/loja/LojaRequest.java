package br.com.ifpe.oxefood.servicos.loja;

import br.com.ifpe.oxefood.modelo.loja.Loja;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LojaRequest {
	
	private String nome;
	
	private String imagem;
	
	private long id_categoria;
	
	private double valor_frete;
	
	public Loja buildLoja() {
		Loja loja = Loja.builder()
				.nome(nome)
				.imagem(imagem)
				.valor_frete(valor_frete)
				.build();
		return loja;
	}

}
