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

import com.projetogerenciamento.entities.Item;
import com.projetogerenciamento.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
	private final ItemService itemService;
		
		@Autowired
		public ItemController (ItemService itemService) {
			this.itemService = itemService;
		}
		@GetMapping("/{id}")
		public ResponseEntity<Item> getItemControlId(@PathVariable Long id){
			Item item = itemService.getItemById(id);
			if(item != null) {
				return ResponseEntity.ok(item);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		@GetMapping
		public ResponseEntity<List<Item>> buscaTodosItemControl(){
			List<Item> item = itemService.buscaTodosItem();

			return ResponseEntity.ok(item);
		}
		@PostMapping("/")
		public ResponseEntity<Item> saveItemControl(@RequestBody Item item){
			Item saveitem = itemService.saveItem(item);
			return ResponseEntity.status(HttpStatus.CREATED).body(saveitem);
		}

		@PutMapping("/{id}")
		public ResponseEntity<Item> alteraItemControl(@PathVariable Long id, @RequestBody Item item){
			Item alteraItem = itemService.alteraItem(id, item);
			if(alteraItem !=null) {
				return ResponseEntity.ok(item);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}

		@DeleteMapping("/{id}")
		public ResponseEntity<String> apagarItemControl(@PathVariable Long id){
			boolean apagar = itemService.apagarItem(id);
			if(apagar) {
				return ResponseEntity.ok().body("O Item foi excluido com sucesso");
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
	}


