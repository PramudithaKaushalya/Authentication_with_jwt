package com.example.demo.resource;

import java.util.List;
import java.util.Optional;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.bytebuddy.asm.Advice.Exit;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @PostMapping(value = "/signup")
    public void signup(@RequestBody User user) {
        userRepository.save(user);
    }

    @PostMapping(value = "/signin")
    public String signin(@RequestBody User user ) {
        String name= user.name;
        String password= user.password;
        User userData= userRepository.findByName(name);
        String pwd = userData.password;
        if(password.equals(pwd)){
            return "true";
        }
        else{
            return "false";
        } 
    }

    @GetMapping("/delete/{id}")
    public String DeleteById(@PathVariable("id") Integer id) {
        userRepository.deleteById(id);
        return "User delete successfully!!!";
        
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    public void updateUser(@RequestBody User user, @PathVariable("id") Integer id) {
        User userToUpdate = userRepository.getOne(id);
        userToUpdate.setName(user.name);
        userToUpdate.setSalary(user.salary);
        userToUpdate.setPassword(user.password);
        userRepository.save(userToUpdate);
        System.out.println(user.name);
    }

    @GetMapping("/search/{id}")
    public Optional<User> getOne(@PathVariable("id") Integer id) {
        System.out.println(id);
        return userRepository.findById(id);
    }
}