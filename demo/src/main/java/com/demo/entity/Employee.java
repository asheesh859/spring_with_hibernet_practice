package com.demo.entity;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ConditionalOnIssuerLocationJwtDecoder;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name" ,nullable=false , length = 45)
    private String firstName;

    @Column(name="last_name" , nullable = false , length = 45)
    private String lastName;

    @Column(name="email_id" , nullable = false , unique = true , length = 255)
    private String emailId;

    @Column(name= "mobile_no" ,nullable = false ,length = 45 , unique = true)
    private String mobile;

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName= lastName;
    }

    public String getEmailId(){
        return emailId;
    }

    public void setEmailId(String emailId){
        this.emailId = emailId;
    }
    public String getMobile(){
        return mobile;
    }
    public void setMobile(String mobile){
        this.mobile = mobile;
    }
}
