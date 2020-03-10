import java.util.GregorianCalendar;
import java.util.List;

public class CommandInterpreter {

    final TaskManager tm;

    public CommandInterpreter(TaskManager manager) {
        tm = manager;
        start();
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
            s = (String) Input.get(Input.STRING, "");
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
        Input.close();
    }

    public void showAll() {
        System.out.println("***********************TASKLIST***********************");
        tm.getTasklist().forEach(e -> {
            System.out.println(e);
            System.out.println();
        });
    }

    public void searchAll() {
        tm.searchTaskList((String) Input.get(Input.STRING, "What keyword do you want to search for?")).forEach(e -> {
            System.out.println(e);
            System.out.println();
        });

    }

    public void showDeadlines() {
        tm.searchDeadline().forEach(e -> {
            System.out.println(e);
            System.out.println();
        });
    }

    public void createNewTask() {
        String s = "-";
        String title;
        String description;
        boolean addTask = true;
        GregorianCalendar greg = new GregorianCalendar();

        while (addTask) {
            s = (String) Input.get(Input.STRING,
                    "Which kind of task do you want to create?\n1) Task\n2) Task with deadline\nx) Exit");

            switch (s) {
                case "1":
                    title = (String) Input.get(Input.STRING, "Enter title!");
                    description = (String) Input.get(Input.STRING, "Enter description (leave empty if none)!");
                    if (!(description.length() < 1)) {
                        tm.addTask(new Task(title, description));
                    } else {
                        tm.addTask(new Task(title));
                    }
                    break;
                case "2":
                    title = (String) Input.get(Input.STRING, "Enter title!");
                    description = (String) Input.get(Input.STRING, "Enter description (leave empty if none)!");
                    System.out.println("ENTER TIME OF DEADLINE!");
                    greg.set((int) Input.get(Input.INT, "Enter year!"), (int) Input.get(Input.INT, "Enter month!"),
                            (int) Input.get(Input.INT, "Enter day!"), (int) Input.get(Input.INT, "Enter hour!"),
                            (int) Input.get(Input.INT, "Enter minute!"), 00);
                    if (!(description.length() < 1)) {

                        tm.addTask(new DeadlineTask(title, greg, description));
                    } else {
                        tm.addTask(new DeadlineTask(title, greg));
                    }
                    break;
                default:
                    System.out.println("Wrong input!");
                    addTask = false;
                    break;
            }
        }
    }

    public void finishTask() {
        List<Task> t = tm.getTasklist();

        for (int i = 0; i < t.size(); i++) {
            System.out.print(i + 1 + ") ");
            System.out.println(t.get(i));
        }
        tm.setDone(tm.getTaskById((int) (Input.get(Input.INT, "Select ID of task to be set completed!")) - 1), true);
    }

    public void deleteTask() {
        List<Task> t = tm.getTasklist();

        for (int i = 0; i < t.size(); i++) {
            System.out.print(i + 1 + ") ");
            System.out.println(t.get(i));
        }
        tm.deleteTask(tm.getTaskById((int) Input.get(Input.INT, "Select ID of task to be deleted!") - 1));
    }

    public void error() {
        System.out.println("Invalid Input!");
    }

}