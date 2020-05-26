import java.util.*;

public class bovineBallet {
    static foot FL;
    static foot FR;
    static foot RL;
    static foot RR;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        FL = new foot(0,1);
        FR = new foot(1,1);
        RL = new foot(0,0);
        RR = new foot(1,0);
        int minX = 0;
        int minY = 0;
        int maxX = 1;
        int maxY = 1;
        int N = input.nextInt();
        for (int i = 0; i < N; i++) {
            String command = input.next();
            if(command.charAt(2) == 'P'){
                pivot(command);
            }
            else{
                move(command);
            }
            checkTrip();
            if(minX > getMinx()){
                minX = getMinx();
            }
            if(minY > getMiny()){
                minY = getMiny();
            }
            if(maxX < getMaxX()){
                maxX = getMaxX();
            }
            if(maxY < getMaxY()){
                maxY = getMaxY();
            }
        }
        System.out.println((Math.abs(minX - maxX)+1) * (Math.abs(minY - maxY)+1));
    }
    static int getMinx(){
        int [] a = new int[4];
        a[0] = FR.x;
        a[1] = FL.x;
        a[2] = RL.x;
        a[3] = RR.x;
        int min = a[0];
        for(int i = 0; i < 4;i++){
            if(min > a[i]){
                min = a[i];
            }
        }
        return min;
    }
    static int getMiny(){
        int [] a = new int[4];
        a[0] = FR.y;
        a[1] = FL.y;
        a[2] = RL.y;
        a[3] = RR.y;
        int min = a[0];
        for(int i = 0; i < 4;i++){
            if(min > a[i]){
                min = a[i];
            }
        }
        return min;
    }
    static int getMaxX(){
        int [] a = new int[4];
        a[0] = FR.x;
        a[1] = FL.x;
        a[2] = RL.x;
        a[3] = RR.x;
        int max = a[0];
        for(int i = 0; i < 4;i++){
            if(max < a[i]){
                max = a[i];
            }
        }
        return max;
    }
    static int getMaxY(){
        int [] a = new int[4];
        a[0] = FR.y;
        a[1] = FL.y;
        a[2] = RL.y;
        a[3] = RR.y;
        int max = a[0];
        for(int i = 0; i < 4;i++){
            if(max < a[i]){
                max = a[i];
            }
        }
        return max;
    }
    static class foot{
        static int direction;
        int x;
        int y;
        public foot(int x, int y){
            this.x = x;
            this.y = y;
            direction = 0;
        }
    }
    static void checkTrip(){
        // FL and FR
        if(FL.x == FR.x && FL.y == FR.y){
            System.out.println(-1);
            System.exit(0);
        }
        //FL and RL
        if(FL.x == RL.x && FL.y == RL.y){
            System.out.println(-1);
            System.exit(0);
        }
        //FL and RR
        if(FL.x == RR.x && FL.y == RR.y){
            System.out.println(-1);
            System.exit(0);
        }
        //FR and RL
        if(FR.x == RL.x && FR.y == RL.y){
            System.out.println(-1);
            System.exit(0);
        }
        //FR and RR
        if(FR.x == RR.x && FR.y == RR.y){
            System.out.println(-1);
            System.exit(0);
        }
        //RL and RR
        if(RL.x == RR.x && RL.y == RR.y){
            System.out.println(-1);
            System.exit(0);
        }
    }

    static foot toFoot(String f){
        if(f.equals("FL")) {
            return FL;
        }
        if(f.equals("FR")) {
            return FR;
        }
        if(f.equals("RL")) {
            return RL;
        }
        if(f.equals("RR")) {
            return RR;
        }
        return null;
    }
    static void move(String command){
        String f = Character.toString(command.charAt(0)) + command.charAt(1);
        foot toMove = toFoot(f);
        if(command.charAt(2) == 'R'){
            if(foot.direction == 0){
                toMove.x += 1;
            }
            else if(foot.direction== 1){
                toMove.y -= 1;
            }
            else if(foot.direction== 2){
                    toMove.x -= 1;
            }
            else if(foot.direction== 3){
                    toMove.y += 1;
            }
        }
        else if(command.charAt(2) == 'F'){
            if(foot.direction == 0){
                toMove.y += 1;
            }
            else if(foot.direction== 1){
                toMove.x += 1;
            }
            else if(foot.direction== 2){
                toMove.y -= 1;
            }
            else if(foot.direction== 3){
                toMove.x -= 1;
            }
        }
        else if(command.charAt(2) == 'B'){
            if(foot.direction == 0){
                toMove.y -= 1;
            }
            else if(foot.direction== 1){
                toMove.x -= 1;
            }
            else if(foot.direction== 2){
                toMove.y += 1;
            }
            else if(foot.direction== 3){
                toMove.x += 1;
            }
        }
        else if(command.charAt(2) == 'L'){
            if(foot.direction == 0){
                toMove.x -= 1;
            }
            else if(foot.direction== 1){
                toMove.y += 1;
            }
            else if(foot.direction== 2){
                toMove.x += 1;
            }
            else if(foot.direction== 3){
                toMove.y -= 1;
            }
        }

    }

    /*
    static void addColumnsToEnd(){
        for(int i = 0; i < matrix.size();i++){
            matrix.get(i).add(0);
        }
    }
    static void addColumnsToBegin(){
        for(int i = 0; i < matrix.size();i++){
            matrix.get(i).add(0,0);
        }
    }
    static void addRowToEnd(){
        ArrayList<Integer> toAdd = new ArrayList<>();
        for(int i = 0; i < matrix.get(0).size();i++){
            toAdd.add(0);
        }
        matrix.add(toAdd);
    }
    static void addRowToBegin(){
        ArrayList<Integer> toAdd = new ArrayList<>();
        for(int i = 0; i < matrix.get(0).size();i++){
            toAdd.add(0);
        }
        matrix.add(0,toAdd);
    }*/
    static void pivot(String command){
        foot.direction = (foot.direction+1) % 4;
        String f = Character.toString(command.charAt(0)) + command.charAt(1);
        if(f.equals("FL")){
            rotate(FR,FL);
            rotate(RL,FL);
            rotate(RR,FL);
        }
        else if(f.equals("FR")){
            rotate(FL,FR);
            rotate(RL,FR);
            rotate(RR,FR);
        }
        else if(f.equals("RL")){
            rotate(FR,RL);
            rotate(FL,RL);
            rotate(RR,RL);
        }
        else if(f.equals("RR")){
            rotate(FR,RR);
            rotate(FL,RR);
            rotate(RL,RR);
        }

    }
    static void rotate(foot toRotate, foot rotateAbout){
        int newY = -1*(toRotate.x - rotateAbout.x)+rotateAbout.y;
        int newX = (toRotate.y - rotateAbout.y) + rotateAbout.x;
        toRotate.x = newX;
        toRotate.y = newY;
    }

}
