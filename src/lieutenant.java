public class lieutenant extends piece {
    public lieutenant() {
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