import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Book {
  private int id;
  private String title;
  private int copies;

  public Book(String title, int copies) {
    this.title = title;
    this.copies = copies;
  }

  public String getTitle() {
    return title;
  }

  public int getCopies() {
    return copies;
  }

  public int getId() {
    return id;
  }

  @Override
  public boolean equals(Object otherBook){
    if (!(otherBook instanceof Book)) {
      return false;
    } else {
      Book newBook = (Book) otherBook;
      return this.getTitle().equals(newBook.getTitle()) &&
             this.getCopies() == newBook.getCopies() &&
             this.getId() == newBook.getId();
    }
  }

  public static List<Book> all() {
    String sql = "SELECT * FROM books";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Book.class);
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO books(title, copies) VALUES (:title , :copies)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("title", this.title)
        .addParameter("copies", this.copies)
        .executeUpdate()
        .getKey();
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String deleteQuery = "DELETE FROM books WHERE id = :id;";
        con.createQuery(deleteQuery)
          .addParameter("id", this.getId())
          .executeUpdate();

      // String joinDeleteQuery = "DELETE FROM tasks_categories WHERE task_id = :taskId";
      //   con.createQuery(joinDeleteQuery)
      //     .addParameter("taskId", this.getId())
      //     .executeUpdate();
      }
    }

  public static Book find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM books WHERE id=:id";
      Book book = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Book.class);
      return book;
    }
  }

  public void update(String newTitle, int newCopies) {
    try(Connection con = DB.sql2o.open()) {
      String titleUpdate = "UPDATE books SET title = :title WHERE id = :id";
      con.createQuery(titleUpdate)
        .addParameter("title", newTitle)
        .addParameter("id", this.id) // if buggy /\ from id
        .executeUpdate();

      String copiesUpdate = "UPDATE books SET copies = :copies WHERE id = :id";
      con.createQuery(copiesUpdate)
        .addParameter("copies", newCopies)
        .addParameter("id", this.id) // if buggy /\ from id
        .executeUpdate();
    }
  }

/*

public void addCategory(Category category) {
  try(Connection con = DB.sql2o.open()) {
    String sql = "INSERT INTO tasks_categories (task_id, category_id) VALUES (:task_id, :category_id)";
    con.createQuery(sql)
      .addParameter("task_id", this.getId())
      .addParameter("category_id", category.getId())
      .executeUpdate();
  }
}

public List<Category> getCategories() {
  try(Connection con = DB.sql2o.open()) {
    String joinQuery = "SELECT category_id FROM tasks_categories WHERE task_id = :task_id";
    List<Integer> categoryIds = con.createQuery(joinQuery)
      .addParameter("task_id", this.getId())
      .executeAndFetch(Integer.class);

    List<Category> categories = new ArrayList<Category>();

    for (Integer categoryId : categoryIds) {
      String taskQuery = "SELECT * FROM categories WHERE id = :categoryId";
      Category category = con.createQuery(taskQuery)
        .addParameter("categoryId", categoryId)
        .executeAndFetchFirst(Category.class);
      categories.add(category);
    }
    return categories;
  }
}

*/

}
