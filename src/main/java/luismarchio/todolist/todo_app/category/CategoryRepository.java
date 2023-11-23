package luismarchio.todolist.todo_app.category;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// @Repository: anotação que indica que a classe é um repositório
// Repositório: classe que permite realizar operações no banco de dados
// CategoryRepository: nome do repositório
@Repository
public interface CategoryRepository extends CrudRepository<Category, String> {
  // findAllCategoriesByUserId: método que permite buscar todas as categorias de
  // um
  // usuário
  // Iterable<Category>: tipo de retorno do método
  // findAllCategoriesByUserId: nome do método
  // String userId: parâmetro do método
  Iterable<Category> findAllCategoriesByUserId(String userId);

}
