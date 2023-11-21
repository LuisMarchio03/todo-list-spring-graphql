package romani.todolist.todo_app.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import romani.todolist.todo_app.entities.User;
import romani.todolist.todo_app.repositories.UserRepository;

@Service
public class UserQueries implements GraphQLQueryResolver {

    private UserRepository userRepository;

    @Autowired
    public UserQueries(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> allUsers() {
        return userRepository.findAll();
    }

    public User findByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public User findById(String id) {
        return userRepository.findById(id).get();
    }
}
