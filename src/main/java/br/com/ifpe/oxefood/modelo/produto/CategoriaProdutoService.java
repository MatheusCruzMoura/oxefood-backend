package br.com.ifpe.oxefood.modelo.produto;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.util.entity.GenericService;
import br.com.ifpe.oxefood.util.exception.EntityAlreadyExistsException;

@Service
public class CategoriaProdutoService extends GenericService {

	@Autowired
	private CategoriaProdutoRepository repository;

	@Transactional
	public CategoriaProduto save(CategoriaProduto categoriaProduto) {

		super.validarRegistroVazio(categoriaProduto.getDescricao(), "descrição");
		this.validarCategoriaProdutoExistente(categoriaProduto, null);
		super.preencherCamposAuditoria(categoriaProduto);

		return repository.save(categoriaProduto);
	}

	@Transactional
	public CategoriaProduto obterCategoriaPorID(Long id) {

		return repository.findById(id).get();
	}

	@Transactional
	public List<CategoriaProduto> consultarPorChaveEmpresa(String chaveEmpresa) {

		return repository.findByChaveEmpresaOrderByDescricaoAsc(chaveEmpresa);
	}

	@Transactional
	public void update(Long id, CategoriaProduto categoriaProdutoAlterado) {

		validarCategoriaProdutoExistente(categoriaProdutoAlterado, id);

		CategoriaProduto categoria = this.obterCategoriaPorID(id);
		categoria.updateFrom(categoriaProdutoAlterado);
		super.preencherCamposAuditoria(categoria);

		repository.save(categoria);
	}

	@Transactional
	public void delete(Long id) {

		CategoriaProduto categoria = this.obterCategoriaPorID(id);
		categoria.setHabilitado(Boolean.FALSE);
		super.preencherCamposAuditoria(categoria);

		repository.save(categoria);
	}

	private void validarCategoriaProdutoExistente(CategoriaProduto categoriaParam, Long id) {

		if (StringUtils.isNotBlank(categoriaParam.getDescricao())) {

			CategoriaProduto categoria = repository.findByChaveAndDescricao(categoriaParam.getChaveEmpresa(),
					categoriaParam.getDescricao());

			if (id == null) { // O id será null quando este método for chamado para validar a inclusão de
								// novas categorias

				if (categoria != null) {
					throw new EntityAlreadyExistsException(CategoriaProduto.LABEL, "Descrição");
				}

			} else { // O id NÃO será null quando este método for chamado para validar a alteração de
						// categorias

				if (categoria != null && categoria.getId() != id) {
					throw new EntityAlreadyExistsException(CategoriaProduto.LABEL, "Descrição");
				}
			}
		}
	}
}
