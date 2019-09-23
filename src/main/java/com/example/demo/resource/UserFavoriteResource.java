package com.example.demo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Favorite;
import com.example.demo.model.User;
import com.example.demo.model.UserFavorite;
import com.example.demo.repository.UserFavoriteRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/")
public class UserFavoriteResource {

    @Autowired
    private UserFavoriteRepository userFavoriteRepository;

    // @GetMapping("/detail/{name}")
    // public User getUser(@PathVariable("name") String name) {
    //     return userFavoriteRepository.findByName(name);
    // }

    @GetMapping("/favorite/{id}")
    public Favorite getFavorite(@PathVariable("id") User id) {
        UserFavorite userFavorite = userFavoriteRepository.findByUser(id);
        return userFavorite.getFavorite();
    }

    @GetMapping("/detail/{id}")
    public User getFavorite(@PathVariable("id") Favorite id) {
        UserFavorite userFavorite = userFavoriteRepository.findByFavorite(id);
        return userFavorite.getUser();
    }
}