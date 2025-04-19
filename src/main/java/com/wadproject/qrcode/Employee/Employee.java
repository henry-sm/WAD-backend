package com.wadproject.qrcode.Employee;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Employee")
public class Employee {

    @Id
    private String id;
    
    private String organisationId;

    @Indexed(unique = true)
    private String email;
    private List<String> logs  = new ArrayList<>();;
    private LocalDate lastMarkedAt;

    public Employee(){}

    public Employee(String email,String organisationId){
        this.organisationId = organisationId;
        this.email = email;
        this.lastMarkedAt = null;
    }

    //getters
    public String getId(){
        return this.id;
    }

    public String getEmail(){
        return this.email;
    }


    public String getOrganisationId(){
        return this.organisationId;
    }

    public List<String> getLogs(){
        return this.logs;
    }


    //Setters
    public void setEmail(String email){
        this.email = email;
    }

    public void setOrganisationId(String org_id){
        this.organisationId = org_id;
    }

    public void setLogs(List<String> logs){
        this.logs = logs;
    }


    public void markAttendance(){
        if (LocalDate.now().equals(this.lastMarkedAt)) {
            return;
        }else{
            this.logs.add(LocalDateTime.now().toString());
            this.lastMarkedAt = LocalDate.now();
        }
        
    }
    
}
