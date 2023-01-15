package br.com.ifpe.oxefood.modelo.pedido;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import br.com.ifpe.oxefood.modelo.loja.Loja;

public interface PedidoRepository  extends JpaRepository<Pedido, Long>, JpaSpecificationExecutor<Pedido>{
	
	List<Pedido> findByLojaOrderByDataAsc(Loja loja);
	
	List<Pedido> findByClienteOrderByDataAsc(Cliente cliente);
}
