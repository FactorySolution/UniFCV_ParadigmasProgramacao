package br.edu.unifcv.faculdade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unifcv.faculdade.model.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

}
