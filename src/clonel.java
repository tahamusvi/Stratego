public class clonel extends piece{
    public clonel(){
        this.setName("clonel");
        this.setAmount(2);
        this.setScore(10);
    }
    public boolean attack(piece markPiece){
        if(this.getScore()>markPiece.getScore()){
            return true;
        } else{
            return false;
        }

    }
}
