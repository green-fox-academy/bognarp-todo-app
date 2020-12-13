package todo_app;

public class ArgumentHandler {

  public static void listTodos(TodoList todos) {
    System.out.println(todos.listTodos());
  }

  public static void addTodos(TodoList todos, String[] args) throws Exception {
    if (args.length == 1) {
      throw new Exception("Unable to add: no task provided");
    } else {
      todos.appendTodo(args[1]);
    }
  }

  public static void removeTodos(TodoList todos, String[] args) throws Exception {
    if (args.length == 1) {
      throw new Exception("Unable to remove: no index provided");
    } else {
      try {
        int removeLine = Integer.parseInt(args[1]);
        todos.removeTodo(removeLine);
      } catch (NumberFormatException e) {
        throw new Exception("Unable to remove: index is not a number");
      }
    }
  }

  public static void checkTodos(TodoList todos, String[] args) throws Exception {
    if (args.length == 1) {
      throw new Exception("Unable to check: no index provided");
    } else {
      try {
        int checkLine = Integer.parseInt(args[1]);
        todos.checkTodo(checkLine);
      } catch (NumberFormatException e) {
        throw new Exception("Unable to check: index is not a number");
      }
    }
  }

}
