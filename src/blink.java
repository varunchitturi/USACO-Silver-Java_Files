package src;

import java.util.*;
public class blink {
    static int num;
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        num = input.nextInt();
        long rounds = input.nextLong();
        int [] count = new int [(int)Math.pow(2,num)];
        for(int i = 0; i<count.length;i++){
            count[i] = -1;
        }
        int [] lightBulbs = new int[num];
        for(int i = 0; i< num;i++){
            lightBulbs[i] = input.nextInt();
        }
        int roundsOver = 0;
        boolean check = false;
        outerloop:
        while(roundsOver != rounds){
            if(count[toDeci(lightBulbs)] == -1){
            count[toDeci(lightBulbs)] = roundsOver;
            roundsOver++;
            toggle(lightBulbs);}
            else{
                for(int i = 0; i < count.length;i++){
                    if(count[i] == (((rounds-count[toDeci(lightBulbs)])) % ((long)(roundsOver-count[toDeci(lightBulbs)])))+count[toDeci(lightBulbs)]){
                        print(toBin(i));
                        check = true;
                        break outerloop;
                    }
                }
            }
        }
        if(check == false){
            print(lightBulbs);
        }


    }
    public static void print(int [] a){
        for(int i = 0; i< a.length;i++){
            System.out.println(a[i]);
        }
    }

    public static int toDeci(int [] binary){
        int num = 0;
        for(int i = binary.length-1; i>=0;i--){
            num += binary[i]*Math.pow(2, binary.length-i-1);
        }
        return num;
    }
    public static int [] toBin(int deci){
        String a = Integer.toBinaryString(deci);
        while(a.length()!=num){
            a = "0" + a;
        }
        int [] print = new int [a.length()];
        for(int i = 0; i<print.length;i++){
            print[i] = Integer.parseInt(Character.toString(a.charAt(i)));
        }
        return print;
    }
    public static void toggle(int [] lightBulbs){
        int [] holder = Arrays.copyOf(lightBulbs,lightBulbs.length);
        for(int i= 0; i< lightBulbs.length;i++){
            if(i!= 0){
                if(holder[i-1] == 1){
                    lightBulbs[i] = (lightBulbs[i]+1)%2;
                }
            }
            else{
                if(holder[holder.length-1] == 1){
                    lightBulbs[i] = (lightBulbs[i]+1)%2;
                }
            }
        }
    }


}
