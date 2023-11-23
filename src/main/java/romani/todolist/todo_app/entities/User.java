package romani.todolist.todo_app.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

// @Document: anotação que indica que a classe é um documento do MongoDB (Ou seja, uma entidade)
// User: nome da coleção no MongoDB
@Document
public class User {
    // @Id: anotação que indica que o atributo é o identificador do documento
    // String: tipo do atributo
    // id: nome do atributo
    // private: modificador de acesso do atributo
    // Atributos
    @Id
    private String id;
    private String name;
    private String email;
    @Transient
    private Iterable<Task> tasks;
    @Transient
    private Iterable<Category> categories;

    // Construtores: métodos que são executados quando a classe é instanciada
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User() {
    }

    // Getters e Setters: métodos que permitem acessar e modificar os atributos
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
