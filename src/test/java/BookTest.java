import org.junit.*;
import static org.junit.Assert.*;

public class BookTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Book_instantiatesCorrectly_true() {
    Book myBook = new Book("Taming of the Shrew");
    assertEquals(true, myBook instanceof Book);
  }

  @Test
  public void getTitle_bookInstantiatesWithTitle_String() {
    Book myBook = new Book("A Tale of Two Cities");
    assertEquals("A Tale of Two Cities", myBook.getTitle());
  }

}
