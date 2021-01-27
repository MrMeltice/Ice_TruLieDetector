import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.util.Scanner;
import java.util.Collections;
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
    System.out.println("Please note: The more details you are able to provide the more reliable your information will become. \n\nTo achieve such a task, we would like you to answer each prompt within 3 sentence as fast as you can.");

    String pressEnter = "𝓟𝓻𝓮𝓼𝓼 𝓔𝓷𝓽𝓮𝓻 𝓣𝓸 𝓒𝓸𝓷𝓽𝓲𝓷𝓾𝓮";

    System.out.println("\n" + pressEnter);
    s.nextLine();
  }

  //pre = get string Story from Main
  //post = remove common words using comWord.txt from story --> ArrayList
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
    //
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
    }
    else if (choice.equals("e") && hear == false){
      procEnd();
    } else {
      questApp();
    }
    Main.clearScreen();
  }

  public void questSmell() {
    Main.clearScreen();
    promptIntro();
    Main.clearScreen();

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

    this.smellAL = addToArrayL(totalAns);
    double speed = calcSpeed(totalTime, smellAL.size());
    String rate = rateSpeed(speed);
    removeCom(smellAL, comAL);
    this.smellCount = compareAL(smellAL, storyAL);
    
    String smellMatched = "Smell Matched: " + this.smellCount + " | Smell Speed: "+ rate + " | SmellWPS " + speed;

    System.out.println(smellMatched);

    countAL.add(smellMatched);

    //remove when done
    Main.sleep(10);

    smell = true;
    questApp();
  }

  public void questSight() {
    Main.clearScreen();
    promptIntro();
    Main.clearScreen();

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

    this.sightAL = addToArrayL(totalAns);
    double speed = calcSpeed(totalTime, sightAL.size());
    String rate = rateSpeed(speed);
    removeCom(sightAL, comAL);
    this.sightCount = compareAL(sightAL, storyAL);
    
    String sightMatched = "Sight Matched: " + this.sightCount + " | Sight Speed: "+ rate + " | SightWPS: " + speed;

    System.out.println(sightMatched);

    countAL.add(sightMatched);

    //remove when done
    Main.sleep(10);

    sight = true;
    questApp();
  }

  public void questTouch() {
    Main.clearScreen();
    promptIntro();
    Main.clearScreen();

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

    this.touchAL = addToArrayL(totalAns);
    double speed = calcSpeed(totalTime, touchAL.size());
    String rate = rateSpeed(speed);
    removeCom(touchAL, comAL);
    this.touchCount = compareAL(touchAL, storyAL);
    
    String touchMatched = "Touch Matched: " + this.touchCount + " | Touch Speed: "+ rate + " | TouchWPS " + speed;

    System.out.println(touchMatched);

    countAL.add(touchMatched);

    //remove when done
    Main.sleep(10);

    touch = true;
    questApp();
  }

  public void questTaste() {
    System.out.println("");
    Main.clearScreen();
    promptIntro();
    Main.clearScreen();

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

    this.tasteAL = addToArrayL(totalAns);
    double speed = calcSpeed(totalTime, tasteAL.size());
    String rate = rateSpeed(speed);
    removeCom(tasteAL, comAL);
    this.tasteCount = compareAL(tasteAL, storyAL);
    
    String tasetMatched = "Taste Matched: " + this.tasteCount + " | Taste Speed: "+ rate + " | TasteWPS " + speed;

    System.out.println(tasetMatched);

    countAL.add(tasetMatched);

    //remove when done
    Main.sleep(10);

    taste = true;
    questApp();
  }

  public void questHear() {
    Main.clearScreen();
    promptIntro();
    Main.clearScreen();

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

    this.hearAL = addToArrayL(totalAns);
    double speed = calcSpeed(totalTime, hearAL.size());
    String rate = rateSpeed(speed);
    removeCom(hearAL, comAL);
    this.hearCount = compareAL(hearAL, storyAL);
    
    String hearMatched = "Hear Matched: " + this.tasteCount + " | Hear Speed: "+ rate + " | HearWPS " + speed;

    System.out.println(hearMatched);

    countAL.add(hearMatched);

    //remove when done
    Main.sleep(10);

    hear = true;
    questApp();
  }

  public void procEnd(){
    
  }

  //pre = get String as parameter
  //mid = remove special character --> lowercase
  //post = return arrayList made from input string
  public ArrayList<String> addToArrayL(String putInto){
    ArrayList<String> putAL = new ArrayList();

    String putList = putInto.replaceAll("[^a-zA-Z]", " ");
    
    String[] putArray = putList.split(" ");
    for (String l : putArray) {
      putAL.add(l.toLowerCase());
    }
    while (putAL.remove("")){
    }

    return putAL;
  }

  //pre = get time and amount of words as parameter
  //post = return wordspersec from parameter to method
  public double calcSpeed(double timeSec, double word){
    System.out.println("Seconds: " + timeSec + " | Amount of Words: " + word);

    double wordsPerSec = word/timeSec;
    double wordsPerMin = wordsPerSec * 60;
    System.out.println("Words per Second: " + wordsPerSec + " | Words per Minute: " + wordsPerMin);

    Main.sleep(5);
    
    return wordsPerSec;
  }

  //pre = get wordspersec as parameter
  //post = return rating from wordspersec to method
  public String rateSpeed(double wordsPerSec){
    String rating = "";
    //Reliability
    if (wordsPerSec >= 0.83){
      rating = "Very High";
    }//Above Average
    else if(wordsPerSec >= 0.75){
      rating = "High";
    }//Average
    else if(wordsPerSec >= 0.66){
      rating = "Moderate";
    }//Below Average
    else if(wordsPerSec >= 0.58){
      rating = "Below Moderate";
    }//
    else if(wordsPerSec >= 0.50){
      rating = "Low";
    }
    else if(wordsPerSec >= (0.41)){
      rating = "Very Low";
    }
    else if(wordsPerSec >= (0.33)){
      rating = "Extremely Low";
    }
    else{
      rating = "No Reliability";
    }
    
    return rating;
  }

  //pre = get two different ArrayList
  //post = remove common element from removeFrom using usetoRemove
  public void removeCom(ArrayList<String> removeFrom, ArrayList<String> usetoRemove) {
    
    for (int b = removeFrom.size() - 1; b > 0; b--){
      for (int c = 0; usetoRemove.size() > c; c++){
        if (removeFrom.get(b).equals(usetoRemove.get(c))){
          removeFrom.remove(b);
        }
      }
    }
  }
  
  //pre = get two different Arraylist
  //post = count common elements from diffAL to mainAL
  public int compareAL(ArrayList<String> diffAL, ArrayList<String> mainAL) {
    int matchResult = 0;
    
    diffAL.retainAll(mainAL);

    matchResult = diffAL.size();

    return matchResult;  
    
  }

  /*
  Pre-conditions are the things that must be true before a method is called. The method tells clients "this is what I expect from you".

  Post-conditions are the things that must be true after the method is complete. The method tells clients "this is what I promise to do for you".

  Invariants are the things that are always true and won't change. The method tells clients "if this was true before you called me, I promise it'll still be true when I'm done".
  */

}