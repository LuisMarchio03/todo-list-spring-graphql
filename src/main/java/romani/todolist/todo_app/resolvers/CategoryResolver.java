package romani.todolist.todo_app.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import romani.todolist.todo_app.entities.Task;
import romani.todolist.todo_app.entities.User;
import romani.todolist.todo_app.entities.Category;
import romani.todolist.todo_app.repositories.TaskRepository;
import romani.todolist.todo_app.repositories.UserRepository;

// @Service: anotação que indica que a classe é um serviço
// Serviço: classe que permite realizar operações no banco de dados
// CategoryResolver: nome do serviço
// Resolver: classe que permite realizar operações de consulta no banco de dados a partir do GraphQL
@Service
public class CategoryResolver implements GraphQLResolver<Category> {

  // Injeção de dependência: mecanismo que permite que uma classe receba
  private TaskRepository taskRepository;
  private UserRepository userRepository;

  // @Autowired: anotação que indica que o atributo será injetado pelo Spring
  // CategoryResolver: nome do construtor
  // TaskRepository taskRepository: parâmetro do construtor
  // this.taskRepository = taskRepository: atributo que será injetado pelo Spring
  @Autowired
  public CategoryResolver(TaskRepository taskRepository, UserRepository userRepository) {
    this.taskRepository = taskRepository;
    this.userRepository = userRepository;
  }

  // getTasks: método que permite buscar todas as tarefas de um usuário
  // Iterable<Task>: tipo de retorno do método
  // getTasks: nome do método
  // Category category: parâmetro do método
  public Iterable<Task> getTasks(Category category, String status) {
    // status == null: verifica se o status é nulo
    // taskRepository.findAllByCategoryId(category.getId()): método que permite
    // buscar todas
    // as tarefas de um usuário
    // taskRepository.findAllByCategoryIdAndStatus(category.getId(), status): método
    // que
    // permite buscar todas as tarefas de um usuário a partir do status
    if (status == null) {
      return taskRepository.findAllByCategoryId(category.getId());
    }
    return taskRepository.findAllByCategoryIdAndStatus(category.getId(), status);
  }

  public User getUser(Category category) {
    return userRepository.findById(category.getUserId()).get();
  }

}
