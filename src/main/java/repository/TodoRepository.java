package repository;
import  model.Todo;
import model.TodoFilter;
import java.util.List;

public interface TodoRepository {
    void save(Todo todo);
    void update( String name, String newPosition);
    void update(String name, boolean completed);
    void delete (String name);
    List<Todo> findAll(TodoFilter todoFilter, String position);
}
