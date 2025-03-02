package com.ql;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {

         Scanner sc= new Scanner(System.in);
         System.out.println("welcome to the account expense tracker");
         System.out.println("Are u a new user or an existing user: new/existing");
         String userType=sc.nextLine();

         switch (userType){

             case "new":{
                 UserManager manager=new UserManager();
                 System.out.println("enter name of user");
                 String name=sc.nextLine();
                 System.out.println("enter initial balance what u want to deposit");
                 double balance=sc.nextDouble();
                 sc.nextLine();

                 manager.addUser(name,balance);

                 while(true){
                     System.out.println("what u want credit or debit or today's expenses statics or current balance");
                     String task=sc.nextLine();
                     switch(task){
                         case "credit":{
                             System.out.println("enter amount u want to credit");
                             double amount=sc.nextDouble();
                             sc.nextLine();
                             manager.creditAmount(amount);
                             break;
                         }
                         case "debit":{
                             System.out.println("enter amount u want to debit");
                             double amount=sc.nextDouble();
                             sc.nextLine();
                             manager.debitAmount(amount);
                             break;
                         }
                         case "current balance":{
                             System.out.println("current balance is: "+manager.getBalance());
                             break;
                         }
                         case "expenses statics":{
                             manager.accountStatistics();
                             break;
                         }
                         default:{
                             System.out.println("please enter valid field check spelling properly");
                         }
                     }

                 }


             }
             case "existing":{
                 System.out.println("enter your id to login to your account");
                 int id=sc.nextInt();

                 UserManager manager=new UserManager(id);

                 while(true){
                     System.out.println("what u want credit or debit or today's expenses statics or current balance");
                     String task=sc.nextLine();
                     switch(task){
                         case "credit":{
                             System.out.println("enter amount u want to credit");
                             double amount=sc.nextDouble();
                             sc.nextLine();
                             manager.creditAmount(amount);
                             break;
                         }
                         case "debit":{
                             System.out.println("enter amount u want to debit");
                             double amount=sc.nextDouble();
                             sc.nextLine();
                             manager.debitAmount(amount);
                             break;
                         }
                         case "current balance":{
                             System.out.println("current balance is: "+manager.getBalance());
                             break;
                         }
                         case "expenses statics":{
                             manager.accountStatistics();
                             break;
                         }
                         default:{
                             System.out.println("please enter valid field check spelling properly");
                         }
                     }

                 }


             }

         }

    }
}