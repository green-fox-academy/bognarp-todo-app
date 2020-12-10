package todo_app;

public class Main {
  private static Todos todos;

  public static void main(String[] args) {
    todos = new Todos("todos.txt");
    handleArgs(args);
  }

  private static void handleArgs(String[] args) {
    if (args.length == 0) {
      // Print usage
      System.out.println(usageInfo());
    } else if (args.length == 1) {
      // Correct number of args
      parseArgs(args);
    } else {
      //TODO: Handle bad things
      System.out.println(args);
    }
  }

  private static void parseArgs(String[] args) {
    switch (args[0]) {
      case "-l":
        System.out.println(todos.listTodos());
        break;
      default:
        System.out.println("default");
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
