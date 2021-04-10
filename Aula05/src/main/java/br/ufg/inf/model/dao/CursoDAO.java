package br.ufg.inf.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.ufg.inf.ctrl.exception.CursoExection;
import br.ufg.inf.model.entities.Curso;


public class CursoDAO {

	EntityManager em = DaoFactory.getEntityManager();

	public Curso inserir(Curso curso) throws CursoExection {
		this.em.getTransaction().begin();
		this.em.persist(curso);
		this.em.getTransaction().commit();
		return curso;
	}

	public List<Curso> buscaTodos() throws CursoExection {
		return this.em.createQuery("from Curso", Curso.class).getResultList();
	}

	public Curso buscaPorId(Integer id) throws CursoExection {
		return this.em.find(Curso.class, id);
	}

	public Curso alterar(Curso curso) throws CursoExection {
		this.em.getTransaction().begin();
		this.em.persist(curso);
		this.em.getTransaction().commit();
		return curso;
	}

	public void excluir(Integer id) throws CursoExection {
		this.em.remove(this.buscaPorId(id));
	}

}
