package lp3.backend.service;

import lp3.backend.dao.UserDao;
import lp3.backend.domain.User;
import lp3.backend.utilities.EmailValidation;
import lp3.backend.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserDao UserDao;
    private final EmailValidation emailValidation;
    @Autowired
    public UserService(@Qualifier("userDao") UserDao UserDao,EmailValidation emailValidation) {

        this.UserDao = UserDao;
        this.emailValidation = emailValidation;
    }

    public void addUser(User user){
        if (!emailValidation.test(user.getEmail())) {
            throw new ApiRequestException(user.getEmail() + " is not valid");
        }

//        if (UserDao.isEmailTaken(user)) {
//            throw new ApiRequestException(user.getEmail() + " is taken");
//        }

        UserDao.insertUser(user);
    }

    public List<User> getAllPeople(){
        return UserDao.selectAllPeople();
    }

    public Optional<User> getUserById(UUID id){
        return UserDao.selectUserById(id);
    }

    public void deleteUser(UUID id){
        UserDao.deleteUserById(id);
    }

    public void updateUser(UUID id, User newUser) {
        UserDao.updateUserById(id, newUser);
    }
}

