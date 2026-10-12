package com.librarymanagementsystem.repository.impl;

import com.librarymanagementsystem.model.Loan;
import com.librarymanagementsystem.repository.LoanRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;




@Repository
public class InMemoryLoanRepository implements LoanRepository {

    private final HashMap<Long,Loan> Loan_storage = new HashMap<>();

    @Override
    public void save(Loan loan){
        Loan_storage.put(loan.getId(),loan);
    }

    @Override
    public Optional<Loan> findById(Long id){

        if(Loan_storage.containsKey(id)){
            return Optional.of(Loan_storage.get(id));
        }
        return Optional.empty();
    }

    @Override
    public List<Loan> findAll(){
        return Loan_storage.values().stream().toList();

    }
}
