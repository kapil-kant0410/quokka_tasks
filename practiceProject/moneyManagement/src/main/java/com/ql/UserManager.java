package com.ql;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class UserManager {

       private ArrayList<User> users=new ArrayList<>();
       private User u1;

       UserManager(int id){
          u1= users.stream().map((user)->user.id==id);
       }

       public void addUser(String name,Double balance){
               u1=new User(name,balance);
               users.add(u1);
       }

       public void showAllUsers(){
            users.stream().forEach(System.out::println);
       }

        public Double getBalance(){
           return u1.getBalance();
        }

        public void creditAmount(double amount){
           u1.creditAmount(amount);
        }

        public void debitAmount(double amount){
            u1.debitAmount(amount);
        }

        public void accountStatistics(){
            u1.accountStatistics();
        }


}
