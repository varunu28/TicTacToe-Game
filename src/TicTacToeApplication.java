import java.util.Scanner;

public class TicTacToeApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean doYouWantToPlay = true;

        while (doYouWantToPlay) {
            System.out.println("Welcome to TicTacToe. You are about to go against the AI Master\n" +
                                "Are you ready? \n I wish you good luck \n But first pick up a character for the game");
            System.out.println();

            System.out.println("Enter a single character that will represent you on the board");
            char playerToken = sc.next().charAt(0);

            System.out.println("Enter a single character that will represent AI Master on the board");
            char opponentToken = sc.next().charAt(0);

            TicTacToe game = new TicTacToe(playerToken, opponentToken);
            AI ai = new AI();

            System.out.println("Now we can start the game. Enter the number and your token would be put at that place. " +
                                "\nThe numbers go from 1-9, left to right. We shall see who will win");
            TicTacToe.printIndexBoard();
            System.out.println();

            while (game.gameOver().equals("Not Over")) {
                if (game.currentMarker == game.userMarker) {
                    System.out.println("Its your turn. Enter a spot for your token.");
                    int spot = sc.nextInt();
                    while (!game.playTurn(spot)) {
                        System.out.println("Try again. " + spot + " is invalid. This spot is already taken or it is out of range");
                        spot = sc.nextInt();
                    }
                    System.out.println("You picked " + spot + " !");
                }
                else {
                    System.out.println("\nIts my turn");
                    int aiSpot = ai.pickSpot(game);
                    game.playTurn(aiSpot);
                    System.out.println("I picked " + aiSpot + " !");
                }
                System.out.println();
                game.printBoard();
            }
            System.out.println(game.gameOver());
            System.out.println();
            System.out.println("Do you want to play again: Enter y if you want to continue");
            char response = sc.next().charAt(0);
            doYouWantToPlay = (response == 'y');
            System.out.println();
        }
    }
}
