package br.ufg.inf.ctrl.negocio;

import java.util.List;

import br.ufg.inf.ctrl.exception.AlunoExection;
import br.ufg.inf.model.dao.AlunoDAO;
import br.ufg.inf.model.entities.Aluno;

public class AlunoNegocio {


		AlunoDAO dao = new AlunoDAO();
	
		public Aluno inserir(Aluno aluno) throws AlunoExection {
			this.validarAluno(aluno);
			dao.inserir(aluno);
			return aluno;
		}
		
		// READ
		public List<Aluno> buscaTodos() throws AlunoExection{
			return dao.buscaTodos();	
		}
		
		public Aluno buscaPorId(Integer id) throws AlunoExection {
			
			return dao.buscaPorId(id);
		}
		
		
		// UPDATE
		
		public Aluno alterar(Aluno aluno) throws AlunoExection {		
			this.validarAluno(aluno);
			return dao.alterar(aluno);
		}
		
		// DELETE
		
		public void excluir(Integer id) throws AlunoExection {
			dao.excluir(id);
		}
		
		
		private void validarAluno(Aluno aluno) throws AlunoExection {
			if (aluno.getPessoa() == null) {
				throw new AlunoExection("É necessário vicular uma pessoa ao aluno.");
			}
			
			if (aluno.getCurso() == null) {
				throw new AlunoExection("É necessário vincular um curso ao aluno.");
			}
		}
}
