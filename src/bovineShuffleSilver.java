package src;

import java.util.*;
public class bovineShuffleSilver {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int numCows = input.nextInt();
        Command [] commands = new Command[numCows];
        for(int i = 0; i < numCows;i++){
            commands[i] = new Command(input.nextInt()-1,i);
        }
        int count = numCows;
        Command current;
        HashMap<Integer,Integer> cycle = new HashMap<>();
        ArrayList<Command> cycleTracker = new ArrayList<>();
        for(int i = 0;i < numCows;i++){
            current = commands[i];
            //cycle.clear();
            cycleTracker.clear();
            if(current.isDone == 0) {
                while (true) {

                    cycle.put(current.index, current.index);
                    cycleTracker.add(current);
                    if (cycle.containsKey(current.indexTo)) {
                        //if (commands[i].index != current.indexTo) {
                            int check = 1;
                            for (int j = 0; j < cycleTracker.size(); j++) {
                                if (cycleTracker.get(j).index == current.indexTo) {
                                    check = 2;
                                }
                                cycleTracker.get(j).isDone = check;
                            }
                            if(commands[i].isDone == 1){
                            count--;}
                        //}
                        break;
                    }
                    else {
                        current = commands[current.indexTo];
                    }
                }
            }
            else if(current.isDone == 1){
                count--;
            }



        }
        System.out.println(count);
    }
    static class Command{
        int index;
        int indexTo;
        int isDone;
        public Command(int indexTo, int index){
            this.indexTo = indexTo;
            isDone = 0;
            this.index = index;
        }
    }
    public static int lowerBound(ArrayList<Integer> array, int length, int value) {
        int low = 0;
        int high = length;
        while (low < high) {
            final int mid = (low + high) / 2;
            //checks if the value is less than middle element of the array
            if (value <= array.get(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

}
