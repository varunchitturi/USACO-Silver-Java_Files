package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MountainView {
    static Comparator<mountain> Y = new Comparator<mountain>() {
        @Override
        public int compare(mountain o1, mountain o2) {
            return Integer.compare(o2.y,o1.y);
        }
    };
    static Comparator<mountain> X = new Comparator<mountain>() {
        @Override
        public int compare(mountain o1, mountain o2) {
            return Integer.compare(o1.startX,o2.startX);
        }
    };
    public static void main(String[] args) throws FileNotFoundException {
        // Scanner in = new Scanner(System.in);
        File f = new File("mountains.in");
        Scanner in = new Scanner(f);
        int N = in.nextInt();
        mountain [] mountainsY = new mountain[N];
        mountain [] mountainsX = new mountain[N];
        for(int i= 0; i < N; i++){
            int x = in.nextInt(), y = in.nextInt();
            mountain m = new mountain(x,y);
            mountainsY[i] = m;
            mountainsX[i] = m;
        }
        Arrays.sort(mountainsX,X);
        Arrays.sort(mountainsY,Y);
        int ans = N;
        for(int i =0; i < mountainsY.length;i++){
            if(!mountainsY[i].isCovered){
                mountain curr = mountainsY[i];
                int start = lowerX(mountainsX,curr.startX);
                for(int j = start; j < mountainsX.length;j++ ){
                    if(mountainsX[j].endX > curr.endX){
                        break;
                    }
                    if(!mountainsX[j].isCovered && mountainsX[j] != curr){
                        mountainsX[j].isCovered = true;
                        ans--;
                    }
                }
            }
        }
        //System.out.println(ans);
        in.close();
        PrintWriter writer = new PrintWriter("mountains.out");
        writer.write(Integer.toString(ans));
        writer.close();
    }
    static class mountain{
        int x,y;
        int startX, endX;
        boolean isCovered = false;
        public mountain(int x, int y) {
            this.x = x;
            this.y = y;
            this.startX = x-y;
            this.endX = x+y;
        }
    }
    public static int lowerX(mountain[] ages, int target) {
        if (ages == null || ages.length == 0) {
            return 0;
        }
        int l = 0;
        int r = ages.length - 1;
        if (target <= ages[0].startX) {
            return 0;
        }
        if (target > ages[r].startX) {
            return -1;
        }
        while (l  <  r) {
            int m = l + (r - l ) / 2 ;

            if (ages[m].startX >= target) {
                r = m;
            }else {
                l = m + 1;
            }
        }
        return r;
    }

}
