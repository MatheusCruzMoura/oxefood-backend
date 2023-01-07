package br.com.ifpe.oxefood.servicos.fornecedor;

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

import br.com.ifpe.oxefood.modelo.fornecedor.Fornecedor;
import br.com.ifpe.oxefood.modelo.fornecedor.FornecedorService;
import br.com.ifpe.oxefood.util.entity.GenericController;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/fornecedor")
public class FornecedorController extends GenericController {

	@Autowired
	private FornecedorService fornecedorService;

	@ApiOperation(value = "Serviço responsável por salvar um fornecedor no sistema.")
	@PostMapping
	public ResponseEntity<Fornecedor> save(@RequestBody @Valid FornecedorRequest request) {

		Fornecedor fornecedorRequisicao = request.buildFornecedor();
		Fornecedor fornecedorSalvo = fornecedorService.save(fornecedorRequisicao);
		return new ResponseEntity<>(fornecedorSalvo, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Serviço responsável por obter um fornecedor referente ao Id passado na URL.")
	@GetMapping("/{id}")
    public Fornecedor obterFornecedorPorID(@PathVariable Long id) {

		return fornecedorService.obterFornecedorPorID(id);
    }

	@ApiOperation(value = "Serviço responsável por listar todos os fornecedores do sistema.")
    @GetMapping
    public List<Fornecedor> listarTodos() {

		return fornecedorService.listarTodos();
    }

	@PutMapping("/{id}")
    @ApiOperation(value = "Serviço responsável por atualizar as informações do fornecedor referente ao Id passado na URL.")
    public ResponseEntity<Fornecedor> update(@PathVariable("id") Long id, @RequestBody FornecedorRequest request) {

		Fornecedor fornecedorAlterado = fornecedorService.update(id, request.buildFornecedor());
		return new ResponseEntity<>(fornecedorAlterado, HttpStatus.OK);
    }

	@DeleteMapping("/{id}")
    @ApiOperation(value = "Rota responsável por remover(exclusão lógica) um fornecedor do sistema.")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

		fornecedorService.delete(id);
		return ResponseEntity.noContent().build();
    }


}


