package com.example.demo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.example.demo.model.Favorite;
import com.example.demo.model.User;
import com.example.demo.model.UserFavorite;
import com.example.demo.repository.UserFavoriteRepository;
import com.example.demo.repository.UserRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/")
public class UserFavoriteResource {

    @Autowired
    private UserFavoriteRepository userFavoriteRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/favorite/{id}")
    public Favorite getFavorite(@PathVariable("id") User id) {
        UserFavorite userFavorite = userFavoriteRepository.findByUser(id);
        return userFavorite.getFavorite();
    }

    @GetMapping("/favorites/{id}")
    public List<Favorite> getFavorites(@PathVariable("id") Integer id) {

        User user = userRepository.getOne(id);
        List<UserFavorite> userFavorite = user.getUserFavorites();
        
        List<Favorite> data = new ArrayList<>();

        for (UserFavorite var : userFavorite) {
            Favorite fav = var.getFavorite();
            data.add(fav);
            System.out.println("xxxxxxxxxxxxxxx"+var);
        }
        System.out.println("yyyyyyyyyyyy"+data);
        return data;
    }

    @GetMapping("/detail/{id}")
    public User getFavorite(@PathVariable("id") Favorite id) {
        UserFavorite userFavorite = userFavoriteRepository.findByFavorite(id);
        return userFavorite.getUser();
    }
}