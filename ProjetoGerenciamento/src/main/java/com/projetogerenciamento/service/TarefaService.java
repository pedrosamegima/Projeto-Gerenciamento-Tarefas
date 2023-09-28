package com.projetogerenciamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetogerenciamento.entities.Tarefa;
import com.projetogerenciamento.repository.TarefaRepository;

@Service
public class TarefaService {
	private final TarefaRepository tarefaRepository;
	
	@Autowired
	public TarefaService (TarefaRepository tarefaRepository) {
		this.tarefaRepository = tarefaRepository;
	}
	public List<Tarefa> buscaTodosTarefa(){
		return tarefaRepository.findAll();
	}
	public Tarefa getTarefaById(Long id) {
		Optional<Tarefa> Tarefa = tarefaRepository.findById(id);
		return Tarefa.orElse(null);
	}
	public Tarefa saveTarefa (Tarefa tarefa) {
		return tarefaRepository.save(tarefa);
	}
	public Tarefa alteraTarefa (Long id, Tarefa alteraTarefa) {
		Optional <Tarefa> existeTarefa = tarefaRepository.findById(id);
		if(existeTarefa.isPresent()) {
			alteraTarefa.setId(id);
			return tarefaRepository.save(alteraTarefa);
		}
		return null;
	}
	public boolean apagarTarefa(Long id) {
		Optional <Tarefa> existeTarefa = tarefaRepository.findById(id);
		if(existeTarefa.isPresent()) {
			tarefaRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
