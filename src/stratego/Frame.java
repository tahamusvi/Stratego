package stratego;

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener{
    public JButton[][] buttons;
    public core table;

    public Frame() {
        super("STRATEGO");
        
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
                    button.setEnabled(false);
                    button.setText("");
                }
                else {
                	 button.setEnabled(false);
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

        JPanel submitPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        submitPanel.add(submitButton);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j++) {
                buttons[i][j].setText("x");
            }
        }
        
        add(buttonPanel, BorderLayout.CENTER);
        add(submitPanel, BorderLayout.SOUTH);
    }

   
    @Override
	public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            if(button.getText()=="Submit")
            {
            	if(!table.getPlayer().isRemain()) {
            	 Object[] options = {"start play", "save values", "cancel"};
                 
                 int choice = JOptionPane.showOptionDialog(
                     null,
                     "what do you want to do?",
                     "submit",
                     JOptionPane.YES_NO_CANCEL_OPTION,
                     JOptionPane.QUESTION_MESSAGE,
                     null,
                     options,
                     options[2]
                 );
                 if (choice == JOptionPane.YES_OPTION) {
                     System.out.println("شما گزینه بازی را انتخاب کردید.");
                     playFrame newplayFrame = new playFrame();
                     this.dispose();
                 } else if (choice == JOptionPane.NO_OPTION) {
                     System.out.println("شما گزینه سیو را انتخاب کردید.");
                     table.writeTxt();
                 } else if (choice == JOptionPane.CANCEL_OPTION) {
                     System.out.println("شما گزینه لغو را انتخاب کردید.");
                 }
            	}
            	else {
					JOptionPane.showMessageDialog(null, "set value of all the buttons");
				}
            }
            
            
            else {
            	for(int i=0;i<10;i++)
                {
                	for(int j=0;j<10;j++)
                	{
                		if(this.buttons[i][j].getText()=="click")
                		{
                			this.buttons[i][j].setText("?");
                		}
                	}
                }
                if(button.getText()=="?")
                {
                	button.setText("click");
                }
                else {
    				this.table.decreacePieceAmount(button.getText());
    				button.setText("click");
    			}

                    valueFrame newvalFrame=new valueFrame(this);
                    newvalFrame.setVisible(true);
                    this.setEnabled(false);
			}
            
                
            }
        
    

    public static void main(String[] args) {
        new Frame();
    }
}




