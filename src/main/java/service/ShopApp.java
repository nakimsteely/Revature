package service;
import exceptions.UserNotFoundException;
import exceptions.InvalidCredentialException;
import repository.UserRepository;
import repository.TodoRepository;
import repository.JdbcTodoRepository;
import repository.JdbcUserRepository;
import model.Todo;
import model.User;
import model.TodoFilter;
import service.TodoService;
import service.UserService;
import service.UserServiceImpl;
import service.TodoServiceImpl;
import java.util.Scanner;

public class ShopApp {
    Scanner scanner = new Scanner(System.in);

    //Init
    static User currentUser = null;
    static TodoRepository todoRepository = new JdbcTodoRepository(); // dependecy in maven
    static TodoService todoService = new TodoServiceImpl(todoRepository); //dependent

    static UserRepository userRepository = new JdbcUserRepository();
    static UserService userService = new UserServiceImpl(userRepository);

     public static void main(String[] args) {
        while (true){
            System.out.println("Select choice from menu!");
            System.out.println("New Users must register to view or purchase items");
            Sysytem.out.println("" + "\n\n" + "1-Login\n"
                    +"2-Register\n" +
                    "3-Update\n" +
                    "4-Delete\n" +
                    "5-Add \n" +
                    "6-View Items\n" +
                    "7-Logout\n" + "");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    handleChoice1();
                    break;
                }
                case 2: {
                    handleChoice2();
                    break;
                }
                case 3: {
                    handleChoice3();
                    break;
                }
            }
                case 4: {
                    handleChoice4();
                    break;
                }
            case 5: {
                handleChoice5();
                break;
            }
            case 6: {
                handleChoice6();
                break;
            }
            case 7:{
                currentUser = null;
                todoService.setUser(null);
                break;
            }
        }
        private static void handleChoice1(){
            scanner.nextLine();
            System.out.println("Enter email");
            String email = scanner.nextLine();
            System.out.println("Enter Password");
            String password = scanner.nextLine();
            try {
                currentUser = userService.login(email, password);
                todoService.setUser(currentUser);
                System.out.println("Login successful");

            }catch (UserNotFoundException | InvalidCredentialException e){
                System.out.println("exception: " + e.getMessage());
            }
         }
        private static void handleChoice2(){
            scanner.nextLine();
            System.out.println("Email: ");
            String email = scanner.nextLine();
            System.out.println("Password:");
            String password = scanner.nextLine();
            System.out.println("Name:");
            String name = scanner.nextLine();

            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            user.setName(name);
            userService.register(user);

         }
        private static void handleChoice3(){
            System.out.println("Enter todo new-position");
            scanner.nextLine();
            String position = scanner.nextLine();
            System.out.println("Enter your name");
            String name = scanner.nextLine();
            todoService.editTodo(name, position);
        }
        private static void handleChoice4(){
            System.out.println("Enter name");
            String name = scanner.nextLine();
            todoService.deleteTodo(name);

         }

        private static void handleChoice5(){
            System.out.println("Enter name");
            scanner.nextLine();
            String position = scanner.nextLine();
            todoService.addTodo(position);
         }
        private static void handleChoice6(){
            todoService.getTodos(TodoFilter.ALL).forEach(System.out::println);
         }

    }
}
