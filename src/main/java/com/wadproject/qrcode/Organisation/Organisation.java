package com.wadproject.qrcode.Organisation;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Organisation")
public class Organisation {

    @Id
    private String id;

    @Indexed(unique = true)
    private String email;
    private String password;


    public Organisation(){}

    public Organisation(String email,String password){
        this.email = email;
        this.password = password;
    }

    //getters
    public String getId(){
        return this.id;
    }


    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }



    //Setters
    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String pass){
        this.password = pass;
    }



    
}
