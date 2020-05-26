import java.util.*;
public class learning {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        long a = input.nextInt();
        long b = input.nextInt();
        cow [] farmersCows  = new cow[N+2];
        long count = 0;
        String trash = input.nextLine();
        for(int i = 0; i < N; i++){
            String [] line = input.nextLine().split(" ");
            if(line[0].equals("S")){
                farmersCows[i] = new cow(true, Long.parseLong(line[1]));
            }
            else{
                farmersCows[i] = new cow(false, Long.parseLong(line[1]));
            }
        }
        farmersCows[farmersCows.length -2] = new cow(false,Long.MIN_VALUE);
        farmersCows[farmersCows.length-1] = new cow(false,Long.MAX_VALUE);
        java.util.Arrays.sort(farmersCows, new java.util.Comparator<cow>() {
            public int compare(cow a, cow b) {
                if(a.weight > b.weight){
                    return 1;
                }
                else{
                    return -1;
                }

            }
        });
        for(int i = 0; i < farmersCows.length-1;i++){
            cow startCow = farmersCows[i];
            cow stopCow = farmersCows[i+1];

            long midpoint = (stopCow.weight + startCow.weight)/2;

            if(startCow.isSpotted()){
                long start = Math.max(startCow.weight+1,a);
                long end = Math.min(midpoint , b);
                if(end >= start){
                    count += end-start+1;
                }
            }
            if(stopCow.isSpotted()){
                long start = Math.max(midpoint+1,a);
                long stop = Math.min(stopCow.weight, b);
                if(stop>=start){
                    count += stop-start+1;
                }
            }
            if(stopCow.isSpotted() && !startCow.isSpotted() && (stopCow.weight-startCow.weight)%2 == 0 && a <= midpoint && midpoint <= b){
                count += 1;
            }
        }
        System.out.println(count);
    }

    static class cow{
        private boolean isSpotted;
        private long weight;
        public cow(boolean isSpotted, long weight){
            this.isSpotted = isSpotted;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return Long.toString(weight);
        }

        public boolean isSpotted() {
            return isSpotted;
        }

        public long getWeight() {
            return weight;
        }
    }
    static class eventInterval{
        long start;
        long stop;
        private boolean isSpotted;
        public eventInterval(boolean isSpotted, long start, long stop){
            this.isSpotted = isSpotted;
            this.start = start;
            this.stop = stop;
        }


        public long getStart() {
            return start;
        }

        public long getStop() {
            return stop;
        }

        public boolean isSpotted() {
            return isSpotted;
        }
    }


}
