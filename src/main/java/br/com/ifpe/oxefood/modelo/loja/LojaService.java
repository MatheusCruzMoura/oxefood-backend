package br.com.ifpe.oxefood.modelo.loja;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.modelo.fornecedor.Fornecedor;
import br.com.ifpe.oxefood.util.entity.GenericService;

@Service
public class LojaService extends GenericService {
	@Autowired
	private LojaRepository repository;

	@Transactional
	public Loja save(Loja loja) {

		super.preencherCamposAuditoria(loja);
		Loja lojaSalva = repository.save(loja);

		return lojaSalva;

	}

	@Transactional
	public Loja obterLojaPorID(Long id) {
		return repository.findById(id).get();
	}
	
	@Transactional
    public List<Loja> listarTodos() {

    	return repository.findAll();
    }

}
