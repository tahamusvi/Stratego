public abstract class piece {
    private player owner;
    private int Score;
    private String name;
    private int amountAlive;
    private boolean color;
//    true --> red
//    false --> blue
    private int amountInsert = 0;
    private int amount;




    public piece(player ply){
        this.owner = ply;

    }
    public int[][] canMove(int i,int j){

        int[][] canMoves = new int[4][2];
        int camount = 0;

        if(i<=98){
            canMoves[camount][0] = i+1;
            canMoves[camount][1] = j;
            camount++;
        }
        else{
            canMoves[camount][0] = -2;
            camount++;
        }

        if(j<=98){
            canMoves[camount][0] = i;
            canMoves[camount][1] = j+1;
            camount++;
        }
        else{
            canMoves[camount][0] = -2;
            camount++;
        }

        if(i-1>=0){
            canMoves[camount][0] = i-1;
            canMoves[camount][1] = j;
            camount++;
        }
        else{
            canMoves[camount][0] = -2;
            camount++;
        }
        if(j-1>=0){
            canMoves[camount][0] = i;
            canMoves[camount][1] = j-1;
            camount++;
        }
        else{
            canMoves[camount][0] = -2;
            camount++;
        }


        return canMoves;
    }

    public boolean isAlive(){
        if(this.getAmountInsert()>0){
            return true;
        }
        return false;
    }
    public abstract boolean attack(piece markPiece);
    public player getOwner() {
        return owner;
    }
    public int getScore() {
        return Score;
    }
    public void setScore(int score) {
        Score = score;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public int getAmountInsert() {
        return amountInsert;
    }
    public void AmountInsertIncreace() {
        this.amountInsert++;
        this.amountAlive++;
    }
    public void AmountInsertDecreace() {
        this.amountInsert--;
        this.amountAlive--;
    }
    public int getAmount() {
        return amount;
    }
    public void setColor(boolean color) {
        this.color = color;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String toString(){
        int len = this.getName().length();

        len = 10 - len;

        String tempName = "";

        if(len % 2 == 0){
            for(int i =0;i<len/2;i++){
                tempName += " ";
            }
            tempName +=  this.getName();
            for(int i =0;i<len/2;i++){
                tempName += " ";
            }
        }
        else{
            for(int i =0;i<(len-1)/2;i++){
                tempName += " ";
            }
            tempName +=  this.getName();
            for(int i =0;i<(len+1)/2;i++){
                tempName += " ";
            }

        }
        return tempName;
    }
}
