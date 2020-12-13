package todo_app;

public class Main {
  private static TodoList todos;

  public static void main(String[] args) {
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
      ArgumentHandler.listTodos(todos);
    } else if (args[0].equals("-a")) {
      ArgumentHandler.addTodos(todos, args);
    } else if (args[0].equals("-r")) {
      ArgumentHandler.removeTodos(todos, args);
    } else if (args[0].equals("-c")) {
      ArgumentHandler.checkTodos(todos, args);
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
