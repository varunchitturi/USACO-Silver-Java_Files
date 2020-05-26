import java.util.*;
public class maxCross {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int numCrosswalks = input.nextInt();
        int workingSignalsNeeded = input.nextInt();
        int numID = input.nextInt();
        ArrayList<Integer> IDs = new ArrayList<>();
        for(int i = 0; i< numID;i++) {
            IDs.add(input.nextInt());
        }
        Collections.sort(IDs);
        if(IDs.get(0) != 1){
            IDs.add(0,1);
        }
        if(IDs.get(IDs.size()-1) != numCrosswalks){
            IDs.add(numCrosswalks);
        }
        ArrayList<Integer> road = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < IDs.size();i++){
            count++;
            if(i != IDs.size() - 1){
                for(int j = 0; j < IDs.get(i+1) - IDs.get(i); j++){
                    road.add(count);
                }
            }else{
                road.add(count);
            }

        }
        //for(int i = 0; i < road.size();i++) {
          //  System.out.println(road.get(i));
        //}

        int min = numID;
        int takeDownNeeded = numID;
        for(int i = 0; i <  numCrosswalks-workingSignalsNeeded+1;i++){
            if(i != numCrosswalks-1){
                if(i == 0 || road.get(i) != road.get(i-1)) {

                        takeDownNeeded = road.get(i + workingSignalsNeeded - 1) - road.get(i)-1;
                        if(takeDownNeeded < min){
                            min = takeDownNeeded;

                    }

                }
            }
        }
        System.out.println(min);
    }
}
