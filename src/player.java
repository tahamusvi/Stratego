public class player {
    public String name;
    public piece[] pieces;
    public player(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }

    public int countPlayerPiece()
    {
        int count = 0;
        for(piece mark : this.pieces){
            count += mark.getAmountInsert();
        }

        return count;
    }

    public piece findPiece(String name)
    {
        for(piece mark : this.pieces){
            if(mark.getName().equals(name)){
                return mark;
            }
        }
        return null;
    }
}
