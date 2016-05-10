import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Book {
  private int id;
  private String title;

  public Book(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

/*
public int getId() {
  return id;
}

public static List<Task> all() {
  String sql = "SELECT id, description FROM tasks";
  try(Connection con = DB.sql2o.open()) {
    return con.createQuery(sql).executeAndFetch(Task.class);
  }
}

@Override
public boolean equals(Object otherTask){
  if (!(otherTask instanceof Task)) {
    return false;
  } else {
    Task newTask = (Task) otherTask;
    return this.getDescription().equals(newTask.getDescription()) &&
           this.getId() == newTask.getId();
  }
}

public void save() {
  try(Connection con = DB.sql2o.open()) {
    String sql = "INSERT INTO tasks(description) VALUES (:description)";
    this.id = (int) con.createQuery(sql, true)
      .addParameter("description", this.description)
      .executeUpdate()
      .getKey();
  }
}

public static Task find(int id) {
  try(Connection con = DB.sql2o.open()) {
    String sql = "SELECT * FROM tasks where id=:id";
    Task task = con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Task.class);
    return task;
  }
}

public void update(String newDescription) {
  try(Connection con = DB.sql2o.open()) {
    String sql = "UPDATE tasks SET description = :description WHERE id = :id";
    con.createQuery(sql)
      .addParameter("description", newDescription)
      .addParameter("id", this.id) // if buggy /\ from id
      .executeUpdate();
  }
}

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

public void delete() {
  try(Connection con = DB.sql2o.open()) {
    String deleteQuery = "DELETE FROM tasks WHERE id = :id;";
      con.createQuery(deleteQuery)
        .addParameter("id", this.getId())
        .executeUpdate();

    String joinDeleteQuery = "DELETE FROM tasks_categories WHERE task_id = :taskId";
      con.createQuery(joinDeleteQuery)
        .addParameter("taskId", this.getId())
        .executeUpdate();
    }
  }

*/

}
