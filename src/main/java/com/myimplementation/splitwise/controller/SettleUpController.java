package com.myimplementation.splitwise.controller;

import com.myimplementation.splitwise.dtos.Response;
import com.myimplementation.splitwise.dtos.SettleUpRequestDTO;
import com.myimplementation.splitwise.dtos.SettleUpResponseDTO;
import com.myimplementation.splitwise.exceptions.InvalidUserInputException;
import com.myimplementation.splitwise.models.Transaction;
import com.myimplementation.splitwise.service.SettleUpService;

import java.util.List;

public class SettleUpController {

    private SettleUpService settleUpService;
    private SettleUpResponseDTO settleUpGroup(SettleUpRequestDTO settleUpRequestDTO){
        SettleUpResponseDTO settleUpResponseDTO =new SettleUpResponseDTO();
        try {
            if(settleUpRequestDTO.getGroupId()<=0){
                throw new InvalidUserInputException("Invalid Group id");
            }

            List<Transaction> transactions = settleUpService.settleUp(settleUpRequestDTO.getGroupId());
            settleUpResponseDTO.setResponse(Response.getSuccessResponse());
            settleUpResponseDTO.setTransactions(transactions);

        } catch (Exception e){
            settleUpResponseDTO.setResponse(Response.getFailureResponse(e.getMessage()));
        }

        return settleUpResponseDTO;
    }

    private SettleUpResponseDTO settleUpUser(SettleUpRequestDTO settleUpRequestDTO){
        /*
        Validate the user using DB
        Query the User expense table to Fetch list of expenses which user part of
        Condense all the expenses down to user and their final total
        Use strategy to actually come up with list of transactions
         */
        return  null;
    }
}
