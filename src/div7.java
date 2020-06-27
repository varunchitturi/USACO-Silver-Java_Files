package src;

import java.util.*;
public class div7 {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int numNumbers = input.nextInt();
        long [] numbers = new long [numNumbers];
        for(int i = 0; i < numNumbers;i++){
            numbers[i] = input.nextLong();
        }
        int [] prefixSum = new int[numNumbers];
        long count = 0;
        for(int i = 0; i < numNumbers;i++){
            count += numbers[i];
            prefixSum[i] = (int)(count%7);
        }
        counter [] allCount = new counter[7];
        for(int i = 0; i< 7;i++){
            allCount[i] = new counter(-1,-1);
        }

        int answer = 0;
        for(int i = 0; i < numNumbers;i++){
            if(allCount[prefixSum[i]].start == -1){
                allCount[prefixSum[i]].start = i;
            }
            else{
                allCount[prefixSum[i]].stop = i;
            }
        }

        for(int i = 0; i < allCount.length;i++){
            if(allCount[i].stop - allCount[i].start > answer){
                answer = allCount[i].stop - allCount[i].start;
            }
        }

        System.out.println(answer);
    }



    static class counter{
        int start;
        int stop;
        public counter(int start, int stop){
            this.start = stop;
            this.start = stop;
        }

    }

}
