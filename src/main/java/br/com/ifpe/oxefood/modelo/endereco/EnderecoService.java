package br.com.ifpe.oxefood.modelo.endereco;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.util.entity.GenericService;

@Service
public class EnderecoService extends GenericService {

	@Autowired
	private EnderecoRepository repository;

	@Transactional
	public Endereco obterEnderecoPorID(Long id) {
		return repository.findById(id).get();
	}

	@Transactional
	public void update(Long id, Endereco enderecoAlterado) {

		Endereco endereco = this.obterEnderecoPorID(id);

		endereco.updateFrom(enderecoAlterado);

		super.preencherCamposAuditoria(endereco);

		repository.save(endereco);
	}

	@Transactional
	public void delete(Long id) {

		Endereco endereco = this.obterEnderecoPorID(id);
		endereco.setCep(null);
		endereco.setLogradouro(null);
		endereco.setNumero(null);
		endereco.setBairro(null);
		endereco.setCidade(null);
		endereco.setUf(null);
		endereco.setComplemento(null);

		super.preencherCamposAuditoria(endereco);

		repository.save(endereco);
	}

}
