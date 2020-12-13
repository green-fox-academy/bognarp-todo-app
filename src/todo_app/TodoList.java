package todo_app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TodoList {
  private final Path path;
  private List<Todo> todos;

  private void readFromFile(List<String> lines) {
    todos = new ArrayList<>();

    for (String line : lines) {
      if (isChecked(line)) {
        if(isDone(line)) {
          todos.add(new Todo(getTodoNameFromLine(line), true));
        } else {
          todos.add(new Todo(getTodoNameFromLine(line), false));
        }
      } else {
        todos.add(new Todo(line));
      }
    }
  }

  private String getTodoNameFromLine(String line) {
    if (line.startsWith("[X] ") || line.startsWith("[ ] ")) {
      return line.substring(4);
    } else {
      return line;
    }
  }

  private boolean isChecked(String line) {
    return line.startsWith("[X] ") || line.startsWith("[ ] ");
  }

  private boolean isDone(String line) {
    return line.startsWith("[X] ");
  }

  private void writeToFile() throws IOException {
    List<String> list = new ArrayList<>();
    for (Todo todo : todos) {
      list.add(todo.toString());
    }
    Files.write(path, list);
  }

  public TodoList(String path) {
    this.path = Paths.get(path);
    try {
      List<String> lines = Files.readAllLines(this.path);
      readFromFile(lines);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String listTodos() {
    if (todos.size() != 0) {
      return toString();
    } else {
      return "No todos for today! :)";
    }
  }

  public void appendTodo(String todo) throws IOException {
    Files.write(path, Collections.singleton(todo),
        StandardOpenOption.APPEND);
  }

  public void removeTodo(int num) throws Exception {
    if (num > todos.size() || num < 1) {
      throw new Exception("Unable to remove: index is out of bound");
    } else {
      todos.remove(num - 1);
      writeToFile();
    }
  }

  public void checkTodo(int num) throws Exception {
    if (num > todos.size() || num < 1) {
      throw new Exception("Unable to check: index is out of bound");
    } else {
      todos.get(num - 1).check();
      writeToFile();
    }
  }

  @Override
  public String toString() {
    StringBuilder list = new StringBuilder();
    for (Todo todo : todos) {
      list.append(todos.indexOf(todo) + 1).append(" - ").append(todo.toString()).append("\n");
    }
    return list.toString();
  }
}
