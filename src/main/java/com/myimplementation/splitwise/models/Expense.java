package com.myimplementation.splitwise.models;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity(name = "expenses")
public class Expense extends BaseModel{
    private double amount;
    private Date addedAt;   //tells when this expense added to group
    private String description;     //tells expense description
    private String proofUrl;        //expense proof attachment like bill image,etc


    @Enumerated(value = EnumType.ORDINAL)
    private Currency currency;

    @OneToMany(mappedBy = "expense")
    private List<UserExpense> userExpenses;         //every userexpense in userexpenses table have expense id as FK
}
