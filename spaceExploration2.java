import java.util.*;
public class spaceExploration2 {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int [][] matrix = new int [size][size];
        for(int i = 0; i< size;i++){
            String next = input.next();
            for(int j = 0; j < size; j++){
                if(next.charAt(j) == '*'){
                    matrix[i][j]=1;
                }
                else{
                    matrix[i][j] = 0;
                }
            }
        }
        int asteroidCount = 0;
        ArrayList<int []> queue = new ArrayList<>();
        for(int i = 0; i < size;i++){
            for(int j = 0; j< size;j++){
                if(matrix[i][j]==1){
                    asteroidCount+=1;
                    queue.clear();
                    queue.add(new int [] {i,j,1});

                    for(int k = 0; k< queue.size();k++){
                        matrix[queue.get(k)[0]][queue.get(k)[1]] = 2;

                        try{
                            if(matrix[queue.get(k)[0]+1][queue.get(k)[1]] == 1){
                                queue.add(new int [] {queue.get(k)[0]+1,queue.get(k)[1],queue.get(k)[2]+1});

                                matrix[queue.get(k)[0]+1][queue.get(k)[1]] = 2;

                            }
                        }
                        catch(Exception e){

                        }
                        try{
                            if(matrix[queue.get(k)[0]-1][queue.get(k)[1]] == 1){
                                queue.add(new int [] {queue.get(k)[0]-1,queue.get(k)[1],queue.get(k)[2]+1});

                                matrix[queue.get(k)[0]-1][queue.get(k)[1]] = 2;
                            }
                        }
                        catch(Exception e){

                        }
                        try{
                            if(matrix[queue.get(k)[0]][queue.get(k)[1]+1] == 1){
                                queue.add(new int [] {queue.get(k)[0],queue.get(k)[1]+1,queue.get(k)[2]+1});

                                matrix[queue.get(k)[0]][queue.get(k)[1]+1] = 2;
                            }
                        }
                        catch(Exception e){

                        }
                        try{
                            if(matrix[queue.get(k)[0]][queue.get(k)[1]-1] == 1){
                                queue.add(new int [] {queue.get(k)[0],queue.get(k)[1]-1,queue.get(k)[2]+1});

                                matrix[queue.get(k)[0]][queue.get(k)[1]-1] = 2;
                            }
                        }
                        catch(Exception e){

                        }
                    }
                }

            }

        }
        System.out.println(asteroidCount);

    }
}
