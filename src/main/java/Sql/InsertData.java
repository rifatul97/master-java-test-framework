package Sql;

import helper.MySQLFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
    public static void main(String[] args) {
        try (Connection connection = MySQLFactory.createConnection()) {
            String query = "Insert into Student (sname, major) VALUES ('Rifat', 'Computer')";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.executeUpdate(query);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("success!");
    }
}
