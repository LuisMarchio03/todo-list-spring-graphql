package romani.todolist.todo_app.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import romani.todolist.todo_app.entities.Task;
import romani.todolist.todo_app.repositories.TaskRepository;

@Service
public class TaskQueries implements GraphQLQueryResolver {

    private TaskRepository taskRepository;

    @Autowired
    public TaskQueries(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Iterable<Task> allTasks() {
        return taskRepository.findAll();
    }
}
