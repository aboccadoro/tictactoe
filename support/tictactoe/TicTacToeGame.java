package tictactoe;

/**
 * An interface specifying an n x n game (n >= 3) of Tic-Tac-Toe.
 * 
 * The board is a n x n set of spaces. Players, identified by "X" or "O", take
 * turns claiming spaces on the board, with "X" going first. The goal is to claim
 * n spaces in a line, horizontally, vertically, or diagonally. The game ends
 * when one player does so, or when no empty spaces remain.
 * 
 * The spaces are numbered left-to-right and top-to-bottom, starting at 0.
 * For the traditional n=3 game the empty board looks like:
 * 
 *      | |                              0|1|2
 *     -+-+-                             -+-+-
 *      | |     which is numbered as     3|4|5
 *     -+-+-                             -+-+-
 *      | |                              6|7|8
 * 
 * @author Marc Liberatore <liberato@cs.umass.edu>
 *
 */
public interface TicTacToeGame {
	/**
	 * @return the value of n for this game
	 */
	public int getN();

	/**
	 * Returns a multi-line string representation of the game.
	 * 
	 * The string should display the board line-by-line, corresponding
	 * to the space numbering. Each line should consist only of "X"s, 
	 * "O"s, or " "s (empty spaces), corresponding to spaces claimed by
	 * the given player (or no player). Between each line is a newline;
	 * there is no newline at the end of the last string.
	 * 
	 * For example, one such String for a 4x4 board might be:
	 * 
	 * "X  O\nXO  \nO X \nXO"
	 * 
	 * which, when printed, would display:
	 * 
	 * X  O
	 * XO  
	 * O X 
	 * XO
	 * 
	 * NOTE TO STUDENTS: This method, and this method ONLY, will not be
	 * tested by the autograder. But you will almost certainly want to have
	 * a working toString() implementation to aid in your debugging, and the
	 * TicTacToeRunner's output won't make sense until you do.
	 * 
	 * @return a human-readable version of the current game state
	 */
	public String toString();

	/**
	 * Returns the identity of the player who has won (either "X" or "O"),
	 * or the empty string if neither player is currently the winner.
	 * @return the winning player "X" or "O" (or "" if no winner)
	 */
	public String getWinner();
		
	/**
	 * Returns the identity of the player whose turn it is to place their
	 * piece ("X", "O", or "" if the game is over).
	 *
	 * Games end when one player has claimed n spaces in a row, or
	 * when the board is full, and neither player has won.
	 *@return the current player "X" or "O", or "" if the game is over
	 */
	public String getCurrentPlayer();
	
	/**
	 * Returns true if the chosen move is valid, and false otherwise.
	 * 
	 * Moves are valid if the chosen space exists in this game, and is empty.
	 * 
	 * This method must not actually perform the move!
	 * @param space the space number
	 * @return true iff the chosen move is valid
	 */
	public boolean isValidMove(int space);
		
	/**
	 * Claims the space for the current player.
	 * 
	 * @param space the space number
	 * @throws IllegalArgumentException if the move is invalid, or the game is over
	 */
	public void move(int space) throws IllegalArgumentException;
}
