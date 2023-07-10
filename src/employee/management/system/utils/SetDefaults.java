package employee.management.system.utils;

import java.awt.Color;
import javax.swing.JFrame;

public class SetDefaults {
    public static void setDefaultProperties(JFrame frame, Color color, int width, int height, boolean visible) {
        frame.getContentPane().setBackground(color);
        frame.setLayout(null);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(visible);
    }

    public static void setVisible(JFrame frame, boolean b) {
        frame.setVisible(b);
    }
}
