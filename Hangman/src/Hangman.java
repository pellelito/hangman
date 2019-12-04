/*  Hangman
 * Ett javaprojekt
 */

import java.util.Scanner;
public class Hangman {
  public static void main(String[] args) {
    
    //Välkomst text och val av single eller multi player
    Scanner numOfPlayers = new Scanner(System.in);
    Lives.hangmanPrint(1);
    System.out.println("Välkommen till Hänga gubbe! :)\nVal av speltyp: \n'M' för multiplayer \n\teller \n'S' för singleplayer \n\n(I multiplayer får man själv välja ord.)\n");
    String playerNumber = numOfPlayers.nextLine();
    playerNumber = playerNumber.toLowerCase();
    
    //Kollar att valet är korrekt
    while (!(playerNumber.equals("m")||playerNumber.equals("s"))){
      System.out.print("\n\nOgiltigt val. \n'M' för multiplayer \\n\\teller \\n'S' för singleplayer\n");
      playerNumber = numOfPlayers.nextLine();
      playerNumber = playerNumber.toLowerCase();
    }
    
    
    //Kollar en eller två spelare
    String answer = "";
    if (playerNumber.equals("m")){
      for (int i=1;i<=54;i++){
      System.out.print("\n");
      }
      System.out.print ("\n\n\nOBS:\n\tOrdet syns om man scrollar upp, håll koll så att ingen fuskar!");
      
      Scanner userPhrase = new Scanner(System.in);
      boolean legalPhrase = false;
      String testPhrase = "";
      String secretPhrase = "";
      
      while(!legalPhrase){
        System.out.print("\n\nSkriv in ordet att spela med:\n");
        secretPhrase="";
        testPhrase="";
        secretPhrase = userPhrase.nextLine();
        for (int i=0; i<secretPhrase.length();i++){
          if((Character.isLetter(secretPhrase.charAt(i))||secretPhrase.substring(i,i+1).equals(" "))){
            testPhrase += secretPhrase.substring(i,i+1);
          }
        }
        if (testPhrase.equals(secretPhrase)){
          legalPhrase=true;
        }
        else {
          for (int i=1;i<=54;i++){
            System.out.print("\n");
          }
          System.out.print ("Ogiltigt.\n\tDu får inte välja siffror eller specialtecken");
        }
      }
      answer = secretPhrase;
    }
    else if (playerNumber.equals("s")) {
      answer = CreatePhrase.secretPhraseGenerate();
    }
    
    //Låt spelet börja
    
    for (int i=1;i<=54;i++){
      System.out.print("\n");
    }
    answer = answer.toLowerCase();
    
    int lives = 7;
    String guessedLetters = "";
    int len = answer.length();
    boolean correct = false;
    String revealedPhrase="";
    Lives.hangmanPrint(lives);
    
    FormatHidden.stringSecret(guessedLetters,answer);    
    
    
    //Kollar om man redan gissat på den bokstaven
    Scanner input= new Scanner(System.in);
    
    while (lives>0&&(!correct)){
      System.out.print("\n\nGissa en bokstav?\n eller * för att gissa på frasen");
      String guess = input.nextLine();
      guess = guess.toLowerCase();
      
      if (guess.equals("*")){
        for (int i=1;i<=54;i++){
          System.out.print("\n");
        }
        System.out.print ("* Gissa nu frasen!\n");
        guess = input.nextLine();
        guess = guess.toLowerCase();
        Checker.correctWord(guess, answer);
        break;
      }
      else if (!(Character.isLetter(guess.charAt(0)))) {
          for (int i=1;i<=54;i++){
            System.out.print("\n");
          }
          System.out.print("**Hallå, gissa en bokstav. Vad är det du inte förstår?**\n");
        }
      else if (!(Character.isLetter(guess.charAt(0)))) {
        for (int i=1;i<=54;i++){
          System.out.print("\n");
        }
        System.out.print("**Hallå, gissa en bokstav. Vad är det du inte förstår?**\n");
      }
      else if (guessedLetters.contains(guess)){
        for (int i=1;i<=54;i++){
          System.out.print("\n");
        }
        System.out.print ("**Du har redan gissat på denna. Du ska ju gissa på en ny bokstav.**\n");
      }
      else if (guess.length()>1) { 
        for (int i=1;i<=54;i++){
          System.out.print("\n");
        }
        System.out.print ("** Hallå, ett tecken åt gången, jag är man och kan inte multitaska **\n\n");
      }
      
      // Visar vilka man har gissat på
      else {
        if (guessedLetters.equals("")){
          guessedLetters+=(guess);
        }
        else {
          guessedLetters+=(", "+ guess);
        }
        // Kollar om bokstav finns med
        if (!(Checker.correct(guess, answer, len))){
          lives--;
        }
        for (int i=1;i<=39;i++){
          System.out.print("\n");
        }
      }
      Lives.hangmanPrint(lives);
      revealedPhrase=FormatHidden.stringSecret(guessedLetters,answer);
      System.out.print ("\nDu har redan gissat på: \n"+guessedLetters);
        
      if (!(revealedPhrase.contains("_"))){
        correct = true;
      }
    }
    //Vinnartext
    if (correct){
      System.out.print ("\n\nGrattis, du rymde ifrån Bödeln, den här gången.");
    }
    
    //Loosertext
    else {
      System.out.print ("\n\nDöd, död, död, just det du DOG!");
      System.out.print("\nRätt svar var ju: "+ answer);
    }  
  }
}

