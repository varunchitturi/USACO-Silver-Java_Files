import java.util.*;

public class helpCross {
    public static int firstOccurance(ArrayList<int []> numbers, int length, int searchNum){
        int answer = -1;
        int start = 0;
        int end = length -1;
        int middle;
        while( start <= end){
            middle = (int)((start + end) / 2);

            if(numbers.get(middle)[1] == searchNum){
                answer = middle;
                end = middle -1;
            }
            else if (numbers.get(middle)[1] > searchNum){
                end = middle - 1;
            }
            else{
                start = middle + 1;
            }
        }
        return answer;
    }

    public static void main(String [] args) {
        ArrayList<Integer> chickenTimes = new ArrayList<>();
        ArrayList<int []> cowTimes = new ArrayList<>();
        int numChickens;
        int numCows;
        Scanner input = new Scanner(System.in);
        numChickens = input.nextInt();
        numCows = input.nextInt();
        for(int i = 0; i < numChickens; i++){
            chickenTimes.add(input.nextInt());
        }

        for(int i = 0; i < numCows; i++){
            int [] toAppend = new int [2];
            toAppend[1] = input.nextInt();
            toAppend[0]= input.nextInt();
            cowTimes.add(toAppend);


        }
        Collections.sort(chickenTimes);
        Collections.sort(cowTimes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[0] - b[0]==0) //if equals
                {
                    return a[1]-b[1];//recompare
                }
                else
                    return a[0]-b[0];
            }
        });


        // print out the contents of cowTimes and chickenTimes
      //  for(int i = 0; i < chickenTimes.size(); i++){
        //    System.out.println(chickenTimes.get(i));
        //}

        //for(int i = 0; i < cowTimes.size();i++){
          //  System.out.println(Arrays.toString(cowTimes.get(i)));
        //}
        int j;

        int count = 0;
        for(int i = 0; i<numChickens; i++){
            j = firstOccurance(cowTimes, cowTimes.size(), chickenTimes.get(i));

            while (j < cowTimes.size()){

                if(j < 0){if(chickenTimes.get(i) >= cowTimes.get(cowTimes.size()+j)[1]){
                    if(chickenTimes.get(i) <= cowTimes.get(cowTimes.size()+j)[0]){
                        count++;
                        cowTimes.remove(cowTimes.size()+j);
                        break;
                    }
                }}
                else{if(chickenTimes.get(i) >= cowTimes.get(j)[1]){
                    if(chickenTimes.get(i) <= cowTimes.get(j)[0]){
                        count++;
                        cowTimes.remove(j);
                        break;
                    }
                }}







                j++;
            }
        }


        System.out.println(count);
    }

}
