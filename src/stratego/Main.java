package stratego;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.security.PublicKey;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
		
		private JLabel wellcomArea;
		private JLabel nameArea;
		private JLabel whoPickArea;
	    private JTextField nameField;
	    private JButton submitName;
	    private JButton user;
	    private JButton custom;
	    private JButton loud;
	    private JButton aboutUsButton;
	    public core table ;
	    public String username;

	    public Main() {

	    	setTitle("Stratego");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(320, 270);
	        setLayout(new FlowLayout());
	        setResizable(false);
	        this.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\progeramming\\stratego\\Stratego.png"));

	        wellcomArea = new JLabel("Welcome to our Game!");
	        nameArea = new JLabel("Please enter your name (if you don't, we'll use 'user'):");
	        whoPickArea = new JLabel("Who will pick?");
	        nameField = new JTextField(15);
	        submitName = new JButton("Submit");
	        user = new JButton("User");
	        custom = new JButton("Custom");
	        loud = new JButton("Loud");
	        aboutUsButton = new JButton("About Us!");

	        JPanel panel1 = new JPanel();
            JPanel panel2 = new JPanel();
            JPanel panel3 = new JPanel();
            JPanel panel4 = new JPanel(new BorderLayout());
            JPanel panel5 = new JPanel();
            JPanel panel6 = new JPanel();
            
	        panel1.add(wellcomArea);
	        panel2.add(nameArea);
	        panel3.add(nameField);
	        panel3.add(submitName);
	        panel4.add(whoPickArea);
	        panel5.add(user);
	        panel5.add(custom);
	        panel5.add(loud);
	        panel6.add(aboutUsButton);
	        
	        add(panel1);
            add(panel2);
            add(panel3);
            add(panel4);
            add(panel5);
            add(panel6);

	       
	        submitName.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                 username = nameField.getText();
	                if (username.isEmpty()) {
	                  
	                	username = "user";
	                }
	                System.out.println("Submitted name: " + username);
	            }
	        });

	        user.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	table = new core(10,10,username,1);
	            	new pickFrame(table);
	            	dispose();
	            }
	        });

	        custom.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	table = new core(10,10,username,2);
	            	playFrame newplayFrame = new playFrame(table);
	            	dispose();
	            }
	        });

	        loud.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	table = new core(10,10,username,3);
	            	playFrame newplayFrame = new playFrame(table);
	            	dispose();
	            }
	        });

	        aboutUsButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	AboutUsFrame newAboutUsFrame = new AboutUsFrame();
	            	newAboutUsFrame.setVisible(true);
	            }
	        });
	    }

	   
	
	
	
public static void main(String[] args) {
	
	 		Main frame = new Main();
             frame.setVisible(true);
         
}
}