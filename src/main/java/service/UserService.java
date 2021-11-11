package service;
import model.User;

public interface UserService {
    void register(User user);
    User login(String email, String password);
}
