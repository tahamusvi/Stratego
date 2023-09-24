package stratego.pieces;

import stratego.piece;
import stratego.player;

public class bomb extends piece {
    public bomb(player ply){
        super(ply);
        this.setName("bomb");
        this.setAmount(6);
        this.setScore(13);
    }

    public boolean attack(piece markPiece) {
        if(markPiece.getName() == "miner"){
            return false;
        }
        else{
            return true;
        }
    }

    public int[][] canMove(int i,int j){
//        for bomb cant move
       int[][] temp = new int[4][2];
       for(int u = 0;u<4;u++){
           temp[u][0] = -2;
           temp[u][1] = 1;
       }

       return temp;
    }

}