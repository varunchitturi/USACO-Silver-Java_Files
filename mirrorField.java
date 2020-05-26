import java.util.*;
public class mirrorField {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int numRows = input.nextInt();
        int numColumns = input.nextInt();
        String [] field = new String [numRows];
        String r = input.nextLine();
        for(int i = 0; i < numRows; i++){
            field[i] = input.nextLine();
        }

        int [] lastPoint = new int [2];
        int [] point = new int [2];
        ArrayList<Integer> reflected = new ArrayList<>();
        boolean didMove;
        String direction;
        int a;
        int reflectedNum;

        for (int i = 0; i< numRows; i++) {
            a = i;
            reflectedNum = 0;
            lastPoint[0] = a;
            lastPoint[1] = 0;
            point[0] = a;
            point[1] = 0;
            didMove = false;
            direction = "right";
            while (true) {
                if (direction.equals("right")){
                    if (field[point[0]].charAt(point[1]) == '\\'){
                        if (didMove == false){
                            point[0] += 1;
                            didMove = true;
                            reflectedNum += 1;}
                        else{
                            lastPoint[0] = point[0];
                            lastPoint[1] = point[1];
                            point[0] += 1;
                            reflectedNum += 1;}
                        direction = "down";}
                    else{
                        if (didMove == false){
                            point[0] -= 1;
                            didMove = true;
                            reflectedNum += 1;}
                        else{
                            lastPoint[0] = point[0];
                            lastPoint[1] = point[1];
                            point[0] -= 1;
                            reflectedNum += 1;}
                        direction = "up";}}
                else if (direction.equals("left")){
                    if (field[point[0]].charAt(point[1]) == '\\'){
                        if (didMove == false){
                            point[0] -= 1;
                            didMove = true;
                            reflectedNum += 1;}
                        else{
                            lastPoint[0] = point[0];
                            lastPoint[1] = point[1];
                            point[0] -= 1;
                            reflectedNum += 1;}
                        direction = "up";}
                    else{
                        if (didMove == false){
                            point[0] += 1;
                            didMove = true;
                            reflectedNum += 1;}
                        else{
                            lastPoint[0] = point[0];
                            lastPoint[1] = point[1];
                            point[0] += 1;
                            reflectedNum += 1;}
                        direction = "down";}}
                else if (direction.equals("up")){
                    if (field[point[0]].charAt(point[1]) == '\\'){
                        if (didMove == false){
                            point[1] -= 1;
                            didMove = true;
                            reflectedNum += 1;}
                        else{
                            lastPoint[0] = point[0];
                            lastPoint[1] = point[1];
                            point[1] -= 1;
                            reflectedNum += 1;}
                        direction = "left";}
                    else{
                        if (didMove == false){
                            point[1] += 1;
                            didMove = true;
                            reflectedNum += 1;}
                        else{
                            lastPoint[0] = point[0];
                            lastPoint[1] = point[1];
                            point[1] += 1;
                            reflectedNum += 1;}
                        direction = "right";}}
                else if (direction.equals("down")){
                    if( field[point[0]].charAt(point[1]) == '\\'){
                        if (didMove == false){
                            point[1] += 1;
                            didMove = true;
                            reflectedNum += 1;}
                        else{
                            lastPoint[0] = point[0];
                            lastPoint[1] = point[1];
                            point[1] += 1;
                            reflectedNum += 1;}
                        direction = "right";}
                    else{
                        if (didMove == false){
                            point[1] -= 1;
                            didMove = true;
                            reflectedNum += 1;}
                        else{
                            lastPoint[0] = point[0];
                            lastPoint[1] = point[1];
                            point[1] -= 1;
                            reflectedNum += 1;}
                        direction = "left";}}

                if (lastPoint == point || point[0] < 0 || point[0] > numRows - 1 || point[1] < 0 || point[1] > numColumns - 1){
                reflected.add(reflectedNum);
                break;}
            }
        }



