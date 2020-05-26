import java.util.ArrayList;
import java.util.Scanner;

public class mirrors {
    static int [] [] mirrorLocations;
    static int numMirrors;
    static ArrayList<int []> done = new ArrayList<>();
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        numMirrors = input.nextInt();
        int [] barnLocation = new int [2];
        barnLocation[0] = input.nextInt();
        barnLocation[1] = input.nextInt();

        // / = -1
        // \ = 1
        // 1 = right
        // -1 = left
        // 2 = up
        // -2 = down
        mirrorLocations = new int [numMirrors+1][3];
        for(int i = 0; i < numMirrors;i++){
            mirrorLocations[i][0] = input.nextInt();
            mirrorLocations[i][1] = input.nextInt();
            String next = input.next();
            if(next.equals("\\")){
                mirrorLocations[i][2] = 1;
            }
            else{
                mirrorLocations[i][2] = -1;
            }
        }
        mirrorLocations[mirrorLocations.length-1][0] = barnLocation[0];
        mirrorLocations[mirrorLocations.length-1][1] = barnLocation[1];
        mirrorLocations[mirrorLocations.length-1][2] = 1;
        // start with right
        int [] start;
        int toReturn;
        for(int i = 0; i < numMirrors+1;i++){
            start =  new int[]{0, 0, 1, -1};
            done.clear();
            //done.add(new int [] {0,0,0,-1});
            if(i == 1){
                if(mirrorLocations[i-1][2] == 1){
                    mirrorLocations[i-1][2] = -1;
                }
                else{
                    mirrorLocations[i-1][2] = 1;
                }
            }
            if(i > 1){
                if(mirrorLocations[i-1][2] == 1){
                    mirrorLocations[i-1][2] = -1;
                }
                else{
                    mirrorLocations[i-1][2] = 1;
                }
                if(mirrorLocations[i-2][2] == 1){
                    mirrorLocations[i-2][2] = -1;
                }
                else{
                    mirrorLocations[i-2][2] = 1;
                }
            }
            while(true){
                start = reflect(start);
                if(start[3] == -1){
                    break;
                }
                if(start[1] == barnLocation[1] && start[0] == barnLocation[0]){
                    if(i == 0){
                        System.out.println(0);
                        System.exit(0);
                    }
                    else{
                        System.out.println(i);
                        System.exit(0);
                    }
                }
            }
        }

        System.out.println(-1);
    }
    static int [] reflect(int [] start){
        int [] current = {start[0],start[1],start[2]};
        int [] test;
        int x = start[0];
        int y = start[1];
        int direction = start[2];
        int closest;
        int best = -1;
        if(direction == 1){
            closest = Integer.MAX_VALUE;
            for(int i = 0; i < numMirrors+1;i++){
                if(mirrorLocations[i][1] == current[1] && mirrorLocations[i][0] < closest && mirrorLocations[i][0] > current[0]){
                    closest = mirrorLocations[i][0];
                    best = i;
                    if(current[2] == 1){
                        if(mirrorLocations[i][2] == -1){
                            direction = 2;
                        }
                        else{
                            direction = -2;
                        }
                    }
                    else if(current[2] == -1){
                        if(mirrorLocations[i][2] == -1){
                            direction = -2;
                        }
                        else{
                            current[2] = 2;
                        }
                    }
                    else if(current[2] == 2){
                        if(mirrorLocations[i][2] == -1){
                            direction = 1;
                        }
                        else{
                            direction = -1;
                        }
                    }
                    else if(current[2] == -2){
                        if(mirrorLocations[i][2] == -1){
                            direction = -1;

                        }
                        else{
                            direction = 1;

                        }
                    }
                }
            }
        }
        else if(direction == -1){
            closest = Integer.MIN_VALUE;
            for(int i = 0; i < numMirrors+1;i++){
                if(mirrorLocations[i][1] == current[1]  && mirrorLocations[i][0] > closest && mirrorLocations[i][0] < current[0] ){
                    closest = mirrorLocations[i][0];
                    best = i;
                    if(current[2] == 1){
                        if(mirrorLocations[i][2] == -1){
                            direction = 2;
                        }
                        else{
                            direction = -2;
                        }
                    }
                    else if(current[2] == -1){
                        if(mirrorLocations[i][2] == -1){
                            direction = -2;
                        }
                        else{
                            direction = 2;
                        }
                    }
                    else if(current[2] == 2){
                        if(mirrorLocations[i][2] == -1){
                            direction = 1;
                        }
                        else{
                            direction = -1;
                        }
                    }
                    else if(current[2] == -2){
                        if(mirrorLocations[i][2] == -1){
                            direction = -1;

                        }
                        else{
                            direction = 1;

                        }
                    }
                }
            }
        }
        else if(direction == 2){
            closest = Integer.MAX_VALUE;
            for(int i = 0; i < numMirrors+1;i++){
                if(mirrorLocations[i][0] == current[0]  && mirrorLocations[i][1] < closest && mirrorLocations[i][1] > current[1] ){
                    closest = mirrorLocations[i][1];
                    best = i;
                    if(current[2] == 1){
                        if(mirrorLocations[i][2] == -1){
                            direction = 2;
                        }
                        else{
                            direction = -2;
                        }
                    }
                    else if(current[2] == -1){
                        if(mirrorLocations[i][2] == -1){
                            direction = -2;
                        }
                        else{
                            direction = 2;
                        }
                    }
                    else if(current[2] == 2){
                        if(mirrorLocations[i][2] == -1){
                            direction = 1;
                        }
                        else{
                            direction = -1;
                        }
                    }
                    else if(current[2] == -2){
                        if(mirrorLocations[i][2] == -1){
                            direction = -1;

                        }
                        else{
                            direction = 1;

                        }
                    }
                }
            }
        }
        else if(direction == -2){
            closest = Integer.MIN_VALUE;
            for(int i = 0; i < numMirrors+1;i++){
                if(mirrorLocations[i][0] == current[0]  && mirrorLocations[i][1] > closest && mirrorLocations[i][1] < current[1]){
                    closest = mirrorLocations[i][1];
                    best = i;
                    if(current[2] == 1){
                        if(mirrorLocations[i][2] == -1){
                            direction = 2;
                        }
                        else{
                            direction = -2;
                        }
                    }
                    else if(current[2] == -1){
                        if(mirrorLocations[i][2] == -1){
                            direction = -2;
                        }
                        else{
                            direction = 2;
                        }
                    }
                    else if(current[2] == 2){
                        if(mirrorLocations[i][2] == -1){
                            direction = 1;
                        }
                        else{
                            direction = -1;
                        }
                    }
                    else if(current[2] == -2){
                        if(mirrorLocations[i][2] == -1){
                            direction = -1;

                        }
                        else{
                            direction = 1;

                        }
                    }
                }
            }
        }
        if(best==numMirrors){
            return new int [] {mirrorLocations[mirrorLocations.length-1][0],mirrorLocations[mirrorLocations.length-1][1],0,start[3]};
        }
        if(best != -1){
            test = new int[] {mirrorLocations[best][0],mirrorLocations[best][1],direction,best};
            int counter = 0;
            for(int i = 0; i< done.size();i++){

            if(done.get(i)[0] == test[0] && done.get(i)[1] == test[1] /*&& done.get(i)[2] == test[2] && done.get(i)[3] == test[3]*/){
                counter++;

            }
        }
            if(counter > 1){
                return new  int [] {0,0,0,-1};
            }
                done.add(test);
                return test;


        }
        else{
            return new  int [] {0,0,0,-1};
        }

    }

}
