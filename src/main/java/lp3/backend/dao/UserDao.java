package lp3.backend.dao;

import lp3.backend.domain.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDao {
    void insertUser (UUID id, User user);

    default void insertUser(User user){
        UUID id = UUID.randomUUID();
        insertUser(id, user);
    }

//    boolean isEmailTaken(User user);

    void insertAdmin (UUID id, Administrator administrator);

    default void insertAdmin(Administrator administrator){
        UUID id = UUID.randomUUID();
        insertAdmin(id, administrator);
    };
    void insertAuditor(UUID id, Auditor user);

    default void insertAuditor(Auditor user){
        UUID id = UUID.randomUUID();
        insertAuditor(id, user);
    };
    void insertCarrier (UUID id, Carrier user);

    default void insertCarrier(Carrier user){
        UUID id = UUID.randomUUID();
        insertCarrier(id, user);
    };

    void insertFowardAgent (UUID id, FowardAgent user);

    default void insertFowardAgent(FowardAgent user){
        UUID id = UUID.randomUUID();
        insertFowardAgent(id, user);
    };

    List<User> selectAllPeople();

    Optional<User> selectUserById(UUID id);
    void deleteUserById(UUID id);

    void updateUserById(UUID id, User user);
}
