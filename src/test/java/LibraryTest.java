import models.Book;
import models.Borrower;
import models.Library;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class LibraryTest {
    Book book;
    Book book2;
    Book book3;
    Library library;
    Borrower borrower;
    Borrower borrower2;

    @Before
    public void before() {
            book = new Book("Jaws", "Horror", "Peter Benchley");
            book2 = new Book("Harry Potter", "Fantasy", "JK Rowling");
            book3 = new Book("Game of thrones", "Sci-Fi", "George RR Martin");


             library = new Library("Royal Glasgow");

             borrower = new Borrower("Fraser", library);
             borrower2 = new Borrower("Paul", library);
             library.addBookToLibrary(book);
    }

    @Test
    public void testCanAddBookToLibrary() {
        assertEquals(1, library.bookCounts());
    }
}
