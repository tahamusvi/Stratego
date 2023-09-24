package stratego;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

import stratego.pieces.bomb;
import stratego.pieces.capitan;
import stratego.pieces.clonel;
import stratego.pieces.flag;
import stratego.pieces.general;
import stratego.pieces.island;
import stratego.pieces.lieutenant;
import stratego.pieces.major;
import stratego.pieces.marshal;
import stratego.pieces.miner;
import stratego.pieces.scout;
import stratego.pieces.sergent;
import stratego.pieces.spy;

public class core {
    private int width = 1;
    private int length = 1;
    private piece[][] map;
    private player player_obj;

    public core(int width,int length){
        setLength(length);
        setWidth(width);
        map = new piece[getWidth()][getLength()];
    }

    public core(int width,int length,String name){
        setLength(length);
        setWidth(width);
        map = new piece[getWidth()][getLength()];

        this.player_obj = new player(name);
        piece[] whoPiece = this.piecesForPlayer(this.player_obj);
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
    
    public player getPlayer() {
        return this.player_obj;
    }

    public void setPlayer(player player_obj) {
        this.player_obj = player_obj;
    }
    
    public piece[] getPiecesList() {
        return this.player_obj.pieces;
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
                cunt = movePiecePlayer(i,j,l,1);
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

    public boolean movePiecePlayer(int i,int j, String t,int k){
        piece mark = map[j][i];
        int count_move = 4;
        if(mark.getName() == "scout")
        {
            count_move = 36;
        }

        int[][] movement = mark.canMove(i,j);
        int finalI = 0;
        int finalJ = 0;

        switch (t){
            case "u":
                finalI = i;
                finalJ = j-k;
                break;
            case "b":
                finalI = i;
                finalJ = j+k;
                break;
            case "r":
                finalI = i+k;
                finalJ = j;
                break;
            case "l":
                finalI = i-k;
                finalJ = j;
                break;      
           default:
                break;
        }

        for(int c=0;c<count_move;c++){
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
            int k = 1;

            if(map[j][i].getName() == "scout"){
                System.out.println("enter move amount for scout: ");
                k = sc.nextInt();
            }

            cunt = this.movePiecePlayer(i,j,u,k);


            if(cunt){
                System.out.println("succses");
            }

        }

    }


    public void ofogh(piece mark){
        if(mark==null){
            String space = "          ";
            System.out.print("|" + space );
        }
        else{
            if(mark.getOwner().name == "bot"){
                System.out.print("|" + "    op    " );
            }
            else{
                System.out.print("|" + mark );
            }
        }

    }
    public void emod(){
        System.out.print("-");
    }
    public void printmap(){
        piece islands = new island(new player("table"));
        for(int i =0;i<110;i++){
            this.emod();
        }
        System.out.println("");
        for(int j = 0 ; j<10;j++){
            for(int i =0;i<10;i++){
                if(j==4){
                    if((i==2)||(i==3)||(i==7)||(i==6)){
                        this.ofogh(islands);
                        continue;
                    }
                }
                if(j==5){
                    if((i==2)||(i==3)||(i==7)||(i==6)){
                        this.ofogh(islands);
                        continue;
                    }
                }
                this.ofogh(this.map[j][i]);
            }
            System.out.println("");
            for(int i =0;i<110;i++){
                this.emod();
            }
            System.out.println("");
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

    public static void main(String args[])
    {
        core gthis = new core(10,10);
        player bot = gthis.layoutBot();
        player ply = gthis.layoutPlayerCustom("taha");

//
//        while((ply.pieces[11].isAlive())&&(bot.pieces[11].isAlive())){
//            gthis.printmap();
//            gthis.movement();
//            gthis.botMove();
//        }
//
//        if(ply.pieces[11].isAlive()){
//            System.out.println("player is won");
//        }
//        else{
//            System.out.println("bot is won");
//        }

    }


    //Controllers
    public boolean pickPiece(int width,int length,String newPiece){
        piece picked = this.player_obj.findPiece(newPiece);
        if(picked == null) return false;
        if(this.player_obj.countPlayerPiece() >= 40) return false;

        if(picked.getAmount() != picked.getAmountInsert()) {
            if(map[width][length] == null ) map[width][length] = picked;
            else return false;

            picked.AmountInsertIncreace();
            return true;
        }
        else{
            return false;
        }
    }
    
    
    public boolean decreacePieceAmount(String name)
    {
    	for(piece mark : this.player_obj.pieces){
            if(mark.getName().equals(name)){
                mark.AmountInsertDecreace();
                return true;
            }
        }
    	return false;
    }
}
