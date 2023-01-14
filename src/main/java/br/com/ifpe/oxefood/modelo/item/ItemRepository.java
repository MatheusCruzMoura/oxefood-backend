package br.com.ifpe.oxefood.modelo.item;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ItemRepository extends JpaRepository<Item, Long>, JpaSpecificationExecutor<Item> {
	
	List<Item> findByLojaIdOrderByNomeAsc(Long lojaId);
}

