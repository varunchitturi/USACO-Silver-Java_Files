package src;

import java.util.*;
public class fairPhotography {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int numCows = input.nextInt();
        cow [] allCows = new cow[numCows];
        for(int i = 0; i < numCows;i++){
            allCows[i] = new cow(input.nextInt(), input.next());

        }
        java.util.Arrays.sort(allCows, new java.util.Comparator<cow>() {
            public int compare(cow a, cow b) {
                if(a.position > b.position){
                    return 1;
                }
                else{
                    return -1;
                }

            }
        });
        int longestH = 0;
        int longestG = 0;
        int tempG = 0;
        int tempH = 0;
        for(int i = 0; i< numCows-1;i++){
            if(allCows[i].type == 1 && allCows[i+1].type == 1){
                tempG += allCows[i+1].position - allCows[i].position;
            }
            else{
                if(tempG > longestG){
                    longestG = tempG;
                }
                tempG = 0;
            }
        }
        for(int i = 0; i< numCows-1;i++){
            if(allCows[i].type == -1 && allCows[i+1].type == -1){
                tempH += allCows[i+1].position - allCows[i].position;
            }
            else{
                if(tempH > longestH){
                    longestH = tempH;
                }
                tempH = 0;
            }
        }
        int [] prefixSum = new int[numCows + 1];
        prefixSum[0] = 0;
        int count = 0;
        for(int i = 1; i < numCows+1;i++){
            count += allCows[i-1].type;
            prefixSum[i] = count;
        }
        ArrayList<intervals> counter = new ArrayList<intervals>();
        int starter = 0;
        int end = 0;
        counter.add(new intervals(prefixSum[0], 0, -1));
        for(int i = 1; i < numCows + 1;i++){
            if( prefixSum[i] > end || prefixSum[i] < starter ){
                if(prefixSum[i] > end){
                    end = prefixSum[i];
                    counter.add(new intervals(prefixSum[i], i, -1));
                }
                else if(prefixSum[i] < starter){
                    starter = prefixSum[i];
                    counter.add(0,new intervals(prefixSum[i],i,-1));
                }
            }
            else{
                counter.get(prefixSum[i]-starter).stop = i;
            }
        }
        int greatestCount = 0;
        for(int i = 0; i < counter.size();i++){
            int size = 0;
            if(counter.get(i).stop != -1){
                size = allCows[counter.get(i).stop-1].position - allCows[counter.get(i).start ].position;
            }
            if(size > greatestCount){
                greatestCount = size;
            }
        }
        System.out.println(Math.max(Math.max(longestG,longestH),greatestCount));


    }
    static class intervals{
        int element;
        int start;
        int stop;
        public intervals(int element, int start, int stop){
            this.element = element;
            this.start = start;
            this.stop = stop;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            intervals intervals = (intervals) o;
            return start == intervals.start &&
                    stop == intervals.stop;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, stop);
        }
    }

    public static int in(int element, ArrayList<intervals> intervals){

        for(int i = 0; i < intervals.size();i++){
            if(intervals.get(i).element == element){
                return i;
            }
        }
        return -1;
    }





    static class cow{
        int type;
        int position;
        public cow(int position, String type){
            this.position = position;
            if(type.equals("G")){
                this.type = 1;
            }
            else{
                this.type = -1;
            }
        }

    }

}
