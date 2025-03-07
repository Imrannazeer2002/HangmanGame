package Github;

import java.util.Scanner;

public class Hangmangame {
    private static final String [] WORDS = { "Car","Omni","Lorry","Jeep"};
    
    private String word;
    private StringBuilder guesstheWord;
    private int attemptsleft;

    public void play(){
        Scanner sc = new Scanner(System.in);
        initializeGame();

        while (attemptsleft>0 && guesstheWord.indexOf("_")!=-1){
            System.out.println("Attempsleft: "+attemptsleft);
            System.out.println("word: "+guesstheWord);

            char guess = getGuessfromplayer(sc);
            checkGuess(guess);
        } 
        if (guesstheWord.indexOf("_")== -1) {
            System.out.println("Good you guessed the word: "+word);  
        }else{
            System.out.println("Game over");
            
        }
    }

    private void initializeGame(){
        word = getRandomword().toLowerCase();
        guesstheWord = new StringBuilder("_".repeat(word.length()));
        attemptsleft=6;
    }
    private String getRandomword(){
        int index =(int)(Math.random()*WORDS.length);
        return WORDS[index];
    }
    private char getGuessfromplayer(Scanner sc){
        System.out.println("Enter your guess: ");
        String str = sc.nextLine().toLowerCase();
        
        while (str.length()!=1 || !Character.isLetter(str.charAt(0))) {
            System.out.println("invlaid guess enter 1 letter");
            str = sc.nextLine().toLowerCase();
        }
        return str.charAt(0);
    }
    private void checkGuess(char guess) {
        boolean guessedCorrectly = false;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                guesstheWord.setCharAt(i, guess);
                guessedCorrectly = true;
            }
        }

        if (guessedCorrectly) {
            System.out.println("Correct guess!");
        } else {
            System.out.println("Incorrect guess!");
            attemptsleft--;
        }
    }


    public static void main(String[] args) {
      Hangmangame game = new Hangmangame();
      game.play();
    }
    
}
