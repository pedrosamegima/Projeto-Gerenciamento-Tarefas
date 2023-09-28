package com.projetogerenciamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetogerenciamento.entities.Item;
import com.projetogerenciamento.repository.ItemRepository;

@Service
public class ItemService {
	
		private final ItemRepository itemRepository;
		
		@Autowired
		public ItemService (ItemRepository itemRepository) {
			this.itemRepository = itemRepository;
		}
		public List<Item> buscaTodosItem(){
			return itemRepository.findAll();
		}
		public Item getItemById(Long id) {
			Optional<Item> Item = itemRepository.findById(id);
			return Item.orElse(null);
		}
		public Item saveItem (Item item) {
			return itemRepository.save(item);
		}
		public Item alteraItem (Long id, Item alteraItem) {
			Optional <Item> existeItem = itemRepository.findById(id);
			if(existeItem.isPresent()) {
				alteraItem.setId(id);
				return itemRepository.save(alteraItem);
			}
			return null;
		}
		public boolean apagarItem(Long id) {
			Optional <Item> existeItem = itemRepository.findById(id);
			if(existeItem.isPresent()) {
				itemRepository.deleteById(id);
				return true;
			}
			return false;
		}
	}


