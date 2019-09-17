package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "favorites")
public class Favorite{

    @Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    
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

    @OneToOne(mappedBy = "favorite")
    private User user;
    
    public Favorite() {

    }

    public Favorite(Integer id, String user_name, String food, String drink, String animal, String bird, String hobby, String place) {
        this.id = id;
        this.user_name = user_name;
        this.food = food;
        this.drink = drink;
        this.animal = animal;
        this.bird = bird;
        this.hobby = hobby;
        this.place = place;
	}
	
	
	public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id=id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }    
}
