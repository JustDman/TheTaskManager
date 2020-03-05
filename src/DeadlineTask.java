import java.util.GregorianCalendar;

public class DeadlineTask extends Task {

    private GregorianCalendar deadline = new GregorianCalendar();

    public DeadlineTask(String title, GregorianCalendar deadline) {
        super(title);
        this.deadline = deadline;
    }

    public DeadlineTask(String title, GregorianCalendar deadline, String description) {
        super(title, description);
        this.deadline = deadline;
    }

    public String getDeadline() {
        return formated(deadline);
    }

    public void setDeadline(GregorianCalendar deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        String str = "";
        str += super.toString() + "\nDeadline: " + formated(deadline);
        return str;
    }

}