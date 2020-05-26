import java.math.BigInteger;
import java.util.*;

public class lamps {
    static ArrayList<ArrayList<int []>> unique;
    static ArrayList<int []> answers = new ArrayList<>();
    static int N;
    static ArrayList<Integer> ON;
    static ArrayList<Integer> OFF;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        int counter = input.nextInt();
        ON = new ArrayList<>();
        OFF = new ArrayList<>();
        unique = new ArrayList<>();
        unique.add(new ArrayList<>());
        unique.add(new ArrayList<>());
        unique.add(new ArrayList<>());
        unique.add(new ArrayList<>());
        int [] buttonTypes = {1,2,3,4};
        for(int i = 0; i < buttonTypes.length;i++){
            printCombination(buttonTypes,buttonTypes.length,i+1);
        }
        ArrayList<int []> possibleCombinations = new ArrayList<>();
        while(true){
            int a = input.nextInt();
            if(a == -1){
                break;
            }
            ON.add(a);
        }
        while(true){
            int a = input.nextInt();
            if(a == -1){
                break;
            }
            OFF.add(a);
        }
        if(counter == 1){
            possibleCombinations.addAll(unique.get(0));
        }
        else if(counter == 2){
            possibleCombinations.addAll(unique.get(1));
            possibleCombinations.add(new int [] {});
        }
       else  if(counter == 3){
            possibleCombinations.addAll(unique.get(0));
            possibleCombinations.addAll(unique.get(2));
        }
      else if(counter == 4){
           possibleCombinations.addAll(unique.get(3));
           possibleCombinations.addAll(unique.get(1));
            possibleCombinations.add(new int [] {});

        }
       else if(counter > 4 && counter%2 == 0){
            possibleCombinations.addAll(unique.get(3));
            possibleCombinations.addAll(unique.get(1));
            possibleCombinations.add(new int [] {});
       }
       else if(counter > 4 && counter%2 == 1){
            possibleCombinations.addAll(unique.get(0));
            possibleCombinations.addAll(unique.get(2));
       }
       else if(counter == 0){
           possibleCombinations.add(new int [] {});
        }
       for(int i = 0; i< possibleCombinations.size();i++){
           int [] a = pressButtons(possibleCombinations.get(i));
           if(check(a)){
               answers.add(a);
           }
       }

            Collections.sort(answers, new java.util.Comparator<int []>() {
                public int compare(int [] o1, int [] o2) {
                    String a = getString(o1);
                    String b = getString(o2);
                    return a.compareTo(b);


                }
            });
        if(answers.size() != 0) {
            for (int i = 0; i < answers.size(); i++) {
                for (int j = 0; j < answers.get(i).length; j++) {
                    System.out.print(answers.get(i)[j] + "");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("IMPOSSIBLE");
        }

    }
    static void combinationUtil(int arr[], int data[], int start,
                                int end, int index, int r)
    {

        if (index == r)
        {
            int [] a = new int [r];
            for (int j=0; j<r; j++)
                a[j] = data[j];
            unique.get(r-1).add(a);
            return;
        }
        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data[index] = arr[i];
            combinationUtil(arr, data, i+1, end, index+1, r);
        }
    }
    static String getString(int [] a){
        String toReturn = "";
        for(int i =0 ; i < a.length;i++){
            toReturn += a[i];
        }
        return toReturn;
    }
    static void printCombination(int arr[], int n, int r)
    {
        int data[]=new int[r];

        combinationUtil(arr, data, 0, n-1, 0, r);
    }
    static void toggle(int [] a,int i){
        if(a[i] == 1){
            a[i] = 0;
            return;
        }
        a[i] = 1;
    }
    static boolean check(int [] a){
        for(int i = 0; i < ON.size();i++){
            if(a[ON.get(i)-1] == 0){
                return false;
            }
        }
        for(int i = 0; i < OFF.size();i++){
            if(a[OFF.get(i)-1] == 1){
                return false;
            }
        }
        return true;
    }

    static int [] pressButtons( int [] buttonCombination){
        int [] blank = new int[N];
        for(int i = 0; i< N;i++){
            blank[i] = 1;
        }
        for(int i = 0; i < buttonCombination.length;i++) {
            if (buttonCombination[i] == 1) {
              for(int j = 0; j < N;j++){
                  toggle(blank,j);
              }
            } else if (buttonCombination[i] == 2) {
                for(int j = 0; j < N; j+=2){
                    toggle(blank,j);
                }
            } else if (buttonCombination[i] == 3) {
                for(int j = 1; j < N;j+=2){
                    toggle(blank,j);
                }
            } else if (buttonCombination[i] == 4) {
                for(int j = 0; j < N;j+=3){
                    toggle(blank,j);
                }
            }
        }
        return blank;
    }
}
