package com.librarymanagementsystem.service;

import com.librarymanagementsystem.model.Book;
import com.librarymanagementsystem.model.Member;

import java.util.List;

public interface LibraryService {
        void addBook(Book book);

        List<Book> getAllBooks();

        void borrowBook(Long bookId, Member member);

        void returnBook(Long loanId);
}
