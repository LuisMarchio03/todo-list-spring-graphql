package luismarchio.todolist.todo_app.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

// @Document: anotação que indica que a classe é um documento do MongoDB (Ou seja, uma entidade)
// Task: nome da coleção no MongoDB
@Document
public class Task {
    // @Id: anotação que indica que o atributo é o identificador do documento
    // String: tipo do atributo
    // id: nome do atributo
    // private: modificador de acesso do atributo
    @Id
    private String id;
    private String title;
    private String description;
    private String status; // finished = true, unfinished = false
    private String userId;
    private String categoryId;

    // @Transient: anotação que indica que o atributo não será persistido no banco
    // de dados
    // User: tipo do atributo -> Retorna o usuário que está associado a tarefa
    @Transient
    private User user;

    // @Transient: anotação que indica que o atributo não será persistido no banco
    // de dados
    // Category: tipo do atributo -> Retorna a categoria que está associada a tarefa
    @Transient
    private Category category;

    // Construtor: método que é executado quando a classe é instanciada
    public Task(String title, String description, String status, String userId, String categoryId) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.userId = userId;
        this.categoryId = categoryId;
    }

    // Getters e Setters: métodos que permitem acessar e modificar os atributos
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

    public String getCategoryId() {
        return categoryId;
    }

    public Task setCategoryId(String categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Task setUser(User user) {
        this.user = user;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Task setCategory(Category category) {
        this.category = category;
        return this;
    }
}
