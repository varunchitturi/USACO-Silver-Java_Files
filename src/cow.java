package src;

import java.util.*;

public class cow {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        String cow = input.next();
        long cCount = 0;
        long total = 0;
        long count = 0;
        for(int i = 0; i < length;i++){
            if(cow.charAt(i) == 'C'){
                cCount++;
            }
            if(cow.charAt(i) == 'O'){
                count += cCount;
            }
            if(cow.charAt(i) == 'W'){
                total += count;
            }
        }
        System.out.println(total);
    }

}
