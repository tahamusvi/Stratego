public class flag extends piece {
    public flag(player ply){
        super(ply);
        this.setName("flag");
        this.setAmount(1);
        this.setScore(0);
    }

    public boolean attack(piece markPiece) {
        if (this.getScore() > markPiece.getScore()) {
            return true;
        } else {
            return false;
        }

    }

}



