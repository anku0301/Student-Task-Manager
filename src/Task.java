import java.io.Serializable;

public class Task implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String title;
    private boolean completed;

    public Task(String title) {
        this.title = title;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        String status = completed ? "[Completed]" : "[Pending]";
        return status + " " + title;
    }
}
