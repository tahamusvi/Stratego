package graphic_test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    private JButton[][] buttons;

    public Frame() {
        super("STRATEGO");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        buttons = new JButton[10][10];

        designFrame();
        
        pack();
        setVisible(true);
    }

    private void designFrame() {
        JPanel buttonPanel = new JPanel(new GridLayout(11, 10));

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                JButton button = new JButton("?");

                if (i == 6 || i == 7 || i == 8 || i == 9) {
                    button.setBackground(Color.red);
                } else if (i == 4 || i == 5) {
                    button.setBackground(Color.white);
                    button.setText("");
                }

                if ((i == 4 || i == 5) && (j == 2 || j == 3 || j == 6 || j == 7)) {
                    button.setEnabled(false);
                    button.setText("w");
                } else {
                    button.addActionListener(new ButtonClickListener());
                }

                buttons[i][j] = button;
                buttonPanel.add(button);
            }
        }

        JPanel submitPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ButtonClickListener());
        submitPanel.add(submitButton);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j++) {
                buttons[i][j].setText("x");
            }
        }
        
        add(buttonPanel, BorderLayout.CENTER);
        add(submitPanel, BorderLayout.SOUTH);
    }

    static class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String buttonText = button.getText();

            if (buttonText.equals("?")) {
                String value = JOptionPane.showInputDialog(null, "Please enter the button value", JOptionPane.INFORMATION_MESSAGE);
                button.setText(value);
            } else if (!buttonText.equals("x")) {
                int selectedMode = JOptionPane.showConfirmDialog(null, "Do you want to change the value of the button?");
                if (selectedMode == JOptionPane.YES_OPTION) {
                    String value = JOptionPane.showInputDialog(null, "Please enter the button value", JOptionPane.INFORMATION_MESSAGE);
                    button.setText(value);
                } else {
                    System.out.println("دکمه " + buttonText + " فشرده شد.");
                }
            }
        }
    }

    public static void main(String[] args) {
        new Frame();
    }
}







//public class Frame extends JFrame {
//    private JButton[][] buttons;
//
//    public Frame() {
//        super("STRATEGO");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(new GridLayout(11, 10));
//
//        buttons = new JButton[10][10];
//
//        designFrame();
//
//        setSize(800, 550);
//        setVisible(true);
//    }
//
//    private void designFrame() {
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                JButton button = new JButton("?");
//
//                if (i == 6 || i == 7 || i == 8 || i == 9) {
//                    button.setBackground(Color.red);
//                } else if (i == 4 || i == 5) {
//                    button.setBackground(Color.white);
//                    button.setText("");
//                }
//
//                if ((i == 4 || i == 5) && (j == 2 || j == 3 || j == 7 || j == 8)) {
//                    button.setEnabled(false);
//                    button.setText("w");
//                } else {
//                    button.addActionListener(new ButtonClickListener());
//                }
//
//                buttons[i][j] = button;
//                add(button);
//            }
//        }
//
//        JButton submitButton = new JButton("Submit");
//        submitButton.addActionListener(new ButtonClickListener());
//        add(submitButton);
//
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 10; j++) {
//                buttons[i][j].setText("x");
//            }
//        }
//    }
//
//    static class ButtonClickListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            JButton button = (JButton) e.getSource();
//            String buttonText = button.getText();
//
//            if (buttonText.equals("?")) {
//                String value = JOptionPane.showInputDialog(null, "Please enter the button value", JOptionPane.INFORMATION_MESSAGE);
//                button.setText(value);
//            } else if (!buttonText.equals("x")) {
//                int selectedMode = JOptionPane.showConfirmDialog(null, "Do you want to change the value of the button?");
//                if (selectedMode == JOptionPane.YES_OPTION) {
//                    String value = JOptionPane.showInputDialog(null, "Please enter the button value", JOptionPane.INFORMATION_MESSAGE);
//                    button.setText(value);
//                } else {
//                    System.out.println("دکمه " + buttonText + " فشرده شد.");
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        new Frame();
//    }
//}

