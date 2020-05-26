import java.util.*;

public class nQueen {
    static int count = 0;
    static int N;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        int [] []board = new int[N][N];
        for (int i = 0; i < N; i++) {
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

        for (int i = row, j = column; i >= 0 && j < N; i--, j++)
            if (board[i][j] == 1)
                return false;

        return true;
    }
    private static void getQueen(int board[][], int currentRow)
    {
        if (currentRow == N)
        {
            count++;
        }
        for (int i = 0; i < N; i++)
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
