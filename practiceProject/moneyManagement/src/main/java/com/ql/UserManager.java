package com.ql;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;
import java.lang.RuntimeException;

public class UserManager {

       public static ArrayList<User> users=new ArrayList<>();
       private  User u1;

       UserManager(String name,Double balance){
           u1=new User(name,balance);
           users.add(u1);
       }

       UserManager(int id){
            for(User usr:users){
                if(usr.id==id){
                    u1=usr;
                    break;
                }
            }

       }

       public int getUserId(){
             return u1.getUserId();
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
