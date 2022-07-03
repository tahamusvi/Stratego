public class table {
    private int width = 1;
    private int length = 1;
    private piece[][] map ;

    public table(int width,int length){
        setLength(length);
        setWidth(width);
        map = new piece[getWidth()][getLength()];

    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void print(){
        for(int i = 0;i<getLength();i++){
            for(int j = 0;j<getWidth();j++){
                System.out.println(map[i][j]);
            }
        }
    }

    public boolean canMovePiece(int i,int j){
        piece mark = map[i][j];
        mark.canMove(i,j);
        return true;
    }

    public void game(){
        System.out.println("Start Game: ");
        int insPiece = 0 ;
        System.out.println("Pieces: ");
        while(insPiece == 41){
            int marshal = 1;
            int general = 2;

        }

    }

    public boolean insertPiece(int length,int width,piece newPiece){
        map[width][length] = newPiece;
        return true;
    }

    public static void main(String args[]){


        table str = new table(10,10);


    }

}
