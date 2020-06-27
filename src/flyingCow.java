package src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.*;
public class flyingCow {

    static int farm;

    static int [] usedPos = new int[1000005];
    public static void main(String [] args){

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try{
        farm = Integer.parseInt(input.readLine());}
        catch (Exception e){

        }

        int energyUsed = 0;
        Node start = new Node(1,0);
        ArrayList<Node> queue = new ArrayList<>();
        queue.add(start);
            for(int i = 0; i< queue.size();i++){
                if(queue.get(i).location == farm){
                    System.out.println(queue.get(i).energy);
                    break ;

                }
                if( queue.get(i).location > 0 && queue.get(i).location-1 -farm <= 3 && usedPos[queue.get(i).location - 1] == 0 && queue.get(i).location - 1 < 1000004){
                    queue.add(new Node(queue.get(i).location - 1,queue.get(i).energy+1));
                    usedPos[queue.get(i).location - 1] = 1;

                }

                if(queue.get(i).location + 1 < 1000004 && usedPos[queue.get(i).location+1] == 0 && queue.get(i).location < farm){
                    queue.add(new Node(queue.get(i).location + 1,queue.get(i).energy+1));

                    usedPos[queue.get(i).location+1] = 1;

                }

                if(queue.get(i).location*3 < 1000004 && usedPos[queue.get(i).location*3] == 0 && queue.get(i).location < farm) {
                    queue.add(new Node(queue.get(i).location * 3, queue.get(i).energy + 1));
                    usedPos[queue.get(i).location*3] = 1;

                }

            }




    }
    static class Node{
        int energy;
        int location;
        /*Node i3;
        Node iplus1;
        Node iminus1;*/

        public Node(int location,int energy){
            this.location = location;
            this.energy = energy;

        }

    }

}
