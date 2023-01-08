package br.com.ifpe.oxefood.servicos.endereco;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.ifpe.oxefood.modelo.endereco.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoRequest {

	@NotNull(message = "O Cepe é de preenchimento obrigatório")
	@NotBlank(message = "O Cepe é de preenchimento obrigatório")
	private String cepe;

	@NotNull(message = "O Logradouro é de preenchimento obrigatório")
	@NotBlank(message = "O Logradouro é de preenchimento obrigatório")
	private String logradouro;

	@NotNull(message = "O Número é de preenchimento obrigatório")
	@NotBlank(message = "O Número é de preenchimento obrigatório")
	private String numero;

	@NotNull(message = "O Bairro é de preenchimento obrigatório")
	@NotBlank(message = "O Bairro é de preenchimento obrigatório")
	private String bairro;

	@NotNull(message = "A Cidade é de preenchimento obrigatória")
	@NotBlank(message = "A Cidade é de preenchimento obrigatória")
	private String cidade;

	@NotNull(message = "O UF é de preenchimento obrigatório")
	@NotBlank(message = "O UF é de preenchimento obrigatório")
	private String uf;

	private String complemento;

	public Endereco buildEndereco() {

		return Endereco.builder()
				.cepe(cepe)
				.logradouro(logradouro)
				.numero(numero)
				.bairro(bairro)
				.cidade(cidade)
				.uf(uf)
				.complemento(complemento)
				.build();
	}

}
