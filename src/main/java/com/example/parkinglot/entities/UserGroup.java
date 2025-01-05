package com.example.parkinglot.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class UserGroup {
    private Long id;

    private String username;

    private String userGroup;

    @Id
    @GeneratedValue
    public long getId(){return id;}

    public void setId(Long id){this.id=id;}

    public String getUsername(){return username;}

    public void setUsername(String username){this.username=username;}

    public String getUserGroup(){return userGroup;}
    public void setUserGroup(String userGroup){this.userGroup=userGroup;}
}
