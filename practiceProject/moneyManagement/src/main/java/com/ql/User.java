package com.ql;

import java.util.ArrayList;
import java.util.Optional;

public class User {

       public static int gid=1;
       public int id;
       private String name;
       private double balance;
       ArrayList<Double> creditList;
       ArrayList<Double> debitList;

          User(String name,double balance){
              this.id=gid++;
              this.name=name;
              this.balance=balance;
              creditList=new ArrayList<>();
              debitList=new ArrayList<>();
          }

          public int getUserId(){
                return id;
          }

          public Double getBalance(){
                return balance;
          }

          public void creditAmount(double amount){
                creditList.add(amount);
                balance=balance+amount;
                System.out.println("amount credit successfully");
          }

          public void debitAmount(double amount){
                debitList.add(amount);
                balance=balance-amount;
                System.out.println("amount debit successfully");
          }

          public void accountStatistics(){
                 Double totalCreditAmount= creditList.stream().reduce( 0.0,(p, c)->p+c);
                 Double totalDebitAmount= debitList.stream().reduce(0.0,(p,c)->p+c);
                 System.out.println( "total balance: " + balance + " && " + "credit amount: "+totalCreditAmount+" && "+"debit amount: "+totalDebitAmount);
          }

}
