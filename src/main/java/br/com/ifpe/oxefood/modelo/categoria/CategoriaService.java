package br.com.ifpe.oxefood.modelo.categoria;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.ifpe.oxefood.util.entity.GenericService;

public class CategoriaService extends GenericService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Transactional 
	public Categoria save(Categoria categoria) {
		
		super.preencherCamposAuditoria(categoria);
		Categoria categoriaSalvo = categoriaRepository.save(categoria);
		
		return categoriaSalvo;
	}
	
	@Transactional
	public Categoria obterCategoriaPorID(Long id) {
		return categoriaRepository.findById(id).get();
	}
	
	//@Transactional
	//public Categoria obterCategoriaPorNome (String nome) {
	//	return repository.findB
	//}
}