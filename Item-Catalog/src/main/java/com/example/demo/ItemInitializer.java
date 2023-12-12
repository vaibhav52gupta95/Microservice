package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class ItemInitializer implements CommandLineRunner {
    private final ItemRepository itemRepository;

    public ItemInitializer(com.example.demo.ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Stream.of("Lining","Puma", "Bad Boy", "Air Jordan", "Nike", "Adidas", "Reebok").forEach(item ->itemRepository.save(new Item(item)));
        itemRepository.findAll().forEach(System.out::println);
    }
}