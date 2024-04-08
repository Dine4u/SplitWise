package com.myimplementation.splitwise.service;

import com.myimplementation.splitwise.exceptions.InvalidInputException;
import com.myimplementation.splitwise.models.*;
import com.myimplementation.splitwise.repository.GroupExpenseRepository;
import com.myimplementation.splitwise.repository.GroupRepository;
import com.myimplementation.splitwise.strategy.settleup.SettleUpStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class SettleUpServiceImpl implements SettleUpService{

    GroupRepository groupRepository;
    GroupExpenseRepository groupExpenseRepository;

    SettleUpStrategy settleUpStrategy;
    @Override
    public List<Transaction> settleUp(int groupId) throws InvalidInputException {

        //validate the gorup present in DB or not
        Group group = groupRepository.findById(groupId).orElseThrow(() -> new InvalidInputException("Requested group doesn't exists in DB"));

        //Fetch list of expenses from group expense table using group id
        List<GroupExpense> groupExpenses = groupExpenseRepository.findAllById(groupId);

        List<Expense> expenses=groupExpenses.stream().map(groupExpense -> groupExpense.getExpense()).toList();

        //Condense all the expenses down to user and their final total
        HashMap<User,Double> condensedAmountOfUsers=new HashMap<>();

        for(Expense expense:expenses){
            for(UserExpense userExpense: expense.getUserExpenses()){
                condensedAmountOfUsers.put(userExpense.getUser(),condensedAmountOfUsers.getOrDefault(userExpense.getUser(),0D) + (userExpense.getAmount() * (userExpense.getExpenseType().equals(ExpenseType.PAID) ? 1 : -1))); //added one terinary operation to put the values with positive and negative signs
            }
        }

        return settleUpStrategy.settleUp(condensedAmountOfUsers);
    }
}
