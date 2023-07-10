package employee.management.system;

import employee.management.system.utils.CreateLabel;
import employee.management.system.utils.CreateButton;
import employee.management.system.utils.SetDefaults;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener {
    private CreateLabel heading;
    private CreateButton clickhere;
    public Splash() {
        SetDefaults.setDefaultProperties(this, Color.WHITE, 1170, 650, true);
        SetDefaults.setVisible(this,true);

        initializeUI();
        addComponentListener(new ResizeListener());
    }

    private void initializeUI() {
        String headings = "EMPLOYEE MANAGEMENT SYSTEM";
        String buttonTitle = "Click to Continue";

        heading = new CreateLabel(headings, 220, 30, 1200, 60, 20);
        heading.setForeground(Color.BLACK);
        add(heading.getLabel());

        clickhere = new CreateButton(buttonTitle, 400, 400, 300, 70, 20);
        clickhere.getButton().addActionListener(this);
        add(clickhere.getButton());
        
        resize();

    }

 private void resize() {
    int fontSize = Math.min(getWidth() / 15, getHeight() / 15);
    Font labelFont = new Font("serif", Font.PLAIN, fontSize);
    heading.getLabel().setFont(labelFont);
    
    int labelWidth = heading.getLabel().getPreferredSize().width;
    int labelX = (getWidth() - labelWidth) / 2;
    int labelY = 30;
    
    System.out.println(labelX + " "+ labelY);
    heading.getLabel().setBounds(labelX, labelY, labelWidth, 60);

    int buttonHeight = clickhere.getButton().getPreferredSize().height;
    int buttonY = (getHeight() - buttonHeight) / 2 + getHeight() / 6;
    int buttonWidth = 300;
    int buttonX = (getWidth() - buttonWidth) / 2;
    clickhere.getButton().setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
}




    @Override
    public void actionPerformed(ActionEvent ae) {
        SetDefaults.setVisible(this,false);
        new Login();
    }

    private class ResizeListener extends ComponentAdapter {
        @Override
        public void componentResized(ComponentEvent e) {
            resize();
        }
    }

    public static void main(String args[]) {
        new Splash();
    }
}
