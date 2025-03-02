package com.ql;

import java.util.ArrayList;
import java.util.Optional;

public class User {

       public static int gid=1;
       public int id;
       private String name;
       private double balance;
       static  int maxOneDayLimit;
       private int remainingMaxOneDayLimit;
       ArrayList<Double> creditList;
       ArrayList<Double> debitList;

          User(String name,double balance,int maxOneDayLimit){
              this.id=gid++;
              this.name=name;
              this.balance=balance;
              this.remainingMaxOneDayLimit=maxOneDayLimit;
              this.maxOneDayLimit=maxOneDayLimit;
              creditList=new ArrayList<>();
              debitList=new ArrayList<>();
          }

          public  boolean checkTodayRemainingAmount(double amount){
              if(remainingMaxOneDayLimit>=0&&(remainingMaxOneDayLimit-amount)>=0&&(balance-amount)>=0) return true;
               return false;
          }

          public int remainingAmountToSpent(){
                return remainingMaxOneDayLimit;
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
                remainingMaxOneDayLimit-=amount;
                System.out.println("amount debit successfully");
          }

          public void accountStatistics(){
                 Double totalCreditAmount= creditList.stream().reduce( 0.0,(p, c)->p+c);
                 Double totalDebitAmount= debitList.stream().reduce(0.0,(p,c)->p+c);
                 System.out.println( "total balance: " + balance + " && " + "credit amount: "+totalCreditAmount+" && "+"debit amount: "+totalDebitAmount);
          }

}
