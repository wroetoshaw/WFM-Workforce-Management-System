package employee.management.system.utils;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class CreateLabel extends JFrame {
    
    private JLabel label;
    
    public CreateLabel(String text, int x, int y, int width, int height, int fontSize) {
        label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setFont(new Font("serif", Font.PLAIN, fontSize));
        label.setForeground(Color.BLACK);

        add(label);
    }
    
    public JLabel getLabel() {
        return label;
    }
}
