package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class grassPlanting {
    public static void main(String[] args) throws Exception {
        //Scanner in = new Scanner(System.in);
        File f = new File("planting.in");
        Scanner in = new Scanner(f);
        int N = in.nextInt();
        node [] nodeMap = new node[N+1];
        for(int i = 0; i< N-1; i++){
            int a = in.nextInt(), b = in.nextInt();
            if(nodeMap[a] == null){
                if(nodeMap[b] == null){
                    nodeMap[a] = new node(a);
                    nodeMap[b] = new node(b);
                }
                else{
                    nodeMap[a] = new node(a);
                }
            }
            else{
                if(nodeMap[b] == null){
                    nodeMap[b] = new node(b);
                }
            }
            nodeMap[a].child.add(nodeMap[b]);
            nodeMap[b].child.add(nodeMap[a]);
        }
        int ans = 0;
        for(int i = 0; i < N; i++){
            int curr = 1;
            node source = nodeMap[i+1];
            curr += source.child.size();
            if(curr > ans){
                ans = curr;
            }
        }
        //System.out.println(ans);
        in.close();
        PrintWriter w = new PrintWriter("planting.out");
        w.write(Integer.toString(ans));
        w.close();
    }
    static class node{
        int val;
        boolean isVisited;
        ArrayList<node> child = new ArrayList<>();
        public node(int val) {
            this.val = val;
            this.isVisited = false;
        }
    }

}
