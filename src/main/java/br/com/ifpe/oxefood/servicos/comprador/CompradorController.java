package br.com.ifpe.oxefood.servicos.comprador;

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

import br.com.ifpe.oxefood.modelo.comprador.Comprador;
import br.com.ifpe.oxefood.modelo.comprador.CompradorService;
import br.com.ifpe.oxefood.util.entity.GenericController;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/comprador")
public class CompradorController extends GenericController {

	@Autowired
	private CompradorService compradorService;

	@ApiOperation(value = "Serviço responsável por salvar um comprador no sistema.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Salva o comprador."),
			@ApiResponse(code = 401, message = "Acesso não autorizado."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso."),
			@ApiResponse(code = 404, message = "Não foi encontrado este recurso."),
			@ApiResponse(code = 500, message = "Foi gerado um erro no servidor."),
	})
	@PostMapping
	public ResponseEntity<Comprador> save(@RequestBody @Valid CompradorRequest request) {
		Comprador compradorRequisicao = request.buildComprador();
		Comprador compradorSalvo = compradorService.save(compradorRequisicao);
		return new ResponseEntity<>(compradorSalvo, HttpStatus.CREATED);
	}


	@ApiOperation(value = "Serviço responsável por obter um comprador referente ao Id passado na URL.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna o comprador."),
			@ApiResponse(code = 401, message = "Acesso não autorizado."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso."),
			@ApiResponse(code = 404, message = "Não foi encontrado um comprador para o Id informado."),
			@ApiResponse(code = 500, message = "Foi gerado um erro no servidor."),
	})
	@GetMapping("/{id}")
    public Comprador obterCompradorPorID(@PathVariable Long id) {

		return compradorService.obterCompradorPorID(id);
    }

	@ApiOperation(value = "Serviço responsável por listar todos os compradores do sistema.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna toodos os compradores."),
			@ApiResponse(code = 401, message = "Acesso não autorizado."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso."),
			@ApiResponse(code = 404, message = "Não foi encontrado nenhum comprador."),
			@ApiResponse(code = 500, message = "Foi gerado um erro no servidor."),
	})
    @GetMapping
    public List<Comprador> listarTodos() {

		return compradorService.listarTodos();
    }

    @ApiOperation(value = "Serviço responsável por atualizar as informações do comprador referente ao Id passado na URL.")
    @ApiResponses(value = {
			@ApiResponse(code = 200, message = "Altera os dados o comprador."),
			@ApiResponse(code = 401, message = "Acesso não autorizado."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso."),
			@ApiResponse(code = 404, message = "Não foi encontrado um comprador para o Id informado."),
			@ApiResponse(code = 500, message = "Foi gerado um erro no servidor."),
	})
    @PutMapping("/{id}")
    public ResponseEntity<Comprador> update(@PathVariable("id") Long id, @RequestBody CompradorRequest request) {

		Comprador compradorAlterado = compradorService.update(id, request.buildComprador());
		return new ResponseEntity<>(compradorAlterado, HttpStatus.OK);
    }

    @ApiOperation(value = "Serviço responsável por remover(exclusão lógica) um comprador do sistema referente ao Id passado na URL.")
    @ApiResponses(value = {
			@ApiResponse(code = 200, message = "Remove o comprador."),
			@ApiResponse(code = 401, message = "Acesso não autorizado."),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso."),
			@ApiResponse(code = 404, message = "Não foi encontrado um comprador para o Id informado."),
			@ApiResponse(code = 500, message = "Foi gerado um erro no servidor."),
	})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

		compradorService.delete(id);
		return ResponseEntity.noContent().build();
    }

}
