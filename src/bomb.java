public class bomb extends piece {
    public bomb(player ply){
        super(ply);
        this.setName("bomb");
        this.setAmount(6);
        this.setScore(2);
    }

    public boolean attack(piece markPiece) {
        if (this.getScore() > markPiece.getScore()) {
            return true;
        } else {
            return false;
        }

    }

}