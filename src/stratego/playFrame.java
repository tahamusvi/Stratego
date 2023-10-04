package stratego;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class playFrame extends JFrame implements ActionListener{
	public JButton[][] buttons;
    public core table;
   
   

    public playFrame(core tableinput) {

    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        buttons = new JButton[10][10];
        table = tableinput;
        designFrame();
        
        pack();
        setVisible(true);
    }

    private void designFrame() {
        JPanel buttonPanel = new JPanel(new GridLayout(11, 10));

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                JButton button = new JButton("?");
                button.setText(table.getPieceNameOnMap(j, i));
                if (i == 6 || i == 7 || i == 8 || i == 9) {
                    button.setBackground(Color.red);
                   
                } else if (i == 4 || i == 5) {
                    button.setBackground(Color.white);
               }
                
                if ((i == 4 || i == 5) && (j == 2 || j == 3 || j == 6 || j == 7)) {
                    button.setEnabled(false);
                    
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
            String click = button.getText();
            for(int i=0 ;i<10;i++)
            {
            	for(int j=0 ;j<10;j++)
            	{
            		if(buttons[i][j] == button)
            		{
            			Boolean isFirst=table.isFirst();
            			
            			
            			if(click=="x" && isFirst)
            			{
            				JOptionPane.showMessageDialog(this,"You cannot move your opponent's pieces");
            				return;
            			}
            			Boolean check = table.PieceGo(this,j, i);
            			System.out.println(check);
            		}
            		
            	}
            }
           int status = table.whoWin();
           if(status == 1) {
        	   JOptionPane.showMessageDialog(this, "you win!");
        	   this.dispose();
           }
           else if( status == 2 ){
        	   JOptionPane.showMessageDialog(this, "Game over!");
        	   this.dispose();
		}
           
      }
}
