import org.junit.*;
import static org.junit.Assert.*;

public class FunctionTest {

  @Test
  public void function_testdescription_expected() {
    Tamagotchi myPet = new Tamagotchi("lil dragon");
    assertEquals("lil dragon", myPet.getName());
    
  }
}
