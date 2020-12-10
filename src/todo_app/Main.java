package todo_app;

public class Main {

  public static void main(String[] args) {
    handleArgs(args);
  }

  private static void handleArgs(String[] args) {
    if (args.length == 0) {
      // Print usage
      System.out.println(usageInfo());
    } else {
      // TODO: Handle arguments
      System.out.println(args);
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
