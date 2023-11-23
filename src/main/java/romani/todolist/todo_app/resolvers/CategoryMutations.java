package romani.todolist.todo_app.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import romani.todolist.todo_app.entities.Category;
import romani.todolist.todo_app.repositories.CategoryRepository;

// @Service: anotação que indica que a classe é um serviço
// Serviço: classe que permite realizar operações no banco de dados
// CategoryMutations: nome do serviço
// Mutations: classe que permite realizar operações de mutação no banco de dados a partir do GraphQL
@Service
public class CategoryMutations implements GraphQLMutationResolver {

    // Injeção de dependência: mecanismo que permite que uma classe receba
    // instâncias de outras classes
    private CategoryRepository categoryRepository;

    // @Autowired: anotação que indica que o atributo será injetado pelo Spring
    // CategoryMutations: nome do construtor
    // CategoryRepository categoryRepository: parâmetro do construtor
    // this.categoryRepository = categoryRepository: atributo que será injetado pelo
    // Spring
    @Autowired
    public CategoryMutations(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // addCategory: método que permite adicionar um usuário
    // Category: tipo de retorno do método R
    // addCategory: nome do método
    // String name: primeiro parâmetro do método
    // String email: segundo parâmetro do método
    public Category addCategory(String name,
            String description,
            String color,
            String status,
            String userId) {
        // Category: Permite criar uma instância da classe Category
        Category category = new Category(name, description, color, status, userId);
        // categoryRepository.save(category): método que permite salvar um usuário no
        // banco de
        // dados
        return categoryRepository.save(category);
    }
}
