/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system.utils;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author wroetoshaw
 */
public class CreateButton extends JFrame {
    private JButton button;
    public CreateButton(String text, int x, int y, int width, int height, int fontSize) {
    button = new JButton(text);
    button.setBounds(x, y, width, height);
    button.setBackground(Color.BLACK);
    button.setForeground(Color.WHITE);
    button.setFont(new Font("serif", Font.PLAIN, fontSize)); // Set the font size
}

    
    public static void main(String args[]){
        
    }

    public JButton getButton(){
    return button;
}


}
