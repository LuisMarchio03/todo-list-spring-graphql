package luismarchio.todolist.todo_app.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import luismarchio.todolist.todo_app.entities.Category;
import luismarchio.todolist.todo_app.entities.Task;
import luismarchio.todolist.todo_app.entities.User;
import luismarchio.todolist.todo_app.repositories.CategoryRepository;
import luismarchio.todolist.todo_app.repositories.UserRepository;

// @Service: anotação que indica que a classe é um serviço
// Serviço: classe que permite realizar operações no banco de dados
// TaskResolver: nome do serviço
// Resolver: classe que permite realizar operações de consulta no banco de dados a partir do GraphQL
@Service
public class TaskResolver implements GraphQLResolver<Task> {

    // Injeção de dependência: mecanismo que permite que uma classe receba
    private UserRepository userRepository;
    private CategoryRepository categoryRepository;

    // @Autowired: anotação que indica que o atributo será injetado pelo Spring
    // TaskResolver: nome do construtor
    // UserRepository userRepository: parâmetro do construtor
    // this.userRepository = userRepository: atributo que será injetado pelo Spring
    @Autowired
    public TaskResolver(UserRepository userRepository, CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    // getUser: método que permite buscar um usuário a partir de uma tarefa
    // User: tipo de retorno do método
    // getUser: nome do método
    // Task task: parâmetro do método
    public User getUser(Task task) {
        return userRepository.findById(task.getUserId()).get();
    }

    // getCategory: método que permite buscar uma categoria a partir de uma tarefa
    // Category: tipo de retorno do método
    // getCategory: nome do método
    // Task task: parâmetro do método
    public Category getCategory(Task task) {
        return categoryRepository.findById(task.getCategoryId()).get();
    }
}
