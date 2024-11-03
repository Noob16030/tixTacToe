import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
        int numberOfSquaresPlayed = 0;
        char whoseTurnItIs = 'x';
        String gameEndingMessage = "";

        while(numberOfSquaresPlayed < 9) {
            printTheBoard(board);
            getTheUserToSelectTheirSquare(board, (char)whoseTurnItIs);
            if (theyWonTheGame(board, (char)whoseTurnItIs)) {
                gameEndingMessage = "Player " + whoseTurnItIs + " won!!! Congratulations!";
                break;
            }

            ++numberOfSquaresPlayed;
            whoseTurnItIs = whoseTurnItIs == 'x' ? 'o' : 'x';

        }
        if (numberOfSquaresPlayed == 9) {
            gameEndingMessage = "A tough battle fought to a draw!";
        }
        printTheBoard(board);
        System.out.println(gameEndingMessage);

    }

    private static void getTheUserToSelectTheirSquare(char[][] board, char whoseTurnItIs) {
        while(true) {
            try {
                System.out.printf("Would player %s please choose an unchosen square:", whoseTurnItIs);
                Scanner scanner = new Scanner(System.in);
                int input = scanner.nextInt();
                char inputChar = (char) (input + '0');
                for (int i = 0; i < board.length; i++){
                    for(int j = 0; j < board[i].length; j++){
                        if (board[i][j] == inputChar && Character.isDigit(inputChar)){
                            board[i][j] = whoseTurnItIs;
                            return;
                        }
                    }
                }
                if (Character.isDigit(inputChar) && input > 0 && input < 10) {
                    System.out.println("Sorry, that's taken.");
                } else {
                    System.out.println("Wrong input. Let's try that again.");
                }
            } catch (Exception var4) {
                System.out.println("Something went wrong. Let's try that again.");
            }

            printTheBoard(board);
        }
    }

    private static void printTheBoard(char[][] board) {
        System.out.printf("%n %s | %s | %s %n", board[0][0], board[0][1], board[0][2]);
        System.out.println(" - + - + - ");
        System.out.printf(" %s | %s | %s %n", board[1][0], board[1][1], board[1][2]);
        System.out.println(" - + - + - ");
        System.out.printf(" %s | %s | %s %n%n", board[2][0], board[2][1], board[2][2]);
    }

    private static boolean theyWonTheGame(char[][] board, char whoseTurnItIs) {
         return board[0][0] + board[0][1] + board[0][2] == whoseTurnItIs * 3 ||
                board[1][0] + board[1][1] + board[1][2] == whoseTurnItIs * 3 ||
                board[2][0] + board[2][1] + board[2][2] == whoseTurnItIs * 3 ||
                board[0][0] + board[1][0] + board[2][0] == whoseTurnItIs * 3 ||
                board[0][1] + board[1][1] + board[2][1] == whoseTurnItIs * 3 ||
                board[0][2] + board[1][2] + board[2][2] == whoseTurnItIs * 3 ||
                board[0][0] + board[1][1] + board[2][2] == whoseTurnItIs * 3 ||
                board[0][2] + board[1][1] + board[2][0] == whoseTurnItIs * 3;
    }
}