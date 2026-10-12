package com.librarymanagementsystem;

import com.librarymanagementsystem.model.Book;
import com.librarymanagementsystem.repository.BookRepository;
import com.librarymanagementsystem.repository.LoanRepository;
import com.librarymanagementsystem.repository.impl.InMemoryBookRepository;
import com.librarymanagementsystem.repository.impl.InMemoryLoanRepository;
import com.librarymanagementsystem.service.LibraryService;
import com.librarymanagementsystem.service.impl.LibraryServiceImpl;

public class Main {

    public static void main(String[] args) {

        BookRepository bookRepository =
                new InMemoryBookRepository();
        Book book1 = new Book(1L,"crime and punishment","dustovecy",true);
        bookRepository.save(book1);

        LoanRepository loanRepository =
                new InMemoryLoanRepository();

        LibraryService libraryService =
                new LibraryServiceImpl(
                        bookRepository,
                        loanRepository
                );

        System.out.println("========== Welcome to the Library =============");
        System.out.println(bookRepository.findAll());

    }
}