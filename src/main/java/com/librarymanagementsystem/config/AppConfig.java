package com.librarymanagementsystem.config;


import com.librarymanagementsystem.model.Book;
import com.librarymanagementsystem.model.Loan;
import com.librarymanagementsystem.repository.BookRepository;
import com.librarymanagementsystem.repository.LoanRepository;
import com.librarymanagementsystem.repository.impl.InMemoryBookRepository;
import com.librarymanagementsystem.repository.impl.InMemoryLoanRepository;
import com.librarymanagementsystem.service.LibraryService;
import com.librarymanagementsystem.service.impl.LibraryServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public BookRepository bookRepository(){
        return new InMemoryBookRepository();
    }

    @Bean
    public LoanRepository loanRepository(){
        return new InMemoryLoanRepository();
    }

    @Bean
    public LibraryService libraryService(BookRepository bookRepository,LoanRepository loanRepository){
        return new LibraryServiceImpl(bookRepository,loanRepository);
    }

}
