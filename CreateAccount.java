package EmployeePayrollSystem;

import javax.swing.*;
import java.awt.*;
public class CreateAccount extends JFrame {
    JTextField txtFirstName, txtLastName, txtEmployeeID;
    JLabel labelEmployeeID, labelFirstName, labelLastName, labelPassword, labelHeading, labelProject, labelUserType;
    JPasswordField txtPassword;
    JCheckBox Employee, Manager;
    JButton btnCreateAccount, btnBack;
    JPanel createAccountPanel, headingPanel;
    public CreateAccount() {
        Font labelFont = new Font("Arial", Font.BOLD, 18);
        Font font = new Font("Arial", Font.BOLD, 20);
        Font headingFont = new Font("Arial", Font.BOLD, 25);

        // Project Label
        labelProject = new JLabel("Employee Management");
        labelProject.setFont(headingFont);

        // Heading Label
        labelHeading = new JLabel("Create Account");
        labelHeading.setFont(headingFont);

        // User Type Label
        labelUserType = new JLabel("Select User Type:");
        labelUserType.setFont(labelFont);

        // First Name Label
        labelFirstName = new JLabel("First Name: ");
        labelFirstName.setFont(labelFont);

        // Last Name Label
        labelLastName = new JLabel("Last Name: ");
        labelLastName.setFont(labelFont);

        // Employee ID Label
        labelEmployeeID=  new JLabel("Employee ID: ");
        labelEmployeeID.setFont(labelFont);

        // Password Label
        labelPassword = new JLabel("Password: ");
        labelPassword.setFont(labelFont);

        // First Name TextField
        txtFirstName = new JTextField();
        txtFirstName.setFont(font);
        txtFirstName.setPreferredSize(new Dimension(200, 24));

        // Last Name TextField
        txtLastName = new JTextField();
        txtLastName.setFont(font);
        txtLastName.setPreferredSize(new Dimension(200, 24));

        // Employee ID TextField
        txtEmployeeID = new JTextField();
        txtEmployeeID.setFont(font);
        txtEmployeeID.setPreferredSize(new Dimension(200, 24));

        // Password TextField
        txtPassword = new JPasswordField();
        txtPassword.setFont(font);
        txtPassword.setPreferredSize(new Dimension(200, 24));

        // Employee CheckBox
        Employee = new JCheckBox("Employee");
        Employee.setFont(font);

        // Manager CheckBox
        Manager = new JCheckBox("Manager");
        Manager.setFont(font);

        // Create Account Button
        btnCreateAccount = new JButton("Create Account");
        btnCreateAccount.setFont(labelFont);

        // Back Button
        btnBack = new JButton("Back");
        btnBack.setFont(labelFont);

        // Heading Panel
        headingPanel = new JPanel();
        headingPanel.setBounds(100, 30, 400, 70);
        headingPanel.setBackground(new Color(145, 194, 236));
        headingPanel.add(labelProject);
        headingPanel.add(labelHeading);

        // Create Account Panel
        createAccountPanel = new JPanel(new GridBagLayout());
        createAccountPanel.setBackground(new Color(145, 194, 236));
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        // Add User Type Label
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        createAccountPanel.add(labelUserType, gridBagConstraints);

        // Add Employee CheckBox
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        createAccountPanel.add(Employee, gridBagConstraints);

        // Add Manager CheckBox
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        createAccountPanel.add(Manager, gridBagConstraints);

        // Add First Name Label
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        createAccountPanel.add(labelFirstName, gridBagConstraints);

        // Add First Name TextField
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        createAccountPanel.add(txtFirstName, gridBagConstraints);

        // Add Last Name Label
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        createAccountPanel.add(labelLastName, gridBagConstraints);

        // Add Last Name TextField
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        createAccountPanel.add(txtLastName, gridBagConstraints);

        // Add Employee ID Label
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        createAccountPanel.add(labelEmployeeID, gridBagConstraints);

        // Add Employee ID TextField
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        createAccountPanel.add(txtEmployeeID, gridBagConstraints);

        // Add Password Label
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        createAccountPanel.add(labelPassword, gridBagConstraints);

        // Add Password TextField
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        createAccountPanel.add(txtPassword, gridBagConstraints);

        // Add Back Button
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        createAccountPanel.add(btnBack, gridBagConstraints);

        // Add Create Account Button
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        createAccountPanel.add(btnCreateAccount, gridBagConstraints);


        // Create Account Frame
        add(headingPanel, BorderLayout.CENTER);
        add(createAccountPanel, BorderLayout.CENTER);
        setTitle("Create Account");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        // Handle Back Button
        btnBack.addActionListener(e -> {
            new Login();
            dispose();
        });

        // Handle Create Account Button
        btnCreateAccount.addActionListener(e -> {
            // Get Text from TextFields
            String userType = "";
            String first_name = txtFirstName.getText().trim();
            String last_name = txtLastName.getText().trim();
            String employee_id_text = txtEmployeeID.getText().trim();
            String password = new String(txtPassword.getPassword()).trim();
            if (Employee.isSelected()) {
                userType = "Employee";
            } else if (Manager.isSelected()) {
                userType = "Manager";
            }
            // Check whether TextFields are empty or not
            if(first_name.isEmpty() || last_name.isEmpty() || password.isEmpty() || employee_id_text.isEmpty() || userType.isEmpty()) {
                JOptionPane.showMessageDialog(createAccountPanel, "Please fill all details");
            } else {
                try {
                    int employee_id = Integer.parseInt(employee_id_text);
                    CreateAccountService createAccountService = new CreateAccountService();
                    int[] result = createAccountService.createAccount(first_name, last_name, employee_id, userType, password);

                    for (int i = 0; i < result.length; i++) {
                        if(result[i] == 0) {
                            System.out.println("Query "+i+" not executed Successfully!");
                        }
                    }
                    System.out.println("All queries executed Successfully!");
                    JOptionPane.showMessageDialog(createAccountPanel, "Account Created Successfully");
                    new Login();
                    dispose();
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(createAccountPanel, "Employee ID must be a number");
                }
            }
        });
    }
}
