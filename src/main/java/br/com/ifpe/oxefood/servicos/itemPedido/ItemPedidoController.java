package br.com.ifpe.oxefood.servicos.itemPedido;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.itemPedido.ItemPedido;
import br.com.ifpe.oxefood.modelo.itemPedido.ItemPedidoService;
import br.com.ifpe.oxefood.util.entity.GenericController;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/itemPedido-pedido")
public class ItemPedidoController extends GenericController{
	
	@Autowired
	private ItemPedidoService itemPedidoService;
	
	
	@PostMapping("/{pedidoId}/itemPedido")
	public ResponseEntity<ItemPedido> save(@RequestBody @Valid ItemPedidoRequest request, @PathVariable("pedidoId") Long pedidoId) {
		
		ItemPedido itemPedidoRequisicao = request.buildItemPedido();
		ItemPedido itemPedidoSalvo = itemPedidoService.save(itemPedidoRequisicao,pedidoId);
		return new ResponseEntity<>(itemPedidoSalvo, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Serviço responsável por obter um itemPedido referente ao Id passado na URL.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna o itemPedido."),
			@ApiResponse(code = 401, message = "Acesso não autorizado."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso."),
			@ApiResponse(code = 404, message = "Não foi encontrado um registro para o Id informado."),
			@ApiResponse(code = 500, message = "Foi gerado um erro no servidor."), })
	@GetMapping("/{id}")
	public ItemPedido obterItemPedidoPorID(@PathVariable Long id) {

		return itemPedidoService.obterItemPedidoPorID(id);
	}


	@PutMapping("/{id}")
	@ApiOperation(value = "Serviço responsável por atualizar as informações do itemPedido no sistema.")
	public ResponseEntity<ItemPedido> update(@PathVariable("id") Long id, @RequestBody ItemPedidoRequest request) {

		itemPedidoService.update(id, request.buildItemPedido());
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Rota responsável por remover(exclusão lógica) um itemPedido do sistema.")
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		itemPedidoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
