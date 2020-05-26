import java.util.*;
public class nameNum {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        long combinationNum = input.nextLong();
        String trash = input.nextLine();
        String currentString;
        char [] [] numToString = {{'A','B','C'},{'D','E','F'},{'G','H','I'},{'J','K','L'},{'M','N','O'},{'P','R','S'},{'T','U','V'},{'W','X','Y'}};
        boolean didPrint = false;
        while(input.hasNextLine()){
            currentString = input.nextLine();

            if(currentString.length() == Long.toString(combinationNum).length()){
                boolean check = true;
                for(int i = 0; i < currentString.length();i++){
                    if(contains(numToString[Integer.parseInt(Character.toString((Long.toString(combinationNum).charAt(i))))-2],currentString.charAt(i)) != true){
                        check = false;
                        break;
                    }
                }
                if(check == true){
                    System.out.println(currentString);
                    didPrint = true;
                }
            }
        }
        if(didPrint == false){
            System.out.println("NONE");
        }


    }
    static boolean contains(char [] array, char element) {
        for(int i = 0;i<array.length;i++){
            if(element == array[i]){
                return true;
            }
        }
        return false;
    }
}
