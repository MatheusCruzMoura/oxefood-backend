package br.com.ifpe.oxefood.servicos.categoria;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.categoria.Categoria;
import br.com.ifpe.oxefood.modelo.categoria.CategoriaService;
import br.com.ifpe.oxefood.util.entity.GenericController;

@RestController
@RequestMapping("/api/Categoria")
public class CategoriaController extends GenericController {

	@Autowired
	private CategoriaService CategoriaService;

	@PostMapping
	public ResponseEntity<Categoria> save(@RequestBody @Valid CategoriaRequest request) {

		Categoria Categoria = request.buildCategoria();
		Categoria CategoriaCriada = CategoriaService.save(Categoria);
		return new ResponseEntity<>(CategoriaCriada, HttpStatus.CREATED);
	}
	

}