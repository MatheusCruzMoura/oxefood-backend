package br.com.ifpe.oxefood.modelo.fornecedor;

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
@Table(name = "Fornecedor")
@Where(clause = "habilitado = true")
public class Fornecedor extends EntidadeNegocio {

	private static final long serialVersionUID = -1189182811561334741L;

    @NotNull
    @Column(nullable = false)
    private String nome;

    @Column
    private String endereco;

    @Column
    private String logoMarca;

    @Column
    private double valorMercado;

    @Column
    private String paginaWeb;

    @Column
    private String contatoVendedor;



    public void updateFrom(Fornecedor param) {

		this.setNome(param.getNome());
		this.setEndereco(param.getEndereco());
		this.setLogoMarca(param.getLogoMarca());
		this.setValorMercado(param.getValorMercado());
		this.setPaginaWeb(param.getPaginaWeb());
		this.setContatoVendedor(param.getContatoVendedor());
    }
}
