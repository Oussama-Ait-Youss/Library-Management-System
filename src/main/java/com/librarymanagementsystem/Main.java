package com.librarymanagementsystem;

import com.librarymanagementsystem.config.AppConfig;
import com.librarymanagementsystem.model.Book;
import com.librarymanagementsystem.repository.BookRepository;
import com.librarymanagementsystem.repository.LoanRepository;
import com.librarymanagementsystem.repository.impl.InMemoryBookRepository;
import com.librarymanagementsystem.repository.impl.InMemoryLoanRepository;
import com.librarymanagementsystem.service.LibraryService;
import com.librarymanagementsystem.service.impl.LibraryServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {


        //Utilisation de SPRING

        //demarrer le container spring
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        

        //recupere instance a partir le conteneur (IoC)
        LibraryService libraryService= context.getBean(LibraryService.class);
        Book book1 = new Book(1L, "Crime and Punishment", "Fyodor Dostoevsky", true);
        Book book2 = new Book(2L, "Clean Code", "Robert C. Martin", true);
        Book book3 = new Book(3L, "1984", "George Orwell", true);
        Book book4 = new Book(4L, "The Pragmatic Programmer", "Andrew Hunt", true);
        Book book5 = new Book(5L, "The Great Gatsby", "F. Scott Fitzgerald", false);

        // Ajouter les livres avec Spring
        libraryService.addBook(book1);
        libraryService.addBook(book2);
        libraryService.addBook(book3);
        libraryService.addBook(book4);
        libraryService.addBook(book5);




        // sans utilisation de SPRING
        //        BookRepository bookRepository =
        //                new InMemoryBookRepository();
        //        Book book1 = new Book(1L,"crime and punishment","dustovecy",true);
        //        bookRepository.save(book1);
        //
        //        LoanRepository loanRepository =
        //                new InMemoryLoanRepository();
        //
        //        LibraryService libraryService =
        //                new LibraryServiceImpl(
        //                        bookRepository,
        //                        loanRepository
        //                );

        // Afficher tous les livres
        System.out.println("========== Library Books ==========");
        libraryService.getAllBooks().forEach(System.out::println);

    }
}