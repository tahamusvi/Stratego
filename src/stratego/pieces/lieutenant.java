package stratego.pieces;

import stratego.piece;
import stratego.player;

public class lieutenant extends piece {
    public lieutenant(player ply){
        super(ply);
        this.setName("lieutenant");
        this.setAmount(4);
        this.setScore(7);
    }

    public boolean attack(piece markPiece) {
        if (this.getScore() > markPiece.getScore()) {
            return true;
        } else {
            return false;
        }

    }

}