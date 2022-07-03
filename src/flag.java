public class flag extends piece {
    public flag() {
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