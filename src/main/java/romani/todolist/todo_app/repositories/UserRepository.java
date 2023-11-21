package romani.todolist.todo_app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import romani.todolist.todo_app.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    User findUserByEmail(String email);
}
