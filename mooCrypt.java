import javax.lang.model.type.ArrayType;
import java.util.*;

public class mooCrypt {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        int numRows = input.nextInt();
        int numColumns = input.nextInt();
        String trash = input.nextLine();
        numRows += 4;
        numColumns += 4;
        String[] matrix = new String[numRows];
        matrix[0] = "";
        matrix[1] = "";
        matrix[matrix.length - 1] = "";
        matrix[matrix.length - 2] = "";
        for (int i = 0; i < numColumns; i++) {
            matrix[0] += "*";
        }
        for (int i = 0; i < numColumns; i++) {
            matrix[1] += "*";
        }
        for (int i = 0; i < numColumns; i++) {
            matrix[matrix.length - 2] += "*";
        }
        for (int i = 0; i < numColumns; i++) {
            matrix[matrix.length - 1] += "*";
        }
        for (int i = 0; i < numRows - 4; i++) {
            matrix[i+2] = "";
            matrix[i+2] += "*";
            matrix[i+2] += "*";
            matrix[i + 2] += input.nextLine();
            matrix[i+2] += "*";
            matrix[i+2] += "*";
        }
        //System.out.println(Arrays.toString(matrix));
        ArrayList<String> possibilities = new ArrayList<>();
        for(int i = 2; i < numRows-2;i++){
            for(int j = 2; j < numColumns-2;j++){
                // right horizontal
                if(matrix[i].charAt(j) != 'M' && matrix[i].charAt(j) != matrix[i].charAt(j+1) && matrix[i].charAt(j+1) == matrix[i].charAt(j+2) && matrix[i].charAt(j+1) != '*'&& matrix[i].charAt(j+1) != 'O'){
                    possibilities.add(Character.toString(matrix[i].charAt(j))+ Character.toString(matrix[i].charAt(j+1)) + Character.toString(matrix[i].charAt(j+2)));
                }
                // left horizontal
                if(matrix[i].charAt(j) != 'M' && matrix[i].charAt(j) != matrix[i].charAt(j-1) && matrix[i].charAt(j-1) == matrix[i].charAt(j-2) && matrix[i].charAt(j-1) != '*'&& matrix[i].charAt(j-1) != 'O'){
                    possibilities.add(Character.toString(matrix[i].charAt(j))+ Character.toString(matrix[i].charAt(j-1)) + Character.toString(matrix[i].charAt(j-2)));
                }
                // up vertical
                if(matrix[i].charAt(j) != 'M' &&matrix[i].charAt(j) != matrix[i-1].charAt(j) && matrix[i-1].charAt(j) == matrix[i-2].charAt(j) && matrix[i-1].charAt(j) != '*'&& matrix[i-1].charAt(j) != 'O'){
                    possibilities.add(Character.toString(matrix[i].charAt(j))+ Character.toString(matrix[i-1].charAt(j)) + Character.toString(matrix[i-2].charAt(j)));
                }
                // down vertical
                if(matrix[i].charAt(j) != 'M' &&matrix[i].charAt(j) != matrix[i+1].charAt(j) && matrix[i+1].charAt(j) == matrix[i+2].charAt(j) && matrix[i+1].charAt(j) != '*'&& matrix[i+1].charAt(j) != 'O'){
                    possibilities.add(Character.toString(matrix[i].charAt(j))+ Character.toString(matrix[i+1].charAt(j)) + Character.toString(matrix[i+2].charAt(j)));
                }
                // right up diagonal
                if(matrix[i].charAt(j) != 'M' &&matrix[i].charAt(j) != matrix[i-1].charAt(j+1) && matrix[i-1].charAt(j+1) == matrix[i-2].charAt(j+2) && matrix[i-1].charAt(j+1) != '*'&& matrix[i-1].charAt(j+1) != 'O'){
                    possibilities.add(Character.toString(matrix[i].charAt(j))+ Character.toString(matrix[i-1].charAt(j+1)) + Character.toString(matrix[i-2].charAt(j+2)));
                }
                // right down diagonal
                if(matrix[i].charAt(j) != 'M' &&matrix[i].charAt(j) != matrix[i+1].charAt(j+1) && matrix[i+1].charAt(j+1) == matrix[i+2].charAt(j+2) && matrix[i+1].charAt(j+1) != '*'&& matrix[i+1].charAt(j+1) != 'O'){
                    possibilities.add(Character.toString(matrix[i].charAt(j))+ Character.toString(matrix[i+1].charAt(j+1)) + Character.toString(matrix[i+2].charAt(j+2)));
                }
                // left up diagonal
                if(matrix[i].charAt(j) != 'M' &&matrix[i].charAt(j) != matrix[i-1].charAt(j-1) && matrix[i-1].charAt(j-1) == matrix[i-2].charAt(j-2) && matrix[i-1].charAt(j-1) != '*'&& matrix[i-1].charAt(j-1) != 'O'){
                    possibilities.add(Character.toString(matrix[i].charAt(j))+ Character.toString(matrix[i-1].charAt(j-1)) + Character.toString(matrix[i-2].charAt(j-2)));
                }
                // left down diagonal
                if(matrix[i].charAt(j) != 'M' &&matrix[i].charAt(j) != matrix[i+1].charAt(j-1) && matrix[i+1].charAt(j-1) == matrix[i+2].charAt(j-2) && matrix[i+1].charAt(j-1) != '*'&& matrix[i+1].charAt(j-1) != 'O'){
                    possibilities.add(Character.toString(matrix[i].charAt(j))+ Character.toString(matrix[i+1].charAt(j-1)) + Character.toString(matrix[i+2].charAt(j-2)));
                }
            }
        }
        int max = 0;
        int count = 0;
        Collections.sort(possibilities);
        for(int i = 0;i< possibilities.size();i++){
            count += 1;
            if(i == 0 || !possibilities.get(i-1).equals(possibilities.get(i))){
                if(count > max){
                    max = count;
                }
                count = 0;
            }
        }
        System.out.println(max);
       // System.out.println(Arrays.toString(possibilities.toArray()));
    }
}
