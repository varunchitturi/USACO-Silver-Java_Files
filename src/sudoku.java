package src;

import java.util.*;

public class sudoku {
    static int [] [] matrix = new int [9][9];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for(int i= 0; i < 9;i++){
            for(int j = 0; j < 9; j++){
                matrix[i][j] = input.nextInt();
            }
        }
        dfs(matrix,0,0);
        System.out.println("NO SOLUTION");
    }

    static boolean analyze(int i, int j, int [] [] r){
        if(i >= 0 && i < 3){
            if(j >= 0 && j < 3){
                HashSet<Integer> check = new HashSet<>();
                int count = 0;
                for(int k = 0; k < 3;k++){
                    for(int l = 0; l < 3;l++){
                        if(r[k][l] != 0){
                            check.add(r[k][l]);
                            count++;
                            }
                        }
                    }
                if(check.size() != count){
                    return false;
                }
            }
            else if(j >= 3 && j < 6){
                HashSet<Integer> check = new HashSet<>();
                int count = 0;
                for(int k = 0; k < 3;k++){
                    for(int l = 3; l < 6;l++){
                        if(r[k][l] != 0){
                            check.add(r[k][l]);
                            count++;
                        }
                    }
                }
                if(check.size() != count){
                    return false;
                }
            }
            else if(j >= 6 && j< 9){
                HashSet<Integer> check = new HashSet<>();
                int count = 0;
                for(int k = 0; k < 3;k++){
                    for(int l = 6; l < 9;l++){
                        if(r[k][l] != 0){
                            check.add(r[k][l]);
                            count++;
                        }
                    }
                }
                if(check.size() != count){
                    return false;
                }
            }
        }
        else if(i >= 3 && i < 6){
            if(j >= 0 && j < 3){
                HashSet<Integer> check = new HashSet<>();
                int count = 0;
                for(int k = 3; k < 6;k++){
                    for(int l = 0; l < 3;l++){
                        if(r[k][l] != 0){
                            check.add(r[k][l]);
                            count++;
                        }
                    }
                }
                if(check.size() != count){
                    return false;
                }
            }
            else if(j >= 3 && j < 6){
                HashSet<Integer> check = new HashSet<>();
                int count = 0;
                for(int k = 3; k < 6;k++){
                    for(int l = 3; l < 6;l++){
                        if(r[k][l] != 0){
                            check.add(r[k][l]);
                            count++;
                        }
                    }
                }
                if(check.size() != count){
                    return false;
                }
            }
            else if(j >= 6 && j< 9){
                HashSet<Integer> check = new HashSet<>();
                int count = 0;
                for(int k = 3; k < 6;k++){
                    for(int l = 6; l < 9;l++){
                        if(r[k][l] != 0){
                            check.add(r[k][l]);
                            count++;
                        }
                    }
                }
                if(check.size() != count){
                    return false;
                }
            }
        }
        else if(i >= 6 && i < 9){
            if(j >= 0 && j < 3){
                HashSet<Integer> check = new HashSet<>();
                int count = 0;
                for(int k = 6; k < 9;k++){
                    for(int l = 0; l < 3;l++){
                        if(r[k][l] != 0){
                            check.add(r[k][l]);
                            count++;
                        }
                    }
                }
                if(check.size() != count){
                    return false;
                }
            }
            else if(j >= 3 && j < 6){
                HashSet<Integer> check = new HashSet<>();
                int count = 0;
                for(int k = 6; k < 9;k++){
                    for(int l = 3; l < 6;l++){
                        if(r[k][l] != 0){
                            check.add(r[k][l]);
                            count++;
                        }
                    }
                }
                if(check.size() != count){
                    return false;
                }
            }
            else if(j >= 6 && j< 9){
                HashSet<Integer> check = new HashSet<>();
                int count = 0;
                for(int k = 6; k < 9;k++){
                    for(int l = 6; l < 9;l++){
                        if(r[k][l] != 0){
                            check.add(r[k][l]);
                            count++;
                        }
                    }
                }
                if(check.size() != count){
                    return false;
                }
            }
        }
        // check column
        HashSet<Integer> b= new HashSet<>();
        int count = 0;
        for(int  a = 0; a < 9;a++){
             if(r[i][a] != 0){
                 count++;
                 b.add(r[i][a]);
             }
        }
        if(b.size() != count){
            return false;
        }
        //check row
        b.clear();
        count = 0;
        for(int  a = 0; a < 9;a++){
            if(r[a][j] != 0){
                count++;
                b.add(r[a][j]);
            }
        }
        if(b.size() != count){
            return false;
        }
        return true;
    }

    static void dfs(int [] [] a, int i, int j){
        boolean check = true;
        outerloop:
        for (int k = 0; k < 9; k++) {
            for (int l = 0; l < 9; l++) {
                if(a[k][l] == 0){
                    check = false;

                    boolean check2 = true;
                    for(int c= 1;c < 10;c++){
                        int [] [] b = new int [9][9];
                        for(int p = 0 ; p < 9; p++){
                            for(int q = 0 ; q <9;q++){
                                b[p][q] = a[p][q];
                            }
                        }
                        b[k][l] = c;

                        if(analyze(k,l,b)){
                        dfs(b,k,l);
                        check2 = false;
                        }
                    }
                    /*
                    if(check2){
                        return;
                    }*/

                    break outerloop;
                }


            }
        }
        if(check){
            for(int r = 0 ;r < 9;r++){
                for(int s = 0; s < 9;s++){
                    System.out.print(a[r][s] + " ");
                }
                System.out.println();
            }
            System.out.println();
            System.exit(0);
        }
    }
}
