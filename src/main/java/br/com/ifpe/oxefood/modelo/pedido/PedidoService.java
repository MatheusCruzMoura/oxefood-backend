package br.com.ifpe.oxefood.modelo.pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import br.com.ifpe.oxefood.modelo.cliente.ClienteService;
import br.com.ifpe.oxefood.modelo.empresa.Empresa;
import br.com.ifpe.oxefood.modelo.empresa.EmpresaService;
import br.com.ifpe.oxefood.util.entity.GenericService;
import br.com.ifpe.oxefood.util.exception.EntidadeNaoEncontradaException;

public class PedidoService extends GenericService{
	
	@Autowired
	private PedidoRepository repository;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private EmpresaService empresaService;
	
	@Transactional
    public Pedido findById(Long id) {

    	Optional<Pedido> consulta = repository.findById(id);
    	
    	if (consulta.isPresent()) {
    	    return consulta.get();
    	} else {
    	    throw new EntidadeNaoEncontradaException("Cliente", id);
    	}

    }
	
	@Transactional
    public Pedido adicionarPedido(Long clienteId,Long empresaId , Pedido pedido) {

	Cliente cliente = clienteService.obterClientePorID(clienteId);
	Empresa empresa = empresaService.obterEmpresaPorID(empresaId);
	//Primeiro salva o Pedido
	pedido.setCliente(cliente);
	pedido.setEmpresa(empresa);
	pedido.setHabilitado(Boolean.TRUE);
	repository.save(pedido);
	
	//Depois acrescenta o endereço criado ao cliente e atualiza o cliente
	List<Pedido> listaPedido = cliente.getPedidos();
	
	if (listaPedido == null) {
	    listaPedido = new ArrayList<Pedido>();
	}
	
	listaPedido.add(pedido);
	cliente.setPedidos(listaPedido);
	clienteService.save(cliente);
	
	return pedido;
    }
	
	@Transactional
    public Pedido atualizarPedido(Long id, Pedido pedidoAlterada) {

	Pedido pedido = this.findById(id);
		pedido.updateFrom(pedidoAlterada);
		return repository.save(pedido);
    }
    
    @Transactional
    public void removerPedido(Long id) {
    Pedido pedido = this.findById(id);	 
    
	pedido.setHabilitado(Boolean.FALSE);
	repository.save(pedido);

	Cliente cliente = clienteService.obterClientePorID(pedido.getId());
	cliente.getPedidos().remove(pedido);
	clienteService.save(cliente);
    }

}
