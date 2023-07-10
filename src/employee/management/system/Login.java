package employee.management.system;

import employee.management.system.utils.CreateButton;
import employee.management.system.utils.CreateLabel;
import employee.management.system.utils.CreateTextField;
import employee.management.system.utils.SetDefaults;
import java.sql.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    private CreateLabel lblusername;
    private CreateLabel lblpassword;

    private CreateTextField tfusername;
    private CreateTextField tfpassword;

    private CreateButton login;

    private int fontSize = 20;

    private int labelX = 40;
    private int labelY = 20;
    private int labelWidth = 100;
    private int labelHeight = 30;

    private int textFieldX = 150;
    private int textFieldY = 20;
    private int textFieldWidth = 150;
    private int textFieldHeight = 30;

    private int buttonX = 150;
    private int buttonY = 140;
    private int buttonWidth = 150;
    private int buttonHeight = 30;

    Login() {
        SetDefaults.setDefaultProperties(this, Color.WHITE, 1170, 650, true);
        SetDefaults.setVisible(this, true);

        lblusername = new CreateLabel("Username", labelX, labelY, labelWidth, labelHeight, fontSize);
        add(lblusername.getLabel());

        tfusername = new CreateTextField(textFieldX, textFieldY, textFieldWidth, textFieldHeight, fontSize);
        add(tfusername.getTextField());

        lblpassword = new CreateLabel("Password", labelX, labelY + 50, labelWidth, labelHeight, fontSize);
        add(lblpassword.getLabel());

        tfpassword = new CreateTextField(textFieldX, textFieldY + 50, textFieldWidth, textFieldHeight, fontSize);
        add(tfpassword.getTextField());

        login = new CreateButton("LOGIN", buttonX, buttonY, buttonWidth, buttonHeight, fontSize);
        login.getButton().addActionListener(this);
        add(login.getButton());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            String username = tfusername.getTextField().getText();
            String password = tfpassword.getTextField().getText();
            System.out.println(username);
            System.out.println(password);
            Conn connection = new Conn();
            String query = "select * from login where username = '" + username + "' and password = '" + password + "'";

            ResultSet rs = connection.statement.executeQuery(query);

            if (rs.next()) {
                SetDefaults.setVisible(this, false);
                new Home();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                SetDefaults.setVisible(this, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
