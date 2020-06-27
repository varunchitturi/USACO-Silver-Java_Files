package src;

import java.util.*;
public class dishes {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int numDishes = input.nextInt();
        ArrayList<Integer> toClean = new ArrayList<>();
        ArrayList<Integer> toDry = new ArrayList<>();
        ArrayList<int []> commands = new ArrayList<>();
        ArrayList<Integer> finalArray = new ArrayList<>();
        while(input.hasNextInt()){
            int [] command = {input.nextInt(),input.nextInt()};
            commands.add(command);
        }
        for(int i = 0; i<numDishes;i++){
            toClean.add(i+1);
        }

        for(int i = 0; i<commands.size();i++){
            if(commands.get(i)[0] == 1){
                for(int j = 0; j< commands.get(i)[1];j++){
                    toDry.add(0,toClean.get(0));
                    toClean.remove(0);

                }

            }
            else{
                for(int j = 0; j<commands.get(i)[1];j++){
                    finalArray.add(0,toDry.get(0));
                    toDry.remove(0);
                }
            }
        }
        for(int i = 0; i< finalArray.size();i++){
            System.out.println(finalArray.get(i));
        }



    }
}
