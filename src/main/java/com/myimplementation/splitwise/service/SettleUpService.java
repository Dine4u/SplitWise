package com.myimplementation.splitwise.service;

import com.myimplementation.splitwise.exceptions.InvalidInputException;
import com.myimplementation.splitwise.models.Transaction;

import java.util.List;

public interface SettleUpService {
    List<Transaction> settleUp(int groupId) throws InvalidInputException;
}
