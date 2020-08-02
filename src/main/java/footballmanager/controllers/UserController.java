package footballmanager.controllers;

import footballmanager.dto.Team;
import footballmanager.dto.User;
import footballmanager.models.TeamEntity;
import footballmanager.models.UserEntity;
import footballmanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Iterator;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return new User(userService.findById(id));
    }

    @PostMapping("/create")
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userService.create(user);
    }

    @PutMapping("/{id}")
    public UserEntity update(@RequestBody UserEntity userEntity, @PathVariable("id") Long id) {
        return userService.update(id, userEntity);
    }

    @GetMapping
    public Iterable<User> getUsers() {
        Iterable<UserEntity> userEntities = userService.getAll();
        Iterator<UserEntity> iterator = userEntities.iterator();
        HashSet<User> users = new HashSet<>();
        while (iterator.hasNext()) {
            users.add(new User(iterator.next()));
        }
        return users;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }
}
