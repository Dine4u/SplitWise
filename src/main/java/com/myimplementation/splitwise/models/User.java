package com.myimplementation.splitwise.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "users")
public class User extends BaseModel{
    private String name;
    private String password;
    private long phone;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phone=" + phone +
                '}';
    }
}
