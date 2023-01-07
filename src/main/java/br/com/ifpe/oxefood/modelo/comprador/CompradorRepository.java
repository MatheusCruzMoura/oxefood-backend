package br.com.ifpe.oxefood.modelo.comprador;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CompradorRepository extends JpaRepository<Comprador, Long>, JpaSpecificationExecutor<Comprador> {
	List<Comprador> findByNomeOrderByNomeAsc(String nome);
}
