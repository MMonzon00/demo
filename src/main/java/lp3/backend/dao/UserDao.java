package lp3.backend.dao;

import lp3.backend.domain.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDao {
    int insertUser (UUID id, User user);

    default void insertUser(User user){
        UUID id = UUID.randomUUID();
        insertUser(id, user);
    }

//    boolean isEmailTaken(User user);

    List<User> selectAllPeople();

    Optional<User> selectUserById(UUID id);
    int deleteUserById(UUID id);

    int updateUserById(UUID id, User user);
}
