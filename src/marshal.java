public class marshal extends piece{
    public marshal(player ply){
        super(ply);
        this.setName("marshal");
        this.setAmount(1);
        this.setScore(12);
    }
    public boolean attack(piece markPiece){
        if(this.getScore()>markPiece.getScore()){
            return true;
        } else{
            return false;
        }

    }
}
