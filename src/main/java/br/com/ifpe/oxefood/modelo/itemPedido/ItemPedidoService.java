package br.com.ifpe.oxefood.modelo.itemPedido;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.modelo.item.ItemService;
import br.com.ifpe.oxefood.util.entity.GenericService;
import br.com.ifpe.oxefood.util.exception.EntidadeNaoEncontradaException;

@Service
public class ItemPedidoService extends GenericService{
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemPedidoRepository repository;
	
	@Transactional
	public ItemPedido save(ItemPedido itemPedido, Long pedidoId) {
		
		itemPedido.setId(pedidoId);
		super.preencherCamposAuditoria(itemPedido);
		ItemPedido itemPedidoSalvo = repository.save(itemPedido);

		// emailService.enviarEmailConfirmacaoCadastroItem(itemSalvo);

		return itemPedidoSalvo;

	}

	@Transactional
	public ItemPedido obterItemPedidoPorID(Long id) {

		Optional<ItemPedido> consulta = repository.findById(id);

		if (consulta.isPresent()) {
			return consulta.get();
		} else {
			throw new EntidadeNaoEncontradaException("ItemPedido", id);
		}
	}

	@Transactional
	public void update(Long id, ItemPedido itemPedidoAlterado) {

		ItemPedido itemPedido = this.obterItemPedidoPorID(id);

		itemPedido.updateFrom(itemPedidoAlterado);

		super.preencherCamposAuditoria(itemPedido);

		repository.save(itemPedido);
	}

	@Transactional
	public void delete(Long id) {

		ItemPedido item = this.obterItemPedidoPorID(id);
		item.setHabilitado(Boolean.FALSE);
		super.preencherCamposAuditoria(item);

		repository.save(item);
	}

}
