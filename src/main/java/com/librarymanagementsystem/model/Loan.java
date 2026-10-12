package com.librarymanagementsystem.model;

import java.time.LocalDate;

public class Loan {
    private Long id;
    private Book book;
    private Member member;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public Loan(Long id,Book book,Member member,LocalDate loanDate,LocalDate returnDate){
        this.id = id;
        this.book = book;
        this.member = member;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }


    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", book=" + book +
                ", member=" + member +
                ", loanDate=" + loanDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
