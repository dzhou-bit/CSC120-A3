// You should **not** update any call signatures in this file
// only modify the body of each function

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


class Conversation implements ConversationRequirements {

  // Attributes 
  private Scanner scanner;
  private ArrayList<String> transcript;
  private int rounds;
  private Random random;


  /**
   * Constructor 
   */
  Conversation() {
    scanner = new Scanner(System.in);
    transcript = new ArrayList<>();
    random = new Random();
    
  }

  /**
   * Starts and runs the conversation with the user
   */
  public void chat() {
    System.out.print("How many rounds?");
    rounds = scanner.nextInt();
    scanner.nextLine();

    String greeting = "Hi there! What's on your mind?";
    System.out.println("\n"+ greeting);
    transcript.add(greeting);

    for (int i = 0; i< rounds; i++){
      String userInput = scanner.nextLine();
      transcript.add(userInput);

      String response = respond(userInput);
      System.out.println(response);
      transcript.add(response);
  
    }

    String goodbye = "See ya!";
    System.out.println(goodbye);
    transcript.add(goodbye);

  }

  /**
   * Prints transcript of conversation
   */
  public void printTranscript() {
    System.out.println("\nTranscript:");
    for (String line: transcript){
      System.out.println(line);
    }

  }

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response to user input  
   */
  public String respond(String inputString) {
    String[] words = inputString.split(" ");
    boolean mirrored = false;

    for (int i = 0; i < words.length; i++) {
      String w = words[i].toLowerCase();

      if (w.equals("i")) {
        words[i] = "you";
        mirrored = true;
      } else if (w.equals("me")) {
        words[i] = "you";
        mirrored = true;
      } else if (w.equals("am")) {
        words[i] = "are";
        mirrored = true;
      } else if (w.equals("you")) {
        words[i] = "I";
        mirrored = true;
      } else if (w.equals("my")) {
        words[i] = "your";
        mirrored = true;
      } else if (w.equals("your")) {
        words[i] = "my";
        mirrored = true;
      }
    }

    if (mirrored) {
      return String.join(" ", words) + "?";
    }

    String[] canned = {
      "Mmm-hm.",
      "Tell me more.",
      "Interesting.",
      "I see.",
      "Go on."
    };

    return canned[random.nextInt(canned.length)];
  }

  public static void main(String[] arguments) {
    Conversation myConversation = new Conversation();
    myConversation.chat();
    myConversation.printTranscript();
  }
}

