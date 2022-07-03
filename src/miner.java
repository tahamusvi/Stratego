public class miner extends piece {
    public miner() {
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