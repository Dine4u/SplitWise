package com.myimplementation.splitwise.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "transactions")
public class Transaction extends BaseModel{

    @ManyToOne
    private User payer;
    @ManyToOne
    private User receiver;
    private double amount;
}
