package com.eugenioamn.todolistapi.service;

import com.eugenioamn.todolistapi.model.Item;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ItemService {

    ResponseEntity<List<Item>> getAll();

    ResponseEntity<Item> create(Item item);

    ResponseEntity<Item> update(Long id, Item item);

    ResponseEntity delete(Long id);
}
