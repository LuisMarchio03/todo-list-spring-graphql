package romani.todolist.todo_app.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import romani.todolist.todo_app.entities.Task;
import romani.todolist.todo_app.entities.User;
import romani.todolist.todo_app.repositories.UserRepository;

@Service
public class TaskResolver implements GraphQLResolver<Task> {

    private UserRepository userRepository;

    @Autowired
    public TaskResolver(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(Task task) {
        return userRepository.findById(task.getUserId()).get();
    }
}
