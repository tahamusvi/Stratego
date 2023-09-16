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
        Button[][] buttons = new Button[10][10];
        for (int i = 0; i < 10; i++) {
        	for (int j = 0; j < 10; j++) {
            JButton button = new JButton(String.valueOf(i));
            if(i==4 && (j==2|| j==3 || j==7 || j== 8)|| i==5 &&(j==2|| j==3 || j==7 || j== 8))
            {	
            	button.setEnabled(false);
            }
            else 
            {
            	button.addActionListener(new ButtonClickListener());
			}
            if(i==6&&(j==0||j==1||j==2||j==3||j==4||j==5||j==6||j==7||j==8||j==9)||
            		i==7&&(j==0||j==1||j==2||j==3||j==4||j==5||j==6||j==7||j==8||j==9)||
            		i==8&&(j==0||j==1||j==2||j==3||j==4||j==5||j==6||j==7||j==8||j==9)||
            		i==9&&(j==0||j==1||j==2||j==3||j==4||j==5||j==6||j==7||j==8||j==9))
            {
            	button.setBackground(Color.red);
            }
            else if(i==4&&(j==0||j==1||j==2||j==3||j==4||j==5||j==6||j==7||j==8||j==9)||
            		i==5&&(j==0||j==1||j==2||j==3||j==4||j==5||j==6||j==7||j==8||j==9))
            {
            	button.setBackground(Color.white);
			}
            
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
