package br.com.glauciorocha.prjp2js.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.glauciorocha.prjp2js.domain.Mensagem;
import br.com.glauciorocha.prjp2js.repository.MensagemRepository;

@RequestMapping(value="/mensagens")
@RestController
public class MensagemResources {

	@Autowired
	private MensagemRepository mensagemRepository;
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String addMensagem(@RequestBody Mensagem mensagem) {
		
		try {
			mensagemRepository.save(mensagem);
		} catch (Exception e) {
			return "Erro ao gravar mensagem!";
		}
		
		return "Mensagem gravada com sucesso!";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Mensagem> obterTodasMensagens() {
		
		List<Mensagem> mensagens;
		
		try {
			 mensagens = mensagemRepository.findAll();
		} catch (Exception e) {
			return new ArrayList<Mensagem>();
		}
		
		return mensagens;
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public String excluirMensagem(@PathVariable Long id) {
		
		try {
			Mensagem m = new Mensagem();
			m.setId(id);
			
			mensagemRepository.delete(m);
			
			return "Mensagem excluída com sucesso!";
		} catch (Exception e) {
			return "Erro ao excluir mensagem!";
		}
		
	}
	
}
