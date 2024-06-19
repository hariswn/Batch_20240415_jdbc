package com.facebook;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacebookConnect {

    public static void main(String[] args) {
        System.out.println("MySQL JDBC Connection Testing ~");


        String SQL_SELECT = "Select * from facebook_emp";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydb", "root", "Harry@12345");
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                long salary = resultSet.getLong("salary");
                String email = resultSet.getString("email");

                System.out.println("id : " + id + ", name : " + name + ", address : "
                        + address + "salary : " + salary + ", email : " + email );

            }


        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
