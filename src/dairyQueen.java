package src;

import java.util.*;

public class dairyQueen {
    static int numToGet;
    static int [] coins;
    static int possibleWays = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        numToGet = input.nextInt();
        int numCoins = input.nextInt();
        coins = new int [numCoins];
        for(int i = 0; i< numCoins;i++){
            coins[i] = input.nextInt();
        }
        int multiplier =0;
        while(true){
            if(coins[0]*multiplier <= numToGet){
                calculate(1,coins[0]*multiplier);
                multiplier++;
            }
            else{
                break;
            }

        }
        System.out.println(possibleWays);
    }
    static void calculate(int whichCoin, int sum){
        if(sum == numToGet){
            possibleWays++;
            return;
        }
        if(whichCoin != coins.length){
            int multiplier = 0;
            while(true){
                if(sum + multiplier*coins[whichCoin] <= numToGet){
                    calculate(whichCoin+1,sum+multiplier*coins[whichCoin]);
                    multiplier++;
                }
                else{
                    break;
                }
            }
        }
    }

}
