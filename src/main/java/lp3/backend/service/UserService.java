package lp3.backend.service;

import lp3.backend.dao.UserDao;
import lp3.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserDao UserDao;
    @Autowired
    public UserService(@Qualifier("userDao") UserDao UserDao) {
        this.UserDao = UserDao;
    }

    public int addUser(User user){
        return UserDao.insertUser(user);
    }

    public List<User> getAllPeople(){
        return UserDao.selectAllPeople();
    }

    public Optional<User> getUserById(UUID id){
        return UserDao.selectUserById(id);
    }

    public int deleteUser(UUID id){
        return UserDao.deleteUserById(id);
    }

    public int updateUser(UUID id, User newUser) {
        return UserDao.updateUserById(id, newUser);
    }
}

