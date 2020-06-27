package src;

import java.util.*;



public class calfFlac {
    public static void main(String [] args){
        Scanner input = new Scanner((System.in));
        String sentence = "";
        String substring;
        int [] answer = new int [2];
        while (true){
            if (input.hasNextLine()){
                sentence += input.nextLine() + "@";}
            else{

                break;

            }
        }
        String s = sentence;
        String [] a = new String [2];
        String [] b = new String [2];
        String [] greatest = {"","0"};
        for (int i = 1; i < s.length()-1;i++){
            if(Character.isLetter(s.charAt(i))){
                a = check1(s,i);
                b = check2(s,i);
                if(Integer.parseInt(a[1]) > Integer.parseInt(greatest[1])){
                    greatest[0] = a[0];
                    greatest[1] = a[1];
                }
                if(Integer.parseInt(b[1]) > Integer.parseInt(greatest[1])){
                    greatest[0] = b[0];
                    greatest[1] = b[1];
                }
            }

        }
        System.out.println(greatest[1]);
        for(int i = 0; i < greatest[0].length(); i++){
            if(greatest[0].charAt(i) == '@'){
                System.out.println();
            }
            else{
                System.out.print(greatest[0].charAt(i));
            }
        }

    }
    static String [] check1(String s, int start){
        int lengthCount = 1;
        int placeCount = 1;
        int pointStart = start;
        int pointEnd = start;
        int placeStart = pointStart;
        int placeEnd = pointEnd;
        while(true){
            if(pointEnd == s.length()-1 || pointStart == 0){
                break;
            }
            placeEnd = findNext(pointEnd, s);
            placeStart = findFirst(pointStart,s);
            placeCount += 2;
            if(placeEnd == -1 || placeStart == -1){
                break;
            }
            if(Character.toLowerCase(s.charAt(placeEnd)) != Character.toLowerCase(s.charAt(placeStart))){

                break;
            }
            if(Character.toLowerCase(s.charAt(placeEnd)) == Character.toLowerCase(s.charAt(placeStart))){
                pointEnd = placeEnd;
                pointStart = placeStart;
                lengthCount = placeCount;
            }
        }
        String [] answer = {s.substring(pointStart, pointEnd+1), Integer.toString(lengthCount)};
        return answer;

    }
    static String [] check2(String s, int start){
        int next = findNext(start, s);
        int lengthCount = 1;
        int placeCount = 1;

        if( next !=  - 1 && Character.toLowerCase(s.charAt(start)) == Character.toLowerCase(s.charAt(next))){
            lengthCount += 1;
            placeCount += 1;
            int pointStart = start;
            int pointEnd = next;
            int placeStart = pointStart;
            int placeEnd = pointEnd;
            while(true){
                if(pointEnd == s.length() - 1 || pointStart == 0){
                    break;
                }
                placeEnd = findNext(pointEnd, s);
                placeStart = findFirst(pointStart, s);
                placeCount += 2;
                if(placeEnd == -1 || placeStart == -1){
                    break;
                }
                if(Character.toLowerCase(s.charAt(placeEnd)) != Character.toLowerCase(s.charAt(placeStart))){

                    break;
                }
                if(Character.toLowerCase(s.charAt(placeEnd)) == Character.toLowerCase(s.charAt(placeStart))){
                    pointEnd = placeEnd;
                    pointStart = placeStart;
                    lengthCount = placeCount;
                }
            }
            String [] answer = {s.substring(pointStart, pointEnd + 1), Integer.toString(lengthCount)};
            return answer;
        }
        else{
            String [] answer = {Character.toString(s.charAt(start)), Integer.toString(lengthCount)};
            return answer;
        }
    }

    static int findNext(int start, String s){
        int i;
        for (i = start+1; i < s.length(); i++){
            if(Character.isLetter(s.charAt(i))){
                return i;
            }
        }
        return -1;
    }
    static int findFirst(int start, String s){
        for(int i = start - 1; i>= 0; i--){
            if(Character.isLetter(s.charAt(i))){
                return i;
            }
        }
        return -1;
    }


}