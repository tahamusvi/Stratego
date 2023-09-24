package stratego;

import java.awt.event.ActionListener;
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
    }

    private void designFrame() {
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
        
        labels[1].setText("taha");
        String test = labels[6].getText();
        System.out.println(test);
        
        
        piece[] pieces = parentFrame.table.getPiecesList();
        for(int i=0; i<12;i++) {
        	labels[i].setText(pieces[i].getLabelText());
        	buttons[i].setText(pieces[i].getName());
        }
        
    }
    
    
    @Override
    
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            selectedpiece = button.getText();
            piece tempPiece = parentFrame.table.getPiecesList()[0];
            for(int k=0; k<12; k++)
            {
            	if(parentFrame.table.getPiecesList()[k].getName()==selectedpiece)
            	{
            		tempPiece = parentFrame.table.getPiecesList()[k];
            	}
            }
            if(tempPiece.isRemain())
            {
            for(int i=0;i<10;i++)
            {
            	for(int j=0;j<10;j++)
            	{
            		if(parentFrame.buttons[i][j].getText()=="pressed")
            		{
            			parentFrame.buttons[i][j].setText(selectedpiece);
            		}
            	}
            }
            }
            this.dispose();
        }
    
    
    }




















