package stratego.pieces;

import stratego.piece;
import stratego.player;

public class sergent extends piece {
    public sergent(player ply){
        super(ply);
        this.setName("sergent");
        this.setAmount(4);
        this.setScore(6);
    }

    public boolean attack(piece markPiece) {
        if (this.getScore() > markPiece.getScore()) {
            return true;
        } else {
            return false;
        }

    }

}