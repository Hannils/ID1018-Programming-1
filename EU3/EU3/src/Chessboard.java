import java.util.*;

public class Chessboard {

  public static class Field {
	private char row;
	private int column;
	private Chesspiece piece = null;
	private boolean marked = false;

	public Field(char row, int column) {
	  this.row = row;
	  this.column = column;
	}

	public void put(Chesspiece piece) {
	  this.piece = piece;
	}

	public void take() {
	  this.piece = null;
	}

	public void mark() {
	  this.marked = true;
	}

	public void unmark() {
	  this.marked = false;
	}

	public String toString() {
	  String s = (marked) ? "xx" : "--";
	  return (piece == null) ? s : piece.toString();
	}
  }

  public static final int NUMBER_OF_ROWS = 8;
  public static final int NUMBER_OF_COLUMNS = 8;

  public static final int FIRST_ROW = 'a';
  public static final int FIRST_COLUMN = 1;

  private Field[][] fields;

  public Chessboard() {
	fields = new Field[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
	char row = 0;
	int column = 0;
	for (int r = 0; r < NUMBER_OF_ROWS; r++) {
	  row = (char) (FIRST_ROW + r);
	  column = FIRST_COLUMN;
	  for (int c = 0; c < NUMBER_OF_COLUMNS; c++) {
		fields[r][c] = new Field(row, column);
		column++;
	  }
	}
  }

  public String toString() {
	StringBuilder stringBuilder = new StringBuilder();
	stringBuilder.append("   1   2   3   4   5   6   7   8\n\n");
	for (int i = 0; i < NUMBER_OF_ROWS; i++) {
	  char rowName = (char) (FIRST_ROW + i);
	  stringBuilder.append(rowName).append("  ");
	  for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
		stringBuilder.append(fields[i][j].toString()).append("  ");
	  }
	  stringBuilder.append("\n\n");
	}
	return stringBuilder.toString();
  }

  public boolean isValidField(char row, int column) {
	if (row >= 'a' && row <= 'h' && column >= 0 && column <= NUMBER_OF_COLUMNS - 1) {
	  return true;
	} else {
	  return false;
	}
  }

  public abstract class Chesspiece {
	private char color;
	//w - white, b - black

	private char name;
	//K - King, Q - Queen, R - Rook, B - Bishop, N - Knight, P - Pawn

	protected char row = 0;
	protected int column = -1;

	protected Chesspiece(char color, char name) {
	  this.color = color;
	  this.name = name;
	}

	public String toString() {
	  return "" + color + name;
	}

	public boolean isOnBoard() {
	  return Chessboard.this.isValidField(row, column);
	}

	public void moveTo(char row, int column) throws NotValidFieldException {
	  if (!Chessboard.this.isValidField(row, column))
		throw new NotValidFieldException("bad field: " + row + column);

	  this.row = row;
	  this.column = column;

	  int r = row - FIRST_ROW;
	  int c = column - FIRST_COLUMN;
	  Chessboard.this.fields[r][c].put(this);
	}

	public void moveOut() {
	  Chessboard.this.fields[row - FIRST_ROW][column - FIRST_COLUMN].take();
	}

	public abstract void markReachableFields();

	public abstract void unmarkReachableFields();
  }

  public class Pawn extends Chesspiece {

	public Pawn(char color, char name) {
	  super(color, name);
	}

	public void markReachableFields() {
	  int col = (int) (column + 1);
	  if (Chessboard.this.isValidField(row, col)) {
		int r = row - FIRST_ROW;
		int c = col - FIRST_COLUMN;
		Chessboard.this.fields[r][c].mark();
	  }
	}

	public void unmarkReachableFields() {
	  int col = (int) (column + 1);
	  if (Chessboard.this.isValidField(row, col)) {
		int r = row - FIRST_ROW;
		int c = col - FIRST_COLUMN;
		Chessboard.this.fields[r][c].unmark();
	  }
	}
  }

  public class Rook extends Chesspiece {
	public Rook(char color, char name) {
	  super(color, 'R');
	}

