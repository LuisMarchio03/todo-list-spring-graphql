package romani.todolist.todo_app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import romani.todolist.todo_app.entities.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, String> {
    Iterable<Task> findAllByUserId(String userId);
    Iterable<Task> findAllByUserIdAndStatus(String userId, String status);
}
