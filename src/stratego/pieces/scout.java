package stratego.pieces;

import stratego.piece;
import stratego.player;

public class scout extends piece {
    public scout(player ply){
        super(ply);
        this.setName("scout");
        this.setAmount(8);
        this.setScore(4);
    }

    public boolean attack(piece markPiece) {
    	System.out.println(this.getScore() );
    	System.out.println(markPiece.getScore() );

        if (this.getScore() > markPiece.getScore()) return true;
        return false;
    }


    public int[][] canMove(int i, int j) {
        int[][] canMoves = new int[40][2];
        int camount = 0;

        for (int k = 0; k < 10; k++) {
            if (i + k < 10) {
                canMoves[camount][0] = i + k;
                canMoves[camount][1] = j;
            } else {
                canMoves[camount][0] = -2;
            }
            camount++;
        }

        for (int k = 0; k < 10; k++) {
            if (j + k < 10) {
                canMoves[camount][0] = i;
                canMoves[camount][1] = j + k;
            } else {
                canMoves[camount][0] = -2;
            }
            camount++;
        }

        for (int k = 0; k < 10; k++) {
            if (i - k >= 0) {
                canMoves[camount][0] = i - k;
                canMoves[camount][1] = j;
            } else {
                canMoves[camount][0] = -2;
            }
            camount++;
        }

        for (int k = 0; k < 10; k++) {
            if (j - k >= 0) {
                canMoves[camount][0] = i;
                canMoves[camount][1] = j - k;
            } else {
                canMoves[camount][0] = -2;
            }
            camount++;
        }

        int[][] invalidMoves = {
                {2, 5},
                {2, 4},
                {3, 5},
                {3, 4},
                {6,4},
                {6, 5},
                {7, 4},
                {7, 5}
        };

        for (int u = 0; u < camount; u++) {
            for (int[] invalidMove : invalidMoves) {
                if (canMoves[u][0] == invalidMove[0] && canMoves[u][1] == invalidMove[1]) {
                    canMoves[u][0] = -2;
                    break;
                }
            }
        }

        return canMoves;
    }

}