package romani.todolist.todo_app.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import romani.todolist.todo_app.entities.User;
import romani.todolist.todo_app.repositories.UserRepository;

@Service
public class UserMutations implements GraphQLMutationResolver {

    private UserRepository userRepository;

    @Autowired
    public UserMutations(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(String name, String email) {
        User user = new User(name, email);
        return userRepository.save(user);
    }
}
