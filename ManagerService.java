package EmployeePayrollSystem;

import java.sql.*;

public class ManagerService {

    Connection connection = DatabaseConnection.getConnection();
    public int[] addRecord(String first_name, String last_name, int employee_id, java.util.Date dob, String genderSelected, String email, String contact_no, String address, String jobTitle, java.util.Date hiredDate, String department, String employeeStatus, double basic_salary, double allowances, double deductions, double net_salary) {
        int[] addRecordResult = new int[]{0};
        try {
            String addRecordQuery = "INSERT INTO employee_details(employee_id, first_name, last_name, address, email, contact_no, gender, birth_date, job_title, department, hired_date, employee_status, basic_salary, allowances, deductions, net_salary) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(addRecordQuery);
            preparedStatement.setInt(1, employee_id);
            preparedStatement.setString(2, first_name);
            preparedStatement.setString(3, last_name);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, contact_no);
            preparedStatement.setString(7, genderSelected);
            preparedStatement.setDate(8, new java.sql.Date(dob.getTime()));
            preparedStatement.setString(9, jobTitle);
            preparedStatement.setString(10, department);
            preparedStatement.setDate(11, new java.sql.Date(hiredDate.getTime()));
            preparedStatement.setString(12, employeeStatus);
            preparedStatement.setDouble(13, basic_salary);
            preparedStatement.setDouble(14, allowances);
            preparedStatement.setDouble(15, deductions);
            preparedStatement.setDouble(16, net_salary);
            preparedStatement.addBatch();
            addRecordResult = preparedStatement.executeBatch();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return addRecordResult;
    }
    public int deleteRecord(int employee_id) {
        int rowsAffected = 0;
        try {
            String deleteUserQuery = "DELETE FROM users WHERE employee_id = ?";
            PreparedStatement preparedStatementUsers = connection.prepareStatement(deleteUserQuery);
            preparedStatementUsers.setInt(1, employee_id);
            rowsAffected = preparedStatementUsers.executeUpdate();

            String deleteAttendanceQuery = "DELETE FROM employee_attendance WHERE employee_id = ?";
            PreparedStatement preparedStatementAttendance = connection.prepareStatement(deleteAttendanceQuery);
            preparedStatementAttendance.setInt(1, employee_id);
            rowsAffected = preparedStatementUsers.executeUpdate();

            String deleteEmployeeQuery = "DELETE FROM employee_details WHERE employee_id = ?";
            PreparedStatement preparedStatementEmployee = connection.prepareStatement(deleteEmployeeQuery);
            preparedStatementEmployee.setInt(1, employee_id);
            rowsAffected += preparedStatementEmployee.executeUpdate();

            return rowsAffected;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rowsAffected;
    }
    public int updateRecord(String first_name, String last_name, int employee_id, java.util.Date dob, String genderSelected, String email, String contact_no, String address, String jobTitle, java.util.Date hiredDate, String department, String employeeStatus, double basic_salary, double allowances, double deductions, double net_salary) {
        try {
        String updateQuery = "UPDATE employee_details SET first_name = ?, last_name = ?, address = ?, email = ?, contact_no = ?, gender = ?, birth_date = ?, job_title = ?, department = ?, hired_date = ?, employee_status = ?, basic_salary = ?, allowances = ?, deductions = ?, net_salary = ? WHERE employee_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
        preparedStatement.setString(1, first_name);
        preparedStatement.setString(2, last_name);
        preparedStatement.setString(3, address);
        preparedStatement.setString(4, email);
        preparedStatement.setString(5, contact_no);
        preparedStatement.setString(6, genderSelected);
        preparedStatement.setDate(7, new java.sql.Date(dob.getTime()));
        preparedStatement.setString(8, jobTitle);
        preparedStatement.setString(9, department);
        preparedStatement.setDate(10, new java.sql.Date(hiredDate.getTime()));
        preparedStatement.setString(11, employeeStatus);
        preparedStatement.setDouble(12, basic_salary);
        preparedStatement.setDouble(13, allowances);
        preparedStatement.setDouble(14, deductions);
        preparedStatement.setDouble(15, net_salary);
        preparedStatement.setInt(16, employee_id);
        return preparedStatement.executeUpdate();
    } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    public ResultSet searchRecord(int employee_id) {
        try {
        String searchQuery = "SELECT * FROM employee_details WHERE employee_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(searchQuery);
        preparedStatement.setInt(1, employee_id);
        return preparedStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ResultSet attendance(int employee_id) {
        try{
            String displayAttendanceQuery = "SELECT * FROM employee_attendance WHERE employee_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(displayAttendanceQuery);
            preparedStatement.setInt(1, employee_id);
            return preparedStatement.executeQuery();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
