package src;

import java.util.*;

public class mothersMilk {
    static ArrayList<Integer> answers = new ArrayList<>();
    static int [] done = new int [9261];
    static  int [] initial;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        initial = new int[3];
        for(int i = 0;i< 3;i++){
            initial[i] = input.nextInt();
        }
        pourRec(new int [] {0,0,initial[2]});
        Collections.sort(answers);
        for(int i = 0; i< answers.size();i++){
            System.out.print(answers.get(i) + " ");
        }

    }
    static int tobase21(int [] a){
        int toReturn = 0;
        toReturn += a[0]*(int)Math.pow(21,2);
        toReturn += a[1]*(int)Math.pow(21,1);
        toReturn += a[2]*(int)Math.pow(21,0);
        return toReturn;
    }
    static int [] pour(int [] a, int toPour, int toPourInto){
        if(a[toPour] != 0){
            if((initial[toPourInto] - a[toPourInto]) < a[toPour]){
                int space = (initial[toPourInto] - a[toPourInto]);
                a[toPourInto] = initial[toPourInto];
                a[toPour] -= space;
            }
            else{
                a[toPourInto] += a[toPour];
                a[toPour] = 0;
            }
        }
        return a;
    }


    static void pourRec(int [] a){
        if(done[tobase21(a)] == 0) {
           done[tobase21(a)] = 1;
            if(a[0] == 0){
                answers.add(a[2]);
            }
            for (int i = 0; i < 3; i++) {
                if(a[i] != 0) {
                    for (int j = 0; j < 3; j++) {
                        if (j != i && a[j] != initial[j]) {
                            int[] c = pour(Arrays.copyOf(a, a.length), i, j);

                            pourRec(c);
                        }
                    }
                }

            }

        }
    }
}
