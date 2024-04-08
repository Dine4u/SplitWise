package com.myimplementation.splitwise.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "groups")
public class Group extends BaseModel{

    private String name;
    private String description; //explains purpose of group

    @ManyToMany
    private List<User> users;
    @ManyToMany
    private List<User> admins;
}
