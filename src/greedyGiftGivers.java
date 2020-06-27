package src;

import java.util.*;
public class greedyGiftGivers {
    static Scanner input = new Scanner(System.in);
    static Friend [] allFriends;
    public static void main(String [] args){

        int numFriends = input.nextInt();
        allFriends = new Friend[numFriends];
        for(int i = 0; i< numFriends;i++){
            allFriends[i] = new Friend(input.next(),0,0);
        }
        for(int i = 0; i< numFriends;i++){
            String name = input.next();
            for(int k = 0; k< numFriends;k++){
                if(allFriends[k].name.equals(name)){
                allFriends[k].moneyHeld = input.nextInt();
                allFriends[k].numFriends = input.nextInt();
                for(int j = 0; j<allFriends[k].numFriends;j++){
                    allFriends[k].friends.add(input.next());

                }
                break;
                }
            }
        }
        for(int i = 0; i < allFriends.length;i++){
            if(allFriends[i].numFriends!=0){
            int moneyToGive = allFriends[i].moneyHeld/allFriends[i].numFriends;
            for(int j = 0; j < allFriends[i].numFriends;j++){
                for(int k = 0; k < allFriends.length;k++){
                    if(allFriends[k].name.equals(allFriends[i].friends.get(j))){
                        allFriends[k].moneyReceived += moneyToGive;
                        allFriends[i].moneyGiven += moneyToGive;
                        break;}

                    }
                }
            }
        }
        for(int i = 0;i< allFriends.length;i++){
            System.out.println(allFriends[i].name + " " + Integer.toString(allFriends[i].moneyReceived-allFriends[i].moneyGiven));
        }

    }
    static class Friend{
        String name;
        int numFriends;
        ArrayList<String> friends = new ArrayList<>();
        int moneyHeld;
        int moneyReceived;
        int moneyGiven;
        public Friend(String name, int moneyHeld, int numFriends){
            this.moneyHeld = moneyHeld;
            this.name = name;
            this.numFriends = numFriends;
            moneyGiven = 0;

        }
    }

}
