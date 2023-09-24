package stratego;

import javax.swing.*;

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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class table {
    private int width = 1;
    private int length = 1;
    private piece[][] map ;
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
    public table(int width,int length){
        setLength(length);
        setWidth(width);
        map = new piece[getWidth()][getLength()];

    }
    public int getWidth() {
        return width;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void print(){
        for(int i = 0;i<getLength();i++){
            for(int j = 0;j<getWidth();j++){
                System.out.println(map[i][j]);
            }
        }
    }
    public boolean canMovePiece(int i,int j){
        piece mark = map[i][j];
        mark.canMove(i,j);
        return true;
    }
    public int getPositiony(){
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        while((6>i)||(i>10)){
            System.out.println("enter again: ");
            i = sc.nextInt();
        }
        return i ;
    }
    public int getPositionx(){
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        while((0>i)||(i>10)){
            System.out.println("enter again: ");
            i = sc.nextInt();
        }
        return i ;
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
                   counter++;
               }
               else{
                   counter++;
               }
           }
           System.out.println("enter number piece:");
           chose = sc.nextInt();

           switch (chose){
               case 1:
//                Marshal
                   if(pieces[0].getAmount()!= pieces[0].getAmountInsert()){
                       while(true){
                           System.out.println("enter length:");
                           i = this.getPositionx();
                           System.out.println("enter width:");
                           j = this.getPositiony();
                           i--;
                           j--;
                           if(map[j][i]==null){
                               break;
                           }
                           System.out.println("is full this position");
                       }
                       this.insertPiece(i,j,pieces[chose-1]);
                       break;
                   }
                   else{
                       System.out.println("amount few");
                       break;
                   }

               case 2:
//                General
                   if(pieces[1].getAmount()!= pieces[1].getAmountInsert()){
                       while(true){
                           System.out.println("enter length:");
                           i = this.getPositionx();
                           System.out.println("enter width:");
                           j = this.getPositiony();
                           i--;
                           j--;
                           if(map[j][i]==null){
                               break;
                           }
                           System.out.println("is full this position");
                       }
                       this.insertPiece(i,j,pieces[chose-1]);
                       break;
                   }
                   else{
                       System.out.println("amount few");
                       break;
                   }
               case 3:
//                Clonel
                   if(pieces[2].getAmount()!= pieces[2].getAmountInsert()){
                       while(true){
                           System.out.println("enter length:");
                           i = this.getPositionx();
                           System.out.println("enter width:");
                           j = this.getPositiony();
                           i--;
                           j--;
                           if(map[j][i]==null){
                               break;
                           }
                           System.out.println("is full this position");
                       }
                       this.insertPiece(i,j,pieces[chose-1]);
                       break;
                   }
                   else{
                       System.out.println("amount few");
                       break;
                   }
               case 4:
//                Major
                   if(pieces[3].getAmount()!= pieces[3].getAmountInsert()){
                       while(true){
                           System.out.println("enter length:");
                           i = this.getPositionx();
                           System.out.println("enter width:");
                           j = this.getPositiony();
                           i--;
                           j--;
                           if(map[j][i]==null){
                               break;
                           }
                           System.out.println("is full this position");
                       }
                       this.insertPiece(i,j,pieces[chose-1]);
                       break;
                   }
                   else{
                       System.out.println("amount few");
                       break;
                   }
               case 5:
//                Capitan
                   if(pieces[4].getAmount()!= pieces[4].getAmountInsert()){
                       while(true){
                           System.out.println("enter length:");
                           i = this.getPositionx();
                           System.out.println("enter width:");
                           j = this.getPositiony();
                           i--;
                           j--;
                           if(map[j][i]==null){
                               break;
                           }
                           System.out.println("is full this position");
                       }
                       this.insertPiece(i,j,pieces[chose-1]);
                       break;
                   }
                   else{
                       System.out.println("amount few");
                       break;
                   }
               case 6:
//                Lieutenant
                   if(pieces[5].getAmount()!= pieces[5].getAmountInsert()){
                       while(true){
                           System.out.println("enter length:");
                           i = this.getPositionx();
                           System.out.println("enter width:");
                           j = this.getPositiony();
                           i--;
                           j--;
                           if(map[j][i]==null){
                               break;
                           }
                           System.out.println("is full this position");
                       }
                       this.insertPiece(i,j,pieces[chose-1]);
                       break;
                   }
                   else{
                       System.out.println("amount few");
                       break;
                   }
               case 7:
//                Sergent
                   if(pieces[6].getAmount()!= pieces[6].getAmountInsert()){
                       while(true){
                           System.out.println("enter length:");
                           i = this.getPositionx();
                           System.out.println("enter width:");
                           j = this.getPositiony();
                           i--;
                           j--;
                           if(map[j][i]==null){
                               break;
                           }
                           System.out.println("is full this position");
                       }
                       this.insertPiece(i,j,pieces[chose-1]);
                       break;
                   }
                   else{
                       System.out.println("amount few");
                       break;
                   }
               case 8:
//                Miner
                   if(pieces[7].getAmount()!= pieces[7].getAmountInsert()){
                       while(true){
                           System.out.println("enter length:");
                           i = this.getPositionx();
                           System.out.println("enter width:");
                           j = this.getPositiony();
                           i--;
                           j--;
                           if(map[j][i]==null){
                               break;
                           }
                           System.out.println("is full this position");
                       }
                       this.insertPiece(i,j,pieces[chose-1]);
                       break;
                   }
                   else{
                       System.out.println("amount few");
                       break;
                   }
               case 9:
//                Scout
                   if(pieces[8].getAmount()!= pieces[8].getAmountInsert()){
                       while(true){
                           System.out.println("enter length:");
                           i = this.getPositionx();
                           System.out.println("enter width:");
                           j = this.getPositiony();
                           i--;
                           j--;
                           if(map[j][i]==null){
                               break;
                           }
                           System.out.println("is full this position");
                       }
                       this.insertPiece(i,j,pieces[chose-1]);
                       break;
                   }
                   else{
                       System.out.println("amount few");
                       break;
                   }
               case 10:
//                Spy
                   if(pieces[9].getAmount()!= pieces[9].getAmountInsert()){
                       while(true){
                           System.out.println("enter length:");
                           i = this.getPositionx();
                           System.out.println("enter width:");
                           j = this.getPositiony();
                           i--;
                           j--;
                           if(map[j][i]==null){
                               break;
                           }
                           System.out.println("is full this position");
                       }
                       this.insertPiece(i,j,pieces[chose-1]);
                       break;
                   }
                   else{
                       System.out.println("amount few");
                       break;
                   }
               case 11:
//                Bomb
                   if(pieces[10].getAmount()!= pieces[10].getAmountInsert()){
                       while(true){
                           System.out.println("enter length:");
                           i = this.getPositionx();
                           System.out.println("enter width:");
                           j = this.getPositiony();
                           i--;
                           j--;
                           if(map[j][i]==null){
                               break;
                           }
                           System.out.println("is full this position");
                       }
                       this.insertPiece(i,j,pieces[chose-1]);
                       break;
                   }
                   else{
                       System.out.println("amount few");
                       break;
                   }
               case 12:
//                Flag
                   if(pieces[11].getAmount()!= pieces[11].getAmountInsert()){
                       while(true){
                           System.out.println("enter length:");
                           i = this.getPositionx();
                           System.out.println("enter width:");
                           j = this.getPositiony();
                           i--;
                           j--;
                           if(map[j][i]==null){
                               break;
                           }
                           System.out.println("is full this position");
                       }
                       this.insertPiece(i,j,pieces[chose-1]);
                       break;
                   }
                   else{
                       System.out.println("amount few");
                       break;
                   }
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

           this.printmap();

       }
       this.writeTxt();
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
    public boolean insertPiece(int length,int width,piece newPiece){
        map[width][length] = newPiece;
        newPiece.AmountInsertIncreace();
        return true;
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
        switch (t){
            case "u":
                for(int c=0;c<4;c++){

                    if((movement[c][0]==i)&&(movement[c][1]==j-1)){
                        if(map[j-1][i]==null){
                            map[j][i] = null;
                            map[j-1][i] = mark;
                            System.out.println(mark.getOwner() +"'s " +  mark.getName() + " moved");
                            return true;
                        }
                        else{
                            if(mark.getOwner()==map[j-1][i].getOwner()){
                                break;
                            }
                            else{
                                if(mark.getScore()==map[j-1][i].getScore()){
                                    System.out.println(mark.getOwner() +"'s " + mark.getName() + " attacked " + map[j-1][i].getName()+ " --> both removed");
                                    map[j][i].AmountInsertDecreace();
                                    map[j-1][i].AmountInsertDecreace();
                                    map[j][i] = null;
                                    map[j-1][i] = null;
                                    return true;
                                }
                                else{
                                    if(mark.attack(map[j-1][i])){
                                        System.out.println(mark.getOwner() +"'s " +  mark.getName() + " attacked " +  map[j-1][i].getName()+ " --> "+ map[j-1][i].getName() +" removed");
                                        map[j-1][i].AmountInsertDecreace();
                                        map[j][i] = null;
                                        map[j-1][i] = mark;
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
                for(int c=0;c<4;c++){
                    if((movement[c][0]==i)&&(movement[c][1]==j+1)){
                        if(map[j+1][i]==null){
                            map[j][i] = null;
                            map[j+1][i] = mark;
                            return true;
                        }
                        else{
                            if(mark.getOwner()==map[j+1][i].getOwner()){
                                break;
                            }
                            else{
                                if(mark.getScore()==map[j+1][i].getScore()){
                                    map[j][i].AmountInsertDecreace();
                                    map[j+1][i].AmountInsertDecreace();
                                    map[j][i] = null;
                                    map[j+1][i] = null;
                                    return true;
                                }
                                else{
                                    if(mark.attack(map[j+1][i])){
                                        map[j+1][i].AmountInsertDecreace();
                                        map[j][i] = null;
                                        map[j+1][i] = mark;
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
                        if(map[j][i+1]==null){
                            map[j][i] = null;
                            map[j][i+1] = mark;
                            return true;
                        }
                        else{
                            if(mark.getOwner()==map[j][i+1].getOwner()){
                                break;
                            }
                            else{
                                if(mark.getScore()==map[j][i+1].getScore()){
                                    map[j][i].AmountInsertDecreace();
                                    map[j][i+1].AmountInsertDecreace();
                                    map[j][i] = null;
                                    map[j][i+1] = null;
                                    return true;
                                }
                                else{
                                    if(mark.attack(map[j][i+1])){
                                        map[j][i+1].AmountInsertDecreace();
                                        map[j][i] = null;
                                        map[j][i+1] = mark;
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
                    if((movement[c][0]==i-1)&&(movement[c][1]==j)){
                        if(map[j][i-1]==null){
                            map[j][i] = null;
                            map[j][i-1] = mark;
                            return true;
                        }
                        else{
                            if(mark.getOwner()==map[j][i-1].getOwner()){
                                break;
                            }
                            else{
                                if(mark.getScore()==map[j][i-1].getScore()){
                                    map[j][i].AmountInsertDecreace();
                                    map[j][i-1].AmountInsertDecreace();
                                    map[j][i] = null;
                                    map[j][i-1] = null;
                                    return true;
                                }
                                else{
                                    if(mark.attack(map[j][i-1])){
                                        map[j][i-1].AmountInsertDecreace();
                                        map[j][i] = null;
                                        map[j][i-1] = mark;
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
//        System.out.println("Movement is not true");
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

            if(map[j][i].getName() == "scout"){
                System.out.println("enter u or b or r or l: ");
                String u = sc.next();

                System.out.println("enter move amount for scout: ");
                int k = sc.nextInt();

                cunt = this.moveScout(i,j,u,k);

            }
            else{
                System.out.println("enter u or b or r or l: ");
                String u = sc.next();


                cunt = this.movePiecePlayer(i,j,u);

            }


            if(cunt){
                System.out.println("succses");
            }

        }

    }
    public void gameAfterlayoutFile(player ply){
        player bot = this.layoutBot();
        this.printmap();

        while((ply.pieces[11].isAlive())&&(bot.pieces[11].isAlive())){
            this.movement();
            this.botMove();
            this.printmap();
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
        this.printmap();

        while((ply.pieces[11].isAlive())&&(bot.pieces[11].isAlive())){
            this.movement();
            this.botMove();
            this.printmap();
        }

        if(ply.pieces[11].isAlive()){
            System.out.println("player is won");
        }
        else{
            System.out.println("bot is won");
        }

    }
    public void gameGUI(String name){
        player bot = this.layoutBot();
        player ply = this.layoutPlayerCustom(name);
        this.printGUI();

        while((ply.pieces[11].isAlive())&&(bot.pieces[11].isAlive())){
            this.movement();
            this.botMove();
            this.printGUI();
        }

        if(ply.pieces[11].isAlive()){
            System.out.println("player is won");
        }
        else{
            System.out.println("bot is won");
        }

    }
    public void printGUI(){
        JFrame f = new JFrame("Label Example");

        ImageIcon[] imageRed = new ImageIcon[13];
        imageRed[0] = new ImageIcon("image/mar2.gif");
        imageRed[1] = new ImageIcon("image/gen2.gif");
        imageRed[2] = new ImageIcon("image/col2.gif");
        imageRed[3] = new ImageIcon("image/maj2.gif");
        imageRed[4] = new ImageIcon("image/cap2.gif");
        imageRed[5] = new ImageIcon("image/lie2.gif");
        imageRed[6] = new ImageIcon("image/ser2.gif");
        imageRed[7] = new ImageIcon("image/min2.gif");
        imageRed[8] = new ImageIcon("image/sco2.gif");
        imageRed[9] = new ImageIcon("image/spy2.gif");
        imageRed[10] = new ImageIcon("image/bomb2.gif");
        imageRed[11] = new ImageIcon("image/flag2.gif");
        imageRed[12] = new ImageIcon("image/un2.gif");


//        ImageIcon[] imageBlue = new ImageIcon[13];
//        imageBlue[0] = new ImageIcon("image/mar1.gif");
//        imageBlue[1] = new ImageIcon("image/gen1.gif");
//        imageBlue[2] = new ImageIcon("image/clo1.gif");
//        imageBlue[3] = new ImageIcon("image/maj1.gif");
//        imageBlue[4] = new ImageIcon("image/cap1.gif");
//        imageBlue[5] = new ImageIcon("image/lie1.gif");
//        imageBlue[6] = new ImageIcon("image/ser1.gif");
//        imageBlue[7] = new ImageIcon("image/min1.gif");
//        imageBlue[8] = new ImageIcon("image/sco1.gif");
//        imageBlue[9] = new ImageIcon("image/spy1.gif");
//        imageBlue[10] = new ImageIcon("image/bomb1.gif");
//        imageBlue[11] = new ImageIcon("image/flag1.gif");
//        imageBlue[12] = new ImageIcon("image/un1.gif");

        ImageIcon blueUn = new ImageIcon("image/un1.gif");
        ImageIcon Sea = new ImageIcon("image/lake.jpg");

//        JLabel j1;
        ImageIcon temp;
        JButton j1 =new JButton(Sea) ;



        for(int j=0;j<10;j++){
            for(int i=0;i<10;i++){

                if(j==4){
                    if((i==2)||(i==3)||(i==7)||(i==6)){
                        j1 = new JButton(Sea);
                        j1.setBounds(i*50,j*50,49,49);
                        f.add(j1);
                        continue;
                    }
                }
                if(j==5){
                    if((i==2)||(i==3)||(i==7)||(i==6)){
                        j1 = new JButton(Sea);
                        j1.setBounds(i*50,j*50,49,49);
                        f.add(j1);
                        continue;
                    }
                }


                if(map[j][i] != null){
                    switch (map[j][i].getName()){
                        case "marshal":
                            if(map[j][i].getOwner().name.equals("bot")){
                                temp = blueUn;
                            }
                            else{
                                temp = imageRed[0];
                            }
                            j1 = new JButton(temp);
                            j1.setBounds(i*50,j*50,49,49);
                            f.add(j1);
                            break;

                        case "general":
                            if(map[j][i].getOwner().name.equals("bot")){
                                temp = blueUn;
                            }
                            else{
                                temp = imageRed[1];
                            }
                            j1 = new JButton(temp);
                            j1.setBounds(i*50,j*50,49,49);
                            f.add(j1);
                            break;

                        case "clonel":
                            if(map[j][i].getOwner().name.equals("bot")){
                                temp = blueUn;
                            }
                            else{
                                temp = imageRed[2];
                            }
                            j1 = new JButton(temp);
                            j1.setBounds(i*50,j*50,49,49);
                            f.add(j1);
                            break;

                        case "major":
                            if(map[j][i].getOwner().name.equals("bot")){
                                temp = blueUn;
                            }
                            else{
                                temp = imageRed[3];
                            }
                            j1 = new JButton(temp);
                            j1.setBounds(i*50,j*50,49,49);
                            f.add(j1);
                            break;

                        case "capitan":
                            if(map[j][i].getOwner().name.equals("bot")){
                                temp = blueUn;
                            }
                            else{
                                temp = imageRed[4];
                            }
                            j1 = new JButton(temp);
                            j1.setBounds(i*50,j*50,49,49);
                            f.add(j1);
                            break;

                        case "lieutenant":
                            if(map[j][i].getOwner().name.equals("bot")){
                                temp = blueUn;
                            }
                            else{
                                temp = imageRed[5];
                            }
                            j1 = new JButton(temp);
                            j1.setBounds(i*50,j*50,49,49);
                            f.add(j1);
                            break;

                        case "sergent":
                            if(map[j][i].getOwner().name.equals("bot")){
                                temp = blueUn;
                            }
                            else{
                                temp = imageRed[6];
                            }
                            j1 = new JButton(temp);
                            j1.setBounds(i*50,j*50,49,49);
                            f.add(j1);
                            break;

                        case "miner":
                            if(map[j][i].getOwner().name.equals("bot")){
                                temp = blueUn;
                            }
                            else{
                                temp = imageRed[7];
                            }
                            j1 = new JButton(temp);
                            j1.setBounds(i*50,j*50,49,49);
                            f.add(j1);
                            break;

                        case "scout":
                            if(map[j][i].getOwner().name.equals("bot")){
                                temp = blueUn;
                            }
                            else{
                                temp = imageRed[8];
                            }
                            j1 = new JButton(temp);
                            j1.setBounds(i*50,j*50,49,49);
                            f.add(j1);
                            break;

                        case "spy":
                            if(map[j][i].getOwner().name.equals("bot")){
                                temp = blueUn;
                            }
                            else{
                                temp = imageRed[9];
                            }
                            j1 = new JButton(temp);
                            j1.setBounds(i*50,j*50,49,49);
                            f.add(j1);
                            break;

                        case "bomb":
                            if(map[j][i].getOwner().name.equals("bot")){
                                temp = blueUn;
                            }
                            else{
                                temp = imageRed[10];
                            }
                            j1 = new JButton(temp);
                            j1.setBounds(i*50,j*50,49,49);
                            f.add(j1);
                            break;

                        case "flag":
                            if(map[j][i].getOwner().name.equals("bot")){
                                temp = blueUn;
                            }
                            else{
                                temp = imageRed[11];
                            }
                            j1 = new JButton(temp);
                            j1.setBounds(i*50,j*50,49,49);
                            f.add(j1);
                            break;

                    }
                }
            }
        }




        f.setSize(600, 600);
        f.setLayout(null);
        f.setVisible(true);
    }



}
