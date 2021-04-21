package br.ufg.inf.fullstack.model.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufg.inf.fullstack.model.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

	@Query("select p from Aluno p where p.ativo = 1")
	List<Aluno> findAllAtivos();
}
