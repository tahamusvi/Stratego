package stratego;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import stratego.Frame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class valueFrame extends JFrame {
	Frame parentFrame;
    private JButton[] buttons;
    private JLabel[] labels;

    public valueFrame(Frame parentFrame) {
        super("set value");
        this.parentFrame=parentFrame;

       
        setLayout(new GridLayout(6, 4));

        buttons = new JButton[12];
        labels = new JLabel[12];

        designFrame();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void designFrame() {
        for (int i = 0; i < 12; i++) {
            JPanel panel1 = new JPanel(new BorderLayout());
            JPanel panel2 = new JPanel(new BorderLayout());

            labels[i] = new JLabel("Label " + (i + 1));
            buttons[i] = new JButton("select");
            buttons[i].addActionListener(new ButtonClickListener());

            panel1.add(labels[i], BorderLayout.WEST);
            panel2.add(buttons[i], BorderLayout.CENTER);

            add(panel1);
            add(panel2);
        }
        
        labels[1].setText("taha");
        String test = labels[6].getText();
        System.out.println(test);
    }
    
    
    
    static class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String buttonText = button.getText();
            System.out.println("Button " + buttonText + " pressed.");
        }
    }
}















//public class valueFrame extends JFrame {
//    private JButton[][] buttons;
//    Frame parentFrame;
//    
//    public valueFrame(Frame parentFrame) {
//    	
//        super("Custom Frame");
//        this.parentFrame=parentFrame;
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(new GridLayout(6, 2));
//
//        buttons = new JButton[6][2];
//
//        designFrame();
//
//        pack();
//        setLocationRelativeTo(null);
//        setVisible(true);
//    }
//
//    private void designFrame() {
//        for (int i = 0; i < 6; i++) {
//            for (int j = 0; j < 2; j++) {
//                JPanel panel = new JPanel(new BorderLayout());
//
//                JButton button = new JButton("Button " + (i * 2 + j + 1));
//                button.addActionListener(new ButtonClickListener());
//
//                JLabel label = new JLabel("Label " + (i * 2 + j + 1), SwingConstants.CENTER);
//
//                panel.add(button, BorderLayout.CENTER);
//                panel.add(label, BorderLayout.NORTH);
//
//                buttons[i][j] = button;
//                add(panel);
//            }
//        }
//    }
//    static class ButtonClickListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            JButton button = (JButton) e.getSource();
//            String buttonText = button.getText();
//            System.out.println("Button " + buttonText + " pressed.");
//        }
//    }
//
//    
//}




