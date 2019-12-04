//Metod för att kolla om gissning finns i ordet

public class Checker{
  public static boolean correct(String guess, String answer, int len){
    for(int i = 0; i < len; i++){
      if(answer.substring(i,i+1).equals(guess)){
        return true;
      }
    }
    return false;
  }
  	// Kollar om din gissning gick hem eller ej
  public static void correctWord(String guess, String answer){
	    if (guess.equals(answer)) {
	    	System.out.print ("\n\nGrattis, du rymde ifrån Bödeln, den här gången.");
	    	System.exit(0);
	    }else {
	    	System.out.print("\n----------\n|\t|\n|\tx\n|      /|\\\n|      / \\\n|\n|\n|\n--------\n\n");
	    	System.out.print ("\n\nDöd, död, död, just det du DOG!");
	    	System.out.print("\nRätt svar var ju: "+ answer);
	    	System.exit(0);
	    }
	  }
}

	  
