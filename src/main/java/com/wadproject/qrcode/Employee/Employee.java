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
    
    private String organisation_id;

    @Indexed(unique = true)
    private String email;
    private List<String> logs;
    private LocalDate lastMarkedAt;

    public Employee(){}

    public Employee(String email,String organisation_id){
        this.organisation_id = organisation_id;
        this.email = email;
        this.logs = new ArrayList<>();
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
        return this.organisation_id;
    }

    public List<String> getLogs(){
        return this.logs;
    }


    //Setters
    public void setEmail(String email){
        this.email = email;
    }

    public void setOrganisationId(String org_id){
        this.organisation_id = org_id;
    }

    public void setLogs(List<String> logs){
        this.logs = logs;
    }


    public void markAttendance(){
        if(this.lastMarkedAt == LocalDate.now()){
            return;
        }else{
            String log = "EmployeeID: "+this.id+" Employee Email: "+this.email+" Marked at: "+ LocalDateTime.now().toString();
            this.logs.add(log);
            this.lastMarkedAt = LocalDate.now();
        }
        
    }
    
}
