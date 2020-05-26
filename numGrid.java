import java.util.*;

public class numGrid {
    static int [] done;
    static int [] [] grid;
    static int totalCount = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        grid = new int [5][5];
        for(int i =0 ; i< 5;i++){
            for(int j = 0;j< 5;j++){
                grid[i][j] = input.nextInt();
            }
        }
        done = new int [1000000];
        for(int i = 0; i < 5;i++){
            for(int j = 0; j < 5;j++){
                move("",0,i,j);
            }
        }

        System.out.println(totalCount);

    }
    static void move(String current, int count, int i, int j){
        if(count == 6){
            if(done[Integer.parseInt(current)] == 0 ){
                //System.out.println(current);
                totalCount++;
                done[Integer.parseInt(current)] = 1;
            }
        }
        else{
             current += grid[i][j];
             count++;
             if(i != 0){
                 move(current, count, i-1,j);
             }
             if(i != 4){
                 move(current, count, i+1,j);
             }
             if(j != 0){
                 move(current, count, i,j-1);
             }
             if(j != 4){
                 move(current, count, i,j+1);
             }

        }
    }
}
