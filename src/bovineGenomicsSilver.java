package src;

import java.util.*;
public class bovineGenomicsSilver {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int numCows = input.nextInt();
        int length = input.nextInt();
        String trash = input.nextLine();
        String [] spottedCows = new String[numCows];
        String [] plainCows = new String[numCows];
        for(int i = 0; i< numCows;i++){
            spottedCows[i] = input.nextLine();
        }
        for(int i = 0; i< numCows; i++){
            plainCows[i] = input.nextLine();
        }

        int count = 0;
        char a;
        char b;
        char c;
        boolean check;
        for(int i = 0; i< length - 2;i++){
            for(int j = i+1; j< length-1; j++){
                for(int k = j+1; k < length; k++){
                    int [] checker = new int[64];
                    for(int l = 0; l < numCows;l++){
                        a = plainCows[l].charAt(i);
                        b = plainCows[l].charAt(j);
                        c = plainCows[l].charAt(k);
                        checker[getValue(a)*16 + getValue(b)*4 + getValue(c)] += 1;

                    }
                    check = true;
                    for(int l = 0; l < numCows;l++) {
                        a = spottedCows[l].charAt(i);
                        b = spottedCows[l].charAt(j);
                        c = spottedCows[l].charAt(k);
                        if (checker[getValue(a)*16 + getValue(b)*4 + getValue(c)] > 0) {
                            check = false;
                            break;
                        }

                    }
                    if(check == true){
                        count++;
                    }
                }

            }
        }

        System.out.println(count);
    }



    public static int getValue(char a){
        if(a == 'A'){
            return 0;
        }
        if(a == 'C'){
            return 1;
        }
        if(a == 'T'){
            return 2;
        }
        else{
            return 3;
        }

    }
}
