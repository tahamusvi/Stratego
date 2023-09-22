import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class core {
    private int width = 1;
    private int length = 1;
    private piece[][] map;

    public core(int width,int length){
        setLength(length);
        setWidth(width);
        map = new piece[getWidth()][getLength()];
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }



    public boolean botMove(){
        Random rn = new Random();
        int i = 0;
        int j = 0;
        int k =0;
        String l= "u" ;
        boolean cunt = false;
        while(!cunt){
            i = rn.nextInt(0,9);
            j = rn.nextInt(0,4);
            k = rn.nextInt(0,4);
            switch (k){
                case 0:
                    l = "u";
                    break;
                case 1:
                    l = "b";
                    break;
                case 2:
                    l = "r";
                    break;
                case 3:
                    l = "l";
                    break;
            }
            if(map[j][i]!=null){
                cunt = movePiecePlayer(i,j,l);
            }
        }

        return true;
    }
    

    
    public boolean WhereCanGo(int i, int j){
        piece mark = map[i][j];
        mark.canMove(i,j);
        return true;
    }
    

    public piece[] piecesForPlayer(player ply){
        piece[] pieces = new piece[12];

        pieces[0] = new marshal(ply);
        pieces[1] = new general(ply);
        pieces[2] = new clonel(ply);
        pieces[3] = new major(ply);
        pieces[4] = new capitan(ply);
        pieces[5] = new lieutenant(ply);
        pieces[6] = new sergent(ply);
        pieces[7] = new miner(ply);
        pieces[8] = new scout(ply);
        pieces[9] = new spy(ply);
        pieces[10] = new bomb(ply);
        pieces[11] = new flag(ply);
        ply.pieces = pieces;
        return pieces;
    }


    public void layoutPlayer(player ply){
        System.out.println("Start layout: ");
        int insPiece = 0 ;
        System.out.println("Pieces: ");

        piece[] pieces = this.piecesForPlayer(ply);

        boolean cunt = true;

        while(cunt){
           for(piece mark : pieces){
               if(mark.getAmount()!= mark.getAmountInsert()){
                   System.out.println(mark + " left :" + (mark.getAmount()-mark.getAmountInsert()));
               }
           }


           int chose=2;
           int i,j;
           Scanner sc = new Scanner(System.in);


           int counter = 1;

           for(piece mark : pieces){
               if(mark.getAmount()!= mark.getAmountInsert()){
                   System.out.println(counter + ". " + mark);
               }
               counter++;
           }

           System.out.println("enter number piece:");
           chose = sc.nextInt();

           if(pieces[chose-1].getAmount() != pieces[chose-1].getAmountInsert()){
                while(true){
                    System.out.println("enter length:");
//                    i = this.getPositionx();
                    i = 0;
                    System.out.println("enter width:");
//                    j = this.getPositiony();
                    j = 0;
                    i--;
                    j--;
                    if(map[j][i]==null){
                        break;
                    }
                    System.out.println("is full this position");
                }
                this.insertPiece(i,j,pieces[chose-1]);
           }
           else{
               System.out.println("amount few");
           }

           int insertedPiece = 0;
           for(piece mark : pieces){
               if(mark.getAmount()!= mark.getAmountInsert()){
                   insertedPiece += mark.getAmountInsert();
               }
           }
           if(insertedPiece == 40){
               cunt = false;
           }
       }
       this.writeTxt();
    }



    public boolean insertPiece(int length,int width,piece newPiece){
        map[width][length] = newPiece;
        newPiece.AmountInsertIncreace();
        return true;
    }
    
    
    
    public player layoutBot(){
        player bot = new player("bot");
        piece[] pieces = this.piecesForPlayer(bot);

        this.insertPiece(0,0,pieces[6]);
        this.insertPiece(1,0,pieces[10]);
        this.insertPiece(2,0,pieces[7]);
        this.insertPiece(3,0,pieces[7]);
        this.insertPiece(4,0,pieces[10]);
        this.insertPiece(5,0,pieces[7]);
        this.insertPiece(6,0,pieces[11]);
        this.insertPiece(7,0,pieces[7]);
        this.insertPiece(8,0,pieces[10]);
        this.insertPiece(9,0,pieces[6]);

        this.insertPiece(0,1,pieces[10]);
        this.insertPiece(1,1,pieces[4]);
        this.insertPiece(2,1,pieces[3]);
        this.insertPiece(3,1,pieces[10]);
        this.insertPiece(4,1,pieces[7]);
        this.insertPiece(5,1,pieces[3]);
        this.insertPiece(6,1,pieces[3]);
        this.insertPiece(7,1,pieces[4]);
        this.insertPiece(8,1,pieces[8]);
        this.insertPiece(9,1,pieces[10]);

        this.insertPiece(0,2,pieces[8]);
        this.insertPiece(1,2,pieces[5]);
        this.insertPiece(2,2,pieces[2]);
        this.insertPiece(3,2,pieces[9]);
        this.insertPiece(4,2,pieces[8]);
        this.insertPiece(5,2,pieces[8]);
        this.insertPiece(6,2,pieces[2]);
        this.insertPiece(7,2,pieces[8]);
        this.insertPiece(8,2,pieces[5]);
        this.insertPiece(9,2,pieces[8]);

        this.insertPiece(0,3,pieces[5]);
        this.insertPiece(1,3,pieces[6]);
        this.insertPiece(2,3,pieces[4]);
        this.insertPiece(3,3,pieces[1]);
        this.insertPiece(4,3,pieces[8]);
        this.insertPiece(5,3,pieces[8]);
        this.insertPiece(6,3,pieces[0]);
        this.insertPiece(7,3,pieces[4]);
        this.insertPiece(8,3,pieces[6]);
        this.insertPiece(9,3,pieces[5]);

        return bot;
    }

    public player layoutPlayerCustom(String name){
        player ply = new player(name);
        piece[] pieces = this.piecesForPlayer(ply);

        this.insertPiece(0,9,pieces[6]);
        this.insertPiece(1,9,pieces[10]);
        this.insertPiece(2,9,pieces[7]);
        this.insertPiece(3,9,pieces[7]);
        this.insertPiece(4,9,pieces[10]);
        this.insertPiece(5,9,pieces[7]);
        this.insertPiece(6,9,pieces[11]);
        this.insertPiece(7,9,pieces[7]);
        this.insertPiece(8,9,pieces[10]);
        this.insertPiece(9,9,pieces[6]);

        this.insertPiece(0,8,pieces[10]);
        this.insertPiece(1,8,pieces[4]);
        this.insertPiece(2,8,pieces[3]);
        this.insertPiece(3,8,pieces[10]);
        this.insertPiece(4,8,pieces[7]);
        this.insertPiece(5,8,pieces[3]);
        this.insertPiece(6,8,pieces[3]);
        this.insertPiece(7,8,pieces[4]);
        this.insertPiece(8,8,pieces[8]);
        this.insertPiece(9,8,pieces[10]);

        this.insertPiece(0,7,pieces[8]);
        this.insertPiece(1,7,pieces[5]);
        this.insertPiece(2,7,pieces[2]);
        this.insertPiece(3,7,pieces[9]);
        this.insertPiece(4,7,pieces[8]);
        this.insertPiece(5,7,pieces[8]);
        this.insertPiece(6,7,pieces[2]);
        this.insertPiece(7,7,pieces[8]);
        this.insertPiece(8,7,pieces[5]);
        this.insertPiece(9,7,pieces[8]);

        this.insertPiece(0,6,pieces[5]);
        this.insertPiece(1,6,pieces[6]);
        this.insertPiece(2,6,pieces[4]);
        this.insertPiece(3,6,pieces[1]);
        this.insertPiece(4,6,pieces[8]);
        this.insertPiece(5,6,pieces[8]);
        this.insertPiece(6,6,pieces[0]);
        this.insertPiece(7,6,pieces[4]);
        this.insertPiece(8,6,pieces[6]);
        this.insertPiece(9,6,pieces[5]);

        return ply;
    }

    public boolean movePiecePlayer(int i,int j, String t){
        piece mark = map[j][i];

        int[][] movement = mark.canMove(i,j);
        int finalI = 0;
        int finalJ = 0;

        switch (t){
            case "u":
                finalI = i;
                finalJ = j-1;
                break;
            case "b":
                finalI = i;
                finalJ = j+1;
                break;
            case "r":
                finalI = i+1;
                finalJ = j;
                break;
            case "l":
                finalI = i-1;
                finalJ = j;
                break;      
           default:
                break;
        }

        for(int c=0;c<4;c++){
            if((movement[c][0]==finalI)&&(movement[c][1]==finalJ)){
                if(map[finalJ][finalI]==null){
                    map[j][i] = null;
                    map[finalJ][finalI] = mark;
                    System.out.println(mark.getOwner() +"'s " +  mark.getName() + " moved");
                    return true;
                }
                else{
                    if(mark.getOwner()==map[finalJ][finalI].getOwner()){
                        break;
                    }
                    else{
                        if(mark.getScore()==map[finalJ][finalI].getScore()){
                            System.out.println(mark.getOwner() +"'s " + mark.getName() + " attacked " + map[finalJ][finalI].getName()+ " --> both removed");
                            map[j][i].AmountInsertDecreace();
                            map[finalJ][finalI].AmountInsertDecreace();
                            map[j][i] = null;
                            map[finalJ][finalI] = null;
                            return true;
                        }
                        else{
                            if(mark.attack(map[finalJ][finalI])){
                                System.out.println(mark.getOwner() +"'s " +  mark.getName() + " attacked " +  map[finalJ][finalI].getName()+ " --> "+ map[finalJ][finalI].getName() +" removed");
                                map[finalJ][finalI].AmountInsertDecreace();
                                map[j][i] = null;
                                map[finalJ][finalI] = mark;
                                return true;
                            }
                            else{
                                System.out.println(mark.getOwner() +"'s " +  mark.getName() + " attacked " + mark.getName()+ " --> both removed");
                                map[j][i].AmountInsertDecreace();
                                map[j][i] = null;
                                return true;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }


    public boolean moveScout(int i,int j,String t ,int k){
        piece mark = map[j][i];

        int[][] movement = mark.canMove(i,j);
        switch (t){
            case "u":
                for(int c=0;c<36;c++){
                    if((movement[c][0]==i)&&(movement[c][1]==j-k)){
                        if(map[j-k][i]==null){
                            map[j][i] = null;
                            map[j-k][i] = mark;
                            System.out.println(mark.getOwner() +"'s " +  mark.getName() + " moved");
                            return true;
                        }
                        else{
                            if(mark.getOwner()==map[j-k][i].getOwner()){
                                break;
                            }
                            else{
                                if(mark.getScore()==map[j-k][i].getScore()){
                                    System.out.println(mark.getOwner() +"'s " + mark.getName() + " attacked " + map[j-k][i].getName()+ " --> both removed");
                                    map[j][i].AmountInsertDecreace();
                                    map[j-k][i].AmountInsertDecreace();
                                    map[j][i] = null;
                                    map[j-k][i] = null;
                                    return true;
                                }
                                else{
                                    if(mark.attack(map[j-k][i])){
                                        System.out.println(mark.getOwner() +"'s " +  mark.getName() + " attacked " +  map[j-k][i].getName()+ " --> "+ map[j-k][i].getName() +" removed");
                                        map[j-k][i].AmountInsertDecreace();
                                        map[j][i] = null;
                                        map[j-k][i] = mark;
                                        return true;
                                    }
                                    else{
                                        System.out.println(mark.getOwner() +"'s " +  mark.getName() + " attacked " + mark.getName()+ " --> both removed");
                                        map[j][i].AmountInsertDecreace();
                                        map[j][i] = null;
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            case "b":
                for(int c=0;c<36;c++){
                    if((movement[c][0]==i)&&(movement[c][1]==j+k)){
                        if(map[j+k][i]==null){
                            map[j][i] = null;
                            map[j+k][i] = mark;
                            return true;
                        }
                        else{
                            if(mark.getOwner()==map[j+k][i].getOwner()){
                                break;
                            }
                            else{
                                if(mark.getScore()==map[j+k][i].getScore()){
                                    map[j][i].AmountInsertDecreace();
                                    map[j+k][i].AmountInsertDecreace();
                                    map[j][i] = null;
                                    map[j+k][i] = null;
                                    return true;
                                }
                                else{
                                    if(mark.attack(map[j+k][i])){
                                        map[j+k][i].AmountInsertDecreace();
                                        map[j][i] = null;
                                        map[j+k][i] = mark;
                                        return true;
                                    }
                                    else{
                                        map[j][i].AmountInsertDecreace();
                                        map[j][i] = null;
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            case "r":
                for(int c=0;c<4;c++){
                    if((movement[c][0]==i+1)&&(movement[c][1]==j)){
                        if(map[j][i+k]==null){
                            map[j][i] = null;
                            map[j][i+k] = mark;
                            return true;
                        }
                        else{
                            if(mark.getOwner()==map[j][i+k].getOwner()){
                                break;
                            }
                            else{
                                if(mark.getScore()==map[j][i+k].getScore()){
                                    map[j][i].AmountInsertDecreace();
                                    map[j][i+k].AmountInsertDecreace();
                                    map[j][i] = null;
                                    map[j][i+k] = null;
                                    return true;
                                }
                                else{
                                    if(mark.attack(map[j][i+k])){
                                        map[j][i+k].AmountInsertDecreace();
                                        map[j][i] = null;
                                        map[j][i+k] = mark;
                                        return true;
                                    }
                                    else{
                                        map[j][i].AmountInsertDecreace();
                                        map[j][i] = null;
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            case "l":
                for(int c=0;c<4;c++){
                    if((movement[c][0]==i-k)&&(movement[c][1]==j)){
                        if(map[j][i-k]==null){
                            map[j][i] = null;
                            map[j][i-k] = mark;
                            return true;
                        }
                        else{
                            if(mark.getOwner()==map[j][i-k].getOwner()){
                                break;
                            }
                            else{
                                if(mark.getScore()==map[j][i-k].getScore()){
                                    map[j][i].AmountInsertDecreace();
                                    map[j][i-k].AmountInsertDecreace();
                                    map[j][i] = null;
                                    map[j][i-k] = null;
                                    return true;
                                }
                                else{
                                    if(mark.attack(map[j][i-k])){
                                        map[j][i-k].AmountInsertDecreace();
                                        map[j][i] = null;
                                        map[j][i-k] = mark;
                                        return true;
                                    }
                                    else{
                                        map[j][i].AmountInsertDecreace();
                                        map[j][i] = null;
                                        return true;
                                    }
                                }
                            }
                        }
                    }

                }
                break;

            default:
                break;
        }
        System.out.println("Movement is not true");
        return false;
    }



    public void movement(){
        boolean cunt = false;
        while(!cunt){
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter posation Piece: ");

            System.out.println("enter length: ");
            int i = sc.nextInt();
            i--;
            System.out.println("enter width: ");
            int j = sc.nextInt();
            j--;

            System.out.println("enter u or b or r or l: ");
            String u = sc.next();

            if(map[j][i].getName() == "scout"){
                System.out.println("enter move amount for scout: ");
                int k = sc.nextInt();

                cunt = this.moveScout(i,j,u,k);
            }
            else{
                cunt = this.movePiecePlayer(i,j,u);
            }


            if(cunt){
                System.out.println("succses");
            }

        }

    }


    public void gameAfterlayoutFile(player ply){
        player bot = this.layoutBot();

        while((ply.pieces[11].isAlive())&&(bot.pieces[11].isAlive())){
            this.movement();
            this.botMove();
        }

        if(ply.pieces[11].isAlive()){
            System.out.println("player is won");
        }
        else{
            System.out.println("bot is won");
        }

    }

    public void game(String name){
        player bot = this.layoutBot();
        player ply = this.layoutPlayerCustom(name);

        while((ply.pieces[11].isAlive())&&(bot.pieces[11].isAlive())){
            this.movement();
            this.botMove();
        }

        if(ply.pieces[11].isAlive()){
            System.out.println("player is won");
        }
        else{
            System.out.println("bot is won");
        }

    }



    public void writeTxt(){
        try {
            FileWriter fw = new FileWriter("StrategoMap.txt");

            BufferedWriter bw = new BufferedWriter(fw);

            for(int i=0;i<10;i++){
                for(int j=6;j<10;j++){
                    bw.write(map[j][i].getName()+","+i+","+j);
                    bw.newLine();
                }
            }

            bw.close();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public player layoutFromFile(String fileName){
        player ply = new player("palyer 1");
        piece[] pieces = this.piecesForPlayer(ply);
        String line = null;
        piece mark = null;

        try {
            FileReader fr = new FileReader(fileName);

            BufferedReader br = new BufferedReader(fr);

            while( (line = br.readLine() ) != null ) {
                String[] array = line.split(",");

                for(int i=0;i<12;i++){
                    if(array[0].equals(pieces[i].getName())){
                         mark = pieces[i];

                    }
                }
                this.insertPiece(Integer.valueOf(array[1]),Integer.valueOf(array[2]),mark);
            }

            br.close();
            return ply;

        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return ply;
    }

}
