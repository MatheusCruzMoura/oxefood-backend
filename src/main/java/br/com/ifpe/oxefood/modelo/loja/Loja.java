package br.com.ifpe.oxefood.modelo.loja;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import br.com.ifpe.oxefood.modelo.categoria.Categoria;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Loja")
@Where(clause = "habilitado = true")
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Loja extends EntidadeAuditavel{
	private static final long serialVersionUID = 2819481163306535449L;
	
	@Column
	private String nome;
	
	
	@Column
	private String imagem;
	
	@JoinColumn (nullable = false)
	private Categoria id_categoria;
	
	@Column
	private double valor_frete;
	
}
