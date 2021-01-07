import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Head {

  public static void main (String args[]) throws Chessboard.NotValidFieldException, InterruptedException {

	Chessboard chessBoard = new Chessboard ();
	System.out.println (chessBoard + "\n");

	Chessboard.Chesspiece[] pieces = new Chessboard.Chesspiece[6];
	pieces[0] = chessBoard.new Pawn ('w', 'P');
	pieces[1] = chessBoard.new Rook ('b', 'R');
	pieces[2] = chessBoard.new Queen ('w', 'Q');
	pieces[3] = chessBoard.new Bishop ('w', 'B');
	pieces[4] = chessBoard.new King ('b', 'K');
	pieces[5] = chessBoard.new Knight ('w', 'N');

	Random rand = new Random();

	for (Chessboard.Chesspiece piece : pieces) {
	  	char x = (char) (rand.nextInt(8) + 'a');
	  	int y = rand.nextInt(8);
		piece.moveTo(x, (byte) (y + 1));
		piece.markReachableFields();
		System.out.println(chessBoard + "\n");
	  	Thread.sleep(1 * 1000);
		piece.unmarkReachableFields();
		piece.moveOut();


	}
  }

  }


