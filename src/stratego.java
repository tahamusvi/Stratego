import java.util.Scanner;

//                                      From Wikipedia, the free encyclopedia
//
//  Stratego (/strəˈtiːɡoʊ/ strə-TEE-goh) is a strategy board game for two players on a board of 10×10 squares.
//  Each player controls 40 pieces representing individual officer and soldier ranks in an army.
//  The pieces have Napoleonic insignia.
//  The objective of the game is to find and capture the opponent's Flag, or to capture so many enemy pieces that the opponent cannot make any further moves.
//  Stratego has simple enough rules for young children to play but a depth of strategy that is also appealing to adults.
//  The game is a slightly modified copy of an early 20th century French game named L'Attaque [fr] ("The Attack").
//  It has been in production in Europe since World War II and the United States since 1961. There are now two- and four-player versions,
//  versions with 10, 30 or 40 pieces per player, and boards with smaller sizes (number of spaces).
//  There are also variant pieces and different rulesets.
//



public class stratego {
    public static void main(String args[]){
        int chose;
        Scanner sc = new Scanner(System.in);
        System.out.println("wellcome in game ");
        System.out.println("Menu:");

        System.out.println("1.layout Pieces and save txt");
        System.out.println("2.load layout");
        System.out.println("3.play game random");
        System.out.println("4.GUI");

        chose = sc.nextInt();


        table str = new table(10,10);


        switch (chose){
            case 1:
                System.out.println("enter your name :");
                String name = sc.next();
                player ply = new player(name);
                str.layoutPlayer(ply);
                str.writeTxt();
                break;
            case 2:
                System.out.println("enter your file name :");
                String ad = sc.next();
                player ply2 = str.layoutFromFile(ad);
                str.gameAfterlayoutFile(ply2);
                break;
            case 3:
                System.out.println("enter your name :");
                String name2 = sc.next();
                str.game(name2);
                break;

            case 4:
                System.out.println("enter your name :");
                String name3 = sc.next();
                str.gameGUI(name3);
                break;
        }

    }
}

