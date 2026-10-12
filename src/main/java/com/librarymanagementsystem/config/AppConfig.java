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
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.librarymanagementsystem")
public class AppConfig {
    // Utilisation de @Repository,@Service ... etc

//    private final BookRepository bookRepository;
//    private final LoanRepository loanRepository;
//    private final LibraryService libraryService;
//
//    public AppConfig(BookRepository bookRepository, LoanRepository loanRepository,LibraryService libraryService) {
//        this.bookRepository = bookRepository;
//        this.loanRepository = loanRepository;
//        this.libraryService = libraryService;
//    }


    //Utilisation de Bean
    //    @Bean
    //    public BookRepository bookRepository(){
    //        return new InMemoryBookRepository();
    //    }
    //
    //    @Bean
    //    public LoanRepository loanRepository(){
    //        return new InMemoryLoanRepository();
    //    }

//    @Bean
//    public LibraryService libraryService(BookRepository bookRepository,LoanRepository loanRepository){
//        return  libraryService(bookRepository,loanRepository);
//    }

}
