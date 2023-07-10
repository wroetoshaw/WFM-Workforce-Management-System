package employee.management.system;

import employee.management.system.utils.SetDefaults;
import employee.management.system.utils.CreateLabel;
import employee.management.system.utils.CreateButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {
    
    private CreateButton addButton, viewButton, updateButton, removeButton;
    private CreateLabel heading;
    private int fontSize = 20;

    public Home() {
        SetDefaults.setDefaultProperties(this, Color.WHITE, 1170, 650, true);
        SetDefaults.setVisible(this, true);
        
        initializeUI();
        addComponentListener(new ResizeListener());
    }
    
    private void initializeUI() {
        heading = new CreateLabel("Employee Management System", 220, 30, 1200, 60, fontSize);
        heading.setForeground(Color.BLACK);
        add(heading.getLabel());
        
        addButton = new CreateButton("Add Employee", 650, 80, 150, 40, fontSize);
        addButton.getButton().addActionListener(this);
        add(addButton.getButton());
        
        viewButton = new CreateButton("View Employees", 820, 80, 150, 40, fontSize);
        viewButton.getButton().addActionListener(this);
        add(viewButton.getButton());
        
        updateButton = new CreateButton("Update Employee", 650, 140, 150, 40, fontSize);
        updateButton.getButton().addActionListener(this);
        add(updateButton.getButton());
        
        removeButton = new CreateButton("Remove Employee", 820, 140, 150, 40, fontSize);
        removeButton.getButton().addActionListener(this);
        add(removeButton.getButton());
    }
    
    private void resize() {
        int fontSize = Math.min(getWidth() / 15, getHeight() / 15);
        heading.setFont(new Font("serif", Font.PLAIN, fontSize));
        
        int x = (getWidth() - heading.getPreferredSize().width) / 2;
        heading.setBounds(x, 30, heading.getPreferredSize().width, 60);
    }
    
    private class ResizeListener extends ComponentAdapter {
        @Override
        public void componentResized(ComponentEvent e) {
            resize();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addButton.getButton()) {
            SetDefaults.setVisible(this, false);
            new AddEmployee();
        } else if (ae.getSource() == viewButton.getButton()) {
            SetDefaults.setVisible(this, false);
            new ViewEmployee();
        } else if (ae.getSource() == updateButton.getButton()) {
            SetDefaults.setVisible(this, false);
            new ViewEmployee();
        } else if (ae.getSource() == removeButton.getButton()) {
            SetDefaults.setVisible(this, false);
            new RemoveEmployee();
        }
    }
    
    public static void main(String args[]) {
        new Home();
    }
}
