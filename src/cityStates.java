package src;

import java.util.*;
public class cityStates {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int numPlaces = input.nextInt();
        ArrayList<String> places = new ArrayList<>();
        String city = "";
        String states = "";
        for(int i = 0; i < numPlaces;i++){
            city = input.next();
            states = input.next();
            places.add(Character.toString(city.charAt(0)) + Character.toString(city.charAt(1))+states);
        }

        Collections.sort(places);

        int count = 0;
        int lower;
        int upper;
        for(int i = 0; i <places.size()-1;i++){
            String toCheck = Character.toString(places.get(i).charAt(2)) + Character.toString(places.get(i).charAt(3)) + Character.toString(places.get(i).charAt(0)) + Character.toString(places.get(i).charAt(1));
            lower = lowerBound(places.subList(i+1,places.size()), places.size()-i-1, toCheck);
            upper = upperBound(places.subList(i+1,places.size()), places.size()-i-1, toCheck);
            if(!(Character.toString(places.get(i).charAt(2)) + Character.toString(places.get(i).charAt(3))).equals(Character.toString(places.get(i).charAt(0)) + Character.toString(places.get(i).charAt(1))))
            count += upper - lower;
        }
        System.out.println(count);

    }

    public static int lowerBound(List<String> array, int length, String value) {
        int low = 0;
        int high = length;
        while (low < high) {
            final int mid = (low + high) / 2;
            //checks if the value is less than middle element of the array
            if (value.compareTo(array.get(mid)) <= 0) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }


    public static int upperBound(List<String> array, int length, String value) {
        int low = 0;
        int high = length;
        while (low < high) {
            final int mid = (low + high) / 2;
            if (value.compareTo(array.get(mid)) >= 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }


}