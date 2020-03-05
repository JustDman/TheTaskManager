import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    // TODO not this
    public List<Task> taskList = new ArrayList<>();

    public TaskManager() {
        taskList.add(new Task("BANANA"));
    }

    public List<Task> getTasklist() {
        return List.copyOf(taskList);
    }

    public List<Task> searchTaskList(String criteria) {
        List<Task> searched = new ArrayList<>();
        for (Task t : taskList) {
            if (t.toString().contains(criteria))
                searched.add(t);
        }
        return searched;
    }

    public List<Task> searchDeadline() {
        List<Task> deadlines = new ArrayList<>();
        for (Task t : taskList)
            if (t instanceof DeadlineTask)
                deadlines.add(t);
        return deadlines;
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void setDone(Task task, boolean done) {
        if (taskList.contains(task)) {
            task.setDone(done);
        }
    }

    public boolean isDone(Task task) {
        if (taskList.contains(task)) {
            return task.isDone();
        }
        return false;
    }

    public void deleteTask(Task task) {
        if (taskList.contains(task))
            taskList.remove(task);
    }

}