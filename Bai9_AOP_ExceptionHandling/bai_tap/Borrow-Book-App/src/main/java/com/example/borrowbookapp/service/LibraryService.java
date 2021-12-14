package com.example.borrowbookapp.service;

import com.example.borrowbookapp.model.Library;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface LibraryService {
    public List<Library> findAll();

    public Page<Library> findAllBook(Pageable pageable);

    public Page<Library> findAllByName(String name, Pageable pageable);

    public Page<Library> findAllByAuthor(String author, Pageable pageable);

    Library getBookById(int id);

    public Library save(Library library);

    public void deleteBookById(int id);
}
