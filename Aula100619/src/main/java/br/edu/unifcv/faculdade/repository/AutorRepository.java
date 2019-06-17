package br.edu.unifcv.faculdade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unifcv.faculdade.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

}
