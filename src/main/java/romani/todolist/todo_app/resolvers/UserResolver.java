package romani.todolist.todo_app.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import romani.todolist.todo_app.entities.Task;
import romani.todolist.todo_app.entities.User;
import romani.todolist.todo_app.repositories.TaskRepository;

@Service
public class UserResolver implements GraphQLResolver<User> {

    private TaskRepository taskRepository;

    @Autowired
    public UserResolver(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Iterable<Task> getTasks(User user, String status) {
        if (status == null) {
            return taskRepository.findAllByUserId(user.getId());
        }
        return taskRepository.findAllByUserIdAndStatus(user.getId(), status);
    }
}
