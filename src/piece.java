public abstract class piece {
    private int Score;
    private boolean color;
//    true --> red
//    false --> blue
    private int amount;
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
    public abstract boolean attack(piece markPiece);

    public int getScore() {
        return Score;
    }
    public void setScore(int score) {
        Score = score;
    }

    public void setColor(boolean color) {
        this.color = color;
    }
}
