package models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "librarys")
public class Library {
    private int id;
    private String name;
    private List<Book> books;
    private List<Borrower> borrowers;

    public Library() {
    }

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<Book>();
        this.borrowers = new ArrayList<Borrower>();
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

    @OneToMany(mappedBy = "library")
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @OneToMany(mappedBy = "library")
    public List<Borrower> getBorrowers() {
        return borrowers;
    }

    public void setBorrowers(List<Borrower> borrowers) {
        this.borrowers = borrowers;
    }

    public void addBookToLibrary(Book book){
        this.books.add(book);
    }

    public void addBorrowerToLibrary(Borrower borrower){
        this.borrowers.add(borrower);
    }

    public int bookCounts() {
         return this.books.size();
    }
}
