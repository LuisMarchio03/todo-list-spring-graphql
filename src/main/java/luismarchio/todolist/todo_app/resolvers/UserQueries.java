package luismarchio.todolist.todo_app.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import luismarchio.todolist.todo_app.entities.User;
import luismarchio.todolist.todo_app.repositories.UserRepository;

// @Service: anotação que indica que a classe é um serviço
// Serviço: classe que permite realizar operações no banco de dados
// UserQueries: nome do serviço
// Queries: classe que permite realizar operações de consulta no banco de dados a partir do GraphQL
@Service
public class UserQueries implements GraphQLQueryResolver {

    // Injeção de dependência: mecanismo que permite que uma classe receba
    private UserRepository userRepository;

    // @Autowired: anotação que indica que o atributo será injetado pelo Spring
    // UserQueries: nome do construtor
    // UserRepository userRepository: parâmetro do construtor
    // this.userRepository = userRepository: atributo que será injetado pelo Spring
    @Autowired
    public UserQueries(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // allUsers: método que permite buscar todos os usuários
    // Iterable<User>: tipo de retorno do método
    // allUsers: nome do método
    public Iterable<User> allUsers() {
        // userRepository.findAll(): método que permite buscar todos os usuários
        return userRepository.findAll();
    }

    // findByEmail: método que permite buscar um usuário a partir do email
    // User: tipo de retorno do método
    // findByEmail: nome do método
    // String email: parâmetro do método
    public User findByEmail(String email) {
        // userRepository.findUserByEmail(email): método que permite buscar um usuário a
        return userRepository.findUserByEmail(email);
    }

    // findById: método que permite buscar um usuário a partir do id
    // User: tipo de retorno do método
    // findById: nome do método
    // String id: parâmetro do método
    public User findById(String id) {
        // userRepository.findById(id).get(): método que permite buscar um usuário a
        return userRepository.findById(id).get();
    }
}
