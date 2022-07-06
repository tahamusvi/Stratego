public class major extends piece{
    public major(player ply){
        super(ply);
        this.setName("major");
        this.setAmount(3);
        this.setScore(9);
    }
    public boolean attack(piece markPiece){
        if(this.getScore()>markPiece.getScore()){
            return true;
        } else{
            return false;
        }

    }
}
