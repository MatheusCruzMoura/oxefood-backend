package br.com.ifpe.oxefood.modelo.loja;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LojaRepository extends JpaRepository<Loja, Long> {
	List <Loja> findById (long id);

}
