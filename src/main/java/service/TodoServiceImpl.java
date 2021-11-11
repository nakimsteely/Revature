package service;
import model.Todo;
import model.User;
import model.TodoFilter;

import java.util.List;

//import repository.
public class TodoServiceImpl implements TodoService{
    private final TodoRepository todoRepository;
    private User user;

    public TodoServiceImpl(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }
    @Override
    public void setUser(User user){
        this.user = user;
    }
    @Override
    public void addTodo(String position){
        Todo newTodo = new Todo(position);
        newTodo.setUser(user);
        todoRepository.save(newTodo);
    }

    @Override
    public void editTodo(String name, String newPosition) {
        todoRepository.update(name, newPosition);
    }
    @Override
    public void deleteTodo(String name){
        todoRepository.delete(name);
    }
    @Override
    public void completeTodo(String name){
        todoRepository.update(name);
    }
    @Override
    public void viewItems(int items){
        todoRepository.update(items);
    }

    @Override
    public void buyItems(int items) {
        todoRepository.update(items);
    }
    @Override
    public void accept(int items){

        todoRepository.addTodo(items);
    }


    @Override
    public void login(String name, String email, String password) {
        todoRepository.update(name,email,password);
    }
    @Override
    public void storeItems(int items){
        todoRepository.save(items);
    }
    @Override
    public void completed(){
        todoRepository.save(user);
    }
    @Override
    public void clear(){
        clearCompleted();
    }
    @Override
    public List<Todo> getTodos(TodoFilter todoFilter){
        return todoRepository.findAll(todoFilter, user.getPosition());
    }
}
