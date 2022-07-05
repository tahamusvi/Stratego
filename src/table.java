import java.util.Scanner;

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

    public int getPositiony(){
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        while((6>i)||(i>10)){
            System.out.println("enter again: ");
            i = sc.nextInt();
        }
        return i ;
    }

    public int getPositionx(){
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        while((0>i)||(i>10)){
            System.out.println("enter again: ");
            i = sc.nextInt();
        }
        return i ;
    }

    public void game(){
        System.out.println("Start Game: ");
        int insPiece = 0 ;
        System.out.println("Pieces: ");

        piece[] pieces = new piece[12];

        pieces[0] = new marshal();
        pieces[1] = new general();
        pieces[2] = new clonel();
        pieces[3] = new major();
        pieces[4] = new capitan();
        pieces[5] = new lieutenant();
        pieces[6] = new sergent();
        pieces[7] = new miner();
        pieces[8] = new scout();
        pieces[9] = new spy();
        pieces[10] = new bomb();
        pieces[11] = new flag();

        boolean cunt = true;

       while(cunt){
           for(piece mark : pieces){
               if(mark.getAmount()!= mark.getAmountInsert()){
                   System.out.println(mark + " left :" + (mark.getAmount()-mark.getAmountInsert()));
               }
           }
           int chose=2;
           int i,j;
           Scanner sc = new Scanner(System.in);


           int counter = 1;

           for(piece mark : pieces){
               if(mark.getAmount()!= mark.getAmountInsert()){
                   System.out.println(counter + ". " + mark);
                   counter++;
               }
               else{
                   counter++;
               }
           }
           System.out.println("enter number piece:");
           chose = sc.nextInt();

           switch (chose){
               case 1:
//                Marshal
                   if(pieces[0].getAmount()!= pieces[0].getAmountInsert()){
                       System.out.println("enter width:");
                       j = this.getPositiony();
                       System.out.println("enter length:");
                       i = this.getPositionx();
                       if(map[i][j] == null){
                           this.insertPiece(i,j,pieces[0]);
                       }
                       else{
                           System.out.println("IS full chose other box");
                           System.out.println("enter width:");
                           j = this.getPositiony();
                           System.out.println("enter length:");
                           i = this.getPositionx();
                           this.insertPiece(i,j,pieces[0]);
                       }
                       break;
                   }
                   else{
                       System.out.println("amount few");
                       break;
                   }

               case 2:
//                General
                   if(pieces[1].getAmount()!= pieces[1].getAmountInsert()){
                       System.out.println("enter width:");
                       j = this.getPositiony();
                       System.out.println("enter length:");
                       i = this.getPositionx();
                       if(map[i][j] == null){
                           this.insertPiece(i,j,pieces[1]);
                       }
                       else{
                           System.out.println("IS full chose other box");
                           System.out.println("enter width:");
                           j = this.getPositiony();
                           System.out.println("enter length:");
                           i = this.getPositionx();
                           this.insertPiece(i,j,pieces[1]);
                       }
                       break;
                   }
                   else{
                       System.out.println("amount few");
                       break;
                   }
               case 3:
//                Clonel
                   if(pieces[2].getAmount()!= pieces[2].getAmountInsert()){
                       System.out.println("enter width:");
                       j = this.getPositiony();
                       System.out.println("enter length:");
                       i = this.getPositionx();
                       if(map[i][j] == null){
                           this.insertPiece(i,j,pieces[2]);
                       }
                       else{
                           System.out.println("IS full chose other box");
                           System.out.println("enter width:");
                           j = this.getPositiony();
                           System.out.println("enter length:");
                           i = this.getPositionx();
                           this.insertPiece(i,j,pieces[2]);
                       }
                       break;
                   }
                   else{
                       System.out.println("amount few");
                       break;
                   }
               case 4:
//                Major
                   if(pieces[3].getAmount()!= pieces[3].getAmountInsert()){
                       System.out.println("enter width:");
                       j = this.getPositiony();
                       System.out.println("enter length:");
                       i = this.getPositionx();
                       if(map[i][j] == null){
                           this.insertPiece(i,j,pieces[3]);
                       }
                       else{
                           System.out.println("IS full chose other box");
                           System.out.println("enter width:");
                           j = this.getPositiony();
                           System.out.println("enter length:");
                           i = this.getPositionx();
                           this.insertPiece(i,j,pieces[3]);
                       }
                       break;
                   }
                   else{
                       System.out.println("amount few");
                       break;
                   }
               case 5:
//                Capitan
                   if(pieces[4].getAmount()!= pieces[4].getAmountInsert()){
                       System.out.println("enter width:");
                       j = this.getPositiony();
                       System.out.println("enter length:");
                       i = this.getPositionx();
                       if(map[i][j] == null){
                           this.insertPiece(i,j,pieces[4]);
                       }
                       else{
                           System.out.println("IS full chose other box");
                           System.out.println("enter width:");
                           j = this.getPositiony();
                           System.out.println("enter length:");
                           i = this.getPositionx();
                           this.insertPiece(i,j,pieces[4]);
                       }
                       break;
                   }
                   else{
                       System.out.println("amount few");
                       break;
                   }
               case 6:
//                Lieutenant
                   if(pieces[5].getAmount()!= pieces[5].getAmountInsert()){
                       System.out.println("enter width:");
                       j = this.getPositiony();
                       System.out.println("enter length:");
                       i = this.getPositionx();
                       if(map[i][j] == null){
                           this.insertPiece(i,j,pieces[5]);
                       }
                       else{
                           System.out.println("IS full chose other box");
                           System.out.println("enter width:");
                           j = this.getPositiony();
                           System.out.println("enter length:");
                           i = this.getPositionx();
                           this.insertPiece(i,j,pieces[5]);
                       }
                       break;
                   }
                   else{
                       System.out.println("amount few");
                       break;
                   }
               case 7:
//                Sergent
                   if(pieces[6].getAmount()!= pieces[6].getAmountInsert()){
                       System.out.println("enter width:");
                       j = this.getPositiony();
                       System.out.println("enter length:");
                       i = this.getPositionx();
                       if(map[i][j] == null){
                           this.insertPiece(i,j,pieces[6]);
                       }
                       else{
                           System.out.println("IS full chose other box");
                           System.out.println("enter width:");
                           j = this.getPositiony();
                           System.out.println("enter length:");
                           i = this.getPositionx();
                           this.insertPiece(i,j,pieces[6]);
                       }
                       break;
                   }
                   else{
                       System.out.println("amount few");
                       break;
                   }
               case 8:
//                Miner
                   if(pieces[7].getAmount()!= pieces[7].getAmountInsert()){
                       System.out.println("enter width:");
                       j = this.getPositiony();
                       System.out.println("enter length:");
                       i = this.getPositionx();
                       if(map[i][j] == null){
                           this.insertPiece(i,j,pieces[7]);
                       }
                       else{
                           System.out.println("IS full chose other box");
                           System.out.println("enter width:");
                           j = this.getPositiony();
                           System.out.println("enter length:");
                           i = this.getPositionx();
                           this.insertPiece(i,j,pieces[7]);
                       }
                       break;
                   }
                   else{
                       System.out.println("amount few");
                       break;
                   }
               case 9:
//                Scout
                   if(pieces[8].getAmount()!= pieces[8].getAmountInsert()){
                       System.out.println("enter width:");
                       j = this.getPositiony();
                       System.out.println("enter length:");
                       i = this.getPositionx();
                       if(map[i][j] == null){
                           this.insertPiece(i,j,pieces[8]);
                       }
                       else{
                           System.out.println("IS full chose other box");
                           System.out.println("enter width:");
                           j = this.getPositiony();
                           System.out.println("enter length:");
                           i = this.getPositionx();
                           this.insertPiece(i,j,pieces[8]);
                       }
                       break;
                   }
                   else{
                       System.out.println("amount few");
                       break;
                   }
               case 10:
//                Spy
                   if(pieces[9].getAmount()!= pieces[9].getAmountInsert()){
                       System.out.println("enter width:");
                       j = this.getPositiony();
                       System.out.println("enter length:");
                       i = this.getPositionx();
                       if(map[i][j] == null){
                           this.insertPiece(i,j,pieces[9]);
                       }
                       else{
                           System.out.println("IS full chose other box");
                           System.out.println("enter width:");
                           j = this.getPositiony();
                           System.out.println("enter length:");
                           i = this.getPositionx();
                           this.insertPiece(i,j,pieces[9]);
                       }
                       break;
                   }
                   else{
                       System.out.println("amount few");
                       break;
                   }
               case 11:
//                Bomb
                   if(pieces[10].getAmount()!= pieces[10].getAmountInsert()){
                       System.out.println("enter width:");
                       j = this.getPositiony();
                       System.out.println("enter length:");
                       i = this.getPositionx();
                       if(map[i][j] == null){
                           this.insertPiece(i,j,pieces[10]);
                       }
                       else{
                           System.out.println("IS full chose other box");
                           System.out.println("enter width:");
                           j = this.getPositiony();
                           System.out.println("enter length:");
                           i = this.getPositionx();
                           this.insertPiece(i,j,pieces[10]);
                       }
                       break;
                   }
                   else{
                       System.out.println("amount few");
                       break;
                   }
               case 12:
//                Flag
                   if(pieces[11].getAmount()!= pieces[11].getAmountInsert()){
                       System.out.println("enter width:");
                       j = this.getPositiony();
                       System.out.println("enter length:");
                       i = this.getPositionx();
                       if(map[i][j] == null){
                           this.insertPiece(i,j,pieces[11]);
                       }
                       else{
                           System.out.println("IS full chose other box");
                           System.out.println("enter width:");
                           j = this.getPositiony();
                           System.out.println("enter length:");
                           i = this.getPositionx();
                           this.insertPiece(i,j,pieces[11]);
                       }
                       break;
                   }
                   else{
                       System.out.println("amount few");
                       break;
                   }
           }

           int insertedPiece = 0;
           for(piece mark : pieces){
               if(mark.getAmount()!= mark.getAmountInsert()){
                   insertedPiece += mark.getAmountInsert();
               }
           }
           if(insertedPiece == 41){
               cunt = false;
           }

           this.printmap();

       }

    }

    public boolean insertPiece(int length,int width,piece newPiece){
        map[width][length] = newPiece;
        newPiece.AmountInsertIncreace();
        return true;
    }

    public void ofogh(piece mark){
        if(mark==null){
            String space = "          ";
            System.out.print("|" + space );
        }
        else{
            System.out.print("|" + mark );
        }

    }
    public void emod(){
        System.out.print("-");
    }

    public void printmap(){
        for(int i =0;i<110;i++){
            this.emod();
        }
        System.out.println("");
        for(int j = 0 ; j<10;j++){
            for(int i =0;i<10;i++){
                this.ofogh(this.map[j][i]);
            }
            System.out.println("");
            for(int i =0;i<110;i++){
                this.emod();
            }
            System.out.println("");
        }
    }

    public static void main(String args[]){


        table str = new table(10,10);
        piece mar = new marshal();
        str.game();
//        str.insertPiece(0,0,mar);
//        str.insertPiece(9,9,mar);
        str.printmap();




    }

}
