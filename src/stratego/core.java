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
    private player bot;
    private int[] click;

    public core(int width,int length){
        setLength(length);
        setWidth(width);
        map = new piece[getWidth()][getLength()];
    }
    
    public core(int width,int length,String name, int section){
    	setLength(10);
        setWidth(10);
        map = new piece[getWidth()][getLength()];
        
        this.bot = this.layoutBot();
        
        this.click = new int[2];
        this.click[0] = -1;
        this.click[1] = -1;
        
        piece[] whoPiece;
        
        if(section == 1) {
        	this.player_obj = new player(name);
            whoPiece = this.piecesForPlayer(this.player_obj);
        }
        else if(section == 2) {
        	this.player_obj = this.layoutPlayerCustom(name);
            whoPiece = this.player_obj.pieces;
        }
        else {
        	this.player_obj = layoutFromFile("StrategoMap.txt",name);
            whoPiece = this.player_obj.pieces;
        	
        }
                      
      
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
    
    public String getPieceNameOnMap(int i,int j) {
    	if(map[j][i] != null) return map[j][i].getName();
    	return "None";
    }    

    public boolean botMove() {
        Random rn = new Random();
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        boolean moveSuccessful = false;
        
        while (!moveSuccessful) {
            i = rn.nextInt(9);
            j = rn.nextInt(9);
            k = rn.nextInt(9);
            l = rn.nextInt(9);

            piece mark = map[j][i];
            if (mark != null && mark.getOwner().equals(this.bot)) {
                moveSuccessful = movePiecePlayer(i, j, k, l);
            }
        }

        return true;
    }

    public boolean WhereCanGo(int i, int j){
        piece mark = map[i][j];
        mark.canMove(i,j);
        return true;
    }
    
    public boolean canJump(int i,int j,int fi,int fj)
    {
    	int distanceI = i - fi;
    	int distanceJ = j - fj;
    	
    	if(distanceI == 0)
    	{
    		for(int y=1 ; y <Math.abs(distanceJ); y++)
    		{
    			if(fj > j)
    			{
    				if(map[j+y][i] != null) return false;
    			}
    			else {
    				if(map[j-y][i] != null) return false;
    			}
    		}
    	}
    	else 
    	{
    		for(int x=1 ; x <Math.abs(distanceI); x++)
    		{
    			if(fi > i)
    			{
    				if(map[j][i+x] != null) return false;
    			}
    			else {
    				if(map[j][i-x] != null) return false;
    			}
    		}
    	}
    	
    	
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

    public boolean movePiecePlayer(int srcRow, int srcCol, int destRow, int destCol) {
        piece currentPiece = map[srcCol][srcRow];

        int[][] possibleMoves = currentPiece.canMove(srcRow, srcCol);

        for (int i = 0; i < possibleMoves.length; i++) {
            int moveRow = possibleMoves[i][0];
            int moveCol = possibleMoves[i][1];

            if (moveRow == destRow && moveCol == destCol) {
            	if (!canJump(srcRow,srcCol,destRow,destCol)) return false;
                piece destinationPiece = map[destCol][destRow];

                if (destinationPiece == null) {
                    map[srcCol][srcRow] = null;
                    map[destCol][destRow] = currentPiece;
                    System.out.println(currentPiece.getOwner() + "'s " + currentPiece.getName() + " moved");
                    return true;
                } else {
                    if (currentPiece.getOwner() == destinationPiece.getOwner()) {
                        return false;
                    } else {
                        if (currentPiece.getScore() == destinationPiece.getScore()) {
                            System.out.println(currentPiece.getOwner() + "'s " + currentPiece.getName() + " attacked " + destinationPiece.getName() + " --> both removed");
                            currentPiece.AmountInsertDecreace();
                            destinationPiece.AmountInsertDecreace();
                            map[srcCol][srcRow] = null;
                            map[destCol][destRow] = null;
                            return true;
                        } else {
                            if (currentPiece.attack(destinationPiece)) {
                                System.out.println(currentPiece.getOwner() + "'s " + currentPiece.getName() + " attacked " + destinationPiece.getName() + " --> " + destinationPiece.getName() + " removed");
                                destinationPiece.AmountInsertDecreace();
                                map[srcCol][srcRow] = null;
                                map[destCol][destRow] = currentPiece;
                                return true;
                            } else {
                                System.out.println(currentPiece.getOwner() + "'s " + currentPiece.getName() + " attacked " + destinationPiece.getName() + " --> " + currentPiece.getName() + " removed");
                                currentPiece.AmountInsertDecreace();
                                map[srcCol][srcRow] = null;
                                return true;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }


    public void ofogh(piece mark){
        if(mark==null){
            String space = "          ";
            System.out.print("|" + space );
        }
        else{
        	 System.out.print("|" + mark );
//            if(mark.getOwner().name == "bot"){
//                System.out.print("|" + "    op    " );
//            }
//            else{
//                System.out.print("|" + mark );
//            }
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
                	if(map[j][i] != null) {
                		bw.write(map[j][i].getName()+","+i+","+j);
                		bw.newLine();
                	}
                }
            }

            bw.close();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public player layoutFromFile(String fileName,String name){
        player ply = new player(name);
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



    //Controllers
    public boolean pickPiece(int width,int length,String newPiece){
        piece picked = this.player_obj.findPiece(newPiece);
        if(picked == null) return false;
        if(this.player_obj.countPlayerPiece() >= 40) return false;

        if(picked.getAmount() != picked.getAmountInsert()) {
            map[width][length] = picked;

            picked.AmountInsertIncreace();
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean stillGame() {
    	return (player_obj.pieces[11].isAlive())&&(bot.pieces[11].isAlive());
    }
    
    public boolean whoWin(){
    	if(player_obj.pieces[11].isAlive()) return true;
    	return false;
    		
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
    
    public boolean PieceGo(int i,int j)
    {
    	
    	if((this.click[0] == -1) && (this.click[1] == -1))
    	{
    		this.click[0] = i;
    		this.click[1] = j;
    		return true;
    	}
    	else
    	{
    		boolean result = movePiecePlayer(click[0],click[1],i,j);
    		if(result)
    		{
    			this.click[0] = -1;
        		this.click[1] = -1;
        		this.botMove();
        		this.printmap();
    		}
    		return result;
    	}
    }
    
}
