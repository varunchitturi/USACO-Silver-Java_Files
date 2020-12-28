package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class perimeter {
    static int N;
    static int [][] grid;
    static int largestArea = 0;
    static int smallestPerim = Integer.MAX_VALUE;
    static int currArea = 0;
    static int currPerim = 0;
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner in = new Scanner(System.in);
        File f = new File("perimeter.in");
        Scanner in = new Scanner(f);
        N = in.nextInt();
        grid = new int[N][N];
        for(int i = 0; i < N; i++){
            String next = in.next();
            for(int j = 0; j < N; j++){
                char c = next.charAt(j);
                if(c == '#'){
                    grid[i][j] = 1;
                }
                else{
                    grid[i][j] = 0;
                }
            }
        }
        for(int i= 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(grid[i][j] == 1){
                    currPerim = 0;
                    currArea = 0;
                    dfs(i,j);
                }

                if(currArea > largestArea){
                    largestArea = currArea;
                    smallestPerim = currPerim;
                }
                else if(currArea == largestArea){
                    if(currPerim < smallestPerim){
                        smallestPerim = currPerim;
                    }
                }
            }
        }
        //System.out.println(largestArea + " " + smallestPerim);
        in.close();
        PrintWriter w = new PrintWriter("perimeter.out");
        w.write(Integer.toString(largestArea) + " " + Integer.toString(smallestPerim));
        w.close();
    }
    static void dfs(int i, int j){
        if(grid[i][j] == 1){
            grid[i][j] = -1;
            currArea++;
            currPerim += getSurround(i,j);
            if(i+1 < N){
                dfs(i+1,j);
            }
            if (i-1 >= 0){
                dfs(i-1,j);
            }
            if(j+1 < N){
                dfs(i,j+1);
            }
            if (j-1 >= 0){
                dfs(i,j-1);
            }
        }
    }
    // fix bounds
    static int getSurround(int i, int j){
        int count = 0;
        if(i+1 < N){
            if(grid[i+1][j] == 0){
                count++;
            }
        }
        else{
            count++;
        }
        if (i-1 >= 0){
            if(grid[i-1][j] == 0){
                count++;
            }
        }
        else{
            count++;
        }
        if(j+1 < N){
            if(grid[i][j+1] == 0){
                count++;
            }
        }
        else{
            count++;
        }
        if (j-1 >= 0){
            if(grid[i][j-1] == 0){
                count++;
            }
        }
        else{
            count++;
        }
        return count;
    }
}
