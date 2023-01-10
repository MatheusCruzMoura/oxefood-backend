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
	
	private String categoria;
	
	private String imagem;
	
	private double valorFrete;
	
	public Loja buildLoja() {
		Loja loja = Loja.builder()
				.nome(nome)
				.categoria(categoria)
				.imagem(imagem)
				.valorFrete(valorFrete)
				.build();
		return loja;
	}

}
