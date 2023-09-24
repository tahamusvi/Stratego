package stratego.pieces;

import stratego.piece;
import stratego.player;

public class island extends piece{
    public island(player ply){
        super(ply);
        this.setName("Sea");
        this.setAmount(1);
        this.setScore(13);
    }
    public boolean attack(piece markPiece){
        return true;

    }
}