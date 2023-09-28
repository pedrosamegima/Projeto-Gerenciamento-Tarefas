package com.projetogerenciamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetogerenciamento.entities.Item;

public interface ItemRepository extends JpaRepository <Item, Long> {

}
