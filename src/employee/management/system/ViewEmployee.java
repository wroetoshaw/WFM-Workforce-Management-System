package employee.management.system;

import employee.management.system.Conn;
import employee.management.system.Home;
import employee.management.system.utils.SetDefaults;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ViewEmployee extends JFrame implements ActionListener{

    JTable table;
    Choice cemployeeId;
    JButton search, print, update, back;
    
    public ViewEmployee() {
        
        SetDefaults.setDefaultProperties(this, Color.WHITE, 1170, 650, true);
        SetDefaults.setVisible(this,true);
        
        JLabel searchlbl = new JLabel("Search by Employee Id");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);
        
        cemployeeId = new Choice();
        cemployeeId.setBounds(180, 20, 150, 20);
        add(cemployeeId);
        
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.statement.executeQuery("select * from details");
            while(rs.next()) {
                cemployeeId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("select * from details");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(25, 100, getWidth()-50 , 600);
        add(jsp);

        
        
        
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from details where empId = '"+cemployeeId.getSelectedItem()+"'";
            try {
                Conn conn = new Conn();
                ResultSet rs = conn.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == update) {
                    SetDefaults.setVisible(this,false);
            new UpdateEmployee(cemployeeId.getSelectedItem());
        } else {
                    SetDefaults.setVisible(this,false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new ViewEmployee();
    }
}
