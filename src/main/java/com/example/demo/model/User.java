package com.example.demo.model;

import java.sql.Blob;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "user_id")
	private Integer user_id;
    @Column(name = "name")
    public String name;
    @Column(name = "email")
	public String email;
	@Column(name = "salary")
	public String salary;
    @Column(name = "password")
    public String password;
    @Column(name = "contact")
	public String contact;
	@Column(name = "image")
    public Blob image;

    @JsonIgnore
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<UserFavorite> userFavorites ;
    

    public User() {

    }

    public User( String name, String email, String salary, String password, String contact, Blob image) {
        this.name = name;
        this.email = email; 
        this.salary = salary;
        this.password = password;
        this.contact = contact;
        this.image = image;
	}
	
    public Integer getUser_id() {
        return user_id;
    }
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getSalary(){
        return salary;
    }
    public void setSalary(String salary){
        this.salary=salary;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getContact(){
        return contact;
    }
    public void setContact(String contact){
        this.contact=contact;
    }
    public Blob getImage(){
        return image;
    }
    public void setImage(Blob image){
        this.image = image;
    }
    public List<UserFavorite> getUserFavorites(){
        return userFavorites;
    }
    public void setUserFavorites(List<UserFavorite> userFavorites){
        this.userFavorites=userFavorites;
    }
    public void addUserFavorite(UserFavorite userFavorite){
        this.userFavorites.add(userFavorite);
    }    
}
