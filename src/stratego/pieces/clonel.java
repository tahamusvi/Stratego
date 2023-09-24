package stratego.pieces;

import stratego.piece;
import stratego.player;

public class clonel extends piece{
    public clonel(player ply){
        super(ply);
        this.setName("clonel");
        this.setAmount(2);
        this.setScore(10);
    }
    public boolean attack(piece markPiece){
        if(this.getScore()>markPiece.getScore()){
            return true;
        } else{
            return false;
        }

    }
}