	public void markReachableFields() {

	  int col = column - 1;
	  int r = row - FIRST_ROW;
	  while (Chessboard.this.isValidField(row, col)) {
		Chessboard.this.fields[r][col].mark();
		col++;
	  }
	  col = column - 1;
	  r = row - FIRST_ROW;
	  while (Chessboard.this.isValidField(row, col)) {
		Chessboard.this.fields[r][col].mark();
		col--;
	  }
	  col = column - 1;
	  r = row - FIRST_ROW;
	  char r2 = row;
	  while (Chessboard.this.isValidField(r2, column)) {
		Chessboard.this.fields[r][col].mark();
		r++;
		r2++;
	  }
	  col = column - 1;
	  r = row - FIRST_ROW;
	  r2 = row;
	  while (Chessboard.this.isValidField((char) r2, column)) {
		Chessboard.this.fields[r][col].mark();
		r--;
		r2--;
	  }
	}

	public void unmarkReachableFields() {
	  int col = column - 1;
	  int r = row - FIRST_ROW;
	  while (Chessboard.this.isValidField(row, col)) {
		Chessboard.this.fields[r][col].unmark();
		col++;
	  }
	  col = column - 1;
	  r = row - FIRST_ROW;
	  while (Chessboard.this.isValidField(row, col)) {
		Chessboard.this.fields[r][col].unmark();
		col--;
	  }
	  col = column - 1;
	  r = row - FIRST_ROW;
	  char r2 = row;
	  while (Chessboard.this.isValidField(r2, column)) {
		Chessboard.this.fields[r][col].mark();
		r++;
		r2++;
	  }
	  col = column - 1;
	  r = row - FIRST_ROW;
	  r2 = row;
	  while (Chessboard.this.isValidField((char) r2, column)) {
		Chessboard.this.fields[r][col].mark();
		r--;
		r2--;
	  }
	}
  }

  public class Knight extends Chesspiece {
	public Knight(char color, char name) {
	  super(color, name);
	}

	int[] xr = {1, 2, -1, -2, 1, 2, -1, -2};
	int[] xc = {2, 1, 2, 1, -2, -1, -2, -1};
	int col;
	int r;

	public void markReachableFields() {
	  for (int i = 0; i < NUMBER_OF_COLUMNS; i++) {
		if (Chessboard.this.isValidField((char) (row + xr[i]), (column + xc[i]))) {
		  r = row + xr[i] - FIRST_ROW;
		  col = column + xc[i] - FIRST_COLUMN;
		  Chessboard.this.fields[r][col].mark();
		}
	  }
	}

	public void unmarkReachableFields() {
	  for (int i = 0; i < NUMBER_OF_COLUMNS; i++) {
		if (Chessboard.this.isValidField((char) (row + xr[i]), (column + xc[i]))) {
		  r = row + xr[i] - FIRST_ROW;
		  col = column + xc[i] - FIRST_COLUMN;
		  Chessboard.this.fields[r][col].unmark();
		}
	  }
	}
  }

  public class Bishop extends Chesspiece {
	public Bishop(char color, char name) {
	  super(color, name);
	}

	public void markReachableFields() {
	  int col = column - 1;
	  int r = row - FIRST_ROW;
	  char r2 = row;
	  while (Chessboard.this.isValidField(r2, col)) {
		Chessboard.this.fields[r][col].mark();
		col--;
		r--;
		r2--;
	  }
	  col = column - 1;
	  r = row - FIRST_ROW;
	  r2 = row;
	  while (Chessboard.this.isValidField(r2, col)) {
		Chessboard.this.fields[r][col].mark();
		r++;
		col--;
	  }
	  col = column - 1;
	  r = row - FIRST_ROW;
	  r2 = row;
	  while (Chessboard.this.isValidField(r2, col)) {
		Chessboard.this.fields[r][col].mark();
		r--;
		col++;
		r2--;
	  }
	  col = column - 1;
	  r = row - FIRST_ROW;
	  r2 = row;
	  while (Chessboard.this.isValidField(r2, col)) {
		Chessboard.this.fields[r][col].mark();
		r++;
		col++;
		r2++;
	  }
	}

