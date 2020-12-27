package src;

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class convention {
    static int N,M,C;
    static int[] cows;
    public static void main(String[] args) throws Exception {
        //Scanner in = new Scanner(System.in);
        int ans = 0;
        File f = new File("convention.in");
        Scanner in = new Scanner(f);
        N = in.nextInt(); M = in.nextInt(); C = in.nextInt();
        cows = new int[N];
        for(int i = 0; i < N; i++){
            int next = in.nextInt();
            cows[i] = next;
        }
        Arrays.sort(cows);
        ans = searchAnswer(0,1000000000);
        in.close();
        PrintWriter p = new PrintWriter("convention.out");
        p.write(ans + "\n");
        p.close();

    }
    static int searchAnswer(int l, int h){
        int m = (l+h)/2;
        if(l==h){
            if(check(l)){
                return l;
            }
        }
        if(l+1 == h){
            if(check(l)){
                return l;
            }
            return h;
        }
        if(check(m)){
            return searchAnswer(l,m);
        }
        return searchAnswer(m+1,h);
    }
    static boolean check(int t){
        int busNeeded = 1;
        int startingCow = 0;
        for(int i = 1; i < N;i++){
            if(cows[i]-cows[startingCow] > t || i-startingCow+1 > C){
                startingCow = i;
                busNeeded++;
            }
        }
        return busNeeded <= M;
    }
}
