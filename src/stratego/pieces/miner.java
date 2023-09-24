package stratego.pieces;

import stratego.piece;
import stratego.player;

public class miner extends piece {
    public miner(player ply){
        super(ply);
        this.setName("miner");
        this.setAmount(5);
        this.setScore(5);
    }

    public boolean attack(piece markPiece) {
        if (this.getScore() > markPiece.getScore()) {
            return true;
        } else {
            return false;
        }

    }

}