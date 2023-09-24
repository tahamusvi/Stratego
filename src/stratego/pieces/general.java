package stratego.pieces;

import stratego.piece;
import stratego.player;

public class general extends piece {
    public general(player ply){
        super(ply);
        this.setName("general");
        this.setAmount(1);
        this.setScore(11);
    }
    public boolean attack(piece markPiece){
        if(this.getScore()>markPiece.getScore()){
            return true;
        } else{
            return false;
        }

    }

}
