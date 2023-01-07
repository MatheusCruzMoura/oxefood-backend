package br.com.ifpe.oxefood.servicos.fornecedor;

import br.com.ifpe.oxefood.modelo.fornecedor.Fornecedor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FornecedorRequest {

	private String nome;

    private String endereco;

    private String logoMarca;

    private double valorMercado;

    private String paginaWeb;

    private String contatoVendedor;

    public Fornecedor buildFornecedor() {

		return Fornecedor.builder()
			.nome(nome)
			.endereco(endereco)
			.logoMarca(logoMarca)
			.valorMercado(valorMercado)
			.paginaWeb(paginaWeb)
			.contatoVendedor(contatoVendedor)
			.build();
	    }

}
