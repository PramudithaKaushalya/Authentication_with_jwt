package com.example.demo.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User{

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "name")
	public String name;
	@Column(name = "salary")
	public String salary;
    @Column(name = "password")
	public String password;
	@Column(name = "image")
    public Blob image;

    public User() {

    }

    public User(Integer id, String name, String salary, String password, Blob image) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.password = password;
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
    public Blob getImage(){
        return image;
    }
    public void setImage(Blob image){
        this.image = image;
    }    
}
