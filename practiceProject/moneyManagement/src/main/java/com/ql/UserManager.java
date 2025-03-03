package com.ql;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;
import java.lang.RuntimeException;

public class UserManager {

       //public static ArrayList<User> users=new ArrayList<>();
       private  User u1;

       UserManager(String name,Double balance,int maxOneDayLimit){
               u1=new User(name,balance,maxOneDayLimit);

           String filePath="C:\\Users\\Kapil Kant\\OneDrive\\Desktop\\quokka-tasks\\practiceProject\\moneyManagement\\src\\main\\java\\com\\ql\\Users.csv";

           try{

               File file =new File(filePath) ;
               boolean fileExist=file.exists();
               FileWriter fw=new FileWriter(filePath,true);
               BufferedWriter bw=new BufferedWriter(fw);
               PrintWriter pw=new PrintWriter(bw);

              if(!fileExist){
                  pw.println("ID,Name,Balance,MaxOneDayLimit");
              }

               pw.println(u1.getUserId()+ "," + name + "," + balance + "," + maxOneDayLimit);
               pw.flush();
               System.out.println("User details saved to CSV successfully.");
           } catch (IOException e) {
               throw new RuntimeException(e);
           }


       }

       UserManager(int id){
           try{
               String filePath="C:\\Users\\Kapil Kant\\OneDrive\\Desktop\\quokka-tasks\\practiceProject\\moneyManagement\\src\\main\\java\\com\\ql\\Users.csv";

               BufferedReader br = new BufferedReader(new FileReader(filePath));
               String line;
               String header=br.readLine();

               while((line=br.readLine())!=null){
                   String []data=line.split(",");

                   if(data.length==4){
                       int userId=Integer.parseInt(data[0].trim());
                       String name = data[1].trim();
                       double balance = Double.parseDouble(data[2].trim());
                       int maxOneDayLimit = Integer.parseInt(data[3].trim());

                       if (id == userId) {
                           u1=new User(name,balance,maxOneDayLimit);
                       }
                   }

               }
           }
           catch (Exception e){
               e.printStackTrace();
           }
       }

       public boolean checkTodayRemainingAmount(double amount){
           return  u1.checkTodayRemainingAmount(amount);
       }

       public int getUserId(){
             return u1.getUserId();
       }

       public Double getBalance(){
           return u1.getBalance();
       }

       public void creditAmount(int id,double amount){
           u1.creditAmount(id,amount);
       }

       public void debitAmount(int id,double amount){
            u1.debitAmount(id,amount);
       }

       public void accountStatistics(int id){
            u1.accountStatistics(id);
       }


}
