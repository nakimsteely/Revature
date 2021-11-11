package service;

import at.favre.lib.crpyto.bcrypt.Bcrypt;
import exceptions.InvalidCredentialExcepetion;
import exceptions.InvalidCredentialException;
import exceptions.UserNotFoundException;
import model.User;
import repository.UserRepository;

public class UserServiceImpl {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public void register(User user){
        @Override
                String bcryptHashString = BCrypt.withDefaults().hashToStrings(12, user.getPassword().toCharArray());
                user.setPassword(bcryptHashString);
                userRepository.save(user);
    }
    @Override
    User user = userRepository.findByEmail(email);
    if (user != null) {
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
        if (result.verified) {
            return user;
        }else{
            throw new InvalidCredentialException("incorrect user/password");
        }else{
            throw new UserNotFoundException("INVALID");
        }
    }
}
