package EmployeePayrollSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login extends JFrame {
    JTextField txtEmployeeID;
    JPasswordField txtPasswordField;
    JLabel labelEmployeeID, labelPasswordField, labelHeading, labelProject;
    JButton btnLogin, btnCreateAccount;
    JPanel loginPanel, headingPanel;
    public Login() {
        Font labelFont = new Font("Arial", Font.BOLD, 18);
        Font font = new Font("Arial",Font.PLAIN, 18);
        Font headingFont = new Font("Arial", Font.BOLD, 30);

        // Employee ID Label
        labelEmployeeID = new JLabel("Employee ID: ");
        labelEmployeeID.setFont(labelFont);

        // Password Label
        labelPasswordField = new JLabel("Password: ");
        labelPasswordField.setFont(labelFont);

        // Heading Label
        labelHeading = new JLabel("Login to continue");
        labelHeading.setFont(headingFont);

        // Project Name Label
        labelProject = new JLabel("Employee Management");
        labelProject.setFont(headingFont);

        // Employee ID TextField
        txtEmployeeID = new JTextField();
        txtEmployeeID.setFont(font);
        txtEmployeeID.setPreferredSize(new Dimension(200, 24));

        // Password TextField
        txtPasswordField = new JPasswordField();
        txtPasswordField.setFont(font);
        txtPasswordField.setPreferredSize(new Dimension(200, 24));

        // Login Button
        btnLogin = new JButton("Login");
        btnLogin.setFont(labelFont);

        // Create Account Button
        btnCreateAccount = new JButton("Create Account");
        btnCreateAccount.setFont(labelFont);

        // Heading Panel
        headingPanel = new JPanel();
        headingPanel.setBounds(100, 50, 400, 100);
        headingPanel.setBackground(new Color(145, 194, 236));
        headingPanel.add(labelProject);
        headingPanel.add(labelHeading);

        // Login Panel
        loginPanel = new JPanel(new GridBagLayout());
        loginPanel.setBackground(new Color(145, 194, 236));
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(15, 15, 15, 15);
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        loginPanel.add(labelEmployeeID, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        loginPanel.add(txtEmployeeID, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        loginPanel.add(labelPasswordField, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        loginPanel.add(txtPasswordField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        loginPanel.add(btnLogin, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        loginPanel.add(btnCreateAccount, gridBagConstraints);

        // Login Frame
        add(headingPanel, BorderLayout.CENTER);
        add(loginPanel, BorderLayout.CENTER);
        setTitle("Login");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        btnLogin.addActionListener(e -> {
            // Get Text from TextField
            String employee_id_text = txtEmployeeID.getText().trim();
            String password = new String(txtPasswordField.getPassword()).trim();

            // Check whether TextField is empty or not
            if(employee_id_text.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(loginPanel, "Please fill all details");
            } else {
                try{
                    int employee_id = Integer.parseInt(employee_id_text);
                    LoginService loginService = new LoginService();
                    String userType = loginService.authenticate(employee_id, password);
                    if(userType != null) {
                        JOptionPane.showMessageDialog(loginPanel, "Login Successful");
                    } else {
                        JOptionPane.showMessageDialog(loginPanel, "Please enter correct Employee ID or Password");
                    }
                    try{
                        assert userType != null;
                        if(userType.equals("Manager")){
                        new ManagerDashboard();
                        dispose();
                    } else if (userType.equals("Employee")) {
                        new EmployeeDashboard();
                        this.dispose();
                    }
                    }catch (NullPointerException exception){
                        System.out.println(exception.getMessage());
                    }
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(loginPanel, "Employee ID must be a number");
                }
            }
        });

        btnCreateAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreateAccount();
                dispose();
            }
        });
    }
}

