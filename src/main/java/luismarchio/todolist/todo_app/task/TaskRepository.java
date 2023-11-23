package luismarchio.todolist.todo_app.task;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

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

    // findAllByCategoryId: metodos que permite buscar todas as tarefas de uma
    // categoria
    Iterable<Task> findAllByCategoryId(String categoryId);

    // Iterable<Task>: tipo de retorno do método
    // findAllByUserIdAndStatus: nome do método
    // String userId: primeiro parâmetro do método

    // findAllByUserIdAndStatus: metodos que permite buscar todas as tarefas de um
    // usuário a partir de um status
    Iterable<Task> findAllByUserIdAndStatus(String userId, String status);

    // findAllByCategoryIdAndStatus: metodos que permite buscar todas as tarefas de
    // uma categoria a partir de um status
    Iterable<Task> findAllByCategoryIdAndStatus(String categoryId, String status);
}
