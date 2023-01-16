package br.com.ifpe.oxefood.servicos.loja;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.fornecedor.Fornecedor;
import br.com.ifpe.oxefood.modelo.loja.Loja;
import br.com.ifpe.oxefood.modelo.loja.LojaService;
import br.com.ifpe.oxefood.util.entity.GenericController;

@RestController
@RequestMapping("/api/loja")
public class LojaController extends GenericController {
	@Autowired
	private LojaService lojaService;

	@PostMapping
	public ResponseEntity<Loja> save(@RequestBody @Valid LojaRequest request) {

		Loja loja = request.buildLoja();

		Loja lojaCriada = lojaService.save(loja);
		return new ResponseEntity<>(lojaCriada, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public Loja obterLojaPorID(@PathVariable Long id) {

		return lojaService.obterLojaPorID(id);
	}
	
	@GetMapping
    public List<Loja> listarTodos() {

		return lojaService.listarTodos();
    }
	
}
