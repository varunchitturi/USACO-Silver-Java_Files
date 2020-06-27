package src;

import java.util.*;

public class overPlanting {
    static rectangle [] fields;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        fields = new rectangle[N];
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        for(int i = 0; i < N;i++) {
            int x1 = input.nextInt();
            int y1 = input.nextInt();
            int x2 = input.nextInt();
            int y2 = input.nextInt();
            fields[i] = new rectangle(x1, y1, x2, y2);
            if(x1 < minX){
                minX = x1;
            }
            if(x2 > maxX){
                maxX = x2;
            }
        }
        //ArrayList<interval> [] positions = new ArrayList[maxX-minX];
        //for (int i = 0; i < maxX-minX; i++) {
         //   positions[i] = new ArrayList<>();
        //}
        java.util.Arrays.sort(fields, (o1, o2) -> {
                if(o1.x1 < o2.x1){
                    return -1;
                }
                else{
                    return 1;
                }
        });

            int count = 0;
            for(double i = minX+0.5; i< maxX+1;i++){
                int c = 0;
                ArrayList<interval> toAdd = new ArrayList<>();
                for (int j = 0; j < N;j++){

                    if(i > fields[j].x1 && i < fields[j].x2){
                        toAdd.add(new interval(true,fields[j].y2, c));
                        toAdd.add(new interval(false,fields[j].y1,c));
                        c += 1;
                    }
                    if(i < fields[j].x1){
                        break;
                    }
                }
                count += getSize(toAdd);


        }
        System.out.println(count);
    }
    static class rectangle{
        int x1;
        int y1;
        int x2;
        int y2;

        public rectangle(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }
    static int findIndex(int x){
        for(int i = 0; i < fields.length;i++){
            if(x >= fields[i].x1){
                return i;
            }
        }
        return -1;
    }
    static class interval{
        boolean isStart;
        int pos;
        int index;

        public interval(boolean isStart, int pos, int index) {
            this.isStart = isStart;
            this.pos = pos;
            this.index = index;
        }
    }
    static int getSize(ArrayList<interval> allIntervals){
        HashSet<Integer> current = new HashSet<>();
        Collections.sort(allIntervals, (o1, o2) -> {
            if(o1.pos < o2.pos){
                return -1;
            }
            else{
                return 1;
            }
        });
        int count = 0;
        for(int i = 0; i < allIntervals.size()-1;i++){
            if(allIntervals.get(i).isStart){
                current.add(allIntervals.get(i).index);
                count += allIntervals.get(i+1).pos - allIntervals.get(i).pos;
            }
            else{
                current.remove(allIntervals.get(i).index);
                if(current.size() != 0){
                    count += allIntervals.get(i+1).pos - allIntervals.get(i).pos;
                }
            }
        }
        return count;
    }



}
