import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

class Process {
  static int smellCount, sightCount, touchCount, tasteCount, hearCount;
  static boolean smell, sight, touch, taste, hear = false;

  static ArrayList<String> storyAL = new ArrayList();
  static ArrayList<String> comAL = new ArrayList();
  

  public void tellMe() {
    System.out.println("Which of these can you provide more details on?\nPlease note: The more details you are able to provide the more reliable your information will become");

    System.out.println("");
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
    tellMe();
    
    


    
  }

  public void questSmell() {
    
    System.out.println(""");
    Scanner s = new Scanner(System.in);
    s.nextLine();
    
    


    
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