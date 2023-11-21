package romani.todolist.todo_app.entities;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    @Transient
    private Iterable<Task> tasks;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public Iterable<Task> getTasks() {
        return tasks;
    }

    public User setTasks(Iterable<Task> tasks) {
        this.tasks = tasks;
        return this;
    }
}
