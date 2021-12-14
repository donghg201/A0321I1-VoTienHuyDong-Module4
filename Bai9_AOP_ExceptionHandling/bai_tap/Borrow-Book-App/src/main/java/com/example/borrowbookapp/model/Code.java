package com.example.borrowbookapp.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

@Entity
public class Code {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code")
    @Range(min = 10000, max = 99999)
    private Integer code;

    @ManyToOne
    @JoinColumn(name="book_id")
    private Library library;

    public Code(Integer id, Integer code, Library library) {
        this.id = id;
        this.code = code;
        this.library = library;
    }

    public Code() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
