package br.com.tatica.register.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.tatica.register.model.Aluno;
import br.com.tatica.register.repository.Alunos;

@Controller
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	private Alunos alunos;
	
	@RequestMapping("/novo")
	public String novo() {
		return "CadastroAluno";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Aluno aluno) {
		
		System.out.println(aluno.getNome());
		
		alunos.save(aluno);
		ModelAndView mv = new ModelAndView("CadastroAluno");
		mv.addObject("mensagem", "Aluno salvo com sucesso");
		return mv;
	}
	
	@RequestMapping
	public ModelAndView listar() {
		List<Aluno> todosAlunos = alunos.findAll();
		
		ModelAndView mv = new ModelAndView("PesquisaAlunos");
		mv.addObject("todosAlunos", todosAlunos);
		return mv;
	}
}
