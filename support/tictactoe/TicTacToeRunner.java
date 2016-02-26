package tictactoe;

import java.util.Scanner;

public class TicTacToeRunner {
	public static void main(String[] args) {
		Scanner conIn = new Scanner(System.in);
		try {
			System.out.println("Welcome to n x n Tic-Tac-Toe.");
			System.out.println("Choose a value for n: ");
			final int n = conIn.nextInt();
			
			TicTacToeGame game = new TicTacToe(n);
			
			String currentPlayer = game.getCurrentPlayer();
			while (!currentPlayer.equals("")) {
				System.out.println("Current board:");
				System.out.println(game.toString());
				boolean hasMoved = false;
				while (!hasMoved) {
					System.out.println("It is " + currentPlayer + "'s turn. Enter a space to claim: ");
					final int space = conIn.nextInt();
					if (!game.isValidMove(space)) {
						System.out.println("Invalid space.");
						continue;
					}
					game.move(space);
					hasMoved = true;
					currentPlayer = game.getCurrentPlayer();
				}	
			}
			System.out.print("Game over...");
			final String winner = game.getWinner();
			if (winner.equals("")) {
				System.out.println("It was a draw.");
			}
			else {
				System.out.println(winner + " has won!");
			}
		} finally {
			conIn.close();
		}
	}
}