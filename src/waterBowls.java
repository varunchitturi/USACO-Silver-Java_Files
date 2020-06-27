package src;

import java.util.*;

public class waterBowls {
    static ArrayList<int []> allCombinations = new ArrayList<>();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] initialArray = new int [20];
        int [] arrangement = new int [20];
        for(int i= 0; i< 20;i++){
            arrangement[i] = i;
        }

        for(int i= 0 ; i< 20;i++){
            initialArray[i] = input.nextInt();
        }

        /*for(int i = 0; i< allCombinations.size();i++){
            System.out.println(Arrays.toString(allCombinations.get(i)));
        }*/
        if(checkAllFlipped(initialArray)){
            System.out.println(0);
        }
        else {
            outerloop:
            for (int k = 1; k <= 20; k++) {
                for (int i = 0; i < allCombinations.size(); i++) {
                    int[] test = Arrays.copyOf(initialArray, initialArray.length);
                    for (int j = 0; j < allCombinations.get(i).length; j++) {
                        flip(test, allCombinations.get(i)[j]);
                    }
                    if (checkAllFlipped(test)) {
                        System.out.println(allCombinations.get(i).length);
                        break outerloop;
                    }
                }
                allCombinations.clear();
                printCombination(arrangement, arrangement.length, k);
            }
        }
    }
    public static void flip(int [] a, int i){
        if(a[i] == 1){
            a[i] = 0;
        }
        else{
            a[i] = 1;
        }
        if(i != 0){
            if(a[i-1] == 0){
                a[i-1]  = 1;
            }
            else{
                a[i-1] = 0;
            }
        }
        if(i != 19){
            if(a[i+1] == 0){
                a[i+1] = 1;
            }
            else{
                a[i+1] = 0;
            }
        }
    }
    public static boolean checkAllFlipped(int [] a){
        for(int i = 0; i< a.length;i++){
            if(a[i] == 1){
                return false;
            }
        }
        return true;
    }
    static void combinationUtil(int arr[], int data[], int start,
                                int end, int index, int r)
    {
        // Current combination is ready to be printed, print it
        if (index == r)
        {
            int [] a = new int [r];
            for (int j=0; j<r; j++)
                a[j] = data[j];
            allCombinations.add(a);
            return;
        }

        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data[index] = arr[i];
            combinationUtil(arr, data, i+1, end, index+1, r);
        }
    }
    static void printCombination(int arr[], int n, int r)
    {

        int data[]=new int[r];

        combinationUtil(arr, data, 0, n-1, 0, r);
    }
}