        for (int i = 0; i< numRows; i++) {
            a = i;
            reflectedNum = 0;
            lastPoint[0] = a;
            lastPoint[1] = numColumns-1;
            point[0] = a;
            point[1] = numColumns-1;
            didMove = false;
            direction = "left";
            while (true) {
                if (direction.equals("right")){
                    if (field[point[0]].charAt(point[1]) == '\\'){
                        if (didMove == false){
                            point[0] += 1;
                            didMove = true;
                            reflectedNum += 1;}
                        else{
                            lastPoint[0] = point[0];
                            lastPoint[1] = point[1];
                            point[0] += 1;
                            reflectedNum += 1;}
                        direction = "down";}
                    else{
                        if (didMove == false){
                            point[0] -= 1;
                            didMove = true;
                            reflectedNum += 1;}
                        else{
                            lastPoint[0] = point[0];
                            lastPoint[1] = point[1];
                            point[0] -= 1;
                            reflectedNum += 1;}
                        direction = "up";}}
                else if (direction.equals("left")){
                    if (field[point[0]].charAt(point[1]) == '\\'){
                        if (didMove == false){
                            point[0] -= 1;
                            didMove = true;
                            reflectedNum += 1;}
                        else{
                            lastPoint[0] = point[0];
                            lastPoint[1] = point[1];
                            point[0] -= 1;
                            reflectedNum += 1;}
                        direction = "up";}
                    else{
                        if (didMove == false){
                            point[0] += 1;
                            didMove = true;
                            reflectedNum += 1;}
                        else{
                            lastPoint[0] = point[0];
                            lastPoint[1] = point[1];
                            point[0] += 1;
                            reflectedNum += 1;}
                        direction = "down";}}
                else if (direction.equals("up")){
                    if (field[point[0]].charAt(point[1]) == '\\'){
                        if (didMove == false){
                            point[1] -= 1;
                            didMove = true;
                            reflectedNum += 1;}
                        else{
                            lastPoint[0] = point[0];
                            lastPoint[1] = point[1];
                            point[1] -= 1;
                            reflectedNum += 1;}
                        direction = "left";}
                    else{
                        if (didMove == false){
                            point[1] += 1;
                            didMove = true;
                            reflectedNum += 1;}
                        else{
                            lastPoint[0] = point[0];
                            lastPoint[1] = point[1];
                            point[1] += 1;
                            reflectedNum += 1;}
                        direction = "right";}}
                else if (direction.equals("down")){
                    if( field[point[0]].charAt(point[1]) == '\\'){
                        if (didMove == false){
                            point[1] += 1;
                            didMove = true;
                            reflectedNum += 1;}
                        else{
                            lastPoint[0] = point[0];
                            lastPoint[1] = point[1];
                            point[1] += 1;
                            reflectedNum += 1;}
                        direction = "right";}
                    else{
                        if (didMove == false){
                            point[1] -= 1;
                            didMove = true;
                            reflectedNum += 1;}
                        else{
                            lastPoint[0] = point[0];
                            lastPoint[1] = point[1];
                            point[1] -= 1;
                            reflectedNum += 1;}
                        direction = "left";}}

                if (lastPoint == point || point[0] < 0 || point[0] > numRows - 1 || point[1] < 0 || point[1] > numColumns - 1){
                    reflected.add(reflectedNum);
                    break;}
            }
        }

        for (int i = 0; i< numColumns; i++) {
            a = i;
            reflectedNum = 0;
            lastPoint[0] = 0;
            lastPoint[1] = a;
            point[0] = 0;
            point[1] = a;
            didMove = false;
            direction = "down";
            while (true) {
                if (direction.equals("right")){
                    if (field[point[0]].charAt(point[1]) == '\\'){
                        if (didMove == false){
                            point[0] += 1;
                            didMove = true;
                            reflectedNum += 1;}
                        else{
                            lastPoint[0] = point[0];
                            lastPoint[1] = point[1];
                            point[0] += 1;
                            reflectedNum += 1;}
                        direction = "down";}
                    else{
                        if (didMove == false){
                            point[0] -= 1;
                            didMove = true;
                            reflectedNum += 1;}
                        else{
                            lastPoint[0] = point[0];
                            lastPoint[1] = point[1];
                            point[0] -= 1;
                            reflectedNum += 1;}
                        direction = "up";}}
                else if (direction.equals("left")){
                    if (field[point[0]].charAt(point[1]) == '\\'){
                        if (didMove == false){
                            point[0] -= 1;
                            didMove = true;
                            reflectedNum += 1;}
                        else{
                            lastPoint[0] = point[0];
                            lastPoint[1] = point[1];
                            point[0] -= 1;
                            reflectedNum += 1;}
                        direction = "up";}
                    else{
                        if (didMove == false){
                            point[0] += 1;
                            didMove = true;
                            reflectedNum += 1;}
                        else{
                            lastPoint[0] = point[0];
                            lastPoint[1] = point[1];
                            point[0] += 1;
                            reflectedNum += 1;}
                        direction = "down";}}
                else if (direction.equals("up")){
                    if (field[point[0]].charAt(point[1]) == '\\'){
                        if (didMove == false){
                            point[1] -= 1;
                            didMove = true;
                            reflectedNum += 1;}
                        else{
                            lastPoint[0] = point[0];
                            lastPoint[1] = point[1];
                            point[1] -= 1;
                            reflectedNum += 1;}
                        direction = "left";}
                    else{
                        if (didMove == false){
                            point[1] += 1;
                            didMove = true;
                            reflectedNum += 1;}
                        else{
                            lastPoint[0] = point[0];
                            lastPoint[1] = point[1];
                            point[1] += 1;
                            reflectedNum += 1;}
                        direction = "right";}}
                else if (direction.equals("down")){
                    if( field[point[0]].charAt(point[1]) == '\\'){
                        if (didMove == false){
                            point[1] += 1;
                            didMove = true;
                            reflectedNum += 1;}
                        else{
                            lastPoint[0] = point[0];
                            lastPoint[1] = point[1];
                            point[1] += 1;
                            reflectedNum += 1;}
                        direction = "right";}
                    else{
                        if (didMove == false){
                            point[1] -= 1;
                            didMove = true;
                            reflectedNum += 1;}
                        else{
                            lastPoint[0] = point[0];
                            lastPoint[1] = point[1];
                            point[1] -= 1;
                            reflectedNum += 1;}
                        direction = "left";}}

                if (lastPoint == point || point[0] < 0 || point[0] > numRows - 1 || point[1] < 0 || point[1] > numColumns - 1){
                    reflected.add(reflectedNum);
                    break;}
            }
        }

