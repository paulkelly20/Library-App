package models;

import db.DBHelper;

import javax.persistence.*;
import java.util.ArrayList;
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
        this.books = new ArrayList<Book>();
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

    @ManyToOne
    @JoinColumn(name = "library_id", nullable = false)
    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
    @ElementCollection
    @CollectionTable
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void recieveBookFromLibrary(Book book){
        this.books.add(book);
        DBHelper.save(this);
        DBHelper.save(book);
    }
}
