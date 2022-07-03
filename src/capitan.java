public class capitan extends piece {
    public capitan() {
        this.setName("capitan");
        this.setAmount(4);
        this.setScore(8);
    }

    public boolean attack(piece markPiece) {
        if (this.getScore() > markPiece.getScore()) {
            return true;
        } else {
            return false;
        }

    }

}