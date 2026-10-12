package com.librarymanagementsystem.repository;

import com.librarymanagementsystem.model.Book;
import java.util.List;
import java.util.Optional;



public interface BookRepository {
        void save(Book book);

        Optional<Book> findById(Long id);

        List<Book> findAll();

        void deleteById(Long id);
}
