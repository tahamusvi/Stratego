package graphic_test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame {
    public static void main(String[] args) {
    	
        JFrame frame = new JFrame("STRATEGO");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(10, 10));
        
        JButton[][] buttons = new JButton[10][10];
        
        for (int i = 0; i < 10; i++) {
        	for (int j = 0; j < 10; j++) {
            JButton button = new JButton("?");
            buttons[i][j]=button;
            
            
            if(i==6 ||i==7||i==8||i==9)
            {
            	button.setBackground(Color.red);
            }
            else if(i==4||i==5)
            {
            	button.setBackground(Color.white);
            	button.setText("");
			}
            if((i==4 || i==5) &&(j==2|| j==3 || j==7 || j== 8))
            {	
            	button.setEnabled(false);
            	button.setText("w");
            }
            else 
            {
            	button.addActionListener(new ButtonClickListener());
			}
            
            frame.add(button);
            
        	}
        		}
        for(int i=0;i<4;i++)
        {
        	for(int j=0;j<10;j++)
        	{
        		buttons[i][j].setText("x");
        	}
        }
        
       
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    static class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String buttonText = button.getText();
            if(buttonText=="?")
            {
            	String value = JOptionPane.showInputDialog(null,"Please Enter the button value", JOptionPane.INFORMATION_MESSAGE);
                button.setText(value);
            }
            else {
            	System.out.println("دکمه " + buttonText + " فشرده شد.");
			}
            
        }
    }
}


///////
    
//    import javax.swing.*;
//    import java.awt.*;
//    import java.awt.event.ActionEvent;
//    import java.awt.event.ActionListener;
//
//    public class FlagGame {
//        public static void main(String[] args) {
//            JFrame frame = new JFrame("فتح پرچم");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.setLayout(new GridLayout(10, 10));
//
//            JButton[][] buttons = new JButton[10][10]; // آرایه‌ای از دکمه‌ها برای دسترسی به هر خانه
//
//            for (int i = 0; i < 10; i++) {
//                for (int j = 0; j < 10; j++) {
//                    JButton button = new JButton();
//                    button.addActionListener(new ButtonClickListener());
//
//                    // اینجا می‌توانید شرطی را بررسی کنید که آیا خانه حاوی آب است یا خیر
//                    boolean hasWater = isCellHasWater(i, j); // تابعی که برای بررسی حالت آب در هر خانه استفاده می‌شود
//
//                    if (hasWater) {
//                        button.setEnabled(false); // غیرفعال کردن دکمه برای خانه‌های حاوی آب
//                    } else {
//                        button.setBackground(Color.RED); // تغییر رنگ دکمه برای خانه‌هایی که حاوی آب نیستند
//                    }
//
//                    buttons[i][j] = button;
//                    frame.add(button);
//                }
//            }
//
//            frame.setSize(500, 500);
//            frame.setVisible(true);
//        }
//
//        static class ButtonClickListener implements ActionListener {
//            public void actionPerformed(ActionEvent e) {
//                JButton button = (JButton) e.getSource();
//                // اینجا می‌توانید کد مربوط به عملیاتی که باید روی دکمه اجرا شود را اضافه کنید
//                System.out.println("دکمه فشرده شد.");
//            }
//        }
//
//        // تابعی برای بررسی حالت آب در هر خانه
//        static boolean isCellHasWater(int row, int col) {
//            // در اینجا می‌توانید شرایط خاصی را برای تشخیص حالت آب در هر خانه بررسی کنید و مقدار مناسب را برگردانید
//            // مثلاً در اینجا مقادیر را به طور تصادفی تعیین می‌کنیم
//            return Math.random() < 0.2; // با احتمال 20�خانه حاوی آب است
//        }
//    }
