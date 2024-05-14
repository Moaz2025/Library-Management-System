package com.example.LibraryManagementSystem.services;

import com.example.LibraryManagementSystem.entity.Patron;
import com.example.LibraryManagementSystem.repository.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PatronService {

    @Autowired
    private PatronRepository patronRepository;

    public Patron createPatron(Patron patron) {
        return patronRepository.save(patron);
    }

    public Patron getPatronById(Long id) {
        return patronRepository.findById(id).orElse(null);
    }

    public Patron updatePatron(Patron patron) {
        return patronRepository.save(patron);
    }

    public List<Patron> getAllPatrons() {
        return patronRepository.findAll();
    }

    public void deletePatron(Patron patron) {
        patronRepository.delete(patron);
    }
}
