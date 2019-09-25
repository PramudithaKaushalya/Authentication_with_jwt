package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Favorite;
import com.example.demo.model.User;
import com.example.demo.model.UserFavorite;;

public interface UserFavoriteRepository extends JpaRepository<UserFavorite, Integer>{

	UserFavorite findByUser(User id);

	UserFavorite findByFavorite(Favorite id);
}