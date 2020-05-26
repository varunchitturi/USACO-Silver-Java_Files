import java.util.*;

public class bigDance {
    static int sum = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        ArrayList<Integer> allCows = new ArrayList<>();
        for(int i = 0; i< N;i++){
            allCows.add(i+1);
        }
        multiply(allCows);
        System.out.println(sum);
    }
    static void multiply(List<Integer> a){
        if(a.size() == 1){
            return;
        }
        if(a.size() == 2){
            sum += a.get(0)*a.get(1);
        }
        else{
            multiply(a.subList(0,(int)Math.ceil(((double)a.size()/2.0))));
            multiply(a.subList((int)Math.ceil(((double)a.size()/2.0)),a.size()));
        }
    }
}
