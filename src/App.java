import java.util.GregorianCalendar;

public class App {

    public static void main(String[] args) {

        TaskManager tm = new TaskManager();

        tm.addTask(new Task("Do something"));
        tm.addTask(new DeadlineTask("April 1st deadline", new GregorianCalendar(2020,3,1)));
        Task m1st = new DeadlineTask("May 1st deadline", new GregorianCalendar(2020,4,1));
        tm.addTask(m1st);
        tm.addTask(new DeadlineTask("May 22nd deadline", new GregorianCalendar(2020,4,22), "Yes :)"));
        tm.addTask(new Task("very important task", "This is indeed a very important Task!"));
        tm.addTask(new DeadlineTask("2021 Deadline", new GregorianCalendar(2021,0,1)));

        System.out.println("Search for \"1st\":");
        tm.searchTaskList("1st").forEach(t -> System.out.println("#######\n"+t));

        System.out.println("\nList all Tasks with a deadline:");
        tm.searchDeadline().forEach(t -> {
            System.out.println("### DeadlineTask ###\n"+t);
        });

        System.out.println("Deleting task from May 1st...");
        tm.deleteTask(m1st);

        System.out.println("\nSearch for \"1st\":");
        tm.searchTaskList("1st").forEach(t -> System.out.println("#######\n"+t));


        System.out.println("Launching interactive session containing all test protocol Tasks...");
        new CommandInterpreter(tm);

    }

}