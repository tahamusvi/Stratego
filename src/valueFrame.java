package graphic_test;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import graphic_test.Frame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class valueFrame extends JFrame {
    private JButton[][] buttons;
    Frame parentFrame;
    
    public valueFrame(Frame parentFrame) {
    	
        super("Custom Frame");
        this.parentFrame=parentFrame;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        buttons = new JButton[6][2];

        designFrame();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void designFrame() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 2; j++) {
                JButton button = new JButton("Button " + (i * 2 + j + 1));
                button.addActionListener(new ButtonClickListener());
                buttons[i][j] = button;
                add(button);
            }
        }
    }

    static class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String buttonText = button.getText();
            System.out.println("Button " + buttonText + " pressed.");
        }
    }

    
}




//public class valueFrame extends JFrame{
//	Frame parentFrame;
//	
//	public valueFrame(Frame parentFrame) 
//	{
//		this.parentFrame=parentFrame;
//	}
//	
//	
//}
