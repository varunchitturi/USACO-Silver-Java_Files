import java.util.*;

public class leprechaun {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int [][] matrix = new int [size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j< size;j++){
                matrix[i][j] = input.nextInt();
            }
        }
        int  [] [] possibleArrays = new int [size*4][size*2];


        // verticals
        for(int i = 0;i < size; i++){
            int [] toAppend = new int [size*2];
            for(int j = 0; j< size;j++){
                toAppend[j] = matrix[j][i];
                toAppend[j+size] = matrix[j][i];
            }
            possibleArrays[i] = toAppend;
        }


        // horizontals

        for(int i = 0;i < size; i++){
            int [] toAppend = new int [size*2];
            for(int j = 0; j< size;j++){
                toAppend[j] = matrix[i][j];
                toAppend[j+size] = matrix[i][j];
            }
            possibleArrays[i+size] = toAppend;
        }

        // up diagonals

        for(int i = 0;i< size;i++){
            int [] toAppend = new int[size*2];
            for(int j = 0; j<size;j++){
                if (i-j >= 0){
                    toAppend[j] = matrix[i-j][j];
                    toAppend[j+size] = matrix[i-j][j];
                }
                else{
                    toAppend[j] = matrix[size+(i-j)][j];
                    toAppend[j+size] = matrix[size+(i-j)][j];
                }
            }
            possibleArrays[i+size*2] = toAppend;
        }

        // down diagonals

        for(int i = 0 ; i < size; i++){
            int [] toAppend = new int [size*2];
            for(int j = 0;j<size;j++){
                toAppend[j] = matrix[(i+j)%size][j];
                toAppend[j+size] = matrix[(i+j)%size][j];
            }
            possibleArrays[size*3+i] = toAppend;
        }


        int finalAnswer = Integer.MIN_VALUE;
        int a;
        for(int i = 0;i<possibleArrays.length;i++){

            a = findGreatestConsecutive(possibleArrays[i],size);




            if(a>finalAnswer){
                finalAnswer = a;
            }
        }
        System.out.println(finalAnswer);
    }
    public static int findGreatestConsecutive(int [] array, int size){
        int total = Integer.MIN_VALUE;
        int last = 0;
        for(int i = 0; i < size; i++){
            for(int j = 0; j<array.length-i;j++) {
                last = 0;
                for(int k = j; k < j + i + 1;k++){
                    last += array[k];
                }
                if( last > total){
                    total = last;

                }

            }
        }
        return total;

    }
}
