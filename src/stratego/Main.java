package stratego;

import javax.swing.JOptionPane;

public class Main {

public static void main(String[] args) {
    	
    	
    	String username = JOptionPane.showInputDialog(null,"Please Enter Your Name...", "Login", JOptionPane.INFORMATION_MESSAGE);
    	core table ;
    	Object[] options = {"user", "custom", "load"};
        
        int choice = JOptionPane.showOptionDialog(
            null,
            "Who will pick?",
            "start",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[2]
        );
        if (choice == JOptionPane.YES_OPTION) {
            System.out.println("شما گزینه user را انتخاب کردید.");
            table = new core(10,10,username,1);
            new pickFrame(table);
           
        } else if (choice == JOptionPane.NO_OPTION) {
            System.out.println("شما گزینه custom را انتخاب کردید.");
            table = new core(10,10,username,2);
            playFrame newplayFrame = new playFrame(table);
        } else if (choice == JOptionPane.CANCEL_OPTION) {
            System.out.println("شما گزینه load را انتخاب کردید.");
            table = new core(10,10,username,3);
            playFrame newplayFrame = new playFrame(table);
        }
       
    }
}
