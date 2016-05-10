import org.junit.*;
import static org.junit.Assert.*;

public class BookTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Book_instantiatesCorrectly_true() {
    Book myBook = new Book("Taming of the Shrew", 1);
    assertEquals(true, myBook instanceof Book);
  }

  @Test
  public void getTitle_bookInstantiatesWithTitle_String() {
    Book myBook = new Book("A Tale of Two Cities", 3);
    assertEquals("A Tale of Two Cities", myBook.getTitle());
  }

  @Test
  public void getCopies_bookInstantiatesWithCopies_int() {
    Book myBook = new Book("A Tale of Two Cities", 2);
    assertEquals(myBook.getCopies(), 2);
  }

  @Test
  public void save_savesObjectIntoDB_true() {
    Book myBook = new Book("Moby Dick", 3);
    myBook.save();
    assertTrue(Book.all().get(0).equals(myBook));
  }

  @Test
  public void all_emptyAtFirst_0() {
    assertEquals(0, Book.all().size());
  }

  @Test
  public void equals_returnsTrueIfTitlesAretheSame_true() {
    Book firstBook = new Book("Necronomicon", 2);
    Book secondBook = new Book("Necronomicon", 2);
    assertTrue(firstBook.equals(secondBook));
  }

  @Test
  public void save_assignsIdToObject_int() {
    Book myBook = new Book("Necronomicon", 666);
    myBook.save();
    Book savedBook = Book.all().get(0);
    assertEquals(myBook.getId(), savedBook.getId());
  }

  @Test
  public void delete_deletesBook_true() {
    Book myBook = new Book("Necronomicon", 666);
    myBook.save();
    int myBookId = myBook.getId();
    myBook.delete();
    assertEquals(null, Book.find(myBookId));
  } // this will fail, .find does not exist
    // also delete
    // also yes

  @Test
  public void find_findsBookInDatabase_true() {
    Book myBook = new Book("Necronomicon", 666);
    myBook.save();
    Book savedBook = Book.find(myBook.getId());
    assertTrue(myBook.equals(savedBook));
  }


/*

@Test
public void update_updatesTaskDescription_true() {
  Task myTask = new Task("Mow the lawn");
  myTask.save();
  myTask.update("Take a nap");
  assertEquals("Take a nap", Task.find(myTask.getId()).getDescription());
}

@Test
public void delete_deletesTask_true() {
  Task myTask = new Task("Mow the lawn");
  myTask.save();
  int myTaskId = myTask.getId();
  myTask.delete();
  assertEquals(null, Task.find(myTaskId));
}

@Test
public void addCategory_addsCategoryToTask_true() {
    Category myCategory = new Category("Shopping");
    myCategory.save();
    Task myTask = new Task("Buy butter");
    myTask.save();
    myTask.addCategory(myCategory);
    Category savedCategory = myTask.getCategories().get(0);
    assertTrue(myCategory.equals(savedCategory));
}

@Test
public void getCategories_returnsAllCategories_List() {
  Category myCategory = new Category("Maintenance");
  myCategory.save();
  Task myTask = new Task("Change the oil");
  myTask.save();
  myTask.addCategory(myCategory);
  List savedCategories = myTask.getCategories();
  assertEquals(1, savedCategories.size());
}

@Test
public void delete_deletesAllTasksAndCategoriesAssociations_true() {
  Category myCategory = new Category("Dental procedures");
  myCategory.save();
  Task myTask = new Task("Polish molars");
  myTask.save();
  myTask.addCategory(myCategory);
  myTask.delete();
  assertEquals(0, myCategory.getTasks().size());
}

*/

}
