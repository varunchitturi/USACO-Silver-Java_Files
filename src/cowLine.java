package src;

import java.util.*;
public class cowLine {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int numCommands = input.nextInt();
        Command [] commands = new Command[numCommands];
        for(int i = 0; i< numCommands;i++){
            String type = input.next();
            if(type.equals("A")){
            commands[i] = new Command(type, input.next());
            }
            else{
                commands[i] = new Command(type, input.next(),input.nextInt());
            }
        }
        Node start = null;
        Node before = null;

        int count = 0;
        for(int i = 0; i< numCommands;i++){
            if(commands[i].type.equals("A")) {
                count += 1;
                if (start == null) {
                    start = new Node(null, null, count);

                    before = start;
                } else {
                    if(commands[i].direction.equals("R")){
                        before.next =  new Node(before, null, count);
                        before =  before.next;
                        if(start != null && start.next == null){
                            start.next = before;
                        }

                    }
                    else{
                        start.before = new Node(null, start, count);
                        start = start.before;
                        if(before != null && before.before == null){
                            before.before = start;
                        }

                    }
                }
            }
            else{
                if(commands[i].direction.equals("R")){
                    for(int j = 0; j < commands[i].count;j++){
                        before = before.before;
                    }
                    before.next = null;
                }
                else{
                    for(int j = 0; j < commands[i].count;j++){
                        start = start.next;

                    }
                    start.before = null;
                }
            }

        }
        while(true){
            if(start == null){
                break;
            }else{
                System.out.println(start.value);
                start = start.next;
            }
        }
    }

    static class Command{
        String type;
        String direction;
        int count;
        public Command(String type, String direction)
        {
            this.type = type;
            this.direction = direction;

        }
        public Command(String type, String direction, int count){
            this.type = type;
            this.direction = direction;
            this.count = count;

        }

    }

    static class Node{
        Node before;
        Node next;
        int value;
        public Node(Node before, Node next, int value){
            this.before = before;
            this.next = next;
            this.value = value;
        }
    }

}
