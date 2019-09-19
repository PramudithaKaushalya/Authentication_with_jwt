package com.example.demo.model;

import java.util.Set;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "favorites")
public class Favorite{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "favorite_id")
    private Integer favorite_id;
    @Column(name = "user_name")
    public String user_name;
    @Column(name = "food")
	public String food;
	@Column(name = "drink")
	public String drink;
    @Column(name = "animal")
	public String animal;
    @Column(name = "bird")
	public String bird;
    @Column(name = "hobby")
	public String hobby;
    @Column(name = "place")
    public String place;
    
    @JsonIgnore
    @OneToMany(mappedBy = "favorite",fetch = FetchType.LAZY)
    private Set<UserFavorite> userFavorites ;

    public Favorite() {

    }

    public Favorite(String user_name, String food, String drink, String animal, String bird, String hobby, String place) {
        this.user_name = user_name;
        this.food = food;
        this.drink = drink;
        this.animal = animal;
        this.bird = bird;
        this.hobby = hobby;
        this.place = place;
	}
	
	
    public Integer getFavorite_id() {
        return favorite_id;
    }
    public void setFavorite_id(Integer favorite_id) {
        this.favorite_id = favorite_id;
    }
    public String getUser_name(){
        return user_name;
    }
    public void setUser_name(String user_name){
        this.user_name=user_name;
    }
    public String getFood(){
        return food;
    }
    public void setFood(String food){
        this.food=food;
    }
    public String getDrink(){
        return drink;
    }
    public void setDrink(String drink){
        this.drink=drink;
    }
    public String getAnimal(){
        return animal;
    }
    public void setAnimal(String animal){
        this.animal=animal;
    }
    public String getBird(){
        return bird;
    }
    public void setBird(String bird){
        this.bird=bird;
    }
    public String getHobby(){
        return hobby;
    }
    public void setHobby(String hobby){
        this.hobby=hobby;
    }
    public String getPlace(){
        return place;
    }
    public void setPlace(String place){
        this.place= place;
    }
    public Set<UserFavorite> getUserFavorites(){
        return userFavorites;
    }
    public void setUserFavorites(Set<UserFavorite> userFavorites) {
        this.userFavorites = userFavorites;
    }
    public void addUserFavorite(UserFavorite userFavorite){
        this.userFavorites.add(userFavorite);
    }

}
