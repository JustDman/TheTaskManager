import java.util.Scanner;

public class CommandInterpreter {

    Scanner scan = new Scanner(System.in);

    final TaskManager tm;

    public CommandInterpreter(TaskManager manager) {
        tm = manager;
    }

    public void showMenu() {
        System.out.println("MENU");
        System.out.println("1) SHOW ALL TASKS");
        System.out.println("2) SEARCH TASKS");
        System.out.println("3) SHOW DEADLINES");
        System.out.println("4) CREATE NEW TASK");
        System.out.println("5) TASK FINISHED");
        System.out.println("6) DELETE TASK");
        System.out.println("x) QUIT");
    }

    public void start() {
        String s = "-";
        while (!s.equals("x")) {
            showMenu();
            s = scan.nextLine();
            switch (s) {
                case "1":
                    this.showAll();
                    break;
                case "2":
                    this.searchAll();
                    break;
                case "3":
                    this.showDeadlines();
                    break;
                case "4":
                    this.createNewTask();
                    break;
                case "5":
                    this.finishTask();
                    break;
                case "6":
                    this.deleteTask();
                case "x":
                    break;
                default:
                    this.error();
                    break;
            }
        }
        scan.close();
    }

    public void showAll() {
        tm.getTasklist().forEach(e -> 
        System.out.println(e));
    }

    public void searchAll() {
        System.out.println("RECHNEN 1+1 = 2");
    }

    public void showDeadlines() {
    }

    public void createNewTask() {

    }

    public void finishTask() {
    }

    public void deleteTask() {
    }

    public void error() {
        System.out.println("Invalid Input!");
    }

}