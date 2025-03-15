package com.ql;
import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        UserManagementSystem u1=new UserManagementSystem();
        u1.getUserOperations();
    }
}