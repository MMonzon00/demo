package lp3.backend.controllers;

import lp3.backend.domain.*;
import lp3.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static lp3.backend.constants.ApiPaths.USER;

@RequestMapping(path = USER)
@RestController
public class UserController {
    private final UserService UserService;
    @Autowired
    public UserController(UserService UserService) {
        this.UserService = UserService;
    }
    @PostMapping
    public void addUser(@RequestBody User user){
        UserService.addUser(user);
    }

    @PostMapping(path = "/admin")
    public void addUser(@RequestBody Administrator user){
        UserService.addAdmin(user);
    }

    @PostMapping(path = "/auditor")
    public void addUser(@RequestBody Auditor auditor){
        UserService.addAuditor(auditor);
    }

    @PostMapping(path = "/carrier")
    public void addUser(@RequestBody Carrier carrier){
        UserService.addCarrier(carrier);
    }

    @PostMapping(path = "/fowardagent")
    public void addUser(@RequestBody FowardAgent fowardAgent){
        UserService.addFowardAgent(fowardAgent);
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

