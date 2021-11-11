package service;
import model.User;
import model.Todo;
import model.TodoFilter;
import java.util.List;

public interface TodoService {
    void setUser(User user);
    void addTodo(String position);
    void editTodo(String name, String position);
    void deleteTodo(String position);
    void completeTodo(String name);



    void completeAll();
    void clearCompleted();
    List<Todo> getTodos(Todofilter todofilter);
}
