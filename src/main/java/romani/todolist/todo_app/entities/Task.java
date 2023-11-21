package romani.todolist.todo_app.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Task {
    @Id
    private String id;
    private String title;
    private String description;
    private String status;
    private String userId;
    @Transient
    private User user;

    public Task(String title, String description, String status, String userId) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public Task setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Task setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Task setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Task setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public Task setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Task setUser(User user) {
        this.user = user;
        return this;
    }
}
