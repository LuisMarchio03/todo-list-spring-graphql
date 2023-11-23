package romani.todolist.todo_app.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import romani.todolist.todo_app.entities.Category;
import romani.todolist.todo_app.repositories.CategoryRepository;

@Service
public class CategoryQueries implements GraphQLQueryResolver {
  // Injeção de dependência: mecanismo que permite que uma classe receba
  private CategoryRepository categoryRepository;

  @Autowired
  public CategoryQueries(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  // allCategories: método que permite buscar todas as categorias
  // Iterable<Category>: tipo de retorno do método
  // allCategories: nome do método
  public Iterable<Category> allCategories() {
    // categoryRepository.findAll(): método que permite buscar todas as categorias
    return categoryRepository.findAll();
  }

  // findById: método que permite buscar uma categoria a partir do id
  // Category: tipo de retorno do método
  // findById: nome do método
  // String id: parâmetro do método
  public Category findCategoryById(String id) {
    // categoryRepository.findById(id).get(): método que permite buscar uma
    // categoria a
    return categoryRepository.findById(id).get();
  }

}
