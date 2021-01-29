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
    
    String info = "Welcome to the 17th generation: Police Inquieries Private Information System or better known as P.I.P.I.S. This interface reports to the Investiagtive Section of the Police Department of ________ which aims to aid and further extend the scope of information to be use in the court of law. This program will ask you to input a situation that you would like to tell us about.";

    System.out.println(info);

    String pressEnter = "Press Enter to Continue...";

    System.out.println("\n" + pressEnter);
    Scanner s = new Scanner(System.in);
    s.nextLine();
    

    String storyPrompt = "Now you should be able to insert your story. Please keep the story as detailed as possible as it should be concise. Please recall as much as you can of the events and anything that happened prior leading up to the main events. Once you finished typing press enter to continue to the next phase. You can start typing";


    System.out.println(storyPrompt);
    Scanner g = new Scanner(System.in);
    String storyAns = g.nextLine();

    Process storyText = new Process();

    storyText.startProc(storyAns);

    System.out.println("End of Examination: Thank you for your cooperation");

  }
}