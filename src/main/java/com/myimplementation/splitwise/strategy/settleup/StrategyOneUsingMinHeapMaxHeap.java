package com.myimplementation.splitwise.strategy.settleup;

import com.myimplementation.splitwise.models.Transaction;
import com.myimplementation.splitwise.models.User;
import org.springframework.data.util.Pair;

import java.util.*;

public class StrategyOneUsingMinHeapMaxHeap implements SettleUpStrategy{
    @Override
    public List<Transaction> settleUp(HashMap<User, Double> condensedAmountOfUsers) {
        PriorityQueue<Pair<User,Double>> payers=new PriorityQueue<>((p1,p2)->{
            return (int) (p1.getSecond()- p2.getSecond());
        });

        PriorityQueue<Pair<User,Double>> receivers=new PriorityQueue<>((p1,p2)->{
            return (int) (p2.getSecond()- p1.getSecond());
        });

        for(Map.Entry<User, Double> entry: condensedAmountOfUsers.entrySet()){
            User user= entry.getKey();
            Double amount= entry.getValue();

            if(amount>0){
                receivers.add(Pair.of(user,amount));
            } else {
                payers.add(Pair.of(user,amount));
            }
        }

        List<Transaction> transactions=new ArrayList<>();

        while(!payers.isEmpty() && !receivers.isEmpty()){

            Pair<User, Double> maxPayer=payers.poll();
            Pair<User, Double> maxReceiver=receivers.poll();

            User payer=maxPayer.getFirst();
            User receiver= maxReceiver.getFirst();

            Transaction transaction=new Transaction();

            transaction.setPayer(payer);
            transaction.setReceiver(receiver);

            Double transactionAmount= maxReceiver.getSecond()+maxPayer.getSecond();

            if(transactionAmount>0){
                transaction.setAmount(Math.abs(maxPayer.getSecond()));
                receivers.add(Pair.of(receiver,transactionAmount));
            } else if(transactionAmount<0){
                transaction.setAmount(maxReceiver.getSecond());
                payers.add(Pair.of(payer,transactionAmount));
            } else {
                transaction.setAmount(transactionAmount);
            }

            transactions.add(transaction);
        }

        return transactions;
    }
}
