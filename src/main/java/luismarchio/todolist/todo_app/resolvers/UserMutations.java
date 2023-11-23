package luismarchio.todolist.todo_app.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import luismarchio.todolist.todo_app.entities.User;
import luismarchio.todolist.todo_app.repositories.UserRepository;

// @Service: anotação que indica que a classe é um serviço
// Serviço: classe que permite realizar operações no banco de dados
// UserMutations: nome do serviço
// Mutations: classe que permite realizar operações de mutação no banco de dados a partir do GraphQL
@Service
public class UserMutations implements GraphQLMutationResolver {

    // Injeção de dependência: mecanismo que permite que uma classe receba
    // instâncias de outras classes
    private UserRepository userRepository;

    // @Autowired: anotação que indica que o atributo será injetado pelo Spring
    // UserMutations: nome do construtor
    // UserRepository userRepository: parâmetro do construtor
    // this.userRepository = userRepository: atributo que será injetado pelo Spring
    @Autowired
    public UserMutations(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // addUser: método que permite adicionar um usuário
    // User: tipo de retorno do método
    // addUser: nome do método
    // String name: primeiro parâmetro do método
    // String email: segundo parâmetro do método
    public User addUser(String name, String email) {
        // User: Permite criar uma instância da classe User
        User user = new User(name, email);
        // userRepository.save(user): método que permite salvar um usuário no banco de
        // dados
        return userRepository.save(user);
    }
}
