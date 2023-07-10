package employee.management.system;

import employee.management.system.Conn;
import employee.management.system.Home;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveEmployee extends JFrame implements ActionListener {

    private Choice cEmpId;
    private JButton delete, back;
    private JLabel lblName, lblPhone, lblEmail;

    RemoveEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel labelempId = createLabel("Employee Id", 50, 50, 100, 30);
        add(labelempId);

        cEmpId = new Choice();
        cEmpId.setBounds(200, 50, 150, 30);
        add(cEmpId);

        try { 
            Conn c = new Conn(); 
            String query = "select * from details";
            ResultSet rs = c.statement.executeQuery(query);
            while (rs.next()) {
                cEmpId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        lblName = createLabel("Name", 50, 100, 100, 30);
        add(lblName);

        lblPhone = createLabel("Phone", 50, 150, 100, 30);
        add(lblPhone);

        lblEmail = createLabel("Email", 50, 200, 100, 30);
        add(lblEmail);

        updateEmployeeDetails();

        cEmpId.addItemListener((ItemEvent ie) -> {
            updateEmployeeDetails();
        });

        delete = createButton("Delete", 80, 300, 100, 30);
        delete.addActionListener(this);
        add(delete);

        back = createButton("Back", 220, 300, 100, 30);
        back.addActionListener(this);
        add(back);


        setSize(1170, 650);
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    private JLabel createLabel(String text, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        return label;
    }

    private JButton createButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        return button;
    }

    private void updateEmployeeDetails() {
        try {
            Conn c = new Conn();
            String query = "select * from details where empId = '" + cEmpId.getSelectedItem() + "'";
            ResultSet rs = c.statement.executeQuery(query);
            while (rs.next()) {
                lblName.setText(rs.getString("name"));
                lblPhone.setText(rs.getString("phone"));
                lblEmail.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try {
                Conn c = new Conn();
                String query = "delete from details where empId = '" + cEmpId.getSelectedItem() + "'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Information Deleted Successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
