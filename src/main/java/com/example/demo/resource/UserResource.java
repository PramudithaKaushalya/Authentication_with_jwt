package com.example.demo.resource;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.User;
import com.example.demo.model.UserFavorite;
import com.example.demo.repository.UserFavoriteRepository;
import com.example.demo.repository.UserRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserFavoriteRepository userFavoriteRepository;

    @GetMapping("/all")
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @PostMapping(value = "/signup")
    public void signup(@RequestBody User user) {
        userRepository.save(user);
    }

    @PostMapping(value = "/signin")
    public Integer signin(@RequestBody User user ) {
        String name= user.name;
        String password= user.password;
        User userData= userRepository.findByName(name);
        String pwd = userData.password;
        Integer id = userData.getUser_id();
        System.out.println("User ID"+id);
        System.out.println("User Password"+password);
        System.out.println("User db passsword"+pwd);
        if(password.equals(pwd)){
            return id;
        } else{
            return 0;
        }
    }

    @PostMapping(value = "/login")
    public User login(@RequestBody User user ) {
        String name= user.name;
        return userRepository.findByName(name);
    }

    @GetMapping("/delete/{id}")
    public String DeleteById(@PathVariable("id") User id) {
        Integer uid = id.getUser_id();
        UserFavorite userFavorite = userFavoriteRepository.findByUser(id);
        Integer userfavid = userFavorite.getId();
        userFavoriteRepository.deleteById(userfavid);
        userRepository.deleteById(uid);
        return "User Delete Successfully!!!";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    public void updateUser(@RequestBody User user, @PathVariable("id") Integer id) {
        User userToUpdate = userRepository.getOne(id);
        userToUpdate.setName(user.name);
        userToUpdate.setEmail(user.email);
        userToUpdate.setContact(user.contact);
        userToUpdate.setSalary(user.salary);
        userToUpdate.setPassword(user.password);
        userRepository.save(userToUpdate);
        System.out.println(user.name);
    }

    @GetMapping("/search/{id}")
    public Optional<User> getOne(@PathVariable("id") Integer id) {
        return userRepository.findById(id);
    }

    @GetMapping("/{name}")
    public User getUser(@PathVariable("name") String name) {
        return userRepository.findByName(name);
    }

    @PostMapping(value = "/change")
    public Boolean change(@RequestBody User user) {
        Integer id = user.getUser_id();
        String password = user.password;
        String new_password = user.salary;

        User data = userRepository.getOne(id);
        String pwd = data.getPassword();

        if(password.equals(pwd)){
            data.setPassword(new_password);
            userRepository.save(data);
            return true;
        } else{
            return false;
        }
    }

    @GetMapping("/change/{id}")
    public Optional<User> changePassword(@PathVariable("id") Integer id) {
        return userRepository.findById(id);
        
    }

    @PostMapping(value = "/changepassword")
    public Boolean changeNew(@RequestBody User user) {
        Integer id = user.getUser_id();
        String password = user.password;

        User data = userRepository.getOne(id);

        data.setPassword(password);
        userRepository.save(data);
        return true;
        
    }
}