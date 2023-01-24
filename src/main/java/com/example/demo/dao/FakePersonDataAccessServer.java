package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import java.util.List;

@Repository("fakeDao")
public class FakePersonDataAccessServer implements PersonDao{

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person user){
        DB.add(new Person(id, user.getName()));
        return 0;
    }

    @Override
    public List<Person> selectAllPeople() {return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> userMaybe = selectPersonById(id);
        if (userMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(userMaybe.get());
        return 1;
    }


    @Override
    public int updatePersonById(UUID id, Person update) {
        return selectPersonById(id)
                .map(user -> {
                    int indexOfPersonToUpdate = DB.indexOf(user);
                    if (indexOfPersonToUpdate >= 0){
                        DB.set(indexOfPersonToUpdate, new Person(id, update.getName()));
                        return 1;
                    }
                    return 0;
                } )
                .orElse(0);
    }
}
