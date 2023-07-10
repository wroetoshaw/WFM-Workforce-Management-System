package employee.management.system;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import employee.management.system.Conn;
import employee.management.system.Home;
import employee.management.system.utils.SetDefaults;
import java.awt.event.*;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {

    Random ran = new Random();
    int number = ran.nextInt(999999);

    JTextField tfname, tffname, tfaddress, tfphone, tfaadhar, tfemail, tfsalary, tfdesignation;
    JDateChooser dcdob;
    JComboBox<String> cbeducation;
    JLabel lblempId;
    JButton add, back;

    public AddEmployee() {
        SetDefaults.setDefaultProperties(this, Color.WHITE, 1170, 650, true);
        SetDefaults.setVisible(this,true);

        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        createLabel("Name", 50, 150, 150, 30, 20);
        tfname = createTextField(200, 150, 150, 30);

        createLabel("Father's Name", 400, 150, 150, 30, 20);
        tffname = createTextField(600, 150, 150, 30);

        createLabel("Date of Birth", 50, 200, 150, 30, 20);
        dcdob = createDateChooser(200, 200, 150, 30);

        createLabel("Salary", 400, 200, 150, 30, 20);
        tfsalary = createTextField(600, 200, 150, 30);

        createLabel("Address", 50, 250, 150, 30, 20);
        tfaddress = createTextField(200, 250, 150, 30);

        createLabel("Phone", 400, 250, 150, 30, 20);
        tfphone = createTextField(600, 250, 150, 30);

        createLabel("Email", 50, 300, 150, 30, 20);
        tfemail = createTextField(200, 300, 150, 30);

        createLabel("Highest Education", 400, 300, 150, 30, 20);
        cbeducation = createComboBox(600, 300, 150, 30, new String[]{"BBA", "BCA", "BA", "BSC", "B.COM", "BTech", "MBA", "MCA", "MA", "MTech", "MSC", "PHD"});

        createLabel("Designation", 50, 350, 150, 30, 20);
        tfdesignation = createTextField(200, 350, 150, 30);

        createLabel("Aadhar Number", 400, 350, 150, 30, 20);
        tfaadhar = createTextField(600, 350, 150, 30);

        createLabel("Employee id", 50, 400, 150, 30, 20);
        lblempId = createLabel("" + number, 200, 400, 150, 30, 20);

        add = createButton("Add Details", 250, 550, 150, 40, 20);
        add.addActionListener(this);

        back = createButton("Back", 450, 550, 150, 40, 20);
        back.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = cbeducation.getSelectedItem().toString();
            String designation = tfdesignation.getText();
            String aadhar = tfaadhar.getText();
            String empId = lblempId.getText();

            try {
                Conn conn = new Conn();
                String query = "insert into details values('" + name + "', '" + fname + "', '" + dob + "', '" + salary + "', '" + address + "', '" + phone + "', '" + email + "', '" + education + "', '" + designation + "', '" + aadhar + "', '" + empId + "')";
                conn.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                        SetDefaults.setVisible(this,false);

                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
                    SetDefaults.setVisible(this,false);

            new Home();
        }
    }

    // Helper methods for creating components

    private JLabel createLabel(String text, int x, int y, int width, int height, int fontSize) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setFont(new Font("serif", Font.PLAIN, fontSize));
        add(label);
        return label;
    }

    private JTextField createTextField(int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        add(textField);
        return textField;
    }

    private JDateChooser createDateChooser(int x, int y, int width, int height) {
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(x, y, width, height);
        add(dateChooser);
        return dateChooser;
    }

    private JComboBox<String> createComboBox(int x, int y, int width, int height, String[] items) {
        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBox.setBackground(Color.WHITE);
        comboBox.setBounds(x, y, width, height);
        add(comboBox);
        return comboBox;
    }

    private JButton createButton(String text, int x, int y, int width, int height, int fontSize) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.addActionListener(this);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        add(button);
        return button;
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
