package todo_app;

public class Todo {
  private String name;
  private boolean checked = false;

  public Todo(String name) {
    this.name = name;
  }

  public void check() {
    checked = true;
  }

  public boolean isChecked() {
    return checked;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return isChecked() ? "[X] " + name : "[ ] " + name;
  }
}
