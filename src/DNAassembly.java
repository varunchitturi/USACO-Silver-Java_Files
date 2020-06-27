package src;

import java.util.*;

public class DNAassembly {
    static int numStrings;
    static int bestStringLength = 100;
    static String [] allStrings;
    static ArrayList<String []> allCombinations = new ArrayList<>();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        numStrings = input.nextInt();
        allStrings = new String [numStrings];
        for(int i = 0; i< allStrings.length;i++){
            allStrings[i] = input.next();
        }
        permute(allStrings);
       // for(int i = 0; i< allCombinations.size();i++){
      //      System.out.println(Arrays.toString(allCombinations.get(i)));
       // }
        for(int i = 0; i< allCombinations.size();i++){
        String current = allCombinations.get(i)[0];
        merge(current,1,allCombinations.get(i));
        }

        System.out.println(bestStringLength);
        //for(int i = 0; i< allCombinations.size();i++){
        //    System.out.println(Arrays.toString(allCombinations.get(i)));
       // }
    }
    static void merge(String str1, int index, String [] strings) {
        String toReturn1 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaasasasaaaasasasasasasassasasassasasasassasasasasasasaa";
        String toReturn2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaasasasaaaasasasasasasassasasassasasasassasasssasasasaa";
        // str1 first str2 second
        if (index >= numStrings) {
            if (bestStringLength > str1.length()) {
                bestStringLength = str1.length();
            }
        } else {
            String str2 = strings[index];
            int minLength = Math.min(str1.length(), str2.length());
            for (int i = 0; i < minLength + 1; i++) {
                if (str1.substring(str1.length() - i, str1.length()).equals(str2.substring(0, i))) {
                    toReturn1 = str1.substring(0, str1.length() - i) + str2;
                }
            }
            for (int i = 0; i < minLength + 1; i++) {
                if (str1.substring(0, i).equals(str2.substring(str2.length() - i, str2.length()))) {
                    toReturn2 = str2 + str1.substring(i, str1.length());
                }
            }

                if(toReturn1 != "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaasasasaaaasasasasasasassasasassasasasassasasasasasasaa" && toReturn1.length() < bestStringLength)
                merge(toReturn1,index + 1,strings);
                if(toReturn2 != "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaasasasaaaasasasasasasassasasassasasasassasasssasasasaa" && toReturn2.length()<bestStringLength)
                merge(toReturn2,index+1,strings);



        }
    }
    public static void permute(String[] arr){
        permuteHelper(arr, 0);
    }

    private static void permuteHelper(String[] arr, int index){
        if(index >= arr.length - 1){ //If we are at the last element - nothing left to permute
            //System.out.println(Arrays.toString(arr));
            //Print the array
            String [] total = new String[arr.length];

            for(int i = 0; i < arr.length - 1; i++){

                total[i] = arr[i];
            }
            if(arr.length > 0){

                total[arr.length - 1] = arr[arr.length - 1];}
            allCombinations.add(total);

            return;
        }

        for(int i = index; i < arr.length; i++){ //For each index in the sub array arr[index...end]

            //Swap the elements at indices index and i
            String t = arr[index];
            arr[index] = arr[i];
            arr[i] = t;

            //Recurse on the sub array arr[index+1...end]
            permuteHelper(arr, index+1);

            //Swap the elements back
            t = arr[index];
            arr[index] = arr[i];
            arr[i] = t;
        }
    }

}
