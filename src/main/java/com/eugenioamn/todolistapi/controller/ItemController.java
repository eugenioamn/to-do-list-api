package com.eugenioamn.todolistapi.controller;

import com.eugenioamn.todolistapi.model.Item;
import com.eugenioamn.todolistapi.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public ResponseEntity<List<Item>> listAll() {
        return itemService.getAll();
    }

    @PostMapping
    public ResponseEntity<Item> create(@Valid @RequestBody Item item) {
        return itemService.create(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> update(@PathVariable Long id,
                                       @Valid @RequestBody Item item) {
        return itemService.update(id, item);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return itemService.delete(id);
    }
}
