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
  static boolean smell, sight, touch, taste, hear = false;
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
    System.out.println("Which of these sense can you provide more details on?\n*select only if applicable*");

    System.out.println("If "

    if (smell == false){
      System.out.println("[A] smell");
    } 
    else if (sight == false ){
      System.out.println("[B] sight");
    }
    else if (touch == false ){
      System.out.println("[C] touch");
    }
    else if (taste == false){
      System.out.println("[D] taste");
    }
    else if (hear == false){
      System.out.println("[E] hear");
    }

    System.out.println("Please type the letters in front to proceed: ");
    
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
  }

  public void questSmell() {
    System.out.println("");
    



    
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



  public int wordSpeed(int time, int word){
    speedRate = "";
    
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
    
    for (int x = compareTo.size()-1; x > 0; x--){
      for(int y = 0; y < compareWith.size(); y++){
        if(compareTo.get(x).equals(compareWith.get(y))){
          matchResult++;
        }
      }
    }

    return matchResult;  
    
  }

}