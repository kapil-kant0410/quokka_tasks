package com.ql;

import java.io.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

       public static boolean findUserbyId(int id){

        String filePath="C:\\Users\\Kapil Kant\\OneDrive\\Desktop\\quokka-tasks\\practiceProject\\moneyManagement\\src\\main\\java\\com\\ql\\Users.csv";
        File file = new File(filePath);

        if(file.exists()){

            try{
                FileReader fr=new FileReader(file);
                BufferedReader br=new BufferedReader(fr);

                String line;
                br.readLine();

                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data.length > 0) {
                        try {
                            int existingID = Integer.parseInt(data[0].trim());
                            if(existingID==id) return  true;
                        } catch (Exception e) {
                            System.out.println("please enter valid id not matched");
                             e.printStackTrace();
                        }
                    }
                }

            }catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        return false;
    }

       public static String getValidName(Scanner sc){
           String name;

           while(true){
               System.out.println("Enter the name of the user name must contain alphbets a-z and spaces length will be minimum 2 and maximum 50");
                   name=sc.nextLine().trim();

                if(name.matches("[a-zA-Z ]{2,50}")){
                       return name;
                }else{
                      System.out.println("Invalid name! Please enter only letters and spaces (min 2 characters).");
                }

           }

       }

       public static double getValidBalance(Scanner sc){
           try{
               while(true){
                   System.out.println("Enter initial balance what u want to deposit");
                   double balance=sc.nextDouble();
                   sc.nextLine();
                   if(balance>0&&balance<500000){
                       return  balance;
                   }else{
                       System.out.println("Please add valid balance between 0 to 500000");
                       continue;
                   }
               }
           }catch(Exception e){
               System.out.println("this field must be a integer value");
               System.out.println("error while fetching one day amount limit"+e.getMessage());

           }
            return -1;
       }

       public static int getValidOneDayLimit(Scanner sc){
           try{
               while(true){
                   System.out.println("Enter maximum one day money spent limit");
                   int balance=sc.nextInt();
                   sc.nextLine();
                   if(balance>0&&balance<500000){
                       return  balance;
                   }else{
                       System.out.println("Please add valid limit between 0 to 500000");
                       continue;
                   }
               }
           }catch(Exception e){
               System.out.println("this field must be a integer value");
               System.out.println("error while fetching one day amount limit"+e.getMessage());
           }

           return -1;
       }

       public static int getValidId(Scanner sc){
           try{
               while(true){
                   System.out.println("Enter your userId to login to your account");
                   int id =sc.nextInt();
                   sc.nextLine();
                   if(id >0){
                       return id;
                   }else{
                       System.out.println("Please add valid id");
                       continue;
                   }
               }
           }catch(Exception e){
               System.out.println("this field must be a integer value");
               System.out.println("error while fetching one day amount limit");
           }

           return -1;
       }

       public static int getUserType(Scanner sc){

              try{
                  System.out.println("Welcome to the account expense tracker");
                  System.out.println("Are you a new user or an existing user: new/existing");
                  System.out.println("select 1 for new");
                  System.out.println("select 2 for existing");
                  int userType=sc.nextInt();
                  sc.nextLine();
                  return userType;
              }catch(Exception e){
                  System.out.println("User type must be an integer");
              }
             return -1;
       }

    public static void main(String[] args) throws Exception {

        while(true){

            Scanner sc= new Scanner(System.in);
            System.out.println();

            int userType=getUserType(sc);

            if(userType!=1&&userType!=2){
                System.out.println("please select the valid field");
                   continue;
            }

            switch (userType){

                case 1:{
                    String name= getValidName(sc) ;
                    double balance=getValidBalance(sc);

                    if(balance==-1){
                           continue;
                    }

                    int maxOneDayLimit=getValidOneDayLimit(sc);

                    if(maxOneDayLimit==-1){
                          continue;
                    }

                    if(maxOneDayLimit>balance){
                        System.out.println("Max one day limit must be less than total balance");
                        getValidOneDayLimit(sc);
                    }
                    UserManager manager=new UserManager(name,balance,maxOneDayLimit);
                    int userId=manager.getUserId();
                    System.out.println("Your user id is: "+userId);
                    System.out.println("What u want credit or debit or today's expenses statics");
                    String task=sc.nextLine();
                    switch(task){
                        case "credit":{
                            System.out.println("Enter amount u want to credit");
                            double amount=sc.nextDouble();
                            sc.nextLine();
                            manager.creditAmount(userId,amount);
                            break;
                        }
                        case "debit":{
                            System.out.println("Enter amount u want to debit");
                            double amount=sc.nextDouble();
                            sc.nextLine();
                            if(manager.checkTodayRemainingAmount(amount)==false){
                                System.out.println("You reached your today spent limit");
                                break;
                            }
                            manager.debitAmount(userId,amount);
                            break;
                        }
                        case "current balance":{
                            System.out.println("Current balance is: "+manager.getBalance());
                            break;
                        }
                        case "expenses statics":{
                            manager.accountStatistics(userId);
                            break;
                        }
                        default:{
                            System.out.println("Please enter valid field check spelling properly");
                        }
                    }
                    break;
                }
                case 2:{

                    int id=getValidId(sc);

                    if(!findUserbyId(id)){
                        System.out.println("Please enter a valid user id");
                        break;
                    }

                    UserManager manager=new UserManager(id);
                    System.out.println("What u want credit or debit or today's expenses statics ");
                    String task=sc.nextLine();
                    switch(task){
                        case "credit":{
                            System.out.println("Enter amount u want to credit");
                            double amount=sc.nextDouble();
                            sc.nextLine();
                            manager.creditAmount(id,amount);
                            break;
                        }
                        case "debit":{
                            System.out.println("Enter amount u want to debit");
                            double amount=sc.nextDouble();
                            sc.nextLine();
                            if(manager.checkTodayRemainingAmount(amount)==false){
                                System.out.println("You reached your today spent limit");
                                break;
                            }
                            manager.debitAmount(id,amount);
                            break;
                        }
                        case "current balance":{
                            System.out.println("Current balance is: "+manager.getBalance());
                            break;
                        }
                        case "expenses statics":{
                            manager.accountStatistics(id);
                            break;
                        }
                        default:{
                            System.out.println("Please enter valid field check spelling properly");
                        }
                    }
                    break;
                }

                default:{
                    System.out.println("enter valid user type");
                }

            }

        }

    }
}