package EmployeePayrollSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateAccountService {

    Connection connection = DatabaseConnection.getConnection();

    public int[] createAccount(String first_name, String last_name, int employee_id, String userType, String password) {
        int[] createAccResult = new int[]{0};
        try {
            String createAccQuery = "INSERT INTO users(employee_id, first_name, last_name, user_type, password) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(createAccQuery);
            preparedStatement.setInt(1, employee_id);
            preparedStatement.setString(2, first_name);
            preparedStatement.setString(3, last_name);
            preparedStatement.setString(4, userType);
            preparedStatement.setString(5, password);
            preparedStatement.addBatch();
            createAccResult = preparedStatement.executeBatch();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return createAccResult;
    }
}
