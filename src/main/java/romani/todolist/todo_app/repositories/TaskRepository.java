package romani.todolist.todo_app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import romani.todolist.todo_app.entities.Task;

// @Repository: anotação que indica que a classe é um repositório
// Repositório: classe que permite realizar operações no banco de dados
// TaskRepository: nome do repositório
@Repository
public interface TaskRepository extends CrudRepository<Task, String> {
    // Iterable<Task>: tipo de retorno do método
    // findAllByUserId: nome do método
    // String userId: parâmetro do método

    // findAllByUserId: metodos que permite buscar todas as tarefas de um usuário
    Iterable<Task> findAllByUserId(String userId);

    // Iterable<Task>: tipo de retorno do método
    // findAllByUserIdAndStatus: nome do método
    // String userId: primeiro parâmetro do método

    // findAllByUserIdAndStatus: metodos que permite buscar todas as tarefas de um
    // usuário a partir de um status
    Iterable<Task> findAllByUserIdAndStatus(String userId, String status);
}
