package com.wadproject.qrcode.Organisation;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Organisation")
public class Organisation {

    @Id
    private String id;
    private String email;
    private String password;
    private String[] logs;
    private String[] employeeIDs; 

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

    public String[] getLogs(){
        return this.logs;
    }

    public String[] getEmployeeIDs(){
        return this.employeeIDs;
    }

    //Setters
    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String pass){
        this.password = pass;
    }

    public void setEmployeeIDs(String[] emp_ids){
        this.employeeIDs = emp_ids;
    }

    public void setLogs(String[] logs){
        this.logs = logs;
    }
    
}
