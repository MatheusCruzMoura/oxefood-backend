package br.com.ifpe.oxefood.modelo.pedido;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import br.com.ifpe.oxefood.modelo.cliente.ClienteService;
import br.com.ifpe.oxefood.modelo.endereco.Endereco;
import br.com.ifpe.oxefood.modelo.endereco.EnderecoService;
import br.com.ifpe.oxefood.modelo.itemPedido.ItemPedido;
import br.com.ifpe.oxefood.modelo.itemPedido.ItemPedidoService;
import br.com.ifpe.oxefood.modelo.loja.Loja;
import br.com.ifpe.oxefood.modelo.loja.LojaService;
import br.com.ifpe.oxefood.util.entity.GenericService;
import br.com.ifpe.oxefood.util.exception.EntidadeNaoEncontradaException;
@Service
public class PedidoService extends GenericService{
	
	@Autowired
	private LojaService lojaService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ItemPedidoService itemPedidoService;
	
	@Autowired
	private PedidoRepository repository;
	
	@Autowired
	private EnderecoService enderecoService;
	
	@Transactional
	public Pedido save(Pedido pedido, Long lojaId, Long usuarioId) {
		
		Loja loja = lojaService.obterLojaPorID(lojaId);
		pedido.setLoja(loja);
		
		Cliente cliente = clienteService.consultarPorUsuarioId(usuarioId);
		pedido.setCliente(cliente);
		
		
		Endereco enderecoEntrega = enderecoService.obterEnderecoPorID(usuarioId);
		
		String entrega = "" + enderecoEntrega.getLogradouro() + ", " +
				enderecoEntrega.getNumero() + " - " +
				enderecoEntrega.getBairro() + ", " + 
				enderecoEntrega.getCidade() + " - " + 
				enderecoEntrega.getUf() + ", " + 
				enderecoEntrega.getCep() + " - " + 
				enderecoEntrega.getComplemento();
		
		pedido.setEnderecoEntrega(entrega);
		
		super.preencherCamposAuditoria(pedido);
		Pedido pedidoSalvo = repository.save(pedido);
		
		List<ItemPedido> items = pedido.getItens();
		for (ItemPedido itemPedido : items) {
			itemPedidoService.save(itemPedido, pedido.getId());
		}

		// emailService.enviarEmailConfirmacaoCadastroItem(itemSalvo);

		return pedidoSalvo;

	}

	@Transactional
	public Pedido obterPedidoPorID(Long id) {

		Optional<Pedido> consulta = repository.findById(id);

		if (consulta.isPresent()) {
			return consulta.get();
		} else {
			throw new EntidadeNaoEncontradaException("Pedido", id);
		}
	}
	
	@Transactional
	public List<Pedido> obterPedidosPorLoja(Long lojaId){
		
		Loja loja = lojaService.obterLojaPorID(lojaId); 
		return repository.findByLojaOrderByDataAsc(loja);
	}
	
	@Transactional
	public List<Pedido> obterPedidosPorCliente(Long usuarioId){
		
		Cliente cliente = clienteService.consultarPorUsuarioId(usuarioId); 
		return repository.findByClienteOrderByDataAsc(cliente);
	}

	@Transactional
	public void update(Long id, Pedido pedidoAlterado) {

		Pedido pedido = this.obterPedidoPorID(id);

		pedido.updateFrom(pedidoAlterado);

		super.preencherCamposAuditoria(pedido);

		repository.save(pedido);
	}

	@Transactional
	public void delete(Long id) {

		Pedido pedido = this.obterPedidoPorID(id);
		pedido.setHabilitado(Boolean.FALSE);
		super.preencherCamposAuditoria(pedido);

		repository.save(pedido);
	}
	}
