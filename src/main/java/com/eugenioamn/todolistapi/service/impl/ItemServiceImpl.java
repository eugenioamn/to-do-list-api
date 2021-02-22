package com.eugenioamn.todolistapi.service.impl;

import com.eugenioamn.todolistapi.model.Item;
import com.eugenioamn.todolistapi.repository.ItemRepository;
import com.eugenioamn.todolistapi.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public ResponseEntity<List<Item>> getAll() {
        List<Item> items = itemRepository.findAll();

        if (!items.isEmpty()) {
            return new ResponseEntity<>(items, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Item> create(Item item) {
        Item itemSaved = itemRepository.save(item);

        if (itemSaved == item) {
            return new ResponseEntity<>(item, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Item> update(Long id, Item item) {
        Item existingItem = itemRepository.findById(id).orElse(null);

        if (existingItem != null) {
            existingItem.setTitle(item.getTitle());
            existingItem.setText(item.getText());
            existingItem.setStatus(item.getStatus());
            itemRepository.save(existingItem);

            return new ResponseEntity<>(existingItem, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity delete(Long id) {
        Item existingItem = itemRepository.findById(id).orElse(null);

        if (existingItem != null) {
            itemRepository.deleteById(id);

            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
