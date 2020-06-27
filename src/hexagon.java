package src;

import java.lang.reflect.Array;
import java.util.*;
public class hexagon {
    public static void main(String [] args){
        Scanner input  = new Scanner(System.in);
        int K = input.nextInt();
        int H = input.nextInt();
        int L = input.nextInt();
        ArrayList<ArrayList<Node>> hexagon = new ArrayList<>();
        ArrayList<Node> answers = new ArrayList<>();
        int count = 1;
        for(int i = 0; i < K*2-1;i++){
            hexagon.add(new ArrayList<>());
            for(int j = 0 ; j < -Math.abs(i-(K-1))+K*2-1;j++){
                hexagon.get(i).add(new Node(count));
                count++;
            }
        }
        for(int i = 0; i < K*2-1;i++){
            for(int j = 0 ; j < -Math.abs(i-(K-1))+K*2-1;j++) {

                //right and left

                try {
                    hexagon.get(i).get(j).children.add(hexagon.get(i).get(j + 1));
                } catch (Exception e) {

                }
                try {
                    hexagon.get(i).get(j).children.add(hexagon.get(i).get(j - 1));
                } catch (Exception e) {

                }


                // up and down

                 //up
                if (i != 0) {
                    if (hexagon.get(i).size() > hexagon.get(i - 1).size()) {
                        try {
                            hexagon.get(i).get(j).children.add(hexagon.get(i - 1).get(j - 1));
                        } catch (Exception e) {

                        }

                        try {
                            hexagon.get(i).get(j).children.add(hexagon.get(i - 1).get(j));
                        } catch (Exception e) {
                        }

                    } else {
                        try {
                            hexagon.get(i).get(j).children.add(hexagon.get(i - 1).get(j));
                        } catch (Exception e) {

                        }

                        try {
                            hexagon.get(i).get(j).children.add(hexagon.get(i - 1).get(j+1));
                        } catch (Exception e) {
                        }

                    }
                }

                if(i != hexagon.size()-1) {
                    if(hexagon.get(i).size() < hexagon.get(i+1).size()) {
                        try {
                            hexagon.get(i).get(j).children.add(hexagon.get(i+1).get(j));
                        } catch (Exception e) {

                        }
                        try {
                            hexagon.get(i).get(j).children.add(hexagon.get(i+1).get(j+1));
                        } catch (Exception e) {

                        }
                    }
                    else{
                        try {
                            hexagon.get(i).get(j).children.add(hexagon.get(i+1).get(j-1));
                        } catch (Exception e) {

                        }
                        try {
                            hexagon.get(i).get(j).children.add(hexagon.get(i+1).get(j));
                        } catch (Exception e) {

                        }
                    }
                }


            }

        }

        for(int i = 0; i < hexagon.size();i++){
            for(int j = 0; j< hexagon.get(i).size();j++){
                if(hexagon.get(i).get(j).num == H){
                    hexagon.get(i).get(j).isVisited = true;
                    ArrayList<Node> queue = new ArrayList<>();
                    ArrayList<Node> toAddToqueue = new ArrayList<>();
                    addAll(queue,hexagon.get(i).get(j).children);
                    for(int k = 0; k< L;k++){
                        for(int l = 0; l < queue.size();l++){
                             if(k != L-1){
                             queue.get(l).isVisited = true;
                             addAll(toAddToqueue, queue.get(l).children);}
                             else{
                                 answers.addAll(queue);
                                 break;
                             }
                         }
                        queue.clear();
                        queue.addAll(toAddToqueue);
                        toAddToqueue.clear();
                     }

                }
            }
        }



        int [] finalAnswer = new int[answers.size()];
        for(int i = 0; i< answers.size();i++){
            finalAnswer[i] = answers.get(i).num;
        }
        Arrays.sort(finalAnswer);
        System.out.println(finalAnswer.length);
        for(int i = 0; i< finalAnswer.length;i++){
            System.out.println(finalAnswer[i]);
        }
    }
    static class Node{
        int num;
        boolean isVisited;
        ArrayList<Node> children = new ArrayList<>();
        public Node(int num){
            this.num = num;
            this.isVisited = false;
        }
    }
    static void addAll(ArrayList<Node> queue, ArrayList<Node> children ){
        for(int i = 0; i<children.size();i++){
            if(children.get(i).isVisited == false){
                queue.add(children.get(i));
                children.get(i).isVisited = true;
            }
        }
    }


}
