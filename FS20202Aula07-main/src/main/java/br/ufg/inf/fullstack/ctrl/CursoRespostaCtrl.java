package br.ufg.inf.fullstack.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufg.inf.fullstack.ctrl.business.CursoBusiness;
import br.ufg.inf.fullstack.ctrl.exception.CursoException;
import br.ufg.inf.fullstack.model.entities.Curso;

@RestController
@RequestMapping(value="/cursoresposta")
public class CursoRespostaCtrl {
	
	@Autowired
	private CursoBusiness business;
	
	@GetMapping
	public ResponseEntity<Curso> inicio(){
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Enviando uma mensagem para o cliente (Front-End)");
		Curso curso = null;
		try {
			curso = business.findById(2);
		} catch (CursoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Curso>(
				curso, 
				headers, 
				HttpStatus.OK);
	}
	
}
