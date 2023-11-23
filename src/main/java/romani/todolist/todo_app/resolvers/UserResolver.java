package romani.todolist.todo_app.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import romani.todolist.todo_app.entities.Category;
import romani.todolist.todo_app.entities.Task;
import romani.todolist.todo_app.entities.User;
import romani.todolist.todo_app.repositories.CategoryRepository;
import romani.todolist.todo_app.repositories.TaskRepository;

// @Service: anotação que indica que a classe é um serviço
// Serviço: classe que permite realizar operações no banco de dados
// UserResolver: nome do serviço
// Resolver: classe que permite realizar operações de consulta no banco de dados a partir do GraphQL
@Service
public class UserResolver implements GraphQLResolver<User> {

    // Injeção de dependência: mecanismo que permite que uma classe receba
    private TaskRepository taskRepository;
    private CategoryRepository categoryRepository;

    // @Autowired: anotação que indica que o atributo será injetado pelo Spring
    // UserResolver: nome do construtor
    // TaskRepository taskRepository: parâmetro do construtor
    // this.taskRepository = taskRepository: atributo que será injetado pelo Spring
    @Autowired
    public UserResolver(TaskRepository taskRepository, CategoryRepository categoryRepository) {
        this.taskRepository = taskRepository;
        this.categoryRepository = categoryRepository;
    }

    // getTasks: método que permite buscar todas as tarefas de um usuário
    // Iterable<Task>: tipo de retorno do método
    // getTasks: nome do método
    // User user: parâmetro do método
    public Iterable<Task> getTasks(User user, String status) {
        // status == null: verifica se o status é nulo
        // taskRepository.findAllByUserId(user.getId()): método que permite buscar todas
        // as tarefas de um usuário
        // taskRepository.findAllByUserIdAndStatus(user.getId(), status): método que
        // permite buscar todas as tarefas de um usuário a partir do status
        if (status == null) {
            return taskRepository.findAllByUserId(user.getId());
        }
        return taskRepository.findAllByUserIdAndStatus(user.getId(), status);
    }

    // getCategories: método que permite buscar todas as categorias de um usuário
    // Iterable<Category>: tipo de retorno do método
    // getCategories: nome do método
    // User user: parâmetro do método
    public Iterable<Category> getCategories(User user) {
        // categoryRepository.findAllByUserId(user.getId()): método que permite buscar
        // todas as categorias de um usuário
        return categoryRepository.findAllCategoriesByUserId(user.getId());
    }
}
