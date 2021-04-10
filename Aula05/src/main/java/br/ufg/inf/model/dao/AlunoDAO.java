package br.ufg.inf.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.ufg.inf.ctrl.exception.AlunoExection;
import br.ufg.inf.model.entities.Aluno;

public class AlunoDAO {

	EntityManager em = DaoFactory.getEntityManager();

	// CREATE
	public Aluno inserir(Aluno aluno) throws AlunoExection {

		this.em.getTransaction().begin();
		this.em.persist(aluno);
		this.em.getTransaction().commit();

		return aluno;
	}

	// READ
	public List<Aluno> buscaTodos() throws AlunoExection {
		return this.em.createQuery("from Aluno", Aluno.class).getResultList();
	}

	public Aluno buscaPorId(Integer id) throws AlunoExection {
		return this.em.find(Aluno.class, id);
	}

	// UPDATE

	public Aluno alterar(Aluno aluno) throws AlunoExection {

		this.em.getTransaction().begin();
		this.em.persist(aluno);
		this.em.getTransaction().commit();

		return aluno;
	}

	// DELETE

	public void excluir(Integer id) throws AlunoExection {
		this.em.remove(this.buscaPorId(id));
	}
}
