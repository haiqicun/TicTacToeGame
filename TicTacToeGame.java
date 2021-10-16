import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Lian Li
 *
 */
public class TicTacToeGame {
    static final String PLAYERX = "X";
    static final String PLAYER0 = "0";
    static final String DRAW = "draw";
    static final String WINSX = "XXX";
    static final String WINS0 = "000";
    static Scanner in;
    static String[] board;
    static String turn;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        board = new String[9];
        turn = "X";
        String winner = null;
        initializeGameBoard();

        System.out.println("Welcome to play the game: Tic Tac Toe");
        System.out.println("-------------------------------------");
        fillBoard();
        System.out.println("X's will play first. Enter a slot number to place X in:");

        while (winner == null) {
            int inputNum;
            try {
                inputNum = in.nextInt();
                if (!(inputNum > 0 && inputNum <= 9)) {
                    System.out.println("Invalid input; re-enter slot number:");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input; Please re-enter slot number between 1~9:");
                continue;
            }
            if (board[inputNum-1].equals(String.valueOf(inputNum))) {
                board[inputNum-1] = turn;
                if (turn.equals(PLAYERX)) {
                    turn = PLAYER0;
                } else {
                    turn = PLAYERX;
                }
                fillBoard();
                winner = checkWinner();
            } else {
                System.out.println("Slot is already taken; re-enter slot number:");
                continue;
            }
        }
        if (winner.equalsIgnoreCase(DRAW)) {
            System.out.println("It's a draw! Thanks for playing.");
        } else {
            System.out.println("Congratulations! " + winner + " have won! Thanks for playing.");
        }
    }

    static String checkWinner() {
        for (int i = 0; i < 8; i++) {
            StringBuilder check = new StringBuilder();
            switch (i) {
                case 0:
                    check.append(board[0]).append(board[1]).append(board[2]);
                    break;
                case 1:
                    check.append(board[3]).append(board[4]).append(board[5]);
                    break;
                case 2:
                    check.append(board[6]).append(board[7]).append(board[8]);
                    break;
                case 3:
                    check.append(board[0]).append(board[3]).append(board[6]);
                    break;
                case 4:
                    check.append(board[1]).append(board[4]).append(board[7]);
                    break;
                case 5:
                    check.append(board[2]).append(board[5]).append(board[8]);
                    break;
                case 6:
                    check.append(board[0]).append(board[4]).append(board[8]);
                    break;
                case 7:
                    check.append(board[2]).append(board[4]).append(board[6]);
                    break;
            }
            if (check.toString().equals(WINSX)) {
                return PLAYERX;
            } else if (check.toString().equals(WINS0)) {
                return PLAYER0;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (Arrays.asList(board).contains(String.valueOf(i + 1))) {
                break;
            }
            else if (i == 8) return DRAW;
        }

        System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:");
        return null;
    }

    static void fillBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("|---|---|---|");
    }

    static void initializeGameBoard() {
        for (int i = 0; i < 9; i++) {
            board[a] = String.valueOf(i + 1);
        }
    }
}
