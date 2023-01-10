package br.com.ifpe.oxefood.servicos.categoria;

import br.com.ifpe.oxefood.modelo.categoria.Categoria;
import br.com.ifpe.oxefood.util.entity.GenericService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaRequest extends GenericService {

	private String nome;
	
	public Categoria buildCategoria() {
		Categoria categoria = Categoria.builder()
				.nome(nome)
				.build();
		return categoria;
	}
	
}
