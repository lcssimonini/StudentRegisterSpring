package br.com.tatica.register.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.tatica.register.model.Aluno;
import br.com.tatica.register.repository.Alunos;
import br.com.tatica.register.repository.filter.AlunoFilter;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

	private static final String CADASTRO_ALUNO = "CadastroAluno";
	@Autowired
	private Alunos alunos;

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(CADASTRO_ALUNO);
		mv.addObject(new Aluno());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Aluno aluno, Errors errors, RedirectAttributes attributes) {

		if (errors.hasErrors()) {
			return CADASTRO_ALUNO;
		}

		alunos.save(aluno);
		attributes.addFlashAttribute("mensagem", "Aluno salvo com sucesso!");
		return "redirect:/alunos/novo";
	}

	@RequestMapping("{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Aluno aluno) {
		ModelAndView mv = new ModelAndView(CADASTRO_ALUNO);
		mv.addObject(aluno);
		return mv;
	}

	@RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
		alunos.delete(codigo);

		attributes.addFlashAttribute("mensagem", "Aluno excluído com sucesso!");
		return "redirect:/alunos";
	}

	@RequestMapping
	public ModelAndView pesquisar(@ModelAttribute("filtro") AlunoFilter filtro) {
		List<Aluno> todosTitulos = filtrar(filtro);

		ModelAndView mv = new ModelAndView("PesquisaAlunos");
		mv.addObject("todosAlunos", todosTitulos);
		return mv;
	}

	private List<Aluno> filtrar(AlunoFilter filtro) {
		String descricao = filtro.getNome() == null ? "%" : filtro.getNome();
		return alunos.findByNomeContaining(descricao);
	}
}
