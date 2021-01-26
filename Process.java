import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

class Process {
  static int smellCount, sightCount, touchCount, tasteCount, hearCount;
  static double reli;
  static boolean smell, sight, touch, taste, hear, end = false;
  //main ArrayList
  static ArrayList<String> storyAL = new ArrayList();
  static ArrayList<String> comAL = new ArrayList();
  //senses ArrayList
  static ArrayList<String> smellAL = new ArrayList();
  static ArrayList<String> sightAL = new ArrayList();
  static ArrayList<String> touchAL = new ArrayList();
  static ArrayList<String> tasteAL = new ArrayList();
  static ArrayList<String> hearAL = new ArrayList();
  //count ArrayList
  static ArrayList<String> countAL = new ArrayList();

  static Scanner s = new Scanner(System.in);

  public void promptIntro() {
    System.out.println("Please note: The more details you are able to provide the more reliable your information will become. \n To achieve such a task, we would like you to answer each prompt within 3 sentence as fast as you can.");

    String pressEnter = "𝓟𝓻𝓮𝓼𝓼 𝓔𝓷𝓽𝓮𝓻 𝓣𝓸 𝓒𝓸𝓷𝓽𝓲𝓷𝓾𝓮";

    System.out.println("\n" + pressEnter);
    s.nextLine();
  }


  public void removeCommon(String story) {
    //use story from Main --> ArrayList

    //remove things like periods, or commas etc
    String storyList = story.replaceAll("[^a-zA-Z]", " ");
    
    String[] storyArray = storyList.split(" ");
    for (String l : storyArray) {
      storyAL.add(l.toLowerCase());
    }
    while (storyAL.remove("")){
    }


    //import list of common words text file --> ArrayList
    String commonText = "";
    try {
      File myFile = new File("comWord.txt");
      Scanner myScan = new Scanner(myFile);
      while(myScan.hasNextLine()) {
        commonText += myScan.nextLine() + " ";
      }
      myScan.close();
    } catch (FileNotFoundException e){
      System.out.println("Error Occurred");
      e.printStackTrace();
    }
    String[] commonArray = commonText.split(",");
    for (String a : commonArray) {
      comAL.add(a.toLowerCase());
    }

    System.out.println("WordCount storyAL: " + storyAL.size());

    removeCom(storyAL, comAL);

    System.out.println("WordCount storyAL After: " + storyAL.size());

    questApp();


  }

  public void questApp() {
    Main.clearScreen();
    //remove when done
    System.out.println(countAL);
    System.out.println(smellAL);
    System.out.println(storyAL);
    System.out.println("Which of the following can you provide details on?");

    System.out.println("The more details you are able to provide the more reliable your information will become, so select as much as it is applicable to the situation");

    if (smell == false){
      System.out.println("[A] smell");
    } 
    if (sight == false ){
      System.out.println("[B] sight");
    }
    if (touch == false ){
      System.out.println("[C] touch");
    }
    if (taste == false){
      System.out.println("[D] taste");
    }
    if (hear == false){
      System.out.println("[E] hear");
    }
    if (end == false){
      System.out.println("[F] no more applies");
    }

    System.out.print("Please type the letters in front to proceed: ");
    
    String choice = s.nextLine().toLowerCase();

    if (choice.equals("a") && smell == false){
      questSmell();
    }
    else if (choice.equals("b")  && sight == false ){
      questSight();
    }
    else if (choice.equals("c") && touch == false ){
      questTouch();
    }
    else if (choice.equals("d") && taste == false){
      questTaste();
    }
    else if (choice.equals("e") && hear == false){
      questHear();
    } else {
      questApp();
    }
    Main.clearScreen();
  }

  public void questSmell() {
    Main.clearScreen();
    promptIntro();

    long startTime = System.currentTimeMillis();

    System.out.println("[1]Input your response: ");
    String totalAns = s.nextLine().toLowerCase();

    Main.clearScreen();
    
    System.out.println("[2]Input your response: ");
    String ans2 = s.nextLine().toLowerCase();
    totalAns = totalAns + " " + ans2;

    Main.clearScreen();
    
    System.out.println("[3]Input your response: ");
    String ans3 = s.nextLine().toLowerCase();
    totalAns = totalAns + " " + ans3;
    


    long stopTime = System.currentTimeMillis();
    long totalTime = (stopTime - startTime)/1000;
    
    Main.clearScreen();
    
    System.out.println(totalTime + " seconds");

    String ansList = totalAns.replaceAll("[^a-zA-Z]", " ");
    
    String[] ansArray = ansList.split(" ");
    for (String l : ansArray) {
      smellAL.add(l.toLowerCase());
    }
    while (smellAL.remove("")){
    }

    //calcSpeed(totalTime, smellAL.size());

    removeCom(smellAL, comAL);
    this.smellCount = compareAL(storyAL, smellAL);

    String smellMatched = "Smell Matched: " + this.smellCount;

    System.out.println(smellMatched);

    countAL.add(smellMatched);

    //remove when done
    Main.sleep(10);

    smell = true;
    questApp();
  }

  public void questSight() {
    System.out.println("");
    


    
  }

  public void questTouch() {
    System.out.println("");
    


    
  }

  public void questTaste() {
    System.out.println("");
    


    
  }

  public void questHear() {
    System.out.println("");
    


    
  }



  public int calcSpeed(int time, int word){
    int speedRate = 0;
    
    return speedRate;
  }





  //Remove common words that could be viewed as duplicates
  public void removeCom(ArrayList<String> removeFrom, ArrayList<String> usetoRemove) {
    
    for (int b = removeFrom.size() - 1; b > 0; b--){
      for (int c = 0; usetoRemove.size() > c; c++){
        if (removeFrom.get(b).equals(usetoRemove.get(c))){
          removeFrom.remove(b);
        }
      }
    }
  }

  
  //Compare how many details are dublicates
  public int compareAL(ArrayList<String> compareTo, ArrayList<String> compareWith) {
    int matchResult = 0;
    for (int x = compareTo.size()-1; x > 0; x--){
      for(int y = 0; y < compareWith.size(); y++){
        if(compareTo.get(x).equals(compareWith.get(y))){
          compareTo.remove(x);
          matchResult++;
        }
      }
    }

    return matchResult;  
    
  }
  

}