package stratego.pieces;

import stratego.piece;
import stratego.player;

public class spy extends piece {
    public spy(player ply){
        super(ply);
        this.setName("spy");
        this.setAmount(1);
        this.setScore(3);
    }

    public boolean attack(piece markPiece) {
        if(markPiece.getName()=="marshal"){
            return true;
        }
        else{
            if (this.getScore() > markPiece.getScore()) {
                return true;
            } else {
                return false;
            }
        }

    }

}