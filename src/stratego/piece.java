package stratego;
import java.util.ArrayList;
import java.util.List;

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

    public int[][] canMove(int i, int j) {
        List<int[]> canMoves = new ArrayList<>();

        if (i <= 98) {
            canMoves.add(new int[]{i + 1, j});
        } else {
            canMoves.add(new int[]{-2, 0});
        }

        if (j <= 98) {
            canMoves.add(new int[]{i, j + 1});
        } else {
            canMoves.add(new int[]{-2, 0});
        }

        if (i - 1 >= 0) {
            canMoves.add(new int[]{i - 1, j});
        } else {
            canMoves.add(new int[]{-2, 0});
        }

        if (j - 1 >= 0) {
            canMoves.add(new int[]{i, j - 1});
        } else {
            canMoves.add(new int[]{-2, 0});
        }

        int[][] invalidMoves = {
                {2, 5},
                {2, 4},
                {3, 5},
                {3, 4},
                {6, 5},
                {6, 4},
                {7, 5},
                {7, 4}
        };

        for (int[] move : canMoves) {
            for (int[] invalidMove : invalidMoves) {
                if (move[0] == invalidMove[0] && move[1] == invalidMove[1]) {
                    move[0] = -2;
                    break;
                }
            }
        }

        return canMoves.toArray(new int[canMoves.size()][]);
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
    public void AmountInsertIncreaceInGame() {
        this.amountInsert++;
        this.amountAlive++;
    }
    public void AmountInsertIncreace() {
        this.amountInsert++;
    }
    public void AmountInsertDecreaceInGame() {
        this.amountInsert--;
        this.amountAlive--;
    }
    public void AmountInsertDecreace() {
        this.amountInsert--;
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
    
    public boolean isRemain() {
    	if(this.amountInsert < this.amount) return true;
    	return false;
    }
    
    public int remain() {
    	return this.amount - this.amountInsert;
    }
    
    public String getLabelText() {
    	return this.getName() + " (" + this.remain()+")";
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
