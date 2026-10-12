package com.librarymanagementsystem.repository.impl;

import com.librarymanagementsystem.model.Book;
import com.librarymanagementsystem.repository.BookRepository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryBookRepository implements BookRepository {


    private final HashMap<Long, Book> storage = new HashMap<>();


    @Override
    public void save(Book book){
        storage.put(book.getId(),book);
    }

    @Override
    public Optional<Book> findById(Long id){
        if(storage.containsKey(id)){
            Optional<Book> book = Optional.ofNullable(storage.get(id));
            return book;
        }
        System.out.println("book not found !");
        return Optional.empty();
    }

    @Override
    public List<Book> findAll(){
        return storage.values().stream().toList();
    }

    public void deleteById(Long id){
        if(storage.containsKey(id)){
            storage.remove(id);
            System.out.println("book removed succefully...");
        }else {
            System.out.println("book doesn't exists...");
        }

    }

}
