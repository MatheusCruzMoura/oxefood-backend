package br.com.ifpe.oxefood.servicos.pedido;

import java.util.List;

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

import br.com.ifpe.oxefood.modelo.pedido.Pedido;
import br.com.ifpe.oxefood.modelo.pedido.PedidoService;
import br.com.ifpe.oxefood.util.entity.GenericController;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController extends GenericController {

	@Autowired
	private PedidoService pedidoService;
	
	
	@PostMapping("/{usuarioId}/{lojaId}/pedido")
	public ResponseEntity<Pedido> save(@RequestBody @Valid PedidoRequest request, @PathVariable("lojaId") Long lojaId, @PathVariable("usuarioId") Long usuarioId) {
		
		Pedido pedidoRequisicao = request.buildPedido();
		Pedido pedidoSalvo = pedidoService.save(pedidoRequisicao,lojaId,usuarioId);
		return new ResponseEntity<>(pedidoSalvo, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Serviço responsável por obter um pedido referente ao Id passado na URL.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna o pedido."),
			@ApiResponse(code = 401, message = "Acesso não autorizado."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso."),
			@ApiResponse(code = 404, message = "Não foi encontrado um registro para o Id informado."),
			@ApiResponse(code = 500, message = "Foi gerado um erro no servidor."), })
	@GetMapping("/{id}")
	public Pedido obterPedidoPorID(@PathVariable Long id) {

		return pedidoService.obterPedidoPorID(id);
	}

	@ApiOperation(value = "Serviço responsável por obter todos os pedidos da loja passando id da loja pela URL.")
	@GetMapping("/porloja/{lojaId}")
	public List<Pedido> consultarPedidosPorLoja(@PathVariable Long lojaId) {

		return pedidoService.obterPedidosPorLoja(lojaId);
	}
	
	@ApiOperation(value = "Serviço responsável por obter todos os pedidos do cliente passando id do usuario pela URL.")
	@GetMapping("/{usuarioId}/pedidos")
	public List<Pedido> consultarPedidosPorCliente(@PathVariable Long usuarioId) {

		return pedidoService.obterPedidosPorCliente(usuarioId);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Serviço responsável por atualizar as informações do pedido no sistema.")
	public ResponseEntity<Pedido> update(@PathVariable("id") Long id, @RequestBody PedidoRequest request) {

		pedidoService.update(id, request.buildPedido());
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Rota responsável por remover(exclusão lógica) um pedido do sistema.")
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		pedidoService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
