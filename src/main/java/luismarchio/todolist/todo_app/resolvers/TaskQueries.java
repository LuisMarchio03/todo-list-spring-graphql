package luismarchio.todolist.todo_app.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import luismarchio.todolist.todo_app.entities.Task;
import luismarchio.todolist.todo_app.repositories.TaskRepository;

// @Service: anotação que indica que a classe é um serviço
// Serviço: classe que permite realizar operações no banco de dados
// TaskQueries: nome do serviço
// Queries: classe que permite realizar operações de consulta no banco de dados a partir do GraphQL
@Service
public class TaskQueries implements GraphQLQueryResolver {

    // Injeção de dependência: mecanismo que permite que uma classe receba
    private TaskRepository taskRepository;

    // @Autowired: anotação que indica que o atributo será injetado pelo Spring
    // TaskQueries: nome do construtor
    // TaskRepository taskRepository: parâmetro do construtor
    // this.taskRepository = taskRepository: atributo que será injetado pelo Spring
    @Autowired
    public TaskQueries(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // allTasks: método que permite buscar todas as tarefas
    // Iterable<Task>: tipo de retorno do método
    // allTasks: nome do método
    public Iterable<Task> allTasks() {
        // taskRepository.findAll(): método que permite buscar todas as tarefas
        return taskRepository.findAll();
    }
}
