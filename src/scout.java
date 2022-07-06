public class scout extends piece {
    public scout(player ply){
        super(ply);
        this.setName("scout");
        this.setAmount(8);
        this.setScore(4);
    }

    public boolean attack(piece markPiece) {
        if (this.getScore() > markPiece.getScore()) {
            return true;
        } else {
            return false;
        }

    }


    public int[][] canMove(int i,int j){

        int[][] canMoves = new int[100][2];
        int camount = 0;

        for(int k=0;k<10;k++){
            if(i+k<10){
                canMoves[camount][0] = i+k;
                canMoves[camount][1] = j;
                camount++;
            }
            else{
                canMoves[camount][0] = -2;
                camount++;
            }
        }
        for(int k=0;k<10;k++){
            if(j+k<10){
                canMoves[camount][0] = i;
                canMoves[camount][1] = j+k;
                camount++;
            }
            else{
                canMoves[camount][0] = -2;
                camount++;
            }
        }
        for(int k=0;k<10;k++){
            if(i-k>=0){
                canMoves[camount][0] = i-k;
                canMoves[camount][1] = j;
                camount++;
            }
            else{
                canMoves[camount][0] = -2;
                camount++;
            }
        }
        for(int k=0;k<10;k++){
            if(j-k>=0){
                canMoves[camount][0] = i;
                canMoves[camount][1] = j-k;
                camount++;
            }
            else{
                canMoves[camount][0] = -2;
                camount++;
            }
        }







        for(int u=0;u<4;u++){
            if((canMoves[u][0]==2)){
                if(canMoves[u][1]==5){
                    canMoves[u][0] = -2;
                }
                if(canMoves[u][1]==4){
                    canMoves[u][0] = -2;
                }
            }
            if((canMoves[u][0]==3)){
                if(canMoves[u][1]==5){
                    canMoves[u][0] = -2;
                }
                if(canMoves[u][1]==4){
                    canMoves[u][0] = -2;
                }
            }
            if((canMoves[u][0]==6)){
                if(canMoves[u][1]==5){
                    canMoves[u][0] = -2;
                }
                if(canMoves[u][1]==4){
                    canMoves[u][0] = -2;
                }
            }
            if((canMoves[u][0]==7)){
                if(canMoves[u][1]==5){
                    canMoves[u][0] = -2;
                }
                if(canMoves[u][1]==4){
                    canMoves[u][0] = -2;
                }
            }

        }




        return canMoves;
    }

}