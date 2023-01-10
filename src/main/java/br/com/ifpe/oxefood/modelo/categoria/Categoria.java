package br.com.ifpe.oxefood.modelo.categoria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
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
@Table(name = "Categoria")
@Where(clause = "habilitado = true")
public class Categoria extends EntidadeAuditavel {
	private static final long serialVersionUID = 6016446565829652171L;
	
	@Column
	private String nome;
	
}
