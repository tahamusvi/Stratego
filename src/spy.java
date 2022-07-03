public class spy extends piece {
    public spy() {
        this.setName("spy");
        this.setAmount(1);
        this.setScore(3);
    }

    public boolean attack(piece markPiece) {
        if (this.getScore() > markPiece.getScore()) {
            return true;
        } else {
            return false;
        }

    }

}