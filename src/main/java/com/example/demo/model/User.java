package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User  implements Serializable{

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
//	@Column(name = "id")
//	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "salary")
	private String salary;
	
	public User() {
		
	}
	
public User(Integer id, String name, String salary) {
		this.id = id;
		this.name= name;
		this.salary = salary;
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
}
