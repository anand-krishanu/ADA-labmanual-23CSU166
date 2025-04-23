package Exp9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NQueens {

    private final char QUEEN = 'Q';

    public List<List<String>> solveNQueen (int n) {
        char[][] chessBoard = new char[n][n];
        for (char[] c: chessBoard) {
            Arrays.fill(c, '.');
        }

        List<List<String>> solutions = new ArrayList<>();

        backtrack(0, chessBoard, solutions, n);
        
        return solutions;
    }

    private void backtrack(int row, char[][] chessBoard, List<List<String>> solutions, int n) {
        if(row == n) {
            solutions.add(construct(chessBoard));
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(chessBoard, row, col, n)) {
                chessBoard[row][col] = QUEEN;
                backtrack(row + 1, chessBoard, solutions, n);
                chessBoard[row][col] = '.';
            }
        }
    }

    private boolean isSafe(char[][] chessBoard, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if(chessBoard[i][col] == QUEEN) return false;
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(chessBoard[i][j] == QUEEN) return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessBoard[i][j] == 'Q') return false;
        }

        return true;
    }

    private List<String> construct(char[][] chessBoard) {
        List<String> result = new ArrayList<>();
        for (char[] row : chessBoard)
            result.add(new String(row));
        return result;
    }

    public static void main(String[] args) {
        NQueens solver = new NQueens();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the chessboard: ");
        int n = sc.nextInt();

        List<List<String>> solutions = solver.solveNQueen(n);
        for (List<String> solution : solutions) {
            for (String row : solution)
                System.out.println(row);
            System.out.println();
        }
    }
}
