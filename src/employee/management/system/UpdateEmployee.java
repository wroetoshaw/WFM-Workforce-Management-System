package employee.management.system;

import employee.management.system.Conn;
import employee.management.system.Home;
import employee.management.system.utils.SetDefaults;
import employee.management.system.utils.CreateLabel;
import employee.management.system.utils.CreateTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateEmployee extends JFrame implements ActionListener {

    CreateTextField tfeducation, tffname, tfaddress, tfphone, tfemail, tfsalary, tfdesignation;
    CreateLabel lblempId;
    JButton add, back;
    String empId;
    private int fontSize = 20;
    public UpdateEmployee(String empId) {
        this.empId = empId;

        SetDefaults.setDefaultProperties(this, Color.WHITE, 1170, 650, true);

        CreateLabel heading = new CreateLabel("Update Employee Detail", 320, 30, 500, 50, fontSize);
        add(heading.getLabel());

        CreateLabel labelname = new CreateLabel("Name", 50, 150, 150, 30, fontSize);
        add(labelname.getLabel());

        CreateLabel lblname = new CreateLabel("", 200, 150, 150, 30, fontSize);
        add(lblname.getLabel());

        CreateLabel labelfname = new CreateLabel("Father's Name", 400, 150, 150, 30, fontSize);
        add(labelfname.getLabel());

        tffname = new CreateTextField(600, 150, 150, 30,fontSize);
        add(tffname.getTextField());

        CreateLabel labeldob = new CreateLabel("Date of Birth", 50, 200, 150, 30, fontSize);
        add(labeldob.getLabel());

        CreateLabel lbldob = new CreateLabel("", 200, 200, 150, 30, fontSize);
        add(lbldob.getLabel());

        CreateLabel labelsalary = new CreateLabel("Salary", 400, 200, 150, 30, fontSize);
        add(labelsalary.getLabel());

        tfsalary = new CreateTextField(600, 200, 150, 30,fontSize);
        add(tfsalary.getTextField());

        CreateLabel labeladdress = new CreateLabel("Address", 50, 250, 150, 30, fontSize);
        add(labeladdress.getLabel());

        tfaddress = new CreateTextField(200, 250, 150, 30,fontSize);
        add(tfaddress.getTextField());

        CreateLabel labelphone = new CreateLabel("Phone", 400, 250, 150, 30, fontSize);
        add(labelphone.getLabel());

        tfphone = new CreateTextField(600, 250, 150, 30,fontSize);
        add(tfphone.getTextField());

        CreateLabel labelemail = new CreateLabel("Email", 50, 300, 150, 30, fontSize);
        add(labelemail.getLabel());

        tfemail = new CreateTextField(200, 300, 150, 30,fontSize);
        add(tfemail.getTextField());

        CreateLabel labeleducation = new CreateLabel("Highest Education", 400, 300, 150, 30, fontSize);
        add(labeleducation.getLabel());

        tfeducation = new CreateTextField(600, 300, 150, 30,fontSize);
        add(tfeducation.getTextField());

        CreateLabel labeldesignation = new CreateLabel("Designation", 50, 350, 150, 30, fontSize);
        add(labeldesignation.getLabel());

        tfdesignation = new CreateTextField(200, 350, 150, 30,fontSize);
        add(tfdesignation.getTextField());

CreateLabel labelaadhar = new CreateLabel("Aadhar Number", 400, 350, 150, 30, fontSize);
        add(labelaadhar.getLabel());

        CreateLabel lblaadhar = new CreateLabel("", 600, 350, 150, 30, fontSize);
        add(lblaadhar.getLabel());

        CreateLabel labelempId = new CreateLabel("Employee id", 50, 400, 150, 30, fontSize);
        add(labelempId.getLabel());

        lblempId = new CreateLabel("", 200, 400, 150, 30, fontSize);
        add(lblempId.getLabel());

        try {
            Conn c = new Conn();
            String query = "select * from details where empId = '" + empId + "'";
            ResultSet rs = c.statement.executeQuery(query);
            if (rs.next()) {
                lblname.getLabel().setText(rs.getString("name"));
tffname.getTextField().setText(rs.getString("fname"));
lbldob.getLabel().setText(rs.getString("dob"));
tfaddress.getTextField().setText(rs.getString("address"));
tfsalary.getTextField().setText(rs.getString("salary"));
tfphone.getTextField().setText(rs.getString("phone"));
tfemail.getTextField().setText(rs.getString("email"));
tfeducation.getTextField().setText(rs.getString("education"));
lblaadhar.getLabel().setText(rs.getString("aadhar"));
lblempId.getLabel().setText(rs.getString("empId"));
tfdesignation.getTextField().setText(rs.getString("designation"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        add = new JButton("Update Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        add(back);

    }


    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String fname = tffname.getTextField().getText();
String salary = tfsalary.getTextField().getText();
String address = tfaddress.getTextField().getText();
String phone = tfphone.getTextField().getText();
String email = tfemail.getTextField().getText();
String education = tfeducation.getTextField().getText();
String designation = tfdesignation.getTextField().getText();


            try {
                Conn conn = new Conn();
                String query = "update details set fname = '" + fname + "', salary = '" + salary + "', address = '" + address + "', phone = '" + phone + "', email =  '" + email + "', education = '" + education + "', designation = '" + designation + "' where empId = '" + empId + "'";
                conn.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                SetDefaults.setVisible(this, false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            SetDefaults.setVisible(this, false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}
