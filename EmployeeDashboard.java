package EmployeePayrollSystem;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;

public class EmployeeDashboard extends JFrame {

    JTextField txtEmployeeID, txtFirstName, txtLastName;
    JDateChooser dateChooser;
    JSpinner checkInTime, checkOutTime;
    SpinnerDateModel checkInModel, checkOutModel;
    JButton btnSubmit, btnClear, btnBack;
    JLabel labelEmployeeID, labelFirstName, labelLastName, labelDate, labelCheckInTime, labelCheckOutTime, labelSubmitAttendance;
    JPanel employeeDashboardPanel, headingPanel;

    public EmployeeDashboard() {
        Font labelFont = new Font("Arial", Font.BOLD, 18);
        Font font = new Font("Arial", Font.PLAIN, 18);
        Font headingFont = new Font("Arial", Font.BOLD, 30);

        // Heading Label
        labelSubmitAttendance = new JLabel("Submit Attendance");
        labelSubmitAttendance.setFont(headingFont);

        // Employee ID Label
        labelEmployeeID = new JLabel("Employee ID: ");
        labelEmployeeID.setFont(labelFont);

        // First Name Label
        labelFirstName = new JLabel("First Name: ");
        labelFirstName.setFont(labelFont);

        // Last Name Label
        labelLastName = new JLabel("Last Name: ");
        labelLastName.setFont(labelFont);

        // Date Label
        labelDate = new JLabel("Date: ");
        labelDate.setFont(labelFont);

        // Label CheckIn Time
        labelCheckInTime = new JLabel("Check In Time: ");
        labelCheckInTime.setFont(labelFont);

        // Label CheckOut Time
        labelCheckOutTime = new JLabel("Check Out Time: ");
        labelCheckOutTime.setFont(labelFont);

        // Employee ID TextField
        txtEmployeeID = new JTextField();
        txtEmployeeID.setFont(font);
        txtEmployeeID.setPreferredSize(new Dimension(150, 22));

        // First Name TextField
        txtFirstName = new JTextField();
        txtFirstName.setFont(font);
        txtFirstName.setPreferredSize(new Dimension(150, 22));

        // Last Name TextField
        txtLastName = new JTextField();
        txtLastName.setFont(font);
        txtLastName.setPreferredSize(new Dimension(150, 22));

        // Date Field
        dateChooser = new JDateChooser();
        dateChooser.setFont(font);
        dateChooser.setPreferredSize(new Dimension(150, 22));

        // CheckIn Time
        checkInModel = new SpinnerDateModel();
        checkInModel.setCalendarField(Calendar.MINUTE);
        checkInTime = new JSpinner(checkInModel);
        JSpinner.DateEditor checkInEditor = new JSpinner.DateEditor(checkInTime, "HH:mm:ss");
        checkInTime.setEditor(checkInEditor);
        checkInTime.setFont(font);
        checkInTime.setPreferredSize(new Dimension(150, 22));

        // Check Out Time
        checkOutModel = new SpinnerDateModel();
        checkOutModel.setCalendarField(Calendar.MINUTE);
        checkOutTime = new JSpinner(checkOutModel);
        JSpinner.DateEditor checkOutEditor = new JSpinner.DateEditor(checkOutTime, "HH:mm:ss");
        checkOutTime.setEditor(checkOutEditor);
        checkOutTime.setFont(font);
        checkOutTime.setPreferredSize(new Dimension(150, 22));

        // Submit Button
        btnSubmit = new JButton("Submit");
        btnSubmit.setFont(labelFont);

        // Clear Button
        btnClear = new JButton("Clear");
        btnClear.setFont(labelFont);

        // Back Button
        btnBack = new JButton("Back");
        btnBack.setFont(labelFont);

        // Heading Panel
        headingPanel = new JPanel();
        headingPanel.setBounds(0, 50, 900, 100);
        headingPanel.setBackground(new Color(145, 194, 236));
        headingPanel.add(labelSubmitAttendance);

        // Employee Dashboard Panel
        employeeDashboardPanel = new JPanel(new GridBagLayout());
        employeeDashboardPanel.setBackground(new Color(145, 194, 236));
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(15, 15, 15, 15);
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        // Add Employee ID Label
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        employeeDashboardPanel.add(labelEmployeeID, gridBagConstraints);

        // Add Employee ID TextField
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        employeeDashboardPanel.add(txtEmployeeID, gridBagConstraints);

        // Add First Name Label
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        employeeDashboardPanel.add(labelFirstName, gridBagConstraints);

        // Add First Name TextField
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        employeeDashboardPanel.add(txtFirstName, gridBagConstraints);

        // Add Last Name Label
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        employeeDashboardPanel.add(labelLastName, gridBagConstraints);

        // Add Last Name TextField
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        employeeDashboardPanel.add(txtLastName, gridBagConstraints);

        // Add Date Chooser Label
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        employeeDashboardPanel.add(labelDate, gridBagConstraints);

        // Add Date Chooser
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        employeeDashboardPanel.add(dateChooser, gridBagConstraints);

        // Add Check In Time Label
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        employeeDashboardPanel.add(labelCheckInTime, gridBagConstraints);

        // Add Check In Time Field
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        employeeDashboardPanel.add(checkInTime, gridBagConstraints);

        // Add Check Out Time Label
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        employeeDashboardPanel.add(labelCheckOutTime, gridBagConstraints);

        // Add Check Out Time Field
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        employeeDashboardPanel.add(checkOutTime, gridBagConstraints);

        // Add Submit Button
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        employeeDashboardPanel.add(btnSubmit, gridBagConstraints);

        // Add Clear Button
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        employeeDashboardPanel.add(btnClear, gridBagConstraints);

        // Add Back Button
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        employeeDashboardPanel.add(btnBack, gridBagConstraints);

        // Employee Dashboard Frame
        add(headingPanel, BorderLayout.CENTER);
        add(employeeDashboardPanel, BorderLayout.CENTER);
        setTitle("Submit Attendance");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        // Handle Submit Button
        btnSubmit.addActionListener(event -> {
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String employee_id_text = txtEmployeeID.getText().trim();
            String first_name = txtFirstName.getText().trim();
            String last_name = txtLastName.getText().trim();
            Date date = dateChooser.getDate();
            Date checkInDate = (Date) checkInTime.getValue();
            Date checkOutDate = (Date) checkOutTime.getValue();
            String check_in_time_text = timeFormat.format(checkInDate);
            String check_out_time_text = timeFormat.format(checkOutDate);
            if (employee_id_text.isEmpty() || first_name.isEmpty() || last_name.isEmpty() || date == null) {
                JOptionPane.showMessageDialog(employeeDashboardPanel, "Please fill all details");
            } else {
                int employee_id = Integer.parseInt(employee_id_text);
                try {
                LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalTime checkInTime = LocalTime.parse(check_in_time_text, formatter);
                LocalTime checkOutTime = LocalTime.parse(check_out_time_text, formatter);
                EmployeeService employeeService = new EmployeeService();
                int[] result = employeeService.submitAttendance(employee_id, first_name, last_name, localDate, checkInTime, checkOutTime);

                for (int i = 0; i < result.length; i++) {
                    if(result[i] == 0) {
                        System.out.println("Query "+i+" not execued successfully!");
                    }
                }
                System.out.println("All queries executed Successfully!");
                JOptionPane.showMessageDialog(employeeDashboardPanel, "Attendance Recorded!");
                }catch (DateTimeParseException exception) {
                    System.out.println(exception.getMessage());
                }
            }
        });

        // Handle Back Button
        btnBack.addActionListener(event ->{
            new Login();
            this.dispose();
        });

        // Handle Clear Button
        btnClear.addActionListener(event ->{
            txtEmployeeID.setText("");
            txtFirstName.setText("");
            txtLastName.setText("");
            dateChooser.setDate(null);
        });
    }
}
