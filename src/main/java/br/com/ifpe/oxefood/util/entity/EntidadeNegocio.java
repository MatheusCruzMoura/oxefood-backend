package br.com.ifpe.oxefood.util.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
@EqualsAndHashCode(of = { "id" })
public abstract class EntidadeNegocio implements Serializable {

    private static final long serialVersionUID = -9000508235793417642L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JsonIgnore
    @NotNull
    @Column
    private Boolean habilitado;

}

