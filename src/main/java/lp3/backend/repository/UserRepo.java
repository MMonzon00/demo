package lp3.backend.repository;

import lp3.backend.dao.UserDao;
import lp3.backend.domain.*;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("userDao")
public class UserRepo implements UserDao {

    private final static List<User> userDB = new ArrayList<>();

    @Override
    public void insertUser(UUID id, User User){
        userDB.add(new User(id, User.getUsername(),User.getEmail(), User.getType(), User.getOrganization()));
    }

    @Override
    public void insertAdmin(UUID id, Administrator Administrator){
        userDB.add(new Administrator(id, Administrator.getUsername(),Administrator.getEmail(), Administrator.getType(),Administrator.getOrganization()));
    }

    @Override
    public void insertAuditor(UUID id, Auditor user){
        userDB.add(new Auditor(id, user.getUsername(),user.getEmail(), user.getType(),user.getOrganization()));
    }

    @Override
    public void insertCarrier(UUID id, Carrier user){
        userDB.add(new Carrier(id, user.getUsername(),user.getEmail(), user.getType(),user.getOrganization()));
    }

    @Override
    public void insertFowardAgent(UUID id, FowardAgent user){
        userDB.add(new FowardAgent(id, user.getUsername(),user.getEmail(), user.getType(),user.getOrganization()));
    }

//    @Override
//    public boolean isEmailTaken(User user) {
//        Optional<String> opt =Optional.of(user.getEmail());
//        assertTrue(opt.isPresent());
//
//        opt = Optional.ofNullable(null);
//        assertFalse(opt.isPresent());
//    }
    @Override
    public List<User> selectAllPeople() {
        return userDB;
    }

    @Override
    public Optional<User> selectUserById(UUID id) {
        return userDB.stream()
                .filter(User -> User.getId().equals(id))
                .findFirst();
    }

    @Override
    public void deleteUserById(UUID id) {
        Optional<User> UserMaybe = selectUserById(id);
        if (UserMaybe.isEmpty()) {
            return;
        }
        userDB.remove(UserMaybe.get());
    }


    @Override
    public void updateUserById(UUID id, User update) {
        selectUserById(id)
                .map(User -> {
                    int indexOfUserToUpdate = userDB.indexOf(User);
                    if (indexOfUserToUpdate >= 0) {
                        userDB.set(indexOfUserToUpdate, new User(id, update.getUsername(), update.getEmail(), User.getType(), update.getOrganization()));
                        return 1;
                    }
                    return 0;
                });
    }
}
