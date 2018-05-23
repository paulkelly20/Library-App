package models;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    private int id;
    private String title;
    private String genre;
    private String author;
    private Library library;
    private Borrower borrower;

    public Book() {
    }

    public Book(String title, String genre, String author) {
        this.title = title;
        this.genre = genre;
        this.author = author;
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
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        genre = genre;
    }

    @ManyToOne()
    @JoinColumn(name = "library_id")
    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    @ManyToOne
    @JoinColumn(name = "borrower_id")
    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }
}
