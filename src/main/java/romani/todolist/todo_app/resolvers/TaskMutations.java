package romani.todolist.todo_app.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import romani.todolist.todo_app.entities.Task;
import romani.todolist.todo_app.entities.UpdateTask;
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
    public Task addTask(String title, String description, String status, String userId) {
        // Task: Permite criar uma instância da classe Task
        Task task = new Task(title, description, status, userId);

        // taskRepository.save(task): método que permite salvar uma tarefa no banco de
        // dados
        return taskRepository.save(task);
    }

    // UpdateTask: Metodos que permite atualizar uma tarefa
    // updateTask: nome do método
    // UpdateTask updateTask: parâmetro do método
    public Task updateTask(UpdateTask updateTask) {
        // Optional<Task>: tipo de retorno do método
        // taskRepository.findById(updateTask.getId()): método que permite buscar uma
        // tarefa a partir do id
        Optional<Task> optional = taskRepository.findById(updateTask.getId());
        // optional.isPresent(): método que permite verificar se a tarefa foi encontrada
        if (!optional.isPresent()) {
            throw new RuntimeException("Não achamos a task");
        }

        // Task task = optional.get(): método que permite obter a tarefa
        Task task = optional.get();
        // updateTask.getDescription(): método que permite obter a descrição da tarefa
        task.setDescription(updateTask.getDescription());
        // taskRepository.save(task): método que permite salvar uma tarefa no banco de
        return taskRepository.save(task);
    }
}
