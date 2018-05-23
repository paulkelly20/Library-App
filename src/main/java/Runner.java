import db.DBHelper;
import models.Book;
import models.Borrower;
import models.Library;

public class Runner {

    public static void main(String[] args) {

        Book book = new Book("Jaws", "Horror", "Peter Benchley");
        Book book2 = new Book("Harry Potter", "Fantasy", "JK Rowling");
        Book book3 = new Book("Game of thrones", "Sci-Fi", "George RR Martin");


        Library library = new Library("Royal Glasgow");

        Borrower borrower = new Borrower("Fraser", library);
        Borrower borrower2 = new Borrower("Paul", library);


        library.addBookToLibrary(book);
        library.addBookToLibrary(book2);
        library.addBookToLibrary(book3);

        library.addBorrowerToLibrary(borrower);
        library.addBorrowerToLibrary(borrower2);

        book.setLibrary(library);
        book2.setLibrary(library);
        book3.setLibrary(library);



        DBHelper.save(library);
        DBHelper.save(book);
        DBHelper.save(book2);
        DBHelper.save(book3);
        DBHelper.save(borrower);
        DBHelper.save(borrower2);

        borrower.recieveBookFromLibrary(library.giveBooks(book));


    }
}
