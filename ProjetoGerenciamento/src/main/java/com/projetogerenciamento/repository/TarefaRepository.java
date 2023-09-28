package com.projetogerenciamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetogerenciamento.entities.Tarefa;

public interface TarefaRepository extends JpaRepository <Tarefa, Long> {

}
