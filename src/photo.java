package src;

import java.util.Scanner;

public class photo {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int totalCows = input.nextInt();

        int numPairs = input.nextInt();
        int [] [] pairs = new int [numPairs][2];

        for(int i = 0; i< numPairs;i++){
            int a = input.nextInt()-1;
            int b = input.nextInt()-1;
            if(a<b)
            pairs[i] = new int []{a,b};
            else{
                pairs[i] = new int []{b,a};
            }

        }
        java.util.Arrays.sort(pairs, new java.util.Comparator<int []>() {
            public int compare(int [] a, int [] b) {
                if(a[0] > b[0]){
                    return 1;
                }
                else{
                    return -1;
                }


            }
        });
        int numPictures = 1;
        int min = pairs[0][1];
        for(int i = 0; i < pairs.length;i++){

            if(pairs[i][0] >= min){
                numPictures++;
                min = pairs[i][1];
            }
            else{
                if(min > pairs[i][1] && pairs[i][1] > pairs[i][0]){
                    min = pairs[i][1];
                }
            }
        }
        System.out.println(numPictures+1);

    }

}
