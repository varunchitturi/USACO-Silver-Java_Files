import java.util.*;

public class cowRace {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> timesToCalculate = new ArrayList<>();
        int bessieRuns = input.nextInt();
        int elsieRuns = input.nextInt();
        int[][] bessie = new int[bessieRuns][2];
        int[][] elsie = new int[elsieRuns][2];
        int count = 0;
        int time1 = 0;
        int time2 = 0;
        for (int i = 0; i < bessieRuns; i++) {
            bessie[i][0] = input.nextInt();
            bessie[i][1] = input.nextInt();
            time1 += bessie[i][1];
            //count+= bessie[i][1];
            //timesToCalculate.add(count);
        }
        count = 0;
        for (int i = 0; i < elsieRuns; i++) {
            elsie[i][0] = input.nextInt();
            elsie[i][1] = input.nextInt();
            time2 += elsie[i][1];
            //count += elsie[i][1];
            //timesToCalculate.add(count);
        }
        int t = Math.max(time1,time2);
        int b = 0;
        int e = 0;
        int bPos = 0;
        int ePos = 0;
        int check = 0;
        count = 0;
        int eCount = elsie[0][1];
        int bCount = bessie[0][1];
        for(int i = 1; i <= t;i++){
           if(i > bCount){
               b++;
               if(b < bessie.length)
               bCount += bessie[b][1];


           }
           if(i > eCount){
               e++;
               if(e < elsie.length)
               eCount += elsie[e][1];

           }
            if(b < bessie.length){
                bPos += bessie[b][0];
            }
            if(e < elsie.length){
                ePos += elsie[e][0];
            }
            if(bPos > ePos){
                if(check == -1){
                    count++;
                }
                check = 1;
            }
            else if(bPos < ePos){
                if(check == 1){
                    count++;
                }
                check = -1;
            }


        }

        System.out.println(count);


    }

}
