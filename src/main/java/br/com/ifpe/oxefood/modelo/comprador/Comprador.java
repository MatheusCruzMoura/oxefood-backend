package br.com.ifpe.oxefood.modelo.comprador;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Where;

import br.com.ifpe.oxefood.util.entity.EntidadeNegocio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Comprador")
@Where(clause = "habilitado = true")
public class Comprador extends EntidadeNegocio {

	private static final long serialVersionUID = 3034904862079787465L;

	@NotNull
    @Column(nullable = false)
    private String nome;

    @Column
    private String enderecoComercial;

    @Column
    private String enderecoResidencial;

    @Column
    private double comissao;

    @Column
    private boolean trabahoHomeOffice;

    @Column
    private int qtdComprasMediasMes;

    @Column
    private String regiaoAtuacao;


    public void updateFrom(Comprador param) {

		this.setNome(param.getNome());
		this.setEnderecoComercial(param.getEnderecoComercial());
		this.setEnderecoResidencial(param.getEnderecoResidencial());
		this.setComissao(param.getComissao());
		this.setTrabahoHomeOffice(param.isTrabahoHomeOffice());
		this.setQtdComprasMediasMes(param.getQtdComprasMediasMes());
		this.setRegiaoAtuacao(param.getRegiaoAtuacao());
    }


}
