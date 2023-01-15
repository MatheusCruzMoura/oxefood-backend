package br.com.ifpe.oxefood.modelo.itemPedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long>, JpaSpecificationExecutor<ItemPedido>{

}
