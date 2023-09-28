package com.projetogerenciamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetogerenciamento.entities.Tarefa;
import com.projetogerenciamento.service.TarefaService;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {
	private final TarefaService tarefaService;

	@Autowired
	public TarefaController (TarefaService tarefaService) {
		this.tarefaService = tarefaService;
	}
	@GetMapping("/{id}")
	public ResponseEntity<Tarefa> getTarefaControlId(@PathVariable Long id){
		Tarefa tarefa = tarefaService.getTarefaById(id);
		if(tarefa != null) {
			return ResponseEntity.ok(tarefa);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping
	public ResponseEntity<List<Tarefa>> buscaTodosTarefaControl(){
		List<Tarefa> tarefa = tarefaService.buscaTodosTarefa();

		return ResponseEntity.ok(tarefa);
	}
	@PostMapping("/")
	public ResponseEntity<Tarefa> saveTarefaControl(@RequestBody Tarefa tarefa){
		Tarefa savetarefa = tarefaService.saveTarefa(tarefa);
		return ResponseEntity.status(HttpStatus.CREATED).body(savetarefa);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Tarefa> alteraTarefaControl(@PathVariable Long id, @RequestBody Tarefa tarefa){
		Tarefa alteraTarefa = tarefaService.alteraTarefa(id, tarefa);
		if(alteraTarefa !=null) {
			return ResponseEntity.ok(tarefa);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagarTarefaControl(@PathVariable Long id){
		boolean apagar = tarefaService.apagarTarefa(id);
		if(apagar) {
			return ResponseEntity.ok().body("A tarefa foi excluido com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
