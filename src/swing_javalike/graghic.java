package swing_javalike ;

import javax.swing.*;

public class graghic {
    public static void main(String[] args) {
        JFrame f = new JFrame("Label Example");
//        f.setBackground(java.awt.color.ICC_ProfileRGB());
        JLabel l1;
        l1 = new JLabel(new ImageIcon("download.jpg"));
        l1.setBounds(0, 0, 100, 200);
        f.add(l1);
        f.setSize(1000, 1000);
        f.setLayout(null);
        f.setVisible(true);
    }
}