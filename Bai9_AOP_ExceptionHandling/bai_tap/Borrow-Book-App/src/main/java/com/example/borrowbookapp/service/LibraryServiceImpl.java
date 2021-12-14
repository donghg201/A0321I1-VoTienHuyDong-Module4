package com.example.borrowbookapp.service;

import com.example.borrowbookapp.model.Library;
import com.example.borrowbookapp.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LibraryServiceImpl implements LibraryService {
    @Autowired
    LibraryRepository libraryRepository;

    @Override
    public List<Library> findAll() {
        return libraryRepository.findAll();
    }

    @Override
    public Page<Library> findAllBook(Pageable pageable) {
        return libraryRepository.findAll(pageable);
    }

    @Override
    public Page<Library> findAllByName(String name, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Library> findAllByAuthor(String author, Pageable pageable) {
        return null;
    }

    @Override
    public Library getBookById(int id) {
        return libraryRepository.getBookById(id);
    }

    @Override
    public Library save(Library library) {
        return libraryRepository.save(library);
    }

    @Override
    public void deleteBookById(int id) {
        libraryRepository.deleteById(id);
    }
}
