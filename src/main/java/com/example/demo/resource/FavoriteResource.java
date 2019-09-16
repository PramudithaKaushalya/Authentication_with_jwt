package com.example.demo.resource;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Favorite;
import com.example.demo.repository.FavoriteRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/")
public class FavoriteResource {

    @Autowired
    private FavoriteRepository favoriteRepository;

    @GetMapping("/favo")
    public List<Favorite> getAll() {
        return favoriteRepository.findAll();
    }

    @PostMapping(value = "/savefavo")
    public void signup(@RequestBody Favorite favorite) {
        favoriteRepository.save(favorite);
    }

    @GetMapping("/deletefavo/{id}")
    public String DeleteById(@PathVariable("id") Integer id) {
        favoriteRepository.deleteById(id);
        return "Favorites Delete Successfully!!!";
        
    }

    @GetMapping("/searchfavo/{id}")
    public Optional<Favorite> getOne(@PathVariable("id") Integer id) {
        System.out.println(id);
        return favoriteRepository.findById(id);
    }
}