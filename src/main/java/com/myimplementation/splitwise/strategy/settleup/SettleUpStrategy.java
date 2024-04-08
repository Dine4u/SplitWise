package com.myimplementation.splitwise.strategy.settleup;

import com.myimplementation.splitwise.models.Transaction;
import com.myimplementation.splitwise.models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SettleUpStrategy {
    List<Transaction> settleUp(HashMap<User,Double> condensedAmountOfUsers);
}
