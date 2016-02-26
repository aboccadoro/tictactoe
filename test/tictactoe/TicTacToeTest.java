package tictactoe;


import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;


public class TicTacToeTest {
	/**
	 * a 3x3 game
	 */
	private TicTacToeGame emptyGame;

	/**
	 * a 3x3 game after "X" has claimed space 4
	 */
	private TicTacToeGame oneMoveGame;
	
	/**
	 * a 3x3 game ending in a draw
	 */
	private TicTacToeGame drawGame;
	
	/**
	 * a 3x3 game where X wins 3,4,5
	 */
	private TicTacToeGame xHorizontalGame;
	
	/**
	 * a 3x3 game where O wins 1,4,7
	 */
	private TicTacToeGame oVerticalGame;

	/**
	 * a 3x3 game where X wins 0,4,8
	 */
	private TicTacToeGame xDiagonalGame;
	
	/**
	 * a 3x3 game where O wins 2,4,6
	 */
	private TicTacToeGame oDiagonalGame;
	

	/**
	 * Runs before each test, resetting the boards to their
	 * default states.
	 */
	@Before
	public void before() {
		emptyGame = new TicTacToe(3);
		
		oneMoveGame = new TicTacToe(3);
		oneMoveGame.move(4);
		
		drawGame = new TicTacToe(3);
		for (int space : new int[] {0, 1, 2, 6, 7, 8, 3, 4, 5}) {
			drawGame.move(space);
		}
		
		xHorizontalGame = new TicTacToe(3);
		for (int space : new int[] {3, 0, 4, 2, 5}) {
			xHorizontalGame.move(space);			
		}

		oVerticalGame = new TicTacToe(3);
		for (int space : new int[] {0, 1, 2, 4, 3, 7}) {
			oVerticalGame.move(space);
		}
		
		xDiagonalGame = new TicTacToe(3);
		for (int space: new int[] {0, 1, 4, 2, 8}) {
			xDiagonalGame.move(space);
		}
		
		oDiagonalGame = new TicTacToe(3);
		for (int space: new int[] {0, 2, 1, 4, 3, 6}) {
			oDiagonalGame.move(space);
		}
	}

	@Test
	public void testGetN() {
		assertEquals(3, emptyGame.getN());
	}
	
	@Test
	public void testGetWinnerEmpty() {
		assertEquals("", emptyGame.getWinner());
	}
	
	@Test
	public void testGetCurrentPlayerEmpty() {
		assertEquals("X", emptyGame.getCurrentPlayer());
	}
	
	@Test
	public void testIsValidMoveEmpty() {
		for (int i=0; i<9; i++) {
			assertTrue(emptyGame.isValidMove(i));
		}
		assertFalse(emptyGame.isValidMove(-1));
		assertFalse(emptyGame.isValidMove(9));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testMoveOutOfBoundsException() {
		emptyGame.move(9);
	}
	
	@Test
	public void testGetWinnerOneMove() {
		assertEquals("", oneMoveGame.getWinner());
	}
	
	@Test
	public void testGetCurrentPlayerOneMove() {
		assertEquals("O", oneMoveGame.getCurrentPlayer());
	}
	
	@Test
	public void testIsValidMoveOneMove() {
		for (int i=0; i<9; i++) {
			if (i != 4) {
				assertTrue(oneMoveGame.isValidMove(i));
			}
		}
		assertFalse(oneMoveGame.isValidMove(-1));
		assertFalse(oneMoveGame.isValidMove(4));
		assertFalse(oneMoveGame.isValidMove(9));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testSpaceAlreadyClaimedException() {
		oneMoveGame.move(4);
	}
	
	@Test
	public void testGetWinnerDraw() {
		assertEquals("", drawGame.getWinner());
	}
	
	@Test
	public void testGetCurrentPlayerDraw() {
		assertEquals("", drawGame.getCurrentPlayer());
	}
	
	@Test
	public void testIsValidMoveDraw() {
		for (int i=1; i<10; i++) {
			assertFalse(drawGame.isValidMove(i));
		}
	}

	@Test
	public void testGetWinnerHorizontal() {
		assertEquals("X", xHorizontalGame.getWinner());
	}

	@Test
	public void testGetWinnerVertical() {
		assertEquals("O", oVerticalGame.getWinner());
	}
	
	@Test
	public void testGetWinnerXDiagonall() {
		assertEquals("X", xDiagonalGame.getWinner());
	}
	
	@Test
	public void testGetWinnerODiagonall() {
		assertEquals("O", oDiagonalGame.getWinner());
	}

	@Test
	public void testIsValidMoveWinner() {
		assertFalse(xHorizontalGame.isValidMove(6));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInvalidMoveWinner() {
		oDiagonalGame.move(2);
	}
	
	@Test
	public void testFiveByFive() {
		TicTacToe game = new TicTacToe(5);
		
		assertEquals(5, game.getN());
		
		assertTrue(game.isValidMove(24));
		game.move(24);
		
		assertTrue(game.isValidMove(20));
		assertFalse(game.isValidMove(24));
		assertEquals("O", game.getCurrentPlayer());
		assertEquals("", game.getWinner());
		
		for (int i: new int[] {20, 23, 16, 19, 12, 22, 8, 18, 4}) {
			game.move(i);
		}
		
		assertEquals("O", game.getWinner());
		assertEquals("", game.getCurrentPlayer());
		assertFalse(game.isValidMove(14));
	}
}
