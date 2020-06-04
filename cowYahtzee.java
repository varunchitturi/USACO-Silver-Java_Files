import java.lang.reflect.Array;
import java.util.*;
public class cowYahtzee {
    static fullComb [] all = new fullComb[20];
    static combinations [] allComb = new combinations[1512768];
    static int numDice;
    static int numSides;
    static int numExpressions;
    static int which = 0;
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        numDice = input.nextInt();
        numSides = input.nextInt();
        numExpressions = input.nextInt();
        for(int i = 0; i < numExpressions;i++){
           String expression = input.next();
           String [] finalExpression = expression.split("x|\\+");
           fullComb current = new fullComb();
           for(int j = 0; j < finalExpression.length;j+=2){
               comb curr = new comb(Integer.parseInt(finalExpression[j]),Integer.parseInt(finalExpression[j+1]));
               current.combs.add(curr);
           }
           all[i] = current;
        }
        combinations start = new combinations(new int [numSides+1],new int [numDice]);
        makeCombinations(0,start);
        int count = 0;
        for(int i = 0; i < which;i++){
            if(check(allComb[i])){
                count++;
            }
        }
        System.out.println(count);
    }
    static void makeCombinations(int i,combinations currentComb){
        if(i == numDice){

            allComb[which] = currentComb;
            which++;
            return;
        }
        for(int j = 1; j<= numSides;j++){
            //if(possibleInt.contains(j)) {
                combinations next = new combinations(currentComb.counts,currentComb.comb);
                next.comb[i] = j; next.counts[j]++;
                makeCombinations(i+1,next);
            //}
        }
    }
    static class combinations{
        int [] counts;
        int [] comb;
        public combinations(int [] count, int [] comb){
            this.counts = Arrays.copyOf(count,count.length);
            this.comb = Arrays.copyOf(comb,comb.length);
        }

    }
    static class comb{
        int num; int side;
        public comb(int num, int side){
            this.num = num;
            this.side = side;
        }
    }
    static class fullComb{
        ArrayList<comb> combs = new ArrayList<>();
    }

    static boolean check(combinations currentComb){
        boolean check;
        for(int i = 0; i < numExpressions;i++){
            check = true;
            for(int j = 0; j < all[i].combs.size();j++){
                if(currentComb.counts[all[i].combs.get(j).side] < all[i].combs.get(j).num){
                    check = false;
                    break;
                }
            }
            if(check){
                return true;
            }
        }
        return false;
    }


}
