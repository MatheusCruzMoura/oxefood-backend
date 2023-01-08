package br.com.ifpe.oxefood.servicos.pedido;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.pedido.Pedido;
import br.com.ifpe.oxefood.modelo.pedido.PedidoService;
import br.com.ifpe.oxefood.util.entity.GenericController;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController extends GenericController {

    @Autowired
    private PedidoService pedidoService;   
    
    @ApiOperation(value = "Rota responsável por adicionar um pedido a um cliente já existente.")
    @PostMapping("/{clienteId}/{empresaId}/pedido")
    public ResponseEntity<Pedido> adicionarPedido(@RequestBody @Valid PedidoRequest request, @PathVariable("clienteId") Long clienteId,@PathVariable("empresaId") Long empresaId) {

	Pedido pedido = pedidoService.adicionarPedido(clienteId, empresaId, request.buildPedido());
	return new ResponseEntity<Pedido>(pedido, HttpStatus.CREATED);
    }
    
    @ApiOperation(value = "Rota responsável por atualizar o pedido de um determinado cliente")
    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizarPedido(@PathVariable("id") Long id, @RequestBody PedidoRequest request) {

	Pedido pedido = pedidoService.atualizarPedido(id, request.buildPedido());
	return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
    }
    
    @ApiOperation(value = "Rota responsável por remover um pedido de um determinado cliente")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPedido(@PathVariable Long id) {

	pedidoService.removerPedido(id);
	return ResponseEntity.noContent().build();
    }
}