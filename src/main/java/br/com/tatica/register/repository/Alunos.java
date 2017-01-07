package br.com.tatica.register.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tatica.register.model.Aluno;

public interface Alunos extends JpaRepository<Aluno, Long>{

}
