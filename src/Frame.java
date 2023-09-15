package graphic_test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("فتح پرچم");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(10, 10));

        for (int i = 1; i <= 100; i++) {
            JButton button = new JButton(String.valueOf(i));
            if(i==43 || i==44 || i==47 ||i==48 || i==53 || i==54 || i==57 || i==58 )
            {
            	button.setEnabled(false);
            }
            else {
            	button.addActionListener(new ButtonClickListener());
                frame.add(button);
			}
            
        }

        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    static class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String buttonText = button.getText();
            // اینجا می‌توانید کد مربوط به عملیاتی که باید روی دکمه اجرا شود را اضافه کنید
            System.out.println("دکمه " + buttonText + " فشرده شد.");
        }
    }
}


///////
