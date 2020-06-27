package src;

import java.util.*;

public class Moo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
         int N = input.nextInt();
        int current = 4;
        //N--;


        //test code
       //int  N = Integer.parseInt(args[0]);
        N--;


        int block = 3;
        int total = 3;
        boolean check = false;
        if(N == 0){
            System.out.println("m");
           check = true;
        }
        boolean forwardIsless = true;
        if(!check){
        while(total < N){
            total += current;
            if(total == N){
                System.out.println("m");
                check = true;
                break;
            }
            total += block;
            if(total == N){
                System.out.println("m");
                check = true;
                break;
            }
            block = block*2+current;
            current++;

        }
        if(total == N && !check){
            System.out.println("m");
            check = true;

        }
        HashSet<Integer> visited = new HashSet<>();
        current--;
        block -= current;
        block /= 2;
        total -= block;
        total -= current;
        current--;
        block -= current;
        block /= 2;
        if(total < N){
            total += current+1;
            total+= block;
        }
        else{
            total -= block;
            total -= current;
        }
        if(!check){
            while (true) {
            if(current == 2 || block == 0){
                System.out.println("o");
                break;
            }
            if(total == N){
                System.out.println("m");
                break;
            }

            if(total > N){
                if(current == 2){
                    System.out.println('o');
                    break;
                }
                    current--;
                    block -= current;
                    block /= 2;
                    total -= block;
                    total -= current;





            }
            else{
               if(current == 2){
                   System.out.println('o');
                   break;
               }
                total += current;
                current--;
                block -= current;
                block /= 2;
                total += block;


            }
                if(total == N){
                    System.out.println("m");
                    break;
                }
        }}


    }}
}
