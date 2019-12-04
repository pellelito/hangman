
//Generarar text/ord att gissa på

public class CreatePhrase{
  public static String secretPhraseGenerate(){
    
    String [] phraseList = {"stor grön traktor","The Hangman game","Besserwisser","nybakde kakor","Reciprositetsprincipen","Krokett","Sällskapsresan","jukebox","Kaffekask","knapriga morötter","resegarderob","tuba","dålig trummis","rosa ballonger","gnistrande glas","oslipad diamant","Animal Farm","rysliga adjektiv","oändlig loop","rimmat fläst","Poison Ivy","smutsigt elfenben","expanderbar ryggsäck","khaki chinos","saftiga bananer","egyptisk bomull","lockigt hår","mörk tunnelbana","djupa hålor","pop quiz","banjo spelare","fattiga riddare","magisk afton","the matrix","jazz","rock and roll","lunginflammation","söta kattungar","svårt patiens","fäska croissanter","alarmerad värdetransportör","Snövit och Butter"};
  
    String secretPhrase = phraseList[(int)(Math.random()*(phraseList.length))];
    
    return secretPhrase;
  }
}