package lp3.backend.service;

import lp3.backend.dao.UserDao;
import lp3.backend.domain.*;
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

    //Instance of where we will store all data
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

        UserDao.insertUser(user);
    }

    public void addAdmin(Administrator administrator){
        if (!emailValidation.test(administrator.getEmail())) {
            throw new ApiRequestException(administrator.getEmail() + " is not valid");
        }

        UserDao.insertAdmin(administrator);
    }

    public void addAuditor(Auditor user){
        if (!emailValidation.test(user.getEmail())) {
            throw new ApiRequestException(user.getEmail() + " is not valid");
        }

        UserDao.insertAuditor(user);
    }

    public void addCarrier(Carrier user){
        if (!emailValidation.test(user.getEmail())) {
            throw new ApiRequestException(user.getEmail() + " is not valid");
        }

        UserDao.insertCarrier(user);
    }

    public void addFowardAgent(FowardAgent user){
        if (!emailValidation.test(user.getEmail())) {
            throw new ApiRequestException(user.getEmail() + " is not valid");
        }

        UserDao.insertFowardAgent(user);
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

