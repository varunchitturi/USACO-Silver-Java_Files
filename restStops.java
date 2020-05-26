import java.util.*;

public class restStops {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int numStops = input.nextInt();
        int farmerRate = input.nextInt();
        int bessieRate = input.nextInt();
        stop [] stops = new stop[numStops];
        for(int i = 0; i < numStops;i++ ){
            stops[i] = new stop(input.nextInt(),input.nextInt());
        }

        long currentPlace = 0;
        long timeGained = 0;
        long total = 0;
        java.util.Arrays.sort(stops, new java.util.Comparator<stop>() {
            public int compare(stop a, stop b) {
                if(a.tastiness > b.tastiness){
                    return -1;
                }
                else{
                    return 1;
                }


            }
        });
        for(int i = 0; i< numStops;i++){
            if(stops[i].place > currentPlace){
                timeGained += (stops[i].place-currentPlace)*(-bessieRate+farmerRate);
                currentPlace = stops[i].place;
                total += stops[i].tastiness*timeGained;
                timeGained = 0;
            }
        }
        System.out.println(total);

    }



    static class stop{
        int place;
        int tastiness;
        public stop(int place, int tastiness){
            this.place = place;
            this.tastiness = tastiness;
        }
    }


}
