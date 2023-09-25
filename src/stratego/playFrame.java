package stratego;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class playFrame extends JFrame implements ActionListener{
	public JButton[][] buttons;
    public core table;

    public playFrame() {

        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        buttons = new JButton[10][10];
        table = new core(10,10,"mors");//این ارگومان باید عوض شه از کاربر گرفته شه
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
                    button.addActionListener(this);
                }

                buttons[i][j] = button;
                buttonPanel.add(button);
            }
        }



        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j++) {
                buttons[i][j].setText("x");
            }
        }
        
        add(buttonPanel, BorderLayout.CENTER);

    }

    
    @Override
	public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            
			
            
                
            }
}
