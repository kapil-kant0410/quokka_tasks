package com.ql;

import com.ql.user_manager.UserManager;
import java.util.Scanner;

public class UserManagementSystem {

    public  void getUserOperations(){
          Scanner sc=new Scanner(System.in);
          while(true){

            System.out.println("\n==== USER MANAGEMENT SYSTEM ====");
            System.out.println("1. Add User");
            System.out.println("2. View All Users");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice=sc.nextInt();
            sc.nextLine();

            switch (choice){

                case 1:{
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();
                    System.out.print("Enter Contact: ");
                    String contact = sc.nextLine();
                    UserManager.addUser(name,address,contact);
                    break;
                }

                case 2:{
                    UserManager.viewAllUsers();
                    break;
                }

                case 3:{
                    System.out.println("Enter id you want to update");
                    int id=sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();
                    System.out.print("Enter Contact: ");
                    String contact = sc.nextLine();
                    UserManager.updateUser(id,name,address,contact);
                    break;
                }

                case 4:{
                    System.out.print("Enter valid id:");
                    int id=sc.nextInt();
                    sc.nextLine();
                    UserManager.deleteUser(id);
                    break;
                }

            }

        }
    }

}
