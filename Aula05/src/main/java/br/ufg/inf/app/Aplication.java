package br.ufg.inf.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.ufg.inf.ctrl.AlunoCtrl;
import br.ufg.inf.ctrl.CursoCtrl;
import br.ufg.inf.ctrl.DisciplinaCtrl;
import br.ufg.inf.ctrl.MatriculaCtrl;
import br.ufg.inf.ctrl.OfertaCtrl;
import br.ufg.inf.ctrl.PessoaCtrl;
import br.ufg.inf.ctrl.ProfessorCtrl;
import br.ufg.inf.model.entities.Aluno;
import br.ufg.inf.model.entities.Curso;
import br.ufg.inf.model.entities.Disciplina;
import br.ufg.inf.model.entities.Matricula;
import br.ufg.inf.model.entities.Oferta;
import br.ufg.inf.model.entities.Pessoa;
import br.ufg.inf.model.entities.Professor;
import br.ufg.inf.model.enums.Dia;
import br.ufg.inf.model.enums.Escolaridade;

public class Aplication {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Executando!!!");
		testeOferta();
		testeCurso();
		testePessoa();
		testeProfessor();
		testeAluno();
		testeMatricula();
		System.out.println("Concluindo");
	}
	
	
	public static void testeOferta() {
		
		OfertaCtrl ctrl = new OfertaCtrl();
		ProfessorCtrl professorCtrl = new ProfessorCtrl();
		DisciplinaCtrl disciplinaCtrl = new DisciplinaCtrl();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			Oferta ofe1 = new Oferta(null, 
						professorCtrl.buscaPorId(1), 
						disciplinaCtrl.buscaPorId(2), 
						simpleDateFormat.parse("02/02/2021"), 
						simpleDateFormat.parse("15/06/2021"), 
						Dia.SEGUNDA, 
						"08:00");
			
			Oferta ofe2 = new Oferta(null, 
					professorCtrl.buscaPorId(2), 
					disciplinaCtrl.buscaPorId(3), 
					simpleDateFormat.parse("02/02/2021"), 
					simpleDateFormat.parse("15/06/2021"), 
					Dia.QUARTA, 
					"14:00");
			
			Oferta ofe3 = new Oferta(null, 
					professorCtrl.buscaPorId(3), 
					disciplinaCtrl.buscaPorId(4), 
					simpleDateFormat.parse("02/02/2021"), 
					simpleDateFormat.parse("15/06/2021"), 
					Dia.SEXTA, 
					"19:00");
			
			ctrl.inserir(ofe1);
			ctrl.inserir(ofe2);
			ctrl.inserir(ofe3);
			
			Oferta oferta = ctrl.buscaPorId(1);
			oferta.setDtInicio(simpleDateFormat.parse("22/02/2021"));
			
			ctrl.alterar(oferta);
			
			
			
			for(Oferta o : ctrl.buscaTodos()) {
				System.out.println(o);
			}
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testeProfessor() {
		
		ProfessorCtrl ctrl = new ProfessorCtrl();
		PessoaCtrl pessoaCtrl = new PessoaCtrl();
		
		Professor prof1 = new Professor(null, pessoaCtrl.buscaPorId(1), Escolaridade.MESTRADO);
		Professor prof2 = new Professor(null, pessoaCtrl.buscaPorId(2), Escolaridade.MEDIO);
		Professor prof3 = new Professor(null, pessoaCtrl.buscaPorId(3), Escolaridade.DOUTORADO);
		
		ctrl.inserir(prof1);
		ctrl.inserir(prof2);
		ctrl.inserir(prof3);
		
		
		prof1 = ctrl.buscaPorId(1);
		
		prof1.setEscolaridade(Escolaridade.GRADUACAO);
		ctrl.alterar(prof1);
		
	}
	
	
public static void testeMatricula() {
		
		
	MatriculaCtrl ctrl = new MatriculaCtrl();
	AlunoCtrl alunoCtrl = new AlunoCtrl();
	OfertaCtrl ofertaCtrl = new OfertaCtrl();
	
	Matricula mat1 = new Matricula(null, alunoCtrl.buscaPorId(1), ofertaCtrl.buscaPorId(3));
	Matricula mat2 = new Matricula(null, alunoCtrl.buscaPorId(5), ofertaCtrl.buscaPorId(6));
		
		ctrl.inserir(mat1);
		ctrl.inserir(mat2);
	
		mat1 = ctrl.buscaPorId(1);
		
		mat1.setIdMatricula(10);
		ctrl.alterar(mat1);
		
	}
	
	public static void testeAluno() {
		
		AlunoCtrl ctrl = new AlunoCtrl();
		CursoCtrl cursoCtrl = new CursoCtrl();
		PessoaCtrl pessoaCtrl = new PessoaCtrl();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			
		Aluno aluno1 = new Aluno(null, simpleDateFormat.parse("02/02/2021"), true, pessoaCtrl.buscaPorId(1), cursoCtrl.buscaPorId(1));
		Aluno aluno2 = new Aluno(null, simpleDateFormat.parse("04/05/2022"), true, pessoaCtrl.buscaPorId(3), cursoCtrl.buscaPorId(7));
		
		
		ctrl.inserir(aluno1);
		ctrl.inserir(aluno2);

		
		aluno1 = ctrl.buscaPorId(1);
		
		aluno1.setAtivo(false);;
		ctrl.alterar(aluno1);
		
		
		for(Aluno o : ctrl.buscaTodos()) {
			System.out.println(o);
		}
		
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void testeCurso() {
		
		CursoCtrl ctrl = new CursoCtrl();
	
		
		Curso curso1 = new Curso(null, "Sistema de Informa��o");
		
		ctrl.inserir(curso1);
		
		curso1 = ctrl.buscaPorId(1);
		
		curso1.setNmCurso("Ci�ncia da Computa��o");
		ctrl.alterar(curso1);
		
	}
	
	
	
	public static void testePessoa() {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

		
		PessoaCtrl ctrl = new PessoaCtrl();
		try {
			
			Pessoa pes1 = new Pessoa(null, "Luiz", 12345678901l, simpleDateFormat.parse("01-01-1990"));
			ctrl.inserir(pes1);
	
			Pessoa pes2 = new Pessoa(null, "Fulano", 11111111111l, simpleDateFormat.parse("01-01-1990"));
			ctrl.inserir(pes2);
	
			Pessoa pes3 = new Pessoa(null, "Beltrano", 22222222222l, simpleDateFormat.parse("01-01-1990"));
			ctrl.inserir(pes3);
	
			Pessoa pes4 = new Pessoa(null, "Cicrano", 33333333333l, simpleDateFormat.parse("01-01-1990"));
			ctrl.inserir(pes4);
	
			pes1 = ctrl.buscaPorId(2);
			
			pes1.setDtNascimento(simpleDateFormat.parse("01-01-1990"));

		
			ctrl.alterar(pes1);
			
			pes2 = ctrl.buscaPorId(2);
			pes2.setDtNascimento(simpleDateFormat.parse("01-04-2000"));
			ctrl.alterar(pes2);

			pes3 = ctrl.buscaPorId(3);
			pes3.setDtNascimento(simpleDateFormat.parse("15-06-2005"));
			ctrl.alterar(pes3);
			
			pes4 = ctrl.buscaPorId(4);
			pes4.setDtNascimento(simpleDateFormat.parse("30-09-2015"));
			ctrl.alterar(pes4);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void testeCtrl() {
		
		DisciplinaCtrl ctrl = new DisciplinaCtrl();
		Disciplina disciplina = new Disciplina(null, "Banco de Dados", 64);
		
		//ctrl.inserir(disciplina);
		disciplina.setNmDisciplina(disciplina.getNmDisciplina()+" - Alterada");
		//ctrl.alterar(disciplina);
		System.out.println(ctrl.buscaPorId(3));
		for(Disciplina d : ctrl.buscaTodos()) {
			System.out.println(d);
		}
		System.out.println("-----------------------------------");
		for(Disciplina d : ctrl.buscaPorNome("Banco")) {
			System.out.println(d);
		}
	}
	
	
	public void testeJPA() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula-jpa");
		EntityManager em = emf.createEntityManager();
		
		Disciplina disc1 = new Disciplina(null, "FullStack", 64);
		Disciplina disc2 = new Disciplina(null, "Matem�tica", 88);
		Disciplina disc3 = new Disciplina(null, "Java", 30);
		Disciplina disc4 = new Disciplina(null, "TypeScript", 90);
		//System.out.println("-------------------------");
		//System.out.println(disc1);
		//System.out.println(disc2);
		//System.out.println(disc3);
		//System.out.println(disc4);
		//System.out.println("-------------------------");	
		//em.getTransaction().begin();
		//em.persist(disc1);
		//em.persist(disc2);
		//em.persist(disc3);
		//em.persist(disc4);
		//em.getTransaction().commit();
		
		//System.out.println("-------------------------");
		//System.out.println(disc1);
		//System.out.println(disc2);
		//System.out.println(disc3);
		//System.out.println(disc4);
		//System.out.println("-------------------------");
		//System.out.println("Acabou!");
		
		
		TypedQuery<Disciplina> query =  em.createQuery("from Disciplina", Disciplina.class);
		List<Disciplina> disciplinas = query.getResultList();
		
		System.out.println("----------------------------");
		System.out.println("---Disciplinas Cadatradas---");
		for(Disciplina d : disciplinas) {
			System.out.println(d);
		}
		System.out.println("----------------------------");
		
		
		Disciplina disciplina = em.find(Disciplina.class, 2);
		System.out.println("----------------------------");
		System.out.println("---Disciplina id 2---");
		System.out.println(disciplina);
		System.out.println("----------------------------");
		

		disciplina.setNmDisciplina(disciplina.getNmDisciplina()+" ALTERADO");
		
		em.getTransaction().begin();
		em.persist(disciplina);
		em.getTransaction().commit();
		
		System.out.println("----------------------------");
		System.out.println("---Disciplina id 2 Alterado---");
		System.out.println(disciplina);
		System.out.println("----------------------------");
		
	
		String str = "ll";
		
		String sql = "from Disciplina d where d.nmDisciplina like :str";
		query = em.createQuery(sql, Disciplina.class);
		query.setParameter("str", "%"+str+"%");
		disciplinas = query.getResultList();
		
		System.out.println("----------------------------");
		System.out.println("---Disciplinas com "+str+"---");
		for(Disciplina d : disciplinas) {
			System.out.println(d);
		}
		System.out.println("----------------------------");
		
		Disciplina excluir = em.find(Disciplina.class, 1);
		System.out.println(excluir);
	//	em.getTransaction().begin();
	//	em.remove(excluir);
	//	em.getTransaction().commit();
		
		
		
	}
	

}
