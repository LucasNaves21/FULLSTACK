package br.ufg.inf.ctrl;

import java.util.List;

import br.ufg.inf.ctrl.exception.MatriculaExection;
import br.ufg.inf.ctrl.negocio.MatriculaNegocio;
import br.ufg.inf.model.entities.Matricula;

public class MatriculaCtrl {

	MatriculaNegocio negocio = new MatriculaNegocio();

	public Matricula inserir(Matricula matricula) {
		try {
			matricula = negocio.inserir(matricula);
			System.out.println("Matricula cadastrada com sucesso: " + matricula);
		} catch (MatriculaExection e) {
			System.out.println("Erro ao tentar cadastrar matricula.");
			System.out.println(e.getMessage());
		}
		return matricula;
	}

	public List<Matricula> buscaTodos() {
		List<Matricula> matriculas = null;
		try {
			matriculas = negocio.buscaTodos();
		} catch (MatriculaExection e) {
			System.out.println("Erro tentar buscar as matriculas cadastradas.");
			System.out.println(e.getMessage());
		}
		return matriculas;
	}

	public Matricula buscaPorId(Integer id) {
		Matricula matricula = null;
		try {
			matricula = negocio.buscaPorId(id);
		} catch (MatriculaExection e) {
			System.out.println("Erro tentar buscar matricula do ID: " + id + ".");
			System.out.println(e.getMessage());
		}
		return matricula;
	}

	public Matricula alterar(Matricula matricula) {
		try {
			matricula = negocio.alterar(matricula);
			System.out.println("Matricula alterado com sucesso: " + matricula);
		} catch (MatriculaExection e) {
			System.out.println("Erro ao tentar alterar matricula com ID: " + matricula.getIdMatricula() + ".");
			System.out.println(e.getMessage());
		}
		return matricula;
	}

	public void excluir(Integer id) {
		try {
			negocio.excluir(id);
			System.out.println("Matricula exclu?da com sucesso.");
		} catch (MatriculaExection e) {
			System.out.println("Erro ao tentar excluir a matricula");
			System.out.println(e.getMessage());
		}
	}
}
