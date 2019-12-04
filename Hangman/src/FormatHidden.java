
public class FormatHidden{
  public static String stringSecret(String guessedLetters, String answer){
      String concealedWord = "";
      int len = answer.length();
      for (int i=0; i<len; i++){
        String check = answer.substring(i, i+1);
        if (guessedLetters.contains(check)){
          //lägger till  
          concealedWord += check + " ";
        }
        else if (!check.equals(" ")){
          concealedWord += "_ ";
        }
        else{
          concealedWord += "  ";
        }
      }
      System.out.print(concealedWord);
      return concealedWord;
  }
}