package com.myimplementation.splitwise.models;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "user_expenses")
public class UserExpense extends BaseModel{

    @ManyToOne
    private User user;
    @ManyToOne
    private Expense expense;
    private double amount;
    @Enumerated(value = EnumType.STRING)
    private ExpenseType expenseType;
}
