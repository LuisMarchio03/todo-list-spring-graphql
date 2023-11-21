package romani.todolist.todo_app.entities;


public class UpdateTask {

    private String description;
    private String id;

    public UpdateTask(String description, String id) {
        this.description = description;
        this.id = id;
    }

    public UpdateTask() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
