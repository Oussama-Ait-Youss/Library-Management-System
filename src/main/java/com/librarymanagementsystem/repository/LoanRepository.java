package com.librarymanagementsystem.repository;

import com.librarymanagementsystem.model.Loan;

import java.util.List;
import java.util.Optional;

public interface LoanRepository {

    void save(Loan loan);

    Optional<Loan> findById(Long id);

    List<Loan> findAll();
}
