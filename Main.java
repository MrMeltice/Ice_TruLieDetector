import java.util.*;

class Main {
  public static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
  } 

  public static void sleep(int seconds){
    long start = System.currentTimeMillis();
    while (start >= System.currentTimeMillis() - seconds * 1000);
  } 
  
  public static void main(String[] args) {
    String title = "   _______   __       _______   __      ________  \n  |   __ \"\\ |\" \\     |   __ \"\\ |\" \\    /\"       ) \n  (. |__) :)||  |    (. |__) :)||  |  (:   \\___/  \n  |:  ____/ |:  |    |:  ____/ |:  |   \\___  \\    \n  (|  /     |.  |    (|  /     |.  |    __/  \\\\   \n /|__/ \\    /\\  |\\  /|__/ \\    /\\  |\\  /\" \\   :)  \n(_______)  (__\\_|_)(_______)  (__\\_|_)(_______/   \n                                                  ";
    System.out.println(title);

    System.out.println();
    
    String info = "Welcome to the 17th generation: Police Inquieris Private Information System or better known as P.I.P.I.S. This ";

    System.out.println(info);

    String pressEnter = "Press Enter to Continue...";

    System.out.println("\n" + pressEnter);
    Scanner s = new Scanner(System.in);
    s.nextLine();
    

    String storyPrompt = "Now you should be able to insert your story. Please keep the story as detailed as possible as it should be concise. Please recall as much as you can of the events that eventually led up to ";


    System.out.println(storyPrompt);
    Scanner g = new Scanner(System.in);
    String storyAns = g.nextLine();

    Process storyText = new Process();

    storyText.removeCommon(storyAns);

    System.out.println("End of Examination: Thank you for your cooperation");

  }
}