package todo_app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Todos {
  private Path file;
  private List<String> content;

  public Todos(String filePath) {
    this.file = Paths.get(filePath);
    try {
      this.content = Files.readAllLines(this.file);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String listTodos() {
    if (content.size() != 0) {
      StringBuilder list = new StringBuilder();
      int counter = 1;
      for (String line : content) {
        list.append(counter + " - " + line + "\n");
        counter++;
      }
      return list.toString();
    } else {
      return "No todos for today! :)";
    }
  }

}
