import java.lang.reflect.Array;
import java.util.*;

public class munching {
    static char matrix [][];
    static int [] bessiePos;
    static int [] barnPos;
    static ArrayList<int []> queue = new ArrayList<>();
    static ArrayList<Integer> all = new ArrayList<>();
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int rows = input.nextInt();
        int columns = input.nextInt();
        matrix = new char [rows][columns];
        bessiePos = new int [2];
        barnPos = new int [2];
        for(int i = 0; i< rows;i++){
            String next = input.next();
            for(int j = 0 ; j< next.length();j++){
                matrix[i][j] = next.charAt(j);
                if(next.charAt(j) == 'C'){
                    bessiePos[0] = i;
                    bessiePos[1] = j;
                }
                if(next.charAt(j) == 'B'){
                    barnPos[0] = i;
                    barnPos[1] = j;
                }
            }
        }
        queue.add(new int [] {0,0,1});
        while(queue.size() != 0){

            if(matrix[queue.get(0)[0]][queue.get(0)[1]] == 'C'){
                System.out.println(queue.get(0)[2]-1);
                break;
            }
            if(matrix[queue.get(0)[0]][queue.get(0)[1]] != '*' && matrix[queue.get(0)[0]][queue.get(0)[1]] != 'a') {
                if (queue.get(0)[0] + 1 < rows) {
                    if (matrix[queue.get(0)[0] + 1][queue.get(0)[1]] != '*' && matrix[queue.get(0)[0] + 1][queue.get(0)[1]] != 'a') {
                        queue.add(new int[]{queue.get(0)[0] + 1, queue.get(0)[1], queue.get(0)[2] + 1});

                    }

                }
                if (queue.get(0)[0] - 1 >= 0) {
                    if (matrix[queue.get(0)[0] - 1][queue.get(0)[1]] != '*' && matrix[queue.get(0)[0] - 1][queue.get(0)[1]] != 'a') {
                        queue.add(new int[]{queue.get(0)[0] - 1, queue.get(0)[1], queue.get(0)[2] + 1});
                    }

                }
                if (queue.get(0)[1] + 1 < columns) {
                    if (matrix[queue.get(0)[0]][queue.get(0)[1] + 1] != '*' && matrix[queue.get(0)[0]][queue.get(0)[1] + 1] != 'a') {
                        queue.add(new int[]{queue.get(0)[0], queue.get(0)[1] + 1, queue.get(0)[2] + 1});
                    }

                }
                if (queue.get(0)[1] - 1 >= 0) {
                    if (matrix[queue.get(0)[0]][queue.get(0)[1] - 1] != '*' && matrix[queue.get(0)[0]][queue.get(0)[1] - 1] != 'a') {
                        queue.add(new int[]{queue.get(0)[0], queue.get(0)[1] - 1, queue.get(0)[2] + 1});
                    }

                }
            }
            matrix[queue.get(0)[0]][queue.get(0)[1]] = 'a';
            queue.remove(0);

            //print(matrix);
           //System.out.println("------------------------------------------------------------------------------------------------------------");
        }

    }

    static void print(char [][]matrix){
        for(int i = 0 ; i< matrix.length;i++){
           for(int j = 0; j < matrix[i].length;j++){
               System.out.print(matrix[i][j] + "\t");
           }
            System.out.println();
        }
    }

}
