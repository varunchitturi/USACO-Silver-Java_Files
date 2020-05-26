import java.lang.reflect.Array;
import java.util.*;
public class pageant2 {
    static int count;
    static  int [] [] matrix;
    static ArrayList<int [] > queue = new ArrayList<>();
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int numRows = input.nextInt();
        int numColumns = input.nextInt();
        matrix = new int [numRows][numColumns];
        int [] done = new int [2500];
        for(int i = 0; i< numRows;i++){
            String next = input.next();
            for(int j = 0; j<numColumns;j++){
                if(next.charAt(j) == 'X'){
                matrix[i][j] = -1;}

            }
        }
        count = 1;
        ArrayList<int []> all = new ArrayList<>();
        for(int i = 0; i< numRows;i++) {
            for(int j =0 ;j< numColumns;j++){
                if(matrix[i][j] == -1){
                    queue.clear();
                    queue.add(new int [] {i,j});

                    matrix[i][j]= count;
                    if(count == 1){
                    all.add(new int [] {i,j,0});}
                    for(int k = 0; k < queue.size();k++){
                        try{
                            if(matrix[queue.get(k)[0]+1][queue.get(k)[1]] == -1){
                                matrix[queue.get(k)[0]+1][queue.get(k)[1]] = count;
                                queue.add(new int [] {queue.get(k)[0]+1,queue.get(k)[1]});
                                if(count == 1){
                                    all.add(new int [] {queue.get(k)[0]+1,queue.get(k)[1],0});
                                }
                            }
                        }
                        catch(Exception e){

                        }
                        try{
                            if(matrix[queue.get(k)[0]-1][queue.get(k)[1]] == -1){
                                matrix[queue.get(k)[0]-1][queue.get(k)[1]] = count;
                                queue.add(new int [] {queue.get(k)[0]-1,queue.get(k)[1]});
                                if(count == 1){
                                    all.add(new int [] {queue.get(k)[0]-1,queue.get(k)[1],0});
                                }

                            }
                        }
                        catch(Exception e){

                        }
                        try{
                            if(matrix[queue.get(k)[0]][queue.get(k)[1]+1] == -1){
                                matrix[queue.get(k)[0]][queue.get(k)[1]+1] = count;
                                queue.add(new int [] {queue.get(k)[0],queue.get(k)[1]+1,});
                                if(count == 1){
                                    all.add(new int [] {queue.get(k)[0],queue.get(k)[1]+1,0});
                                }
                            }
                        }
                        catch(Exception e){

                        }
                        try{
                            if(matrix[queue.get(k)[0]][queue.get(k)[1]-1] == -1){
                                matrix[queue.get(k)[0]][queue.get(k)[1]-1] = count;
                                queue.add(new int [] {queue.get(k)[0],queue.get(k)[1]-1,});
                                if(count == 1){
                                    all.add(new int [] {queue.get(k)[0],queue.get(k)[1]-1,0});
                                }

                            }
                        }
                        catch(Exception e){

                        }
                    }
                    count++;
                }


            }
        }
        //for(int i =0; i< numRows;i++){
          //  System.out.println(Arrays.toString(matrix[i]));

        //}
        //start
        for(int i = 0; i< all.size();i++){
            try{
                if(matrix[all.get(i)[0]+1][all.get(i)[1]] == 0){
                    matrix[all.get(i)[0]+1][all.get(i)[1]] = 1;
                    all.add(new int[] {all.get(i)[0]+1,all.get(i)[1],all.get(i)[2]+1});
                }
                else if(matrix[all.get(i)[0]+1][all.get(i)[1]] == 2){
                    System.out.println(all.get(i)[2]);
                    break;
                }

            }
            catch(Exception e){

            }
            try{
                if(matrix[all.get(i)[0]-1][all.get(i)[1]] == 0){
                    matrix[all.get(i)[0]-1][all.get(i)[1]] = 1;
                    all.add(new int[] {all.get(i)[0]-1,all.get(i)[1],all.get(i)[2]+1});
                }
                else if(matrix[all.get(i)[0]-1][all.get(i)[1]] == 2){
                    System.out.println(all.get(i)[2]);
                    break;
                }

            }
            catch(Exception e){

            }
            try{
                if(matrix[all.get(i)[0]][all.get(i)[1]+1] == 0){
                    matrix[all.get(i)[0]][all.get(i)[1]+1] = 1;
                    all.add(new int[] {all.get(i)[0],all.get(i)[1]+1,all.get(i)[2]+1});
                }
                else if(matrix[all.get(i)[0]][all.get(i)[1]+1] == 2){
                    System.out.println(all.get(i)[2]);
                    break;
                }

            }
            catch(Exception e){

            }
            try{
                if(matrix[all.get(i)[0]][all.get(i)[1]-1] == 0){
                    matrix[all.get(i)[0]][all.get(i)[1]-1] = 1;
                    all.add(new int[] {all.get(i)[0],all.get(i)[1]-1,all.get(i)[2]+1});
                }
                else if(matrix[all.get(i)[0]][all.get(i)[1]-1] == 2){
                    System.out.println(all.get(i)[2]);
                    break;
                }

            }
            catch(Exception e){

            }
        }



       //for(int i =0; i< numRows;i++){
         //  System.out.println(Arrays.toString(matrix[i]));

       //}

    }


}
