import java.util.*;
import java.util.concurrent.TimeUnit;

public class Head {

  public static void main (String args[]){

    Chessboard chessBoard = new Chessboard ();
    System.out.println (chessBoard + "\n");
    Chessboard.Chesspiece[] pieces = new Chessboard.Chesspiece[4];
    pieces[0] = chessBoard.new Pawn ('w', 'P');
    pieces[1] = chessBoard.new Rook ('b', 'R');
    pieces[2] = chessBoard.new Queen ('w', 'Q');
    pieces[3] = chessBoard.new Bishop ('w', 'B');
    pieces[4] = chessBoard.new King ('b', 'K');
    pieces[5] = chessBoard.new Knight ('w', 'N');

    Random rnd = new Random();
    for(Chessboard.Chesspiece c: pieces){

      try {
        char x = (char) (rnd.nextInt(7) + 'a');
        int y = rnd.nextInt(7) + 1;
        c.moveTo(x, y);
        c.markReachableFields();
        System.out.println(chessBoard);
        c.unmarkReachableFields();
        TimeUnit.SECONDS.sleep(2);
        c.moveOut();

      } catch(Exception e){
        System.out.println(e.getMessage());
      }
    }




  }
}
