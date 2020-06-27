package src;

import java.util.*;
public class diningCows {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int numCows = input.nextInt();
        int [] numbers = new int [numCows];
        int a;
        int countOne = 0;
        int countTwo = 0;
        ArrayList<Integer> twoOccurs = new ArrayList<>();
        for(int i = 0; i < numCows; i++){
            a = input.nextInt();
            if(a == 1){
                countOne++;
            }
            if(a == 2){
                if(numbers.length != 0){
                    if(numbers[numbers.length-1] != 2){
                        twoOccurs.add(i);
                    }
                }
                else{
                    twoOccurs.add(i);
                }
                countTwo++;
            }
            numbers[i] = a;

        }

        int minChanges = Integer.MAX_VALUE;

        for(int i = 0; i < twoOccurs.size();i++){
            a = count(Arrays.copyOfRange(numbers,twoOccurs.get(i),numbers.length),1) + count(Arrays.copyOfRange(numbers,0,twoOccurs.get(i)),2);
            if(a < minChanges){
                minChanges = a;
            }
        }

        a = count(numbers,2);
        if(a < minChanges){
            minChanges = a;
        }

        if(countOne == 0 || countTwo == 0){
            System.out.println(0);
        }
        else{
            System.out.println(minChanges);
        }


    }

    public static int count(int [] a, int element){
        int count = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] == element){
                count++;
            }
        }
        return count;
    }

}
