package com.ql;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

public class User {

       //public static int gid=1;
       public  int id;
       public  String name;
       private double balance;
       public  int maxOneDayLimit;
//       private int remainingMaxOneDayLimit;
//       ArrayList<Double> creditList;
//       ArrayList<Double> debitList;

          User(String name,double balance,int maxOneDayLimit){
              this.id=generateUniqueID();
              this.name=name;
              this.balance=balance;
              this.maxOneDayLimit=maxOneDayLimit;
          }

          public int generateUniqueID(){

                int maxId=0;
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
                                    maxId = Math.max(maxId, existingID);
                                } catch (NumberFormatException e) {
                                    System.out.println("Skipping invalid ID: " + data[0]);
                                }
                            }
                        }

                    }catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }
                return maxId+1;
          }

          public  boolean checkTodayRemainingAmount(double amount){
               if(maxOneDayLimit>0&&amount<=maxOneDayLimit) return true;
                System.out.println("Please enter amount less than today's remaining amount"+maxOneDayLimit);
                return false;
          }

          public int getUserId(){
                return id;
          }

          public Double getBalance(){
                return balance;
          }

          public void creditAmount(int id,double amount){
                balance=balance+amount;
                String filePath="C:\\Users\\Kapil Kant\\OneDrive\\Desktop\\quokka-tasks\\practiceProject\\moneyManagement\\src\\main\\java\\com\\ql\\Users.csv";
                List<String> fileData = new ArrayList<>();

                try{
                    BufferedReader br = new BufferedReader(new FileReader(filePath));
                    String line;
                    String header=br.readLine();
                    fileData.add(header);
                    int idCount=1;

                    while((line=br.readLine())!=null){
                          String []data=line.split(",");

                          if(data.length==4){
                              int userId=Integer.parseInt(data[0].trim());
                              String name = data[1].trim();
                              double balance = Double.parseDouble(data[2].trim());
                              int maxOneDayLimit = Integer.parseInt(data[3].trim());

                               if (id == userId) {
                                  balance += amount; // Add credit amount

                              }

                              fileData.add(idCount + "," + name + "," + balance + "," + maxOneDayLimit);
                                  idCount++;
                          }

                    }
                }
                catch (Exception e){
                       System.out.println("error occurred during credit amount "+e.getMessage());
                       e.printStackTrace();
                }
                try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
                  for (String record : fileData) {
                      pw.println(record);
                  }
                } catch (IOException e) {
                  System.out.println("Error writing to CSV file: " + e.getMessage());
                     return;
                }

              System.out.println("Amount credited successfully! New balance: " + balance);
          }

          public void debitAmount(int id,double amount){
                balance=balance-amount;
              String filePath="C:\\Users\\Kapil Kant\\OneDrive\\Desktop\\quokka-tasks\\practiceProject\\moneyManagement\\src\\main\\java\\com\\ql\\Users.csv";
              List<String> fileData = new ArrayList<>();

              try{
                  BufferedReader br = new BufferedReader(new FileReader(filePath));
                  String line;
                  String header=br.readLine();
                  fileData.add(header);
                  int idCount=1;

                  while((line=br.readLine())!=null){
                      String []data=line.split(",");

                      if(data.length==4){
                          int userId=Integer.parseInt(data[0].trim());
                          String name = data[1].trim();
                          double balance = Double.parseDouble(data[2].trim());
                          int maxOneDayLimit = Integer.parseInt(data[3].trim());

                          if (id == userId) {
                              balance -= amount; // debit amount
                              maxOneDayLimit-=amount;
                              System.out.println("Amount debit successfully! New balance: " + balance);
                          }

                          fileData.add(idCount + "," + name + "," + balance + "," + maxOneDayLimit);
                          idCount++;
                      }

                  }
              }
              catch (Exception e){
                  e.printStackTrace();
              }
              try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
                  for (String record : fileData) {
                      pw.println(record);
                  }
              } catch (IOException e) {
                  System.out.println("Error writing to CSV file: " + e.getMessage());
              }

          }

          public void accountStatistics(int id){
              String filePath="C:\\Users\\Kapil Kant\\OneDrive\\Desktop\\quokka-tasks\\practiceProject\\moneyManagement\\src\\main\\java\\com\\ql\\Users.csv";

                try{
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
                              System.out.println("Current balance of user: "+balance);
                              System.out.println("Remaining balance of user: "+maxOneDayLimit);
                          }

                      }

                  }
              } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
          }

}
