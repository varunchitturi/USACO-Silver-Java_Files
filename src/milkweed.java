package src;

import java.util.*;
public class milkweed {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        //input
        int numColumns = input.nextInt();
        int numRows = input.nextInt();
        int [] startPos = new int [3];
        startPos[1] = input.nextInt()-1;
        startPos[0] = numRows-input.nextInt();
        int [] [] matrix = new int [numRows][numColumns];
        for(int i = 0; i< numRows;i++){
            String next = input.next();
            for(int j = 0; j< numColumns;j++){
                if(next.charAt(j) == '*'){
                    matrix[i][j] = -1;
                }
            }
        }
        ArrayList<Integer> greatest = new ArrayList<>();
        ArrayList<int[]> queue = new ArrayList<>();
        int numWeeks = 0;
        matrix[startPos[0]][startPos[1]] = 1;
        queue.add(startPos);
        for(int i = 0; i <queue.size();i++){
            try{
                if(matrix[queue.get(i)[0]+1][queue.get(i)[1]] == 0){
                    matrix[queue.get(i)[0]+1][queue.get(i)[1]] = 1;
                    queue.add(new int [] {queue.get(i)[0]+1,queue.get(i)[1],queue.get(i)[2]+1});
                    greatest.add(queue.get(i)[2]+1);
                }
            }
            catch (Exception e){

            }
            try{
                if(matrix[queue.get(i)[0]-1][queue.get(i)[1]] == 0){
                    matrix[queue.get(i)[0]-1][queue.get(i)[1]] = 1;
                    queue.add(new int [] {queue.get(i)[0]-1,queue.get(i)[1],queue.get(i)[2]+1});
                    greatest.add(queue.get(i)[2]+1);
                }
            }
            catch (Exception e){

            }
            try{
                if(matrix[queue.get(i)[0]][queue.get(i)[1]+1] == 0){
                    matrix[queue.get(i)[0]][queue.get(i)[1]+1] = 1;
                    queue.add(new int [] {queue.get(i)[0],queue.get(i)[1]+1,queue.get(i)[2]+1});
                    greatest.add(queue.get(i)[2]+1);
                }
            }
            catch (Exception e){

            }
            try{
                if(matrix[queue.get(i)[0]][queue.get(i)[1]-1] == 0){
                    matrix[queue.get(i)[0]][queue.get(i)[1]-1] = 1;
                    queue.add(new int [] {queue.get(i)[0],queue.get(i)[1]-1,queue.get(i)[2]+1});
                }
            }
            catch (Exception e){

            }
            try{
                if(matrix[queue.get(i)[0]+1][queue.get(i)[1]+1] == 0){
                    matrix[queue.get(i)[0]+1][queue.get(i)[1]+1] = 1;
                    queue.add(new int [] {queue.get(i)[0]+1,queue.get(i)[1]+1,queue.get(i)[2]+1});
                    greatest.add(queue.get(i)[2]+1);
                }
            }
            catch (Exception e){

            }
            try{
                if(matrix[queue.get(i)[0]-1][queue.get(i)[1]-1] == 0){
                    matrix[queue.get(i)[0]-1][queue.get(i)[1]-1] = 1;
                    queue.add(new int [] {queue.get(i)[0]-1,queue.get(i)[1]-1,queue.get(i)[2]+1});
                    greatest.add(queue.get(i)[2]+1);
                }
            }
            catch (Exception e){

            }
            try{
                if(matrix[queue.get(i)[0]+1][queue.get(i)[1]-1] == 0){
                    matrix[queue.get(i)[0]+1][queue.get(i)[1]-1] = 1;
                    queue.add(new int [] {queue.get(i)[0]+1,queue.get(i)[1]-1,queue.get(i)[2]+1});
                    greatest.add(queue.get(i)[2]+1);
                }
            }
            catch (Exception e){

            }
            try{
                if(matrix[queue.get(i)[0]-1][queue.get(i)[1]+1] == 0){
                    matrix[queue.get(i)[0]-1][queue.get(i)[1]+1] = 1;
                    queue.add(new int [] {queue.get(i)[0]-1,queue.get(i)[1]+1,queue.get(i)[2]+1});
                    greatest.add(queue.get(i)[2]+1);
                }
            }
            catch (Exception e){

            }

        }
        Collections.sort(greatest);
        System.out.println(greatest.get(greatest.size()-1));
        //System.out.println(queue.get(queue.size()-1)[2]);



    }
}
