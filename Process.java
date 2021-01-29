import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.util.Scanner;
import java.util.Collections;
import java.io.FileNotFoundException;

class Process {
  static double smellCount, sightCount, touchCount, tasteCount, hearCount, smellTot, sightTot, touchTot, tasteTot, hearTot = 0;
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
    System.out.println("We would like you to answer each prompt within 3 sentence as fast as you can. \n\nPlease note: The more details you are able to provide the more reliable your information will become.");

    String pressEnter = "Press Enter to Continue...";

    System.out.println("\n" + pressEnter);
    s.nextLine();
  }

  //pre = get string Story from Main
  //post = remove common words using comWord.txt from story --> ArrayList
  public void startProc(String story) {
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

    removeCom(storyAL, comAL);

    questApp();


  }

  public void questApp() {
    Main.clearScreen();
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
    else if (choice.equals("f") && end == false){
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

    System.out.println("[1]As of the time of event, if I was there with you, what would I have smelled? This can range from a strong fragrance to a very mild smell.\n");
    String totalAns = s.nextLine().toLowerCase();

    Main.clearScreen();
    
    System.out.println("[2]Prior to the event that you described, what would you say was the most pungent smell you are able to recall?\n");
    String ans2 = s.nextLine().toLowerCase();
    totalAns = totalAns + " " + ans2;

    Main.clearScreen();
    
    System.out.println("[3]If we recall the smell in question [1], what is your relative location to the smell. Beside, Below, Behind? Elaborate.\n");
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

    this.smellTot = smellAL.size();
    this.smellCount = compareAL(smellAL, storyAL);
    
    String smellMatched = "Smell Matched: " + this.smellCount + "/" + this.smellTot + " | Smell Speed: "+ rate + " | SmellWPS " + speed;

    System.out.println(smellMatched);

    countAL.add(smellMatched);

    smell = true;
    questApp();
  }

  public void questSight() {
    Main.clearScreen();
    promptIntro();
    Main.clearScreen();

    long startTime = System.currentTimeMillis();

    System.out.println("[1]Upon the current situation you have described, what are some noticable objects in the scene that you can remember?");
    String totalAns = s.nextLine().toLowerCase();

    Main.clearScreen();
    
    System.out.println("[2]Recall to first question what atmosphere would you describe were your surrounding? Was it dark? was it lit properly? Elaborate visually.");
    String ans2 = s.nextLine().toLowerCase();
    totalAns = totalAns + " " + ans2;

    Main.clearScreen();
    
    System.out.println("[3]In question [1] the noticable objects you recall viewing, what was their position relative to each other?");
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
    this.sightTot = sightAL.size();
    this.sightCount = compareAL(sightAL, storyAL);
    
    String sightMatched = "Sight Matched: " + this.sightCount + "/" + this.sightTot + " | Sight Speed: "+ rate + " | SightWPS: " + speed;

    countAL.add(sightMatched);

    sight = true;
    questApp();
  }

  public void questTouch() {
    Main.clearScreen();
    promptIntro();
    Main.clearScreen();

    long startTime = System.currentTimeMillis();

    System.out.println("[1]Identify important texture that you have associated your body with at the time of the situation. Why did you feel that texture?\n");
    String totalAns = s.nextLine().toLowerCase();

    Main.clearScreen();
    
    System.out.println("[2]In question [1], analyze the events that led up to the eventual comtact of felt of texture in chronological order.\n");
    String ans2 = s.nextLine().toLowerCase();
    totalAns = totalAns + " " + ans2;

    Main.clearScreen();
    
    System.out.println("[3]In prompt [1], ");
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
    this.touchTot = touchAL.size();
    this.touchCount = compareAL(touchAL, storyAL);
    
    String touchMatched = "Touch Matched: " + this.touchCount + "/" + this.touchTot + " | Touch Speed: "+ rate + " | TouchWPS " + speed;

    countAL.add(touchMatched);

    touch = true;
    questApp();
  }

  public void questTaste() {
    System.out.println("");
    Main.clearScreen();
    promptIntro();
    Main.clearScreen();

    long startTime = System.currentTimeMillis();

    System.out.println("[1]");
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
    this.tasteTot = tasteAL.size();
    this.tasteCount = compareAL(tasteAL, storyAL);
    
    String tasetMatched = "Taste Matched: " + this.tasteCount + "/" + this.tasteTot + " | Taste Speed: "+ rate + " | TasteWPS " + speed;

    countAL.add(tasetMatched);

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
    this.hearTot = hearAL.size();
    this.hearCount = compareAL(hearAL, storyAL);
    
    String hearMatched = "Hear Matched: " + this.tasteCount + "/" + this.hearTot + " | Hear Speed: "+ rate + " | HearWPS " + speed;

    countAL.add(hearMatched);

    hear = true;
    questApp();
  }
  
  public void procEnd(){
    Main.clearScreen();
    //Reverse percent for actual percent for grading
    double smellPerc = 0;
    double sightPerc = 0;
    double tastePerc = 0;
    double touchPerc = 0;
    double hearPerc = 0;

    //unless there is an input, do not execute --> NaN
    if (smell == true){
      smellPerc = 100-((this.smellCount/this.smellTot)*100);
    } 
    if (sight == true){
      sightPerc = 100-((this.sightCount/this.sightTot)*100);
    }
    if (touch == true ){
      touchPerc = 100-((this.touchCount/this.touchTot)*100);
    }
    if (taste == true){
      tastePerc = 100-((this.tasteCount/this.tasteTot)*100);
    }
    if (hear == true){
      hearPerc = 100-((this.hearCount/this.hearTot)*100);
    }

    System.out.println("Smell: " + smellPerc);
    System.out.println("Sight: " + sightPerc);
    System.out.println("Touch: " + touchPerc);
    System.out.println("Taste: " + tastePerc);
    System.out.println("Hear: " + hearPerc);

    double smellInt = smell? 1:0;
    double sightInt = sight? 1:0;
    double tasteInt = taste? 1:0;
    double touchInt = touch? 1:0;
    double hearInt = hear? 1:0;

    System.out.println(countAL);

    double topVal = (smellInt*smellPerc) + (sightInt*sightPerc) + (tasteInt*tastePerc) + (touchInt*touchPerc) + (hearInt*hearPerc);
    double botVal = smellInt+sightInt+tasteInt+touchInt+hearInt;

    double matchGrade = topVal/botVal;

    System.out.println("Percentage of matched Unique words: "+ matchGrade);

    String pressEnter = "Press Enter to Continue...";

    System.out.println("\n" + pressEnter);
    s.nextLine();
    Main.clearScreen();

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
    
    //double wordsPerMin = wordsPerSec * 60;
    
    //System.out.println("Words per Second: " + wordsPerSec + " | Words per Minute: " + wordsPerMin);
    
    return wordsPerSec;
  }

  //pre = get wordspersec as parameter
  //post = return rating from wordspersec to method
  public String rateSpeed(double wordsPerSec){
    String rating = "";
    //50 wpm = 7/7
    if (wordsPerSec >= 0.83){
      rating = "Very High";
    }//45 wpm = 6/7
    else if(wordsPerSec >= 0.75){
      rating = "High";
    }//40 wpm = 5/7
    else if(wordsPerSec >= 0.66){
      rating = "Moderate";
    }//35 wpm = 4/7
    else if(wordsPerSec >= 0.58){
      rating = "Below Moderate";
    }//30 wpm = 3/7
    else if(wordsPerSec >= 0.50){
      rating = "Low";
    }//25 wpm = 2/7
    else if(wordsPerSec >= (0.41)){
      rating = "Very Low";
    }//20 wpm = 1/7
    else if(wordsPerSec >= (0.33)){
      rating = "Extremely Low";
    }//Erroe
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