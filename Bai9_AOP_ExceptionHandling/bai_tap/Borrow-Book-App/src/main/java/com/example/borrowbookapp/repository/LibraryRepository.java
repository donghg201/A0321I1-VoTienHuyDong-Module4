package com.example.borrowbookapp.repository;

import com.example.borrowbookapp.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Integer> {
    Library getBookById(int id);
}
