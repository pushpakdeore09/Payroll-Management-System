package EmployeePayrollSystem;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService {

    Connection connection = DatabaseConnection.getConnection();
    public String authenticate(int employee_id, String password) {
        try {
            String loginQuery = "SELECT * FROM users WHERE employee_id = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(loginQuery);
            preparedStatement.setInt(1, employee_id);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                return resultSet.getString("user_type");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
