package com.simple.simple_batchapi_maven;

public class User {

    private int id;
    private String email;
    private String name;

    public User(){

    }

    public User(int id, String email, String name){
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "toString : {" + "id = '" + id + "', email = '" + email + "', name = '" + name + '}';
    }
    
}
