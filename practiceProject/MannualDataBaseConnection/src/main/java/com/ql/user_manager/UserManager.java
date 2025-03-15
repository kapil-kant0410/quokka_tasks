package com.ql.user_manager;

import com.ql.config.DataBaseConfig;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserManager {

    public static Statement getConnection()  {
        try{
            Connection connection= DataBaseConfig.getConnection();
            Statement  statement=connection.createStatement();
            return statement;
        }catch (SQLException e){
            System.out.println("Error while connecting to the database");
            e.printStackTrace();
            return null;
        }
    }

     public static void addUser(String name,String address,String contact)  {

           try{
               Statement  statement= UserManager.getConnection();
               String q1 = String.format("INSERT INTO %s (name, address, contact) VALUES ('%s', '%s', '%s')", "users", name, address, contact);
               int rowsAffected=statement.executeUpdate(q1);
               System.out.println(rowsAffected + " row(s) inserted");
           }catch(SQLException e){
               System.out.println("Error while inserting into users table of testingDB1");
               e.printStackTrace();
           }


     }

     public static void viewAllUsers(){

         try{
              Statement statement= UserManager.getConnection();
              String q1="select * from users";
              ResultSet rs=statement.executeQuery(q1);

              while(rs.next()){
                   int id=rs.getInt("id");
                   String name =rs.getString("name");
                   String address=rs.getString("address");
                   String contact=rs.getString("contact");

                  System.out.println(id + " | "+ name + " | " + address + " | " + contact );
              }

         }catch (SQLException e){
              System.out.println("Error while fetching users from users table");
              e.printStackTrace();
         }

     }

     public static void deleteUser(int id){
         String q1=String.format("DELETE FROM %s WHERE id=%d","users",id);
         try{
             Statement statement= UserManager.getConnection();
             int rowsDeleted=statement.executeUpdate(q1);
             System.out.println(rowsDeleted + " row(s) deleted.");
         }catch(SQLException e){
             System.out.println("Error while deleting the user from users table of testingDB1");
             e.printStackTrace();
         }


     }

     public static void updateUser(int id,String name,String address,String contact){

           try{
                 Statement statement= UserManager.getConnection();
                 String q1 = "UPDATE users SET name = '" + name + "', address = '" + address +
                       "', contact = '" + contact + "' WHERE id = " + id;
                 int rowsAffected = statement.executeUpdate(q1);
                 if (rowsAffected > 0) {
                    System.out.println("User updated successfully!");
                 } else {
                   System.out.println("No user found with the given ID.");
                 }
           }catch (SQLException e){
                 System.out.println("Error while updating thee user");
                 e.printStackTrace();
           }

     }
}
