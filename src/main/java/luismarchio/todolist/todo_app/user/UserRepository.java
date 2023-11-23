package luismarchio.todolist.todo_app.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// @Repository: anotação que indica que a classe é um repositório
// Repositório: classe que permite realizar operações no banco de dados
// UserRepository: nome do repositório
@Repository
public interface UserRepository extends CrudRepository<User, String> {

    // User: tipo de retorno do método
    // findUserByEmail: nome do método
    // String email: parâmetro do método
    // findUserByEmail: método que permite buscar um usuário a partir do email
    User findUserByEmail(String email);
}