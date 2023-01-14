package br.com.ifpe.oxefood.modelo.item;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.modelo.loja.Loja;
import br.com.ifpe.oxefood.modelo.loja.LojaService;
import br.com.ifpe.oxefood.util.entity.GenericService;
import br.com.ifpe.oxefood.util.exception.EntidadeNaoEncontradaException;

@Service
public class ItemService extends GenericService {

	@Autowired
	private ItemRepository repository;

	@Autowired
	private LojaService lojaService;

	@Transactional
	public Item save(Item item, Long LojaId) {

		item.setLoja(lojaService.obterLojaPorID(LojaId));
		super.preencherCamposAuditoria(item);
		Item itemSalvo = repository.save(item);

		// emailService.enviarEmailConfirmacaoCadastroItem(itemSalvo);

		return itemSalvo;

	}

	@Transactional
	public Item obterItemPorID(Long id) {

		Optional<Item> consulta = repository.findById(id);

		if (consulta.isPresent()) {
			return consulta.get();
		} else {
			throw new EntidadeNaoEncontradaException("Item", id);
		}
	}
	
	public List<Item> obterItensPorLoja(Long lojaId){
		
		Loja loja = lojaService.obterLojaPorID(lojaId); 
		return repository.findByLojaOrderByNomeAsc(loja);
	}

	@Transactional
	public void update(Long id, Item itemAlterado) {

		Item item = this.obterItemPorID(id);
		// item.setChaveEmpresa(itemAlterado.getChaveEmpresa());
		// item.setNome(itemAlterado.getNome());
		// item.setCpf(itemAlterado.getCpf());
		// item.setFone(itemAlterado.getFone());
		// item.setFoneAlternativo(itemAlterado.getFoneAlternativo());

		item.updateFrom(itemAlterado);

		super.preencherCamposAuditoria(item);

		repository.save(item);
	}

	@Transactional
	public void delete(Long id) {

		Item item = this.obterItemPorID(id);
		item.setHabilitado(Boolean.FALSE);
		super.preencherCamposAuditoria(item);

		repository.save(item);
	}

}
