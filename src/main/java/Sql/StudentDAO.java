package Sql;

import helper.MySQLFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private static final String getStudentsQuery = "SELECT * from Student";
    private static final String deleteStudentByIdQuery = "Delete from Student where sid = ?";

    public static List<Student> findAll() {
        List<Student> studentRecords = new ArrayList<>();

        try (
                Connection connection = MySQLFactory.createConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(getStudentsQuery);
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while (resultSet.next()) {
                int id = resultSet.getInt("sid");
                String name = resultSet.getString("sname");
                String major = resultSet.getString("major");
                studentRecords.add(new Student(id, name, major));
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return studentRecords;
    }

    public static void deleteById(int id) {
        try (
                Connection connection = MySQLFactory.createConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(deleteStudentByIdQuery);
        ) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

}
