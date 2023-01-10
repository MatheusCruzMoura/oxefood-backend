package br.com.ifpe.oxefood.modelo.endereco;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>, JpaSpecificationExecutor<Endereco> {

	List<Endereco> findByCepOrderByCepAsc(String Cep);

}
