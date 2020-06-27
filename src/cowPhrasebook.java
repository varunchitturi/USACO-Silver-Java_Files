package src;

import java.util.*;
public class cowPhrasebook{
  public static void main(String [] args){
    Scanner input = new Scanner(System.in);

    String in = input.nextLine();
    String [] numbers = in.split(" ");
    int numPhrasebook = Integer.parseInt(numbers[0]);
    int numCowPhrase = Integer.parseInt(numbers[1]);
    //System.out.println(numPhrasebook);
    //System.out.println(numCowPhrase);
    String [] phraseBook = new String[numPhrasebook];
    String [] cowPhrase = new String[numCowPhrase];

    for (int i = 0; i<numPhrasebook;i++){
      phraseBook[i] = input.nextLine();
    }
    for (int i = 0; i<numCowPhrase;i++){
      cowPhrase[i] = input.nextLine();
    }

    //System.out.println(Arrays.toString(phraseBook));
    //System.out.println(Arrays.toString(cowPhrase));
    //System.out.println(phraseBook.length);
    //System.out.println(cowPhrase.length);
    int matches = 0;
    for (int i = 0; i< numCowPhrase;i++) {
      for (int j = 0; j<numPhrasebook;j++){
        if (phraseBook[j].contains(cowPhrase[i])){

          matches++;
          break;
        }
      }

    }

    System.out.println(matches);


  }
}
