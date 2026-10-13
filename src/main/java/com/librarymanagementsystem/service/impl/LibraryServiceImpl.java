package com.librarymanagementsystem.service.impl;


import com.librarymanagementsystem.model.Book;
import com.librarymanagementsystem.model.Loan;
import com.librarymanagementsystem.model.Member;
import com.librarymanagementsystem.repository.BookRepository;
import com.librarymanagementsystem.repository.LoanRepository;
import com.librarymanagementsystem.service.NotificationService;
import com.librarymanagementsystem.service.LibraryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LibraryServiceImpl
        implements LibraryService {

    //@Autowired
    private final BookRepository bookRepository;
    private final LoanRepository loanRepository;
    private final NotificationService notificationService;

    public LibraryServiceImpl(
            BookRepository bookRepository,
            LoanRepository loanRepository,NotificationService notificationService) {

        this.bookRepository = bookRepository;
        this.loanRepository = loanRepository;
        this.notificationService = notificationService;
    }


    @Override
    public void addBook(Book book){
        bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @Override
    public void borrowBook(Long bookId, Member member) {

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() ->
                        new RuntimeException("Book not found"));

        if (!book.isAvailable()) {
            throw new RuntimeException("Book is not available");
        }

        Loan loan = new Loan();

        loan.setBook(book);
        loan.setMember(member);
        loan.setLoanDate(LocalDate.now());
        loan.setReturnDate(null);

        book.setAvailable(false);

        bookRepository.save(book);
        loanRepository.save(loan);
        notificationService.SendNotification("Book Borrow succefully..." + book.getTitle());
    }
    @Override
    public void returnBook(Long loanId) {

        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() ->
                        new RuntimeException("Loan not found"));
    }
}