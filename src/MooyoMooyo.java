package src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MooyoMooyo {
    static int K;
    static int N;
    static int[][] board;
    static boolean [][] visited;
    static int count ;
    public static void main(String[] args) throws IOException {
        try{
            File f = new File("mooyomooyo.in");
            Scanner in = new Scanner(f);
            N = in.nextInt(); K = in.nextInt();
            board = new int[N][10];
            for(int i = 0; i < N; i++){
                String curr = in.next();
                for(int j = 0; j < 10;j++){
                    board[i][j] = Integer.parseInt(Character.toString(curr.charAt(j)));
                }
            }
            visited = new boolean[N][10];
            while(true){
                Boolean didFill = false;
                for(int i = 0; i < N;i++){
                    for(int j = 0; j < 10; j++){
                        if(board[i][j] != 0){
                            reset();
                            count = 0;
                            fillCount(i,j,board[i][j]);
                            if(count >= K){
                                fill(i,j,board[i][j]);
                                didFill = true;
                            }
                        }
                    }
                }
                gravity();
                if(!didFill){
                    break;
                }
            }
            in.close();
            PrintWriter writer = new PrintWriter("mooyomooyo.out");
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < 10; j++){
                    writer.write(Integer.toString(board[i][j]));
                }
                writer.write("\n");
            }
            writer.close();
        }
        catch (Exception e){
            System.out.println("Something");
            e.printStackTrace();
        }


    }
    static void reset(){
        for(int i = 0; i < visited.length;i++){
            for(int j = 0; j < visited[i].length;j++){
                visited[i][j] = false;
            }
        }
    }
    static void gravity(){
        for(int i = 0; i < 10; i++){
            ArrayList<Integer> q = new ArrayList<>();
            for(int j = 0; j < N;j++){
                if(board[j][i] != 0){
                    q.add(board[j][i]);
                }
            }
            for(int j = N-1; j >= 0;j--){
                if(!q.isEmpty()){
                    int last  = q.get(q.size()-1);
                    q.remove(q.size()-1);
                    board[j][i] = last;
                }
                else{
                    board[j][i] = 0;
                }
            }
        }
    }
    static void fill(int i, int j, int color){
        if(board[i][j] == color){
            board[i][j] = 0;
            if(i-1 >= 0){
                fill(i-1,j,color);
            }
            if(i+1 < N){
                fill(i+1,j,color);
            }
            if(j-1 >= 0){
                fill(i,j-1,color);
            }
            if(j+1 < 10){
                fill(i,j+1,color);
            }
        }
    }
    static void fillCount(int i, int j, int color){
        if(!visited[i][j]){
            visited[i][j] = true;
            if(board[i][j] == color){
                count++;
                if(i-1 >= 0){
                    fillCount(i-1,j,color);
                }
                if(i+1 < N){
                    fillCount(i+1,j,color);
                }
                if(j-1 >= 0){
                    fillCount(i,j-1,color);
                }
                if(j+1 < 10){
                    fillCount(i,j+1,color);
                }
            }
        }
    }
}
