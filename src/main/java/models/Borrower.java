package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "borrowers")
public class Borrower {
    private int id;
    private String name;
    private Library library;
    private List<Book> books;

    public Borrower() {
    }

    public Borrower(String name, Library library) {
        this.name = name;
        this.library = library;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "borrower")
    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    @OneToMany(mappedBy = "borrower_id")
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
