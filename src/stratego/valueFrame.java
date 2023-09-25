package stratego;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.xml.transform.Templates;

import stratego.Frame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class valueFrame extends JFrame implements ActionListener{
	Frame parentFrame;
    private JButton[] buttons;
    private JLabel[] labels;
    String selectedpiece;
    

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
        
this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				parentFrame.setEnabled(true);
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        	
        
    }

    private void designFrame() {
        piece[] pieces = parentFrame.table.getPiecesList();

        
        for (int i = 0; i < 12; i++) {
            JPanel panel1 = new JPanel(new BorderLayout());
            JPanel panel2 = new JPanel(new BorderLayout());
            

            labels[i] = new JLabel("Label " + (i + 1));
            buttons[i] = new JButton("select");
            buttons[i].addActionListener(this);

            panel1.add(labels[i], BorderLayout.WEST);
            panel2.add(buttons[i], BorderLayout.CENTER);

            add(panel1);
            add(panel2);
        }
        
        
        
        
        
        for(int i=0; i<12;i++) 
        {
        	labels[i].setText(pieces[i].getLabelText());
        	buttons[i].setText(pieces[i].getName());
        	if(!pieces[i].isRemain()) buttons[i].setEnabled(false);
        }
}
    
    
    @Override
    
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            selectedpiece = button.getText();
            
            
            for(int i=0;i<10;i++)
            {
            	for(int j=0;j<10;j++)
            	{
            		if(parentFrame.buttons[i][j].getText()=="click")
            		{
            			parentFrame.buttons[i][j].setText(selectedpiece);
            			System.out.println(parentFrame.table.pickPiece(i, j, selectedpiece));
            		}
            	}
            }
            parentFrame.setEnabled(true);
            this.dispose();
        }
    
    
    }




