        for (int i = 0; i< numColumns; i++) {
            a = i;
            reflectedNum = 0;
            lastPoint[0] = numRows-1;
            lastPoint[1] = a;
            point[0] = numRows -1;
            point[1] = a;
            didMove = false;
            direction = "up";
            while (true) {
                if (direction.equals("right")){
                    if (field[point[0]].charAt(point[1]) == '\\'){
                        if (didMove == false){
                            point[0] += 1;
                            didMove = true;
                            reflectedNum += 1;}
                        else{
                            lastPoint[0] = point[0];
                            lastPoint[1] = point[1];
                            point[0] += 1;
                            reflectedNum += 1;}
                        direction = "down";}
                    else{
                        if (didMove == false){
                            point[0] -= 1;
                            didMove = true;
                            reflectedNum += 1;}
                        else{
                            lastPoint[0] = point[0];
                            lastPoint[1] = point[1];
                            point[0] -= 1;
                            reflectedNum += 1;}
                        direction = "up";}}
                else if (direction.equals("left")){
                    if (field[point[0]].charAt(point[1]) == '\\'){
                        if (didMove == false){
                            point[0] -= 1;
                            didMove = true;
                            reflectedNum += 1;}
                        else{
                            lastPoint[0] = point[0];
                            lastPoint[1] = point[1];
                            point[0] -= 1;
                            reflectedNum += 1;}
                        direction = "up";}
                    else{
                        if (didMove == false){
                            point[0] += 1;
                            didMove = true;
                            reflectedNum += 1;}
                        else{
                            lastPoint[0] = point[0];
                            lastPoint[1] = point[1];
                            point[0] += 1;
                            reflectedNum += 1;}
                        direction = "down";}}
                else if (direction.equals("up")){
                    if (field[point[0]].charAt(point[1]) == '\\'){
                        if (didMove == false){
                            point[1] -= 1;
                            didMove = true;
                            reflectedNum += 1;}
                        else{
                            lastPoint[0] = point[0];
                            lastPoint[1] = point[1];
                            point[1] -= 1;
                            reflectedNum += 1;}
                        direction = "left";}
                    else{
                        if (didMove == false){
                            point[1] += 1;
                            didMove = true;
                            reflectedNum += 1;}
                        else{
                            lastPoint[0] = point[0];
                            lastPoint[1] = point[1];
                            point[1] += 1;
                            reflectedNum += 1;}
                        direction = "right";}}
                else if (direction.equals("down")){
                    if( field[point[0]].charAt(point[1]) == '\\'){
                        if (didMove == false){
                            point[1] += 1;
                            didMove = true;
                            reflectedNum += 1;}
                        else{
                            lastPoint[0] = point[0];
                            lastPoint[1] = point[1];
                            point[1] += 1;
                            reflectedNum += 1;}
                        direction = "right";}
                    else{
                        if (didMove == false){
                            point[1] -= 1;
                            didMove = true;
                            reflectedNum += 1;}
                        else{
                            lastPoint[0] = point[0];
                            lastPoint[1] = point[1];
                            point[1] -= 1;
                            reflectedNum += 1;}
                        direction = "left";}}

                if (lastPoint == point || point[0] < 0 || point[0] > numRows - 1 || point[1] < 0 || point[1] > numColumns - 1){
                    reflected.add(reflectedNum);
                    break;}
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < reflected.size();i++ ){
            if(reflected.get(i) > max){
                max = reflected.get(i);
            }
        }

        System.out.println(max);

    }
}
