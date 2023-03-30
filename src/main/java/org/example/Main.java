package org.example;

import java.sql.*;
import java.util.ArrayList;

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
            ArrayList<Student> students = new ArrayList();

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int age = rs.getInt("age");

                Student student = new Student(id,name,email,age);
                students.add(student);
            }

            for (Student currstudent:students){
                //System.out.println(currstudent);
                System.out.println("ID: "+currstudent.getId()+ ", Name: "+ currstudent.getName() + ", Email: " + currstudent.getEmail() + ", age: " + currstudent.getAge());
            }


        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}