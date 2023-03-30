package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        System.out.println(System.getenv("DB_USER_NAME"));
        System.out.println(System.getenv("DB_USER_PASS"));

        try {
            connection= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/tradb",
                    System.getenv("DB_USER_NAME"),
                    System.getenv("DB_USER_PASS")
            );
            statement = connection.createStatement();

            //Read
            System.out.println("Display all Student :");
            rs = statement.executeQuery("select * from student ;");
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int age = rs.getInt("age");
                System.out.println("ID: "+ id + ", Name: "+ name + ", Email: " + email + ", age: " + age);
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}