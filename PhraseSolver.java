/*
 * Activity 2.2.2
 *
 * The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;

public class PhraseSolver
{
  /* your code here - attributes */
  private Player player1;
  private Player player2;
  private Board board;
  private boolean solved;

  /* your code here - constructor(s) */
  public PhraseSolver(){
    player1 = new Player();
    player2 = new Player();
    board = new Board();
    solved = false;
  }

  public void play()
  {
    int currentPlayer = 1;
    Scanner input = new Scanner(System.in);

    while (!solved)
    {
      board.setLetterValue();
      System.out.println("Letter Guess Value: " + board.getCurrentLetterValue());
      System.out.println("Type a letter OR type the full phrase to solve:");

      if (currentPlayer == 1) {
        System.out.println(player1.getName() + " it is your turn to guess.");
      } 
      else {
        System.out.println(player2.getName() + " it is your turn to guess.");
      }

      System.out.println(board.getSolvedPhrase());

      String userGuess = input.nextLine();

      if (board.isSolved(userGuess)) {
        solved = true;

        if (player1.getPoints() > player2.getPoints()) {
          System.out.println("Player 1 WON");
        } 
        else {
          System.out.println("Player 2 WON");
        }

        System.out.println(board.getSolvedPhrase());
        break;
      }

      if (userGuess.length() == 1) {

        if (board.guessLetter(userGuess)) {
          System.out.println("Correct");

          if (currentPlayer == 1) {
            player1.setPoints(board.getCurrentLetterValue() + player1.getPoints());
          } 
          else {
            player2.setPoints(board.getCurrentLetterValue() + player2.getPoints());
          }

        } 
        else {
          if (currentPlayer == 1) {
            currentPlayer = 2;
          }
          else {
            currentPlayer = 1;
          }
        }

      } 
      else {
        if (currentPlayer == 1) {
            currentPlayer = 2;
        }
        else {
            currentPlayer = 1;
        }
      }

      System.out.println(board.getSolvedPhrase());
    }
  }
}
