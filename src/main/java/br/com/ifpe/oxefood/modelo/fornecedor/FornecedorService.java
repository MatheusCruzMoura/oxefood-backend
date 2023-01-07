package br.com.ifpe.oxefood.modelo.fornecedor;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.util.entity.GenericService;

@Service
public class FornecedorService extends GenericService {

    @Autowired
    private FornecedorRepository repository;

    @Transactional
    public Fornecedor save(Fornecedor fornecedor) {

    	super.preencherCamposNegocio(fornecedor);
		return repository.save(fornecedor);
    }

    @Transactional
    public Fornecedor obterFornecedorPorID(Long id) {
    	return repository.findById(id).get();
    }

    @Transactional
    public List<Fornecedor> listarTodos() {

    	return repository.findAll();
    }

    @Transactional
    public Fornecedor update(Long id, Fornecedor fornecedorAlterado) {

    	Fornecedor fornecedor = this.obterFornecedorPorID(id);
    	fornecedor.updateFrom(fornecedorAlterado);
		super.preencherCamposNegocio(fornecedor);

		return repository.save(fornecedor);
    }

    @Transactional
    public void delete(Long id) {

    	Fornecedor fornecedor = this.obterFornecedorPorID(id);
    	fornecedor.setHabilitado(Boolean.FALSE);
		super.preencherCamposNegocio(fornecedor);

		repository.save(fornecedor);
    }


}
