package src;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class convention2 {
    static Comparator<cow> c = new Comparator<cow>() {
        @Override
        public int compare(cow o1, cow o2) {
           return Long.compare(o1.seniority, o2.seniority);
        }
    };
    public static void main(String[] args) throws Exception {
        File f = new File("convention2.in");
        //Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(f);
        long N = in.nextInt();
        long currTime = 0;
        PriorityQueue<cow> q = new PriorityQueue<>();
        for(long i = 0; i < N; i++){
            long start = in.nextInt();
            long l = in.nextInt();
            q.add(new cow(i,start,l));

        }
        long ans = 0;
        PriorityQueue<cow> line = new PriorityQueue<>(c);
        cow currCow;
        while(!q.isEmpty() || !line.isEmpty()){
            boolean useLine = false;
            if(!line.isEmpty()){
                currCow = line.poll();
                currCow.timeWaited = currTime - currCow.start;
                useLine = true;
            }
            else{
                currCow = q.poll();
            }

            if(currCow.timeWaited > ans){
                ans = currCow.timeWaited;
            }
            if(useLine){
                currTime += currCow.length;
            }
            else{
                currTime = currCow.start + currCow.length;
            }

            while(true){
                if(!q.isEmpty() && q.peek().start <= currTime){
                    cow toAdd = q.poll();
                    line.add(toAdd);
                }
                else{
                    break;
                }
            }

        }
        in.close();
        PrintWriter out = new PrintWriter("convention2.out");
        out.write(Long.toString(ans));
        out.close();
        //System.out.println(ans);
    }
    static class cow implements Comparable<cow>{
        long seniority, start,length;
        long timeWaited = 0;
        public cow(long seniority, long start, long length) {
            this.seniority = seniority;
            this.start = start;
            this.length = length;
        }

        @Override
        public int compareTo(cow o) {
            if(this.start<o.start){
                return -1;
            }
            else if(this.start == o.start){
                if(this.seniority < o.seniority){
                    return -1;
                }
                return 1;
            }
            return 1;
        }
    }
}
