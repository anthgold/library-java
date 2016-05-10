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

/*

@Test
public void all_emptyAtFirst_0() {
  assertEquals(0, Task.all().size());
}

@Test
public void equals_returnsTrueIfDescriptionsAretheSame_true() {
  Task firstTask = new Task("Mow the lawn");
  Task secondTask = new Task("Mow the lawn");
  assertTrue(firstTask.equals(secondTask));
}

@Test
public void save_savesObjectIntoDB_true() {
  Task myTask = new Task("Mow the lawn");
  myTask.save();
  assertTrue(Task.all().get(0).equals(myTask));
}

@Test
public void save_assignsIdToObject_int() {
  Task myTask = new Task("Mow the lawn");
  myTask.save();
  Task savedTask = Task.all().get(0);
  assertEquals(myTask.getId(), savedTask.getId());
}

@Test
public void find_findsTaskInDatabase_true() {
  Task myTask = new Task("Mow the lawn");
  myTask.save();
  Task savedTask = Task.find(myTask.getId());
  assertTrue(myTask.equals(savedTask));
}


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