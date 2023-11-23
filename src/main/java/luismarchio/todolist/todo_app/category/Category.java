package luismarchio.todolist.todo_app.category;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import luismarchio.todolist.todo_app.task.Task;
import luismarchio.todolist.todo_app.user.User;

@Document
public class Category {
  @Id
  private String id;
  private String name;
  private String description;
  private String color;
  private String status; // active = true, inactive = false
  private String userId;

  @Transient
  private Iterable<Task> tasks;
  @Transient
  private User user;

  public Category(String name, String description, String color, String status, String userId) {
    this.name = name;
    this.description = description;
    this.color = color;
    this.status = status;
    this.userId = userId;
  }

  public Category() {
  }

  public String getId() {
    return id;
  }

  public Category setId(String id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public Category setName(String name) {
    this.name = name;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public Category setDescription(String description) {
    this.description = description;
    return this;
  }

  public String getColor() {
    return color;
  }

  public Category setColor(String color) {
    this.color = color;
    return this;
  }

  public String getStatus() {
    return status;
  }

  public Category setStatus(String status) {
    this.status = status;
    return this;
  }

  public String getUserId() {
    return userId;
  }

  public Category setUserId(String userId) {
    this.userId = userId;
    return this;
  }

  public Iterable<Task> getTasks() {
    return tasks;
  }

  public Category setTasks(Iterable<Task> tasks) {
    this.tasks = tasks;
    return this;
  }

  public User getUser() {
    return user;
  }

  public Category setUser(User user) {
    this.user = user;
    return this;
  }

  @Override
  public String toString() {
    return "Category{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", description='" + description + '\'' +
        ", color='" + color + '\'' +
        ", status='" + status + '\'' +
        ", userId='" + userId + '\'' +
        ", tasks=" + tasks +
        ", user=" + user +
        '}';
  }
}
