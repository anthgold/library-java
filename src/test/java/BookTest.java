import org.junit.*;
import static org.junit.Assert.*;

public class BookTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void book_bookInstantiatesCorrectly_true() {
    Book myBook = new Book("Taming of the Shrew");
    assertEquals(true, myBook instanceof Book);
  }

}
