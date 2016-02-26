package tictactoe;

/**
 * An implementation of the TicTacToeGame interface.
 * 
 * ATTENTION STUDENTS: You MUST use exactly this class specification. Do not 
 * rename the class, and do not remove the "implements TicTacToeGame", or
 * you will receive no credit for your submission.
 */
public class TicTacToe implements TicTacToeGame {
	/**
	 * Constructs a new instance, implementing the TicTacToeGame interface.
	 * 
	 * ATTENTION STUDENTS: You MUST use exactly this signature for your constructor.
	 * Do not rename the class and do not change the argument, or you will receive
	 * no credit for your submission.
	 * 
	 * @param n the length and width of the board; n >= 3
	 */
	private int row;
	private int col;
	private String[][] board;
	
	public TicTacToe(int n) {
		row = n;
		col = n;
		board = new String[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				board[i][j] = " ";
			}
		}
	}
	
	@Override
	public int getN() {
		return row;
	}

	@Override
	public String toString() {
		String emptySpace = "";
		int lastRow = 0;;
		for (int i = 0; i < row; i++) {	
			for (int j = 0; j < col; j++) {
				emptySpace += board[i][j];
			}
			lastRow = i;
			if (lastRow != (row - 1)) {
				emptySpace += "\n";
			}
		}
		return emptySpace;
	}

	@Override
	public String getWinner() {
		for (int i = 0; i < row; i++) {
			int x = 0;
			int o = 0;
			for (int j = 0; j < col; j++) {
				if (board[i][j].equals("X")) {
					x++;
				}
				else if (board[i][j].equals("O")) {
					o++;
				}
			}
			if (x == row) {
				return "X";
			}
			else if (o == row) {
				return "O";
			}
		}
		for (int i = 0; i < col; i++) {
			int x = 0;
			int o = 0;
			for (int j = 0; j < row; j++) {
				if (board[j][i].equals("X")) {
					x++;
				}
				else if (board[j][i].equals("O")) {
					o++;
				}
			}
			if (x == col) {
				return "X";
			}
			else if (o == col) {
				return "O";
			}
		}
		if (board[0][0].equals("X") || board[0][0].equals("O")) {
			int diagonalForward = 0;
			for (int i = 0; i < row; i++) {
				if (board[i][i].equals("X")) {
					diagonalForward++;
				}
				if (diagonalForward == row) {
					return "X";
				}
			}
			diagonalForward = 0;
			for (int i = 0; i < row; i++) {
				if (board[i][i].equals("O")) {
					diagonalForward++;
				}
				if (diagonalForward == row) {
					return "O";
				}
			}
		}
		if (board[row - 1][0].equals("X") || board[row - 1][0].equals("O")) {
			int diagonalBackward = 0;
			int rowD = row - 1;
			for (int i = 0; i < col; i++) {
				if (board[rowD][i].equals("X")) {
					diagonalBackward++;
				}
				rowD--;
			}
			if (diagonalBackward == col) {
				return "X";
			}
			diagonalBackward = 0;
			rowD = row - 1;
			for (int i = 0; i < col; i++) {
				if (board[rowD][i].equals("O")) {
					diagonalBackward++;
				}
				rowD--;
			}
			if (diagonalBackward == row) {
				return "O";
			}
		}
		return "";
	}

	@Override
	public String getCurrentPlayer() {
		if (getWinner() == "") {
			int x = 0;
			int o = 0;
			for (int i = 0; i < row; i++) {	
				for (int j = 0; j < col; j++) {
					if(board[i][j].equals("X")) {
						x++;
					}
					else if (board[i][j].equals("O")) {
						o++;
					}
				}
			}
			if (x > o && (x + o) != row*col) {
				return "O";
			}
			else if (x == o && (x + o) != row*col) {
				return "X";
			}
		}
		return "";
	}

	@Override
	public boolean isValidMove(int space) {
		if (space >= 0 && space < row*col) {
			if (board[space/row][space%col].equals(" ") && getWinner().equals("")) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void move(int space) throws IllegalArgumentException {
		if (!isValidMove(space)) {
			throw new IllegalArgumentException();
		}
		board[space/row][space%col] = getCurrentPlayer();
	}
}