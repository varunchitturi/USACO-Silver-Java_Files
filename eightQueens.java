import java.util.*;

public class eightQueens {
    static int count = 0;
    public static void main(String[] args) {
        int [] []board = new int[8][8];
        for (int i = 0; i < 8; i++) {
            Arrays.fill(board[i], 0);
        }
        getQueen(board,0);
        System.out.println(count);

    }
    public static boolean check(int [][] board, int row, int column){
        for (int i = 0; i < row; i++)
            if (board[i][column] == 1)
                return false;
        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        for (int i = row, j = column; i >= 0 && j < 8; i--, j++)
            if (board[i][j] == 1)
                return false;

        return true;
    }
    private static void getQueen(int board[][], int currentRow)
    {
        if (currentRow == 8)
        {
            count++;
        }
        for (int i = 0; i < 8; i++)
        {
            if (check(board, currentRow, i))
            {
                board[currentRow][i] = 1;
                getQueen(board, currentRow + 1);
                board[currentRow][i] = 0;
            }
        }
    }

}
