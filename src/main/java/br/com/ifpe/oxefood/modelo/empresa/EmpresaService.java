package br.com.ifpe.oxefood.modelo.empresa;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.modelo.acesso.UsuarioService;
import br.com.ifpe.oxefood.util.entity.GenericService;
import br.com.ifpe.oxefood.util.exception.EntidadeNaoEncontradaException;

@Service
public class EmpresaService extends GenericService {

	@Autowired
	private EmpresaRepository repository;

	@Autowired
	private UsuarioService usuarioService;

	@Transactional
	public Empresa save(Empresa empresa) {

		usuarioService.save(empresa.getUsuario());

		super.preencherCamposAuditoria(empresa);
		Empresa empresaSalvo = repository.save(empresa);

		// emailService.enviarEmailConfirmacaoCadastroEmpresa(empresaSalvo);

		return empresaSalvo;

	}

	@Transactional
	public Empresa obterEmpresaPorID(Long id) {

		Optional<Empresa> consulta = repository.findById(id);

		if (consulta.isPresent()) {
			return consulta.get();
		} else {
			throw new EntidadeNaoEncontradaException("Empresa", id);
		}
	}

	@Transactional
	public void update(Long id, Empresa empresaAlterado) {

		Empresa empresa = this.obterEmpresaPorID(id);
		// empresa.setChaveEmpresa(empresaAlterado.getChaveEmpresa());
		// empresa.setNome(empresaAlterado.getNome());
		// empresa.setCpf(empresaAlterado.getCpf());
		// empresa.setFone(empresaAlterado.getFone());
		// empresa.setFoneAlternativo(empresaAlterado.getFoneAlternativo());

		empresa.updateFrom(empresaAlterado);

		super.preencherCamposAuditoria(empresa);

		repository.save(empresa);
	}

	@Transactional
	public void delete(Long id) {

		Empresa empresa = this.obterEmpresaPorID(id);
		empresa.setHabilitado(Boolean.FALSE);
		super.preencherCamposAuditoria(empresa);

		repository.save(empresa);
	}

}
