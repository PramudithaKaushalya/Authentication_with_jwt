package com.example.demo.resource;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import com.example.demo.mapper.UserMapper;
//import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
//import com.example.demo.service.UserService;

// @Slf4j
//@RequiredArgsConstructor

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/")
public class UserResource {

    // private final UserService userService;
    // private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    // @GetMapping("/a")
    // public List<UserDTO> findAll() {
    //     return userMapper.toUserDTOs(userService.findAll());
    // }

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
        if(password.equals(pwd)){
            return id;
        } else{
            return 0;
        }
    }

    @GetMapping("/delete/{id}")
    public String DeleteById(@PathVariable("id") Integer id) {
        userRepository.deleteById(id);
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
}