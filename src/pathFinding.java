package src;

import java.lang.reflect.Array;
import java.util.*;

public class pathFinding {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int bessiePos = input.nextInt();
        int [] encountered = new int [100];
        encountered[bessiePos-1] = 1;
        Node [] allNodes = new Node[N];
        for(int i = 0; i < N;i++){
            allNodes[i] = new Node(i+1);

        }
        ArrayList<Node> queue = new ArrayList<>();
        for(int i = 0; i< N;i++){
            for(int j = 0; j < N;j++){
                if(input.nextInt() == 1){
                    allNodes[i].next.add(j);
                    encountered[j]=1;
                }
            }
        }
        boolean check = false;
        ArrayList<Integer> toPrint = new ArrayList<>();
        queue.add(allNodes[bessiePos-1]);
        int initial = 0;
        int numChildren = 0;
        int [] done = new int [N];
        int begin = 0;
        for(int i = 0; i < queue.size();i++){

            toPrint.add(queue.get(i).pos);

            done[queue.get(i).pos-1] = 1;
            for(int j= 0; j<queue.get(i).next.size();j++){
                if(done[queue.get(i).next.get(j)] == 0){
                    allNodes[queue.get(i).next.get(j)].id = queue.get(i).id+1;
                    queue.add(allNodes[queue.get(i).next.get(j)]);
                    done[queue.get(i).next.get(j)] = 1;

                }
            }

            if(i!= queue.size()-1 && queue.get(i+1).id != queue.get(i).id){
                Collections.sort(toPrint);
                for(int j = 0; j< toPrint.size();j++){
                    System.out.print(toPrint.get(j)+" ");
                }
                toPrint.clear();
                System.out.println();
            }


        }
        Collections.sort(toPrint);
        for(int i = 0; i< toPrint.size();i++){
            System.out.print(toPrint.get(i) + " ");
        }
    }

    static class Node{
        int pos;
        ArrayList<Integer> next;
        int id;
        public Node(int pos){
            this.pos = pos;
            next = new ArrayList<>();
            id = 0;
        }

    }
}
