package br.ufg.inf.ctrl.negocio;

import java.util.List;

import br.ufg.inf.ctrl.exception.CursoExection;
import br.ufg.inf.model.dao.CursoDAO;
import br.ufg.inf.model.entities.Curso;

public class CursoNegocio {


		CursoDAO dao = new CursoDAO();
		ProfessorNegocio professorNegocio = new ProfessorNegocio();
		DisciplinaNegocio disciplinaNegocio = new DisciplinaNegocio();
	
		public Curso inserir(Curso curso) throws CursoExection {
			this.validarCurso(curso);
			return dao.inserir(curso);
		}
		
		public List<Curso> buscaTodos() throws CursoExection{
			return dao.buscaTodos();
		}
		
		public Curso buscaPorId(Integer id) throws CursoExection  {
			return dao.buscaPorId(id);
		}
		

		public Curso alterar(Curso curso) throws CursoExection {		
			this.validarCurso(curso);
			return dao.alterar(curso);
		}
		
		public void excluir(Integer id) throws CursoExection {
			dao.excluir(id);
		}
		
		private void validarCurso(Curso curso) throws CursoExection {
			

		}
}
