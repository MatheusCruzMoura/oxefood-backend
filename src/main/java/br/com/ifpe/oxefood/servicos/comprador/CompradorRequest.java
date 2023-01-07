package br.com.ifpe.oxefood.servicos.comprador;

import br.com.ifpe.oxefood.modelo.comprador.Comprador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompradorRequest {

	private String nome;

    private String enderecoComercial;

    private String enderecoResidencial;

    private double comissao;

    private boolean trabahoHomeOffice;

    private int qtdComprasMediasMes;

    private String regiaoAtuacao;

    public Comprador buildComprador() {

		return Comprador.builder()
			.nome(nome)
			.enderecoComercial(enderecoComercial)
			.enderecoResidencial(enderecoResidencial)
			.comissao(comissao)
			.trabahoHomeOffice(trabahoHomeOffice)
			.qtdComprasMediasMes(qtdComprasMediasMes)
			.regiaoAtuacao(regiaoAtuacao)
			.build();
    }

}
