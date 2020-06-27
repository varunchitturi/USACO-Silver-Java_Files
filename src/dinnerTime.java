package src;

import java.util.*;
public class dinnerTime {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int numCows = input.nextInt();
        int numChairs = input.nextInt();
        Integer [] [] cowPositions = new Integer [numCows][2];
        int [] [] chairPositions = new int [numChairs][2];
        ArrayList<Integer> hungryCows = new ArrayList<>();
        for(int i = 0; i < numCows;i++){
            cowPositions[i][0] = input.nextInt();
            cowPositions[i][1] = input.nextInt();
        }
        for(int i = 0; i < numChairs;i++){
            chairPositions[i][0] = input.nextInt();
            chairPositions[i][1] = input.nextInt();
        }
        int closestCow;
        double closestDistance;
        double distance;
        for(int i = 0; i < chairPositions.length;i++){
            closestCow = 0;
            closestDistance =Double.MAX_VALUE;
            for(int j = 0; j < numCows; j++){
                if(cowPositions[j][0] != null && cowPositions[j][1] != null){
                distance = getDistance(cowPositions[j][0], cowPositions[j][1], chairPositions[i][0],chairPositions[i][1]);
                if(distance < closestDistance){
                    closestDistance = distance;
                    closestCow = j;

                }}
            }
            cowPositions[closestCow][0] = null;
            cowPositions[closestCow][1] = null;

        }
        boolean didPrint = false;
        for(int i = 0; i < numCows; i++){
            if(cowPositions[i][0] != null && cowPositions[i][1] != null){
                System.out.println(i+1);
                didPrint = true;
            }
        }
        if (didPrint == false) {
            System.out.println(0);
        }
        //System.out.println(Arrays.toString(cowPositions));
    }
    public static double getDistance(int x1, int y1, int x2, int y2){
        return(Math.pow(Math.abs(x1-x2),2) + Math.pow(Math.abs(y1-y2),2));
    }
}
