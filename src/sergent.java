public class sergent extends piece {
    public sergent() {
        this.setName("sergent");
        this.setAmount(4);
        this.setScore(6);
    }

    public boolean attack(piece markPiece) {
        if (this.getScore() > markPiece.getScore()) {
            return true;
        } else {
            return false;
        }

    }

}