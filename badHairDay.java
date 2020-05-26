import java.lang.reflect.Array;
import java.util.*;
public class badHairDay {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        int numCows = input.nextInt();
        Cow [] cows = new Cow[numCows];
        for(int i = 0;i<numCows;i++){
            cows[i] = new Cow(input.nextInt(),i);
        }


        java.util.Arrays.sort(cows, new java.util.Comparator<Cow>() {
            public int compare(Cow a, Cow b) {
                if(a.height != b.height){
                    if(a.height < b.height){
                        return 1;
                    }
                    else{
                        return -1;
                    }
                }
                else{
                    if(a.index < b.index){
                        return 1;
                    }
                    else{
                        return -1;
                    }
                }

            }
        });

        ArrayList<Integer> heightOrder = new ArrayList<>();

        long count = 0;
        for(int i = 0; i < cows.length;i++){
            if(heightOrder.size() == 0) {
                heightOrder.add(cows[i].index);
                count += numCows - cows[i].index-1;
            }
            else{
                int indexToAdd = lowerBound(heightOrder,heightOrder.size(),cows[i].index);
                heightOrder.add(indexToAdd, cows[i].index);
                if(indexToAdd == heightOrder.size()-1){
                    count += numCows- cows[i].index-1;
                }
                else{
                    count +=  heightOrder.get(indexToAdd+1) - heightOrder.get(indexToAdd) -1;
                }


            }

        }

        System.out.println(count);

    }
    static class Cow{
        int height;
        int index;
        public Cow(int height, int index){
            this.height = height;
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
