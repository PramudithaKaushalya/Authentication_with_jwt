package com.example.demo.model;

import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User{

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "favorite_id", referencedColumnName = "id")
    private Favorite favorite;

    public User() {

    }

    public User(Integer id, String name, String email, String salary, String password, String contact, Blob image) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.password = password;
        this.contact = contact;
        this.image = image;
	}
	
	
	public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id=id;
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
}
