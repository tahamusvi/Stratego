public class island extends piece{
    public island(player ply){
        super(ply);
        this.setName("island");
        this.setAmount(1);
        this.setScore(13);
    }
    public boolean attack(piece markPiece){
        return true;

    }
}