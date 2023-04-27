package br.com.glauciorocha.prjp2js.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.glauciorocha.prjp2js.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	public List<Usuario> findByEmail(String email);
}
