package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite, Integer>{

}
		 