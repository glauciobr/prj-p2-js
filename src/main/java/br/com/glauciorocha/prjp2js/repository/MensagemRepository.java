package br.com.glauciorocha.prjp2js.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.glauciorocha.prjp2js.domain.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem, Long>{

}
