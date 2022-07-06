public class scout extends piece {
    public scout(player ply){
        super(ply);
        this.setName("scout");
        this.setAmount(8);
        this.setScore(4);
    }

    public boolean attack(piece markPiece) {
        if (this.getScore() > markPiece.getScore()) {
            return true;
        } else {
            return false;
        }

    }

}