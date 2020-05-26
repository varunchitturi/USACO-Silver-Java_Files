import java.util.*;
public class hoofPaperScissors {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int plays = input.nextInt();
        int [] h = new int [plays];
        int [] p = new int [plays];
        int [] s = new int [ plays];
        int hCount = 0;
        int pCount = 0;
        int sCount = 0;
        for(int i = 0; i < plays; i++){
            String a = input.next();
            if(a.equals("H")){
                hCount += 1;

            } else if (a.equals("P")) {
                pCount += 1;

            }
            else{
                sCount += 1;
            }
            h[i] = hCount;
            p[i] = pCount;
            s[i] = sCount;
        }
        int greatestWins = Integer.MIN_VALUE;
        for(int i = 0; i<plays-1;i++){
            int best = calculateBestWins(h[i],h[h.length-1]-h[i],p[i],p[p.length-1]-p[i],s[i],s[s.length-1]-s[i]);
            if(greatestWins < best){
                greatestWins = best;
            }
        }
        int hh = 0;
        int pp = 0;
        int ss = 0;
        hh += s[s.length-1];
        pp += h[h.length-1];
        ss += p[p.length-1];
        greatestWins = Math.max(Math.max(Math.max(greatestWins,hh),pp),ss);
        System.out.println(greatestWins);

    }
    public static int calculateBestWins(int hLeft, int hRight, int pLeft, int pRight, int sLeft, int sRight){
        int h1 = 0;
        int p1 = 0;
        int s1 = 0;
        int h2 = 0;
        int p2 = 0;
        int s2 = 0;
        int hs = 0;
        int sh = 0;
        int hp = 0;
        int ph = 0;
        int ps = 0;
        int sp = 0;
        //int hh = 0;
        //int pp = 0;
        //int ss = 0;
        hs += sLeft + pRight;
        sh += pLeft + sRight;
        hp += sLeft + hRight;
        ph += hLeft + sRight;
        ps += hLeft + pRight;
        sp += pLeft + hRight;




        return getMax((new int[]{h1, p1, s1, h2,p2,s2,hs,sh,hp,ph,ps,sp}));

    }
    public static int getMax(int [] a){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < a.length; i++){
            if(a[i] > max){
                max = a[i];
            }
        }
        return max;
    }

}
