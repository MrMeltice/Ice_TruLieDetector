import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

class Process {
  static int match;


  static ArrayList<String> storyAL = new ArrayList();
  static ArrayList<String> comAL = new ArrayList();




  public void removeCommon(String story) {
    //use story from Main

    //remove things like periods, or commas etc
    String storyList = story.replaceAll("[^a-zA-Z]", " ");
    
    String[] storyArray = storyList.split(" ");
    
    for (String l : storyArray) {
      storyAL.add(l.toLowerCase());
    }
    
    while (storyAL.remove("")){
    }

    //import list of common words text file
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

    //remove common
    for (int b = storyAL.size() - 1; b > 0; b--){
      for (int c = 0; comAL.size() > c; c++){
        if (storyAL.get(b).equals(comAL.get(c))){
          storyAL.remove(b);
        }
      }
    }

    System.out.println("WordCount storyAL After: " + storyAL.size());
    

  




  }

}