	public void unmarkReachableFields() {
	  int col = column - 1;
	  int r = row - FIRST_ROW;
	  char r2 = row;
	  while (Chessboard.this.isValidField(r2, col)) {
		Chessboard.this.fields[r][col].unmark();
		col--;
		r--;
		r2--;
	  }
	  col = column - 1;
	  r = row - FIRST_ROW;
	  r2 = row;
	  while (Chessboard.this.isValidField(r2, col)) {
		Chessboard.this.fields[r][col].unmark();
		r++;
		col--;
	  }
	  col = column - 1;
	  r = row - FIRST_ROW;
	  r2 = row;
	  while (Chessboard.this.isValidField(r2, col)) {
		Chessboard.this.fields[r][col].unmark();
		r--;
		col++;
		r2--;
	  }
	  col = column - 1;
	  r = row - FIRST_ROW;
	  r2 = row;
	  while (Chessboard.this.isValidField(r2, col)) {
		Chessboard.this.fields[r][col].unmark();
		r++;
		col++;
		r2++;
	  }
	}
  }

  public class Queen extends Chesspiece {
	public Queen(char color, char name) {
	  super(color, name);
	}

	public void markReachableFields() {
	  int col = column - 1;
	  int r = row - FIRST_ROW;
	  while (Chessboard.this.isValidField(row, col)) {
		Chessboard.this.fields[r][col].mark();
		col++;
	  }
	  col = column - 1;
	  r = row - FIRST_ROW;
	  while (Chessboard.this.isValidField(row, col)) {
		Chessboard.this.fields[r][col].mark();
		col--;
	  }
	  col = column - 1;
	  r = row - FIRST_ROW;
	  char r2 = row;
	  while (Chessboard.this.isValidField(r2, column)) {
		Chessboard.this.fields[r][col].mark();
		r++;
		r2++;
	  }
	  col = column - 1;
	  r = row - FIRST_ROW;
	  r2 = row;
	  while (Chessboard.this.isValidField((char) r2, column)) {
		Chessboard.this.fields[r][col].mark();
		r--;
		r2--;
	  }

	}

	public void unmarkReachableFields() {
	  int col = column - 1;
	  int r = row - FIRST_ROW;
	  while (Chessboard.this.isValidField(row, col)) {
		Chessboard.this.fields[r][col].unmark();
		col++;
	  }
	  col = column - 1;
	  r = row - FIRST_ROW;
	  while (Chessboard.this.isValidField(row, col)) {
		Chessboard.this.fields[r][col].unmark();
		col--;
	  }
	  col = column - 1;
	  r = row - FIRST_ROW;
	  char r2 = row;
	  while (Chessboard.this.isValidField(r2, column)) {
		Chessboard.this.fields[r][col].mark();
		r++;
		r2++;
	  }
	  col = column - 1;
	  r = row - FIRST_ROW;
	  r2 = row;
	  while (Chessboard.this.isValidField((char) r2, column)) {
		Chessboard.this.fields[r][col].mark();
		r--;
		r2--;
	  }
	}

  }


  public class King extends Chesspiece {
	public King(char color, char name) {
	  super(color, name);
	}



	public void markReachableFields() {
	  int[] xr = {0, -1, -1, -1, 1, 1,  1, 0 ,0};
	  int[] xc = {0,  0,  1, -1, 0, 1, -1, -1, 1};
	  int r = 0;
	  int col = 0;


	  for(int i = 0; i < NUMBER_OF_COLUMNS; i++){
	    if(Chessboard.this.isValidField( (char)(row + xr[i]), (column + xc[i]) )){
	      r = row - FIRST_ROW + xr[i];
	      col = column + xc[i];
	      Chessboard.this.fields[r][col].mark();
		}
	  }
	}

	public void unmarkReachableFields() {

	  int[] xr = {-1, -1, -1, 1, 1,  1, 0 ,0};
	  int[] xc = { 0,  1, -1, 0, 1, -1, -1, 1};
	  int r = 0;
	  int col = 0;

	  for (int i = 0; i < NUMBER_OF_COLUMNS; i++) {
		if(Chessboard.this.isValidField( (char)(row + xr[i]), (column + xc[i]) )){
		  r = row + xr[i];
		  col = column + xc[i];
		  Chessboard.this.fields[r][col].unmark();
		}
	  }
	}

  }

  public class NotValidFieldException extends Exception {
	public NotValidFieldException(String errorMessage) {
	  super(errorMessage);
	}
  }


}