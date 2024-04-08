package com.myimplementation.splitwise.repository;

import com.myimplementation.splitwise.models.Expense;
import com.myimplementation.splitwise.models.GroupExpense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupExpenseRepository extends JpaRepository<GroupExpense,Integer> {
    List<GroupExpense> findAllById(int groupId);
}
