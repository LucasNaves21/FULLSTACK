package br.ufg.inf.ctrl.negocio;

import java.util.List;

import br.ufg.inf.ctrl.exception.MatriculaExection;
import br.ufg.inf.model.dao.MatriculaDAO;
import br.ufg.inf.model.entities.Matricula;

public class MatriculaNegocio {


		MatriculaDAO dao = new MatriculaDAO();
		AlunoNegocio AlunoNegocio = new AlunoNegocio();
		OfertaNegocio OfertaNegocio = new OfertaNegocio();
	
		public Matricula inserir(Matricula matricula) throws MatriculaExection {
			this.validarMatricula(matricula);
			return dao.inserir(matricula);
		}
		
		public List<Matricula> buscaTodos() throws MatriculaExection{
			return dao.buscaTodos();
		}
		
		public Matricula buscaPorId(Integer id) throws MatriculaExection  {
			return dao.buscaPorId(id);
		}
		

		public Matricula alterar(Matricula matricula) throws MatriculaExection {		
			this.validarMatricula(matricula);
			return dao.alterar(matricula);
		}
		
		public void excluir(Integer id) throws MatriculaExection {
			dao.excluir(id);
		}
		
		private void validarMatricula(Matricula matricula) throws MatriculaExection {
			if (matricula.getAluno() == null) {
				throw new MatriculaExection("É necessário vicular um aluno a matricula.");
			}
			
			if (matricula.getOferta() == null) {
				throw new MatriculaExection("É necessário vincular uma oferta a matrícula.");
			}

		}
}
