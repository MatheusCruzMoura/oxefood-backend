package br.com.ifpe.oxefood.modelo.loja;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.ifpe.oxefood.util.entity.GenericService;

public class LojaService extends GenericService {
	@Autowired
	private LojaRepository repository;
	
	@Transactional
	public Loja save(Loja loja) {
		Loja lojaSalvo = repository.save(loja);
		return lojaSalvo;
	}

	@Transactional
	public Loja obterLojaPorID(Long id) {
		return repository.findById(id).get();
	}

}
