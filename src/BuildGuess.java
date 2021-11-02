import java.util.Random;

public class BuildGuess {
    Helper helper = new Helper();
    Random rand = new Random();
    int guessNumber = rand.nextInt(helper.returnSize()) - 1;

    String chosenWord = (helper.returnItem(guessNumber));


    String buildGuess(){
        String guess = "";
        char incercare[] = new char[chosenWord.length()];

        for (int i = 0; i<chosenWord.length(); i++){
            incercare[i] = '-';
        }

        guess = incercare.toString();

        return guess;
    }

}
