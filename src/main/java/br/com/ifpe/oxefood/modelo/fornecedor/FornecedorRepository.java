package br.com.ifpe.oxefood.modelo.fornecedor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>, JpaSpecificationExecutor<Fornecedor> {

	List<Fornecedor> findByNomeOrderByNomeAsc(String nome);

}

