import java.util.*;
public class meetAndGreet {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int numBessie = input.nextInt();
        int numElsie = input.nextInt();
        String trash = input.nextLine();
        String [][] bessieMovements = new String[numBessie][2];
        String [][] elsieMovements = new String[numElsie][2];
        int bessiePosition = 0;
        int elsiePosition = 0;
        ArrayList<Integer> allBessieMovements = new ArrayList<>();
        ArrayList<Integer> allElsieMovements = new ArrayList<>();
        for(int i = 0; i< numBessie;i++){
            bessieMovements[i] = input.nextLine().split(" ");
        }
        for(int i = 0; i< numElsie;i++){
            elsieMovements[i] = input.nextLine().split(" ");
        }
        for(int i = 0; i< bessieMovements.length;i++){
            if(bessieMovements[i][1].equals("R")){
                for(int j = 0; j< Integer.parseInt(bessieMovements[i][0]);j++){
                    allBessieMovements.add(1);
                }
            }
            else{
                for(int j = 0; j< Integer.parseInt(bessieMovements[i][0]);j++){
                    allBessieMovements.add(-1);
                }
            }
        }
        for(int i = 0; i< elsieMovements.length;i++){
            if(elsieMovements[i][1].equals("R")){
                for(int j = 0; j< Integer.parseInt(elsieMovements[i][0]);j++){
                    allElsieMovements.add(1);
                }
            }
            else{
                for(int j = 0; j< Integer.parseInt(elsieMovements[i][0]);j++){
                    allElsieMovements.add(-1);
                }
            }
        }
        int count = 0;
       int toTravel =  Math.max(allBessieMovements.size(),allElsieMovements.size());
       boolean didPart;
       int bDirection = 0;
       int eDirection = 0;
       boolean justMet = true;
       for(int i = 0; i < toTravel;i++){

           if(i < allBessieMovements.size()){
                bessiePosition += allBessieMovements.get(i);
                bDirection = allBessieMovements.get(i);
            }
            if(i < allElsieMovements.size()){
                elsiePosition += allElsieMovements.get(i);
                eDirection = allElsieMovements.get(i);
            }
            if(justMet == true && bDirection != eDirection){
                justMet = false;
            }
            if(bessiePosition == elsiePosition && justMet == false){
                count += 1;
                justMet = true;

            }

        }
        System.out.println(count);
    }
}
