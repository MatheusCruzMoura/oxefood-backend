package br.com.ifpe.oxefood.servicos.endereco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.endereco.Endereco;
import br.com.ifpe.oxefood.modelo.endereco.EnderecoService;
import br.com.ifpe.oxefood.util.entity.GenericController;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/cliente/endereco")
public class EnderecoController extends GenericController {

	@Autowired
	private EnderecoService enderecoService;

	@ApiOperation(value = "Serviço responsável por obter o endereço de um cliente referente ao Id passado na URL.")
	@GetMapping("/{id}")
	public Endereco obterEnderecoPorID(@PathVariable Long id) {

		return enderecoService.obterEnderecoPorID(id);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Serviço responsável por atualizar o endereço do cliente no sistema.")
	public ResponseEntity<Endereco> update(@PathVariable("id") Long id, @RequestBody EnderecoRequest request) {

		enderecoService.update(id, request.buildEndereco());
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Rota responsável por remover(exclusão lógica) o enderecço do cliente do sistema.")
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		enderecoService.delete(id);
		return ResponseEntity.ok().build();
	}
}
