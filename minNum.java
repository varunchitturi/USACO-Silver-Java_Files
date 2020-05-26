import java.util.*;

public class minNum {
    static String [] allNums;
    static String password;
    static int numNumbers;
    static HashSet<String> possible = new HashSet<>();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int passwordLength = input.nextInt();
        numNumbers = input.nextInt();
        password = input.next();
        allNums = new String[numNumbers];
        for(int i = 0; i < numNumbers;i++){
            allNums[i] = input.next();
        }
        for(int i = 0 ; i< numNumbers;i++){
            pick(allNums[i]);
        }
        java.util.Arrays.sort(allNums, new java.util.Comparator<String>() {
            public int compare(String o1, String o2) {

                if(o1.length() > o2.length()){
                    return 1;
                }
                return -1;
            }
        });
        ArrayList<String> finalA  = new ArrayList<>();
        finalA.addAll(possible);
        Collections.sort(finalA);
        if(finalA.size() != 0){
            System.out.println(finalA.get(0));
        }
        else{
            System.out.println("NO SOLUTION");
        }
    }
    static void pick( String check){
        if(check.length() > password.length()){
            return;
        }
        boolean p = check(check);
        if(check.length() == password.length() && check(check)){
            possible.add(check);
            return;
        }
        if(!p){
            return;
        }

            for(int i= 0; i< numNumbers;i++){
                    /*
                    if((check + allNums[i]).length() > password.length()){
                        break;
                    }*/


                    pick(check+allNums[i]);

            }

    }
    static boolean check(String a){
        for(int i = 0; i < a.length();i++){
            if(a.charAt(i) == password.charAt(i) || password.charAt(i) == '?'){

            }
            else{
                return false;
            }
        }
        return true;
    }

}
