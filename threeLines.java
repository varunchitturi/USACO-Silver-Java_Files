import java.util.*;

public class threeLines {
    static class SizeComparator implements Comparator<Set<?>> {

        @Override
        public int compare(Set<?> o1, Set<?> o2) {
            return Integer.valueOf(o1.size()).compareTo(o2.size())*-1;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        HashSet<Integer> allX = new HashSet<>();
        HashSet<Integer> allY = new HashSet<>();
        HashMap<Integer,HashSet<Integer>> mapX = new HashMap<>();
        HashMap<Integer,HashSet<Integer>> mapY = new HashMap<>();
        for(int i= 0; i<N;i++){
            int x = input.nextInt();
            int y = input.nextInt();
            allX.add(x);
            allY.add(y);
            if(mapX.containsKey(x)){
                mapX.get(x).add(i+1);
            }
            else{
                mapX.put(x,new HashSet<>(Arrays.asList(i+1)));
            }
            if(mapY.containsKey(y)){
                mapY.get(y).add(i+1);
            }
            else{
                mapY.put(y,new HashSet<>(Arrays.asList(i+1)));
            }
        }
        ArrayList<HashSet<Integer>> y = new ArrayList<>(mapY.values());
        ArrayList<HashSet<Integer>> x = new ArrayList<>(mapX.values());
        Collections.sort(x, new SizeComparator());
        Collections.sort(y, new SizeComparator());
        if(allX.size() == 3 || allY.size() == 3){
            System.out.println(1);
        }
        else{
            // 2 x and 1 y
            outerloop:
            for(int i = 0; i < mapX.size();i++){
                for(int j = i + 1; j < mapX.size();j++){
                    for(int k = 0; k < mapY.size();k++){
                        HashSet<Integer> all = new HashSet<>();
                        all.addAll(x.get(i));
                        all.addAll(x.get(j));
                        all.addAll(y.get(k));
                        if(x.get(j).size() + x.get(i).size() + y.get(k).size() < N){
                            break outerloop;
                        }
                        if(all.size() == N){
                            System.out.println(1);
                            System.exit(0);
                        }

                    }
                }
            }
            // 2 y and 1 x
            outerloop:
            for(int i = 0; i < mapY.size();i++){
                for(int j = i + 1; j < mapY.size();j++){
                    for(int k = 0; k < mapX.size();k++){
                        HashSet<Integer> all = new HashSet<>();
                        all.addAll(y.get(i));
                        all.addAll(y.get(j));
                        all.addAll(x.get(k));
                        if(y.get(j).size() + y.get(i).size() + x.get(k).size() < N){
                            break outerloop;
                        }
                        if(all.size() == N){
                            System.out.println(1);
                            System.exit(0);
                        }

                    }
                }
            }
            System.out.println(0);
        }

    }
}
