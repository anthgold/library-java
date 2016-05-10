import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Patron {
  private String name;
  private int id;

  public Patron(String name) {
    this.name = name;
  }

  // public void save() {
  //   try(Connection con = DB.sql2o.open()) {
  //     String sql = "INSERT INTO patrons(name) VALUES (:name)";
  //     this.id = (int) con.createQuery(sql, true)
  //       .addParameter("name", this.name)
  //       .executeUpdate()
  //       .getKey();
  //   }
  // }



}
