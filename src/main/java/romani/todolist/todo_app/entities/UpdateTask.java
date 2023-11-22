package romani.todolist.todo_app.entities;

// UpdateTask: classe que representa uma tarefa que será atualizada
public class UpdateTask {

    // Atributos
    private String description;
    private String id;

    // Construtores: métodos que são executados quando a classe é instanciada
    public UpdateTask(String description, String id) {
        this.description = description;
        this.id = id;
    }

    public UpdateTask() {
    }

    // Getters e Setters: métodos que permitem acessar e modificar os atributos
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
