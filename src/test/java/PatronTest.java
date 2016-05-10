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
    Patron myPatron = new Patron("Bobcat Goldthwait");
    assertEquals("Bobcat Goldthwait", myPatron.getName());
  }

  @Test
  public void save_savesObjectIntoDB_true() {
    Patron myPatron = new Patron("Bobcat Goldthwait");
    myPatron.save();
    assertTrue(Patron.all().get(0).equals(myPatron));
  }

}
