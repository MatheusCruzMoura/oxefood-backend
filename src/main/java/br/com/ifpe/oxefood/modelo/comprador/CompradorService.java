package br.com.ifpe.oxefood.modelo.comprador;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.util.entity.GenericService;

@Service
public class CompradorService extends GenericService {

	@Autowired
    private CompradorRepository repository;

    @Transactional
    public Comprador save(Comprador comprador) {

    	super.preencherCamposNegocio(comprador);
		return repository.save(comprador);
    }

    @Transactional
    public Comprador obterCompradorPorID(Long id) {
    	return repository.findById(id).get();
    }

    @Transactional
    public List<Comprador> listarTodos() {

    	return repository.findAll();
    }

    @Transactional
    public Comprador update(Long id, Comprador compradorAlterado) {

    	Comprador comprador = this.obterCompradorPorID(id);
    	comprador.updateFrom(compradorAlterado);
		super.preencherCamposNegocio(comprador);

		return repository.save(comprador);
    }

    @Transactional
    public void delete(Long id) {

    	Comprador comprador = this.obterCompradorPorID(id);
    	comprador.setHabilitado(Boolean.FALSE);
		super.preencherCamposNegocio(comprador);

		repository.save(comprador);
    }

}
