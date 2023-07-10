package employee.management.system.utils;

import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Color;

public class CreateTextField extends JFrame {
    private JTextField textField;

    public CreateTextField(int x, int y, int width, int height, int fontSize) {
        textField = new JTextField();
        textField.setBounds(x, y, width, height);
        textField.setFont(new Font("serif", Font.PLAIN, fontSize));
        textField.setForeground(Color.BLACK);
        add(textField);
    }

    public JTextField getTextField() {
        return textField;
    }
    
    
    
}
