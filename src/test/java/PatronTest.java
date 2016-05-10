import org.junit.*;
import static org.junit.Assert.*;

public class PatronTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Patron_instantiatesCorrectly_true() {
    Patron myPatron = new Patron("Bob Roberts");
    assertEquals(true, myPatron instanceof Patron);
  }

  @Test
  public void getName_patronInstantiatesWithName_String() {
    Patron myPatron = new Patron("A Tale of Two Cities");
    assertEquals("A Tale of Two Cities", myPatron.getName());
  }

}
