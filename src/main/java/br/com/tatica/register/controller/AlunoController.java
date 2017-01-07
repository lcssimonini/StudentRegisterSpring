package br.com.tatica.register.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.tatica.register.model.Aluno;

@Controller
@RequestMapping("/alunos")
public class AlunoController {
	
	@RequestMapping("/novo")
	public String novo() {
		return "CadastroAluno";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(Aluno aluno) {
		
		System.out.println(aluno.getNome());
		return "CadastroAluno";
	}

}
