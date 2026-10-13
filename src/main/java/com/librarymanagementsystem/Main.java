package com.librarymanagementsystem;

import com.librarymanagementsystem.config.AppConfig;
import com.librarymanagementsystem.model.Book;
import com.librarymanagementsystem.model.Member;
import com.librarymanagementsystem.service.LibraryService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        // 1. Initialize the Spring IoC Container
        System.out.println("[SPRING] Initializing container...\n");

        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            // 2. Retrieve the LibraryService Bean from Spring
            LibraryService libraryService =
                    context.getBean(LibraryService.class);

            // 3. Create a Member
            Member member = new Member(
                    1L,
                    "Oussama",
                    "oussama@gmail.com"
            );

            // 4. Create Books
            Book book1 = new Book(
                    1L, "Crime and Punishment",
                    "Fyodor Dostoevsky", true
            );

            Book book2 = new Book(
                    2L, "Clean Code",
                    "Robert C. Martin", true
            );

            Book book3 = new Book(
                    3L, "1984",
                    "George Orwell", true
            );

            Book book4 = new Book(
                    4L, "The Pragmatic Programmer",
                    "Andrew Hunt", true
            );

            Book book5 = new Book(
                    5L, "The Great Gatsby",
                    "F. Scott Fitzgerald", false
            );

            // 5. Add Books
            System.out.println("========== BOOK MANAGEMENT ==========\n");

            libraryService.addBook(book1);
            libraryService.addBook(book2);
            libraryService.addBook(book3);
            libraryService.addBook(book4);
            libraryService.addBook(book5);

            // 6. Display All Books
            System.out.println("\n========== AVAILABLE BOOKS ==========\n");

            libraryService.getAllBooks()
                    .forEach(System.out::println);

            // 7. Borrow a Book
            System.out.println("\n========== BORROW BOOK ==========\n");

            System.out.println("Member: " + member.getName());
            System.out.println("Book: " + book1.getTitle());
            System.out.println();

            libraryService.borrowBook(book1.getId(), member);

            // 8. Display Books After Borrowing
            System.out.println("\n========== BOOKS AFTER BORROWING ==========\n");

            libraryService.getAllBooks()
                    .forEach(System.out::println);

        } // 9. Spring Context closes automatically here

        System.out.println("\n========== SHUTDOWN ==========");
    }
}