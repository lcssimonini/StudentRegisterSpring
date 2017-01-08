package br.com.tatica.register.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tatica.register.model.Aluno;

public interface Alunos extends JpaRepository<Aluno, Long>{

	List<Aluno> findByNomeContaining(String nome);

}
