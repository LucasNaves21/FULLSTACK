package br.ufg.inf.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.ufg.inf.ctrl.exception.MatriculaExection;
import br.ufg.inf.model.entities.Matricula;

public class MatriculaDAO {

	EntityManager em = DaoFactory.getEntityManager();

	public Matricula inserir(Matricula matricula) throws MatriculaExection {
		this.em.getTransaction().begin();
		this.em.persist(matricula);
		this.em.getTransaction().commit();
		return matricula;
	}

	public List<Matricula> buscaTodos() throws MatriculaExection {
		return this.em.createQuery("from Oferta", Matricula.class).getResultList();
	}

	public Matricula buscaPorId(Integer id) throws MatriculaExection {
		return this.em.find(Matricula.class, id);
	}

	public Matricula alterar(Matricula matricula) throws MatriculaExection {
		this.em.getTransaction().begin();
		this.em.persist(matricula);
		this.em.getTransaction().commit();
		return matricula;
	}

	public void excluir(Integer id) throws MatriculaExection {
		this.em.remove(this.buscaPorId(id));
	}

}
