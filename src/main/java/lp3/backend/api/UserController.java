package lp3.backend.api;

import lp3.backend.model.User;
import lp3.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/lp3/user")
@RestController
public class UserController {
    private final UserService UserService;
    @Autowired
    public UserController(UserService UserService) {
        this.UserService = UserService;
    }
    @PostMapping
    public void addUser(@RequestBody User User){
        UserService.addUser(User);
    }

    @GetMapping
    public List<User> getAllPeople(){
        return
                UserService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public User getUserById(@PathVariable("id") UUID id){
         return  UserService.getUserById(id)
                 .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUserById(@PathVariable("id") UUID id) {
        UserService.deleteUser(id);
    }

    @PutMapping(path = "{id}")
    public void updateUser(@PathVariable("id") UUID id, @RequestBody User UserToUpdate){
        UserService.updateUser(id, UserToUpdate);
    }
}

