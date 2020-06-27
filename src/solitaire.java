package src;

import java.util.*;
public class solitaire {
    static String [][] matrix;
    static int bestScore;
    static int size;
    public static void main(String [] args){
    Scanner input = new Scanner(System.in);
    size = input.nextInt();
    matrix = new String [size][size];
    for(int i = 0; i < size;i++){
        for(int j = 0; j < size;j++){
            matrix[i][j] = input.next();
        }
    }
    bestScore = Integer.MIN_VALUE;
    dfs(size-1,0,0);
        System.out.println(bestScore);

    }
    static void dfs(int i, int j, int score){
        score += readCard(matrix[i][j]);
        if(score > bestScore){
            bestScore = score;
        }
        if(i == 0 && j == size - 1){
            return;
        }
        if(i != 0){
            dfs(i-1,j,score);
        }
        if(j != size -1){
            dfs(i,j+1,score);
        }
    }
    static int readCard(String card){
        String num = Character.toString(card.charAt(0));
        if(num.equals("T")){
            return 10;

        }
        if(num.equals("A")){
            return 1;
        }
        if(num.equals("2")){
            return 2;
        }
        if(num.equals("3")){
            return 3;
        }
        if(num.equals("4")){
            return 4;
        }
        if(num.equals("5")){
            return 5;
        }
        if(num.equals("6")){
            return 6;
        }
        if(num.equals("7")){
            return 7;
        }
        if(num.equals("8")){
            return 8;
        }
        if(num.equals("9")){
            return 9 ;
        }
        if(num.equals("J")){
            return 11;
        }
        if(num.equals("Q")){
            return 12;
        }
        if(num.equals("K")){
            return 13;
        }
        return 1000000000;

    }
}
