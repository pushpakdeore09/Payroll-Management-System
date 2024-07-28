package EmployeePayrollSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class EmployeeService {
    Connection connection = DatabaseConnection.getConnection();
    public int[] submitAttendance(int employee_id, String first_name, String last_name, LocalDate date, LocalTime checkInTime, LocalTime checkOutTime) {
        int[] submitAttendanceResult = new int[]{0};
        try {
            String attendanceQuery = "INSERT INTO employee_attendance(employee_id, first_name, last_name, date, check_in_time, check_out_time) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(attendanceQuery);
            preparedStatement.setInt(1, employee_id);
            preparedStatement.setString(2, first_name);
            preparedStatement.setString(3, last_name);
            preparedStatement.setDate(4, java.sql.Date.valueOf(date));
            preparedStatement.setTime(5, Time.valueOf(checkInTime));
            preparedStatement.setTime(6, Time.valueOf(checkOutTime));
            preparedStatement.addBatch();
            submitAttendanceResult = preparedStatement.executeBatch();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return  submitAttendanceResult;
    }
}
