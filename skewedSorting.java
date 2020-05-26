import java.lang.reflect.Array;
import java.util.*;

public class skewedSorting {
    static int totalMoves = 0;
    static int [] cows;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numCows = (int)Math.pow(2,input.nextInt());
        cows = new int[numCows];
        for(int i = 0; i< numCows;i++){
            cows[i] = input.nextInt();
        }
        skew(cows,0,cows.length);
        System.out.println(totalMoves);
        for(int i = 0; i< cows.length;i++){
            System.out.println(cows[i]);
        }

    }


    static void skew(int [] current,int start, int end){
        if(end-start == 2){
            if(current[start] > current[end-1]){
                totalMoves+=2;
                flip(current,start,end);
            }


        }
        else{
            skew(current,start,(start+end)/2);
            skew(current,(start+end)/2,end);
            if(current[start] > current[(start+end)/2]){
                totalMoves += Math.pow(end-start,2)/2;
                flip(current,start,end);
            }
        }
    }
    static void flip(int [] a,int start, int end){
        int [] temp = new int[(end-start)/2];
        for(int i = start ;i < (start+end)/2;i++){
            temp[i-start] = a[i];
        }
        for(int i = (start+end)/2; i < end;i++){
            a[start + i-(start+end)/2] = a[i];
            a[i] = temp[i-(start+end)/2];
        }

    }



}
