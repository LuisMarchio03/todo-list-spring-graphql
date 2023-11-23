package romani.todolist.todo_app.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import romani.todolist.todo_app.entities.Task;
import romani.todolist.todo_app.repositories.TaskRepository;

import java.util.Optional;

// @Service: anotação que indica que a classe é um serviço
// Serviço: classe que permite realizar operações no banco de dados
// TaskMutations: nome do serviço
// Mutations: classe que permite realizar operações de inserção, atualização e remoção no banco de dados a partir do GraphQL
@Service
public class TaskMutations implements GraphQLMutationResolver {

    // Injeção de dependência: mecanismo que permite que uma classe receba
    // instâncias de outras classes
    // TaskRepository: tipo do atributo
    // taskRepository: nome do atributo
    // taskRepository: atributo que será injetado pelo Spring
    private TaskRepository taskRepository;

    // @Autowired: anotação que indica que o atributo será injetado pelo Spring
    // TaskMutations: nome do construtor
    // TaskRepository taskRepository: parâmetro do construtor
    // this.taskRepository = taskRepository: atributo que será injetado pelo Spring
    @Autowired
    public TaskMutations(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // addTask: método que permite adicionar uma tarefa
    // Task: tipo de retorno do método
    // addTask: nome do método
    // String title: primeiro parâmetro do método
    // String description: segundo parâmetro do método
    // String status: terceiro parâmetro do método
    // String userId: quarto parâmetro do método
    public Task addTask(String title, String description, String status, String userId, String categoryId) {
        // Task: Permite criar uma instância da classe Task
        Task task = new Task(title, description, status, userId, categoryId);

        // taskRepository.save(task): método que permite salvar uma tarefa no banco de
        // dados
        return taskRepository.save(task);
    }

    // UpdateTask: Metodos que permite atualizar uma tarefa
    // updateTask: nome do método
    // UpdateTask updateTask: parâmetro do método
    public Task updateTask(String title, String description, String status, String taskId) {
        // Optional<Task>: tipo de retorno do método
        // taskRepository.findById(taskId): método que permite buscar uma tarefa a
        // partir do id
        Optional<Task> optionalTask = taskRepository.findById(taskId);

        // optionalTask.isPresent(): método que verifica se a tarefa existe
        if (optionalTask.isPresent()) {
            // Task task: permite criar uma instância da classe Task
            Task task = optionalTask.get();

            // task.setTitle(title): método que permite atualizar o título de uma tarefa
            // task.setDescription(description): método que permite atualizar a descrição
            // de uma tarefa
            // task.setStatus(status): método que permite atualizar o status de uma tarefa
            task.setTitle(title).setDescription(description).setStatus(status);

            // taskRepository.save(task): método que permite salvar uma tarefa no banco de
            // dados
            return taskRepository.save(task);
        }

        // null: valor de retorno caso a tarefa não exista
        return null;
    }
}
