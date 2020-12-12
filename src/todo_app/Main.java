package todo_app;

public class Main {
  private static TodoList todos;

  public static void main(String[] args) throws Exception {
    todos = new TodoList("todos.txt");
    handleArgs(args);
  }

  private static void handleArgs(String[] args) {
    if (args.length == 0) {
      System.out.println(usageInfo());
    } else if (args.length > 2) {
      System.out.println("Too much arguments");
    } else {
      try {
        parseArgs(args);
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }

  }

  private static void parseArgs(String[] args) throws Exception {

    if (args[0].equals("-l")) {
      System.out.println(todos.listTodos());

    } else if (args[0].equals("-a")) {
      if (args.length == 1) {
        throw new Exception("Unable to add: no task provided");
      } else {
        todos.appendTodo(args[1]);
      }

    } else if (args[0].equals("-r")) {
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
    } else if (args[0].equals("-c")) {
      if (args.length == 1) {
        throw new Exception("Unable to check: no index provided");
      } else {
        try {
          int checkLine = Integer.parseInt(args[1]);
          todos.checkTodo(checkLine);
        } catch (NumberFormatException e) {
          throw new Exception("Unable to remove: index is not a number");
        }
      }

    } else {
      System.out.println("Unsupported argument");
      System.out.println(usageInfo());
    }

  }

  private static String usageInfo() {
    return "Command Line Todo application\n" +
        "=============================\n\n" +
        "Command line arguments:\n" +
        "\t-l\tLists all the tasks\n" +
        "\t-a\tAdds a new task\n" +
        "\t-r\tRemoves an task\n" +
        "\t-c\tCompletes an task";
  }

}
