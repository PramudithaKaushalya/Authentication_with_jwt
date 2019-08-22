package com.example.demo;

public class Topic {

    private Integer id;
    private String name;
    private String salary;

    public Topic(){
        
    }
    public Topic(Integer id, String name, String salary){
        super();
        this.id = id;
        this.name = name;
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