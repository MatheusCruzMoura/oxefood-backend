package br.com.ifpe.oxefood.modelo.cliente;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.modelo.acesso.UsuarioService;
import br.com.ifpe.oxefood.util.entity.GenericService;
import br.com.ifpe.oxefood.util.exception.EntidadeNaoEncontradaException;

@Service
public class ClienteService extends GenericService {

	@Autowired
	private ClienteRepository repository;

	@Autowired
	private UsuarioService usuarioService;

	@Transactional
	public Cliente save(Cliente cliente) {

		usuarioService.save(cliente.getUsuario());

		super.preencherCamposAuditoria(cliente);
		Cliente clienteSalvo = repository.save(cliente);

		// emailService.enviarEmailConfirmacaoCadastroCliente(clienteSalvo);

		return clienteSalvo;

	}

	@Transactional
	public Cliente obterClientePorID(Long id) {

		Optional<Cliente> consulta = repository.findById(id);

		if (consulta.isPresent()) {
			return consulta.get();
		} else {
			throw new EntidadeNaoEncontradaException("Cliente", id);
		}
	}

	@Transactional
	public Cliente consultarPorUsuarioId(Long usuarioId) {

		return repository.findByUsuarioIdOrderByNomeAsc(usuarioId);
	}

	@Transactional
	public void update(Long id, Cliente clienteAlterado) {

		Cliente cliente = this.obterClientePorID(id);
		// cliente.setChaveEmpresa(clienteAlterado.getChaveEmpresa());
		// cliente.setNome(clienteAlterado.getNome());
		// cliente.setCpf(clienteAlterado.getCpf());
		// cliente.setFone(clienteAlterado.getFone());
		// cliente.setFoneAlternativo(clienteAlterado.getFoneAlternativo());

		cliente.updateFrom(clienteAlterado);

		super.preencherCamposAuditoria(cliente);

		repository.save(cliente);
	}

	@Transactional
	public void delete(Long id) {

		Cliente cliente = this.obterClientePorID(id);
		cliente.setHabilitado(Boolean.FALSE);
		super.preencherCamposAuditoria(cliente);

		repository.save(cliente);
	}

}
