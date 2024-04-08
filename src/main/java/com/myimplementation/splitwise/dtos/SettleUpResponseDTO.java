package com.myimplementation.splitwise.dtos;

import com.myimplementation.splitwise.models.Transaction;
import lombok.Data;

import java.util.List;


@Data
public class SettleUpResponseDTO {
    private List<Transaction> transactions;
    private Response response;

}
