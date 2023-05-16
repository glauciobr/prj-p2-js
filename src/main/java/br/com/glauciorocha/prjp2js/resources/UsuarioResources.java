package br.com.glauciorocha.prjp2js.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.glauciorocha.prjp2js.domain.Usuario;
import br.com.glauciorocha.prjp2js.repository.UsuarioRepository;

@RestController
@RequestMapping(value="/usuarios")
@CrossOrigin
public class UsuarioResources {

	@Autowired
	private UsuarioRepository usuarioRepository;
	

	@RequestMapping(value="/validar", method=RequestMethod.POST)
	@CrossOrigin
	public boolean validarAcesso(@RequestBody Usuario usuario) {
		
		List<Usuario> usuarios = usuarioRepository.findByEmail(usuario.getEmail());
		
		if (usuarios.size() <= 0) {
			return false;
		}
		
		Usuario u = usuarios.get(0);
		
		if (u.getSenha().equals(usuario.getSenha())) {
			return true;
		} else {
			return false;
		}
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@CrossOrigin
	public String addUsuario(@RequestBody Usuario usuario) {
		
		usuarioRepository.save(usuario);
		return "Usuário cadastrado com sucesso!";
		
	}
	
	
}
