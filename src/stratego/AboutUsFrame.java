package stratego;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class AboutUsFrame extends JFrame {
	private JTextArea textArea;
    private JButton person1Button;
    private JButton person2Button;

    public AboutUsFrame() {
        setTitle("About Us");
        setSize(370, 260);
        setLayout(new FlowLayout());

        		textArea = new JTextArea(
                "Sahel and Taha created this game\n" +
                "for their final project in the CS50 course.\n" +
                "Taha worked on the core part,\n" +
                "while Sahel worked on the GUI.\n" +
                "You can play this game,\n" +
                "and if you're interested in seeing more of our projects,\n" +
                "you can visit our GitHub page,\n" +
                "which is linked below."
            );
        		textArea.setEditable(false);
                textArea.setWrapStyleWord(true);
                
        person1Button = new JButton("sahel github");
        person2Button = new JButton("taha github");
        
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        
        panel1.add(textArea);
        panel2.add(person1Button);
        panel2.add(person2Button);
        
        add(panel1);
        add(panel2);
        

        person1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openWebPage("https://github.com/Seyedsahel");
            }
        });

        person2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openWebPage("https://github.com/TahaM8000");
            }
        });
    }

    private void openWebPage(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    
}