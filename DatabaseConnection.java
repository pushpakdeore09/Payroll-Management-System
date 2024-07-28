package EmployeePayrollSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String url = "jdbc:mysql://localhost:3306/employee_payroll_management";
    private static final String username = "root";
    private static final String password = "PushpakSQL#2024";

    public static Connection getConnection() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            return DriverManager.getConnection(url, username, password);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
