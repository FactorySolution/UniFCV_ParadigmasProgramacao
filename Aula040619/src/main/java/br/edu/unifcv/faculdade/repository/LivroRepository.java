package br.edu.unifcv.faculdade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unifcv.faculdade.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
