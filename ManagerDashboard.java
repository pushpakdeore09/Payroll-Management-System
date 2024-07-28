package EmployeePayrollSystem;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import com.toedter.calendar.JDateChooser;

public class ManagerDashboard extends JFrame {
    JTextField txtFirstName, txtLastName, txtEmployeeID, txtJobTitle, txtDepartment, txtSearchEmployee, txtEmail, txtContactNo, txtStatus, txtBasicSalary, txtNetSalary, txtAllowances, txtAddress, txtDeductions;
    JLabel labelProject, labelSearchEmployee, labelFirstName, labelLastName, labelEmployeeID, labelJobTitle, labelDepartment, labelGender, labelContactNo, labelEmail, labelDOB, labelDateHired, labelStatus, labelBasicSalary, labelNetSalary, labelAllowances, labelDeductions, labelAddress;
    JComboBox<String> gender;
    JButton btnAddRecord, btnUpdateRecord, btnDeleteRecord, btnSearch, btnComputeSalary, btnAttendance, btnClear, btnBack;
    JPanel managerDashboardPanel, headingPanel;
    JDateChooser dobDate, hiredDate;
    public ManagerDashboard() {
        Font labelFont = new Font("Arial", Font.BOLD, 18);
        Font font = new Font("Arial", Font.PLAIN, 18);
        Font headingFont = new Font("Arial", Font.BOLD, 25);

        // Project Label
        labelProject = new JLabel("Employee Management System");
        labelProject.setFont(headingFont);

        // First Name Label
        labelFirstName = new JLabel("First Name: ");
        labelFirstName.setFont(labelFont);

        // Last Name Label
        labelLastName = new JLabel("Last Name: ");
        labelLastName.setFont(labelFont);

        // Employee ID Label
        labelEmployeeID = new JLabel("Employee ID: ");
        labelEmployeeID.setFont(labelFont);

        // Search Employee
        labelSearchEmployee = new JLabel("Search Employee: ");
        labelSearchEmployee.setFont(labelFont);

        // Job Title Label
        labelJobTitle = new JLabel("Job Title: ");
        labelJobTitle.setFont(labelFont);

        // Label Department
        labelDepartment = new JLabel("Department: ");
        labelDepartment.setFont(labelFont);

        // Label Date of Birth
        labelDOB = new JLabel("Date of Birth: ");
        labelDOB.setFont(labelFont);

        // Label Date Hired
        labelDateHired = new JLabel("Date Hired: ");
        labelDateHired.setFont(labelFont);

        // Label Gender
        labelGender = new JLabel("Gender: ");
        labelGender.setFont(labelFont);

        // Label Contact Number
        labelContactNo = new JLabel("Contact Number: ");
        labelContactNo.setFont(labelFont);

        // Label Email
        labelEmail = new JLabel("Email: ");
        labelEmail.setFont(labelFont);

        // Label Employee Status
        labelStatus = new JLabel("Status: ");
        labelStatus.setFont(labelFont);

        // Label Basic Salary
        labelBasicSalary = new JLabel("Basic Salary: ");
        labelBasicSalary.setFont(labelFont);

        // Label Address
        labelAddress = new JLabel("Address: ");
        labelAddress.setFont(labelFont);

        // Label Deductions
        labelDeductions = new JLabel("Deductions: ");
        labelDeductions.setFont(labelFont);

        // Label Allowances
        labelAllowances = new JLabel("Allowances: ");
        labelAllowances.setFont(labelFont);

        // Label Net Salary
        labelNetSalary = new JLabel("Net Salary: ");
        labelNetSalary.setFont(labelFont);

        // First Name TextField
        txtFirstName = new JTextField();
        txtFirstName.setFont(font);
        txtFirstName.setPreferredSize(new Dimension(150, 22));

        // Last Name TextField
        txtLastName = new JTextField();
        txtLastName.setFont(font);
        txtLastName.setPreferredSize(new Dimension(150, 22));

        // Search Employee TextField
        txtSearchEmployee = new JTextField();
        txtSearchEmployee.setText("Enter Employee ID");
        txtSearchEmployee.setPreferredSize(new Dimension(150, 22));


        // Employee ID TextField
        txtEmployeeID = new JTextField();
        txtEmployeeID.setFont(font);
        txtEmployeeID.setPreferredSize(new Dimension(150, 22));

        // Job Title TextField
        txtJobTitle = new JTextField();
        txtJobTitle.setFont(font);
        txtJobTitle.setPreferredSize(new Dimension(150, 22));

        // Department TextField
        txtDepartment = new JTextField();
        txtDepartment.setFont(font);
        txtDepartment.setPreferredSize(new Dimension(150, 22));

        // Email TextField
        txtEmail = new JTextField();
        txtEmail.setFont(font);
        txtEmail.setPreferredSize(new Dimension(150, 22));

        // Contact No. TextField
        txtContactNo = new JTextField();
        txtContactNo.setFont(font);
        txtContactNo.setPreferredSize(new Dimension(150, 22));

        // Status TextField
        txtStatus = new JTextField();
        txtStatus.setFont(font);
        txtStatus.setPreferredSize(new Dimension(150, 22));

        // Basic Salary TextField
        txtBasicSalary = new JTextField();
        txtBasicSalary.setFont(font);
        txtBasicSalary.setPreferredSize(new Dimension(150, 22));

        // Net Salary TextField
        txtNetSalary = new JTextField();
        txtNetSalary.setFont(font);
        txtNetSalary.setPreferredSize(new Dimension(150, 22));

        // Address TextField
        txtAddress = new JTextField();
        txtAddress.setFont(font);
        txtAddress.setPreferredSize(new Dimension(150, 22));

        // Allowances TextField
        txtAllowances = new JTextField();
        txtAllowances.setFont(font);
        txtAllowances.setPreferredSize(new Dimension(150, 22));

        // Deductions TextField
        txtDeductions = new JTextField();
        txtDeductions.setFont(font);
        txtDeductions.setPreferredSize(new Dimension(150, 22));

        // Search Button
        btnSearch = new JButton("Search");
        btnSearch.setFont(labelFont);

        // Add Record Button
        btnAddRecord = new JButton("Add Record");
        btnAddRecord.setFont(labelFont);

        // Delete Record Button
        btnDeleteRecord = new JButton("Delete Record");
        btnDeleteRecord.setFont(labelFont);

        // Update Record Button
        btnUpdateRecord = new JButton("Update Record");
        btnUpdateRecord.setFont(labelFont);

        // Compute Salary Button
        btnComputeSalary = new JButton("Compute Salary");
        btnComputeSalary.setFont(labelFont);

        // Attendance Button
        btnAttendance = new JButton("Attendance");
        btnAttendance.setFont(labelFont);

        // Clear Button
        btnBack = new JButton("Back");
        btnBack.setFont(labelFont);

        // Back Button
        btnClear = new JButton("Clear");
        btnClear.setFont(labelFont);

        // Gender ComboBox
        gender = new JComboBox<>();
        gender.setFont(font);
        gender.addItem("");
        gender.addItem("Male");
        gender.addItem("Female");
        gender.addItem("Other");
        gender.setPreferredSize(new Dimension(150, 22));

        // Date of Birth Field
        dobDate = new JDateChooser();
        dobDate.setPreferredSize(new Dimension(150, 22));
        dobDate.getCalendarButton();

        // Hired Date
        hiredDate = new JDateChooser();
        hiredDate.setPreferredSize(new Dimension(150, 22));
        hiredDate.getCalendarButton();

        // Heading Panel
        headingPanel = new JPanel();
        headingPanel.setBounds(0, 20, 900, 50);
        headingPanel.setBackground(new Color(145, 194, 236));
        headingPanel.add(labelProject);

        // Manager Dashboard Panel
        managerDashboardPanel = new JPanel(new GridBagLayout());
        managerDashboardPanel.setBackground(new Color(145, 194, 236));
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(10, 10, 5, 10);
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        // Add Search Employee Label
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        managerDashboardPanel.add(labelSearchEmployee, gridBagConstraints);

        // Add Search Employee TextField
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        managerDashboardPanel.add(txtSearchEmployee, gridBagConstraints);

        // Add Search Employee Button
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        managerDashboardPanel.add(btnSearch, gridBagConstraints);

        // Add First Name Label
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        managerDashboardPanel.add(labelFirstName, gridBagConstraints);

        // Add First Name TextField
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        managerDashboardPanel.add(txtFirstName, gridBagConstraints);

        // Add Last Name Label
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        managerDashboardPanel.add(labelLastName, gridBagConstraints);

        // Add Last Name TextField
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        managerDashboardPanel.add(txtLastName, gridBagConstraints);

        // Add Employee ID Label
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        managerDashboardPanel.add(labelEmployeeID, gridBagConstraints);

        // Add Employee ID TextField
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        managerDashboardPanel.add(txtEmployeeID, gridBagConstraints);

        // Add DOB Label
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        managerDashboardPanel.add(labelDOB, gridBagConstraints);

        // Add DOB TextField
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        managerDashboardPanel.add(dobDate, gridBagConstraints);

        // Add Gender Label
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        managerDashboardPanel.add(labelGender, gridBagConstraints);

        // Add Gender ComboBox
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        managerDashboardPanel.add(gender, gridBagConstraints);

        // Add Email Label
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        managerDashboardPanel.add(labelEmail, gridBagConstraints);

        // Add Email TextField
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        managerDashboardPanel.add(txtEmail, gridBagConstraints);

        // Add Contact No. Label
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        managerDashboardPanel.add(labelContactNo, gridBagConstraints);

        // Add Contact No. TextField
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        managerDashboardPanel.add(txtContactNo, gridBagConstraints);

        // Add Address Label
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        managerDashboardPanel.add(labelAddress, gridBagConstraints);

        // Add Address TextField
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        managerDashboardPanel.add(txtAddress, gridBagConstraints);

        // Add Job Title Label
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        managerDashboardPanel.add(labelJobTitle, gridBagConstraints);

        // Add Job Title TextField
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        managerDashboardPanel.add(txtJobTitle, gridBagConstraints);

        // Add Hired Label
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        managerDashboardPanel.add(labelDateHired, gridBagConstraints);

        // Add Hired Date TextField
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        managerDashboardPanel.add(hiredDate, gridBagConstraints);

        // Add Department Label
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        managerDashboardPanel.add(labelDepartment, gridBagConstraints);

        // Add Department TextField
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        managerDashboardPanel.add(txtDepartment, gridBagConstraints);

        // Add Status Label
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        managerDashboardPanel.add(labelStatus, gridBagConstraints);

        // Add Status TextField
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        managerDashboardPanel.add(txtStatus, gridBagConstraints);

        // Add Basic Salary Label
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        managerDashboardPanel.add(labelBasicSalary, gridBagConstraints);

        // Add Basic Salary TextField
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        managerDashboardPanel.add(txtBasicSalary, gridBagConstraints);

        // Add Allowances Label
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        managerDashboardPanel.add(labelAllowances, gridBagConstraints);

        // Add Allowances TextField
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        managerDashboardPanel.add(txtAllowances, gridBagConstraints);

        // Add Deductions Label
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        managerDashboardPanel.add(labelDeductions, gridBagConstraints);

        // Add Deductions TextField
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        managerDashboardPanel.add(txtDeductions, gridBagConstraints);

        // Add Net Salary Label
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        managerDashboardPanel.add(labelNetSalary, gridBagConstraints);

        // Add New Salary TextField
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        managerDashboardPanel.add(txtNetSalary, gridBagConstraints);

        // Add addRecord Button
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        managerDashboardPanel.add(btnAddRecord, gridBagConstraints);

        // Add Update Record Button
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        managerDashboardPanel.add(btnUpdateRecord, gridBagConstraints);

        // Add Delete Record Button
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        managerDashboardPanel.add(btnDeleteRecord, gridBagConstraints);

        // Add Compute Salary Button
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        managerDashboardPanel.add(btnComputeSalary, gridBagConstraints);

        // Add Attendance Button
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        managerDashboardPanel.add(btnAttendance, gridBagConstraints);

        // Add Back Button
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 10;
        managerDashboardPanel.add(btnBack, gridBagConstraints);

        // Add Back Button
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        managerDashboardPanel.add(btnClear, gridBagConstraints);
        // Manager Dashboard Frame
        add(headingPanel, BorderLayout.CENTER);
        add(managerDashboardPanel, BorderLayout.CENTER);
        setTitle("Manager Dashboard");
        setSize(new Dimension(900, 600));
        setLocationRelativeTo(null);
        setVisible(true);

        // Handle Add Record Button
        btnAddRecord.addActionListener(event -> {
            try {
                // Get Text from TextField
                String first_name = txtFirstName.getText().trim();
                String last_name = txtLastName.getText().trim();
                String employee_id_text = txtEmployeeID.getText().trim();
                Date birth_date = dobDate.getDate();
                String genderSelected = (String) gender.getSelectedItem();
                String email = txtEmail.getText().trim();
                String contact_no = txtContactNo.getText().trim();
                String address = txtAddress.getText().trim();
                String jobTitle = txtJobTitle.getText().trim();
                Date hired_date = hiredDate.getDate();
                String department = txtDepartment.getText().trim();
                String employeeStatus = txtStatus.getText().trim();
                String basic_salary_text = txtBasicSalary.getText().trim();
                String allowances_text = txtAllowances.getText().trim();
                String deductions_text = txtDeductions.getText().trim();
                String net_salary_text = txtNetSalary.getText().trim();

                if (first_name.isEmpty() || last_name.isEmpty() || employee_id_text.isEmpty() || birth_date == null || genderSelected == null || email.isEmpty() || contact_no.isEmpty() || address.isEmpty() || jobTitle.isEmpty() || hired_date == null || department.isEmpty() || employeeStatus.isEmpty() || basic_salary_text.isEmpty() || allowances_text.isEmpty() ||
                        deductions_text.isEmpty() || net_salary_text.isEmpty()) {
                    JOptionPane.showMessageDialog(managerDashboardPanel, "Please fill all details");
                } else {
                    int employee_id = Integer.parseInt(employee_id_text);
                    double basic_salary = Double.parseDouble(basic_salary_text);
                    double allowances = Double.parseDouble(allowances_text);
                    double deductions = Double.parseDouble(deductions_text);
                    double net_salary = Double.parseDouble(net_salary_text);
                    ManagerService managerService = new ManagerService();
                    int[] result = managerService.addRecord(first_name, last_name, employee_id, birth_date, genderSelected, email, contact_no, address, jobTitle, hired_date, department, employeeStatus, basic_salary, allowances, deductions, net_salary);

                    for (int i = 0; i < result.length; i++) {
                        if(result[i] == 0) {
                            System.out.println("Query "+i+" not executed Successfully!");
                        }
                    }
                    System.out.println("All queries executed Successfully!");
                    JOptionPane.showMessageDialog(managerDashboardPanel, "Record added Successfully!");
                    clearText();
                }
            } catch (NullPointerException exception) {
                JOptionPane.showMessageDialog(managerDashboardPanel,"Please fill all details");
            }
        });

        // Handle Update Record Button
        btnUpdateRecord.addActionListener(event -> {
            String first_name = txtFirstName.getText().trim();
            String last_name = txtLastName.getText().trim();
            String employee_id_text = txtEmployeeID.getText().trim();
            Date birth_date = dobDate.getDate();
            String genderSelected = (String) gender.getSelectedItem();
            String email = txtEmail.getText().trim();
            String contact_no = txtContactNo.getText().trim();
            String address = txtAddress.getText().trim();
            String jobTitle = txtJobTitle.getText().trim();
            Date hired_date = hiredDate.getDate();
            String department = txtDepartment.getText().trim();
            String employeeStatus = txtStatus.getText().trim();
            String basic_salary_text = txtBasicSalary.getText().trim();
            String allowances_text = txtAllowances.getText().trim();
            String deductions_text = txtDeductions.getText().trim();
            String net_salary_text = txtNetSalary.getText().trim();

            if (first_name.isEmpty() || last_name.isEmpty() || employee_id_text.isEmpty() || birth_date == null || genderSelected == null || email.isEmpty() || contact_no.isEmpty() || address.isEmpty() || jobTitle.isEmpty() || hired_date == null || department.isEmpty() || employeeStatus.isEmpty() || basic_salary_text.isEmpty() || allowances_text.isEmpty() ||
                    deductions_text.isEmpty() || net_salary_text.isEmpty()) {
                JOptionPane.showMessageDialog(managerDashboardPanel, "Please fill all details");
            } else {
                int employee_id = Integer.parseInt(employee_id_text);
                double basic_salary = Double.parseDouble(basic_salary_text);
                double allowances = Double.parseDouble(allowances_text);
                double deductions = Double.parseDouble(deductions_text);
                double net_salary = Double.parseDouble(net_salary_text);
                double new_net_salary = basic_salary - deductions + allowances;
                if (net_salary != new_net_salary) {
                    JOptionPane.showMessageDialog(managerDashboardPanel, "Please compute net salary");
                } else {
                    ManagerService managerService = new ManagerService();
                    int rowUpdated = managerService.updateRecord(first_name, last_name, employee_id, birth_date, genderSelected, email, contact_no, address, jobTitle, hired_date, department, employeeStatus, basic_salary, allowances, deductions, net_salary);

                    if (rowUpdated > 0) {
                        System.out.println("Record updated Successfully!");
                        JOptionPane.showMessageDialog(managerDashboardPanel, "Record Updated Successfully!");
                        clearText();
                    } else {
                        System.out.println("Record updation Unsuccessful!");
                    }
                }
            }
        });

        // Handle Delete Record Button
        btnDeleteRecord.addActionListener(event -> {
            String employee_id_text = txtEmployeeID.getText().trim();
            if(employee_id_text.isEmpty()) {
                JOptionPane.showMessageDialog(managerDashboardPanel, "Please enter Employee ID");
            }  else {
                int employee_id = Integer.parseInt(employee_id_text);
                ManagerService managerService = new ManagerService();
                int rowsAffected = managerService.deleteRecord(employee_id);
                if (rowsAffected > 0) {
                    System.out.println("Record deleted Successfully!");
                    JOptionPane.showMessageDialog(managerDashboardPanel, "Record Deleted Successfully!");
                } else {
                    System.out.println("Record deletion Unsuccessful!");
                }
            }
        });

        // Handle Compute Salary
        btnComputeSalary.addActionListener(event -> {
            String basic_salary_text = txtBasicSalary.getText().trim();
            String allowances_text = txtAllowances.getText().trim();
            String deductions_text = txtDeductions.getText().trim();
            if(basic_salary_text.isEmpty() || allowances_text.isEmpty() || deductions_text.isEmpty()) {
                JOptionPane.showMessageDialog(managerDashboardPanel, "Please fill Basic Salary, Allowances, Deductions details");
            } else {
                double basic_salary = Double.parseDouble(basic_salary_text);
                double allowances = Double.parseDouble(allowances_text);
                double deductions = Double.parseDouble(deductions_text);
                double net_salary = basic_salary + allowances - deductions;
                String net_salary_text = String.valueOf(net_salary);
                txtNetSalary.setText(net_salary_text);
            }
        });

        // Handle Search Button
        btnSearch.addActionListener(event -> {
            // Get Employee ID from TextField
            String search_employee_id_text = txtSearchEmployee.getText().trim();
            if(search_employee_id_text.isEmpty()) {
                JOptionPane.showMessageDialog(managerDashboardPanel, "Please enter Employee ID to search");
            } else {
                try {
                    int search_employee_id = Integer.parseInt(search_employee_id_text);

                    ManagerService managerService = new ManagerService();
                    ResultSet resultSet = managerService.searchRecord(search_employee_id);
                    if(resultSet.next()) {
                        txtFirstName.setText(resultSet.getString("first_name"));
                        txtLastName.setText(resultSet.getString("last_name"));
                        txtEmployeeID.setText(String.valueOf(resultSet.getInt("employee_id")));
                        dobDate.setDate(resultSet.getDate("birth_date"));
                        gender.setSelectedItem(resultSet.getString("gender"));
                        txtEmail.setText(resultSet.getString("email"));
                        txtContactNo.setText(resultSet.getString("contact_no"));
                        txtAddress.setText(resultSet.getString("address"));
                        txtJobTitle.setText(resultSet.getString("job_title"));
                        hiredDate.setDate(resultSet.getDate("hired_date"));
                        txtDepartment.setText(resultSet.getString("department"));
                        txtStatus.setText(resultSet.getString("employee_status"));
                        txtBasicSalary.setText(String.valueOf(resultSet.getDouble("basic_salary")));
                        txtAllowances.setText(String.valueOf(resultSet.getDouble("allowances")));
                        txtDeductions.setText(String.valueOf(resultSet.getDouble("deductions")));
                        txtNetSalary.setText(String.valueOf(resultSet.getDouble("net_salary")));
                    } else {
                        JOptionPane.showMessageDialog(managerDashboardPanel, "Invalid Employee ID");
                    }
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(managerDashboardPanel, "Please enter Employee ID to search");
                } catch (SQLException exception) {
                    throw new RuntimeException(exception);
                }
            }
        });

        // Handle Clear Button
        btnClear.addActionListener(event -> {
            clearText();
        });

        // Handle Back Button
        btnBack.addActionListener(event ->{
            new Login();
            this.dispose();
        });
        // Handle Attendance Button
        btnAttendance.addActionListener(event -> {
            new AttendanceDisplay();
            dispose();
        });
    }
    public void clearText() {
        txtFirstName.setText("");
        txtLastName.setText("");
        txtEmail.setText("");
        txtEmployeeID.setText("");
        txtContactNo.setText("");
        txtAddress.setText("");
        txtJobTitle.setText("");
        txtDepartment.setText("");
        txtStatus.setText("");
        txtBasicSalary.setText("");
        txtAllowances.setText("");
        txtDeductions.setText("");
        txtNetSalary.setText("");
        txtSearchEmployee.setText("Enter Employee ID");
        dobDate.setDate(null);
        hiredDate.setDate(null);
        gender.setSelectedIndex(-1);
    }
}
