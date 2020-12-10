package todo_app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Todos {
  Path file;
  List<String> content;

  public Todos(String filePath) {
    this.file = Paths.get(filePath);
    try {
      this.content = Files.readAllLines(this.file);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String listTodos() {
    StringBuilder list = new StringBuilder();
    int counter = 1;
    for (String line : content) {
      list.append(counter + " - " + line + "\n");
      counter++;
    }
    return list.toString();
  }


}
