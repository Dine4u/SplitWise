package com.myimplementation.splitwise.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "group_expenses")
public class GroupExpense extends BaseModel{

    @ManyToOne
    private Group group;
    @ManyToOne
    private Expense expense;

}
