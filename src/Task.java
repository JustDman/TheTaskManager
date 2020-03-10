import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Task {

    public static final SimpleDateFormat FORMATTER = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy");

    private String taskTitle;
    private String taskDescription;
    private GregorianCalendar creationDate = new GregorianCalendar();
    private boolean done = false;

    public static String formated(GregorianCalendar date) {
        return FORMATTER.format(date.getTime());
    }

    public Task(String title) {

        taskTitle = title;
        taskDescription = "None";

    }

    public Task(String title, String description) {

        taskTitle = title;
        taskDescription = description;

    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getCreationDate() {
        return formated(creationDate);
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isDone() {
        return done;
    }

    @Override
    public String toString() {
        String str = taskTitle + "\n" + getCreationDate() + "\n" + taskDescription;
        if (done)
            str += "\nTask complete!";
        else
            str += "\nTask incomplete!";
        return str;
    }
}