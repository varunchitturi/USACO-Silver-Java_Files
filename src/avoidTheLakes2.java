package src;

import java.lang.reflect.Array;
import java.security.spec.ECField;
import java.util.*;
public class avoidTheLakes2 {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int numRows = input.nextInt();
        int numColumns = input.nextInt();
        int numCells = input.nextInt();
        int [] [] matrix = new int[numRows][numColumns];
        int largestCell = 1;
        int cellCount = 1;

        for(int i =0; i < numCells;i++){
            matrix[input.nextInt()-1][input.nextInt()-1] = 1;
        }
        ArrayList<int []> queue = new ArrayList<>();
         for(int i = 0; i < numRows;i++){
             for(int j = 0; j< numColumns;j++){
                 if(matrix[i][j]==1){
                     cellCount = 1;
                     queue.clear();
                     queue.add(new int [] {i,j,1});

                     for(int k = 0; k< queue.size();k++){
                         matrix[queue.get(k)[0]][queue.get(k)[1]] = 2;

                         try{
                             if(matrix[queue.get(k)[0]+1][queue.get(k)[1]] == 1){
                                 queue.add(new int [] {queue.get(k)[0]+1,queue.get(k)[1],queue.get(k)[2]+1});
                                 cellCount++;
                                 matrix[queue.get(k)[0]+1][queue.get(k)[1]] = 2;

                             }
                         }
                         catch(Exception e){

                         }
                         try{
                             if(matrix[queue.get(k)[0]-1][queue.get(k)[1]] == 1){
                                 queue.add(new int [] {queue.get(k)[0]-1,queue.get(k)[1],queue.get(k)[2]+1});
                                 cellCount++;
                                 matrix[queue.get(k)[0]-1][queue.get(k)[1]] = 2;
                             }
                         }
                         catch(Exception e){

                         }
                         try{
                             if(matrix[queue.get(k)[0]][queue.get(k)[1]+1] == 1){
                                 queue.add(new int [] {queue.get(k)[0],queue.get(k)[1]+1,queue.get(k)[2]+1});
                                 cellCount++;
                                 matrix[queue.get(k)[0]][queue.get(k)[1]+1] = 2;
                             }
                         }
                         catch(Exception e){

                         }
                         try{
                             if(matrix[queue.get(k)[0]][queue.get(k)[1]-1] == 1){
                                 queue.add(new int [] {queue.get(k)[0],queue.get(k)[1]-1,queue.get(k)[2]+1});
                                 cellCount++;
                                 matrix[queue.get(k)[0]][queue.get(k)[1]-1] = 2;
                             }
                         }
                         catch(Exception e){

                         }
                     }
                 }
                 if(cellCount > largestCell){
                     largestCell = cellCount;
                 }
             }

         }
        System.out.println(largestCell);
    }


}
