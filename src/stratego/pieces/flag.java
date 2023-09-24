package stratego.pieces;

import stratego.piece;
import stratego.player;

public class flag extends piece {
    public flag(player ply){
        super(ply);
        this.setName("flag");
        this.setAmount(1);
        this.setScore(0);
    }

    public boolean attack(piece markPiece) {
        return false;

    }

    public int[][] canMove(int i,int j){
//        for flag cant move
        int[][] temp = new int[4][2];
        for(int u = 0;u<4;u++){
            temp[u][0] = -2;
            temp[u][1] = 1;
        }

        return temp;
    }

}



