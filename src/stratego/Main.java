package stratego;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.security.PublicKey;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
		
		private JTextArea wellcomArea;
	    private JTextArea nameArea;
	    private JTextArea whoPickArea;
	    private JTextField nameField;
	    private JButton submitName;
	    private JButton user;
	    private JButton custom;
	    private JButton loud;
	    private JButton aboutUsButton;
	    public core table ;
	    public String username;

	    public Main() {
	        // تنظیمات فریم
	        setTitle("Game");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(400, 300);
	        setLayout(new FlowLayout());

	        // ایجاد اجزا
	        wellcomArea = new JTextArea("Welcome to our Game!");
	        nameArea = new JTextArea("Please enter your name (if you don't, we'll use 'user'):");
	        whoPickArea = new JTextArea("Who will pick?");
	        nameField = new JTextField(15);
	        submitName = new JButton("Submit");
	        user = new JButton("User");
	        custom = new JButton("Custom");
	        loud = new JButton("Loud");
	        aboutUsButton = new JButton("About Us!");

	        // اضافه کردن اجزا به فریم
	        add(wellcomArea);
	        add(nameArea);
	        add(nameField);
	        add(submitName);
	        add(user);
	        add(custom);
	        add(loud);
	        add(whoPickArea);
	        add(aboutUsButton);

	        // تنظیمات دکمه‌ها
	        submitName.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                 username = nameField.getText();
	                if (username.isEmpty()) {
	                    // اگر نام وارد نشده بود، از "user" استفاده می‌کنیم
	                	username = "user";
	                }
	                System.out.println("Submitted name: " + username);
	            }
	        });

	        user.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                //کدی که در صورت فشرده شدن دکمه "user" اجرا می‌شود
	            	table = new core(10,10,username,1);
	            	new pickFrame(table);
	            }
	        });

	        custom.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // کدی که در صورت فشرده شدن دکمه "custom" اجرا می‌شود
	            	table = new core(10,10,username,2);
	            	playFrame newplayFrame = new playFrame(table);
	            }
	        });

	        loud.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // کدی که در صورت فشرده شدن دکمه "loud" اجرا می‌شود
	            	table = new core(10,10,username,3);
	            	playFrame newplayFrame = new playFrame(table);
	            }
	        });

	        aboutUsButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // کدی که در صورت فشرده شدن دکمه "About Us!" اجرا می‌شود
	            }
	        });
	    }

	   
	
	
	
public static void main(String[] args) {
	
	 SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            Main frame = new Main();
             frame.setVisible(true);
         }
     });
}
}