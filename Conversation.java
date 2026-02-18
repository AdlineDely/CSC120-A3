// You should **not** update any call signatures in this file
// only modify the body of each function
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

class Conversation implements ConversationRequirements {

  // Attributes 
  int numRounds;
  ArrayList<String> transcript;

  /**
   * Constructor 
   */
  public Conversation() {
    this.numRounds = 100;
    this.transcript = new ArrayList<String>();
  }

  /**
   * Starts and runs the conversation with the user
   */
  public void chat() {
    // this a scanner object
    Scanner input = new Scanner(System.in);
    // this is to set the round to 0 
    System.out.println("How many rounds?");
    this.numRounds = input.nextInt();
    input.nextLine(); // don't want the number to be read into what's next
    int round = 0;
  // System.in is take an input and System.out is to print out
  // this print out the first prompt. this prompt is out of the loop
  // because I don't want this prompt to appear over and over
  String greeting = "Hi there! What's your mind?";  
  System.out.println(greeting);
  // this will save the previous string 
  this.transcript.add(greeting);
      while (round < this.numRounds){
  // get the user input 
      String answer = input.nextLine();
      this.transcript.add(answer); // save user input 
      String Response = respond(answer);
      System.out.println(Response);
      this.transcript.add(Response); // Save computer input 
      round = round + 1;
    }
    String goodbye = "See ya!";
    System.out.println(goodbye);
    this.transcript.add(goodbye);
  }

  /**
   * Prints transcript of conversation
   */
  public void printTranscript() {
  System.out.println("\nTRANSCRIPT:");
  for (String line : this.transcript){
    System.out.println(line);
  }
  }

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response to user input  
   */
  public String respond(String inputString) {
    Random random = new Random();
  // canned responses 
    String [] cannedResponses = {
      "Mmmm-hmm. ",
      "Tell me more. ",
      "Interesting, go on.",
      "I see.",
      "Why do you say that?"
    };
  // this will start with the user's string 
    String returnString = inputString; 
  // this will mirror the user answer to turn into a question that the chatbot will ask
      returnString = returnString.replace("I am", "Are you");
      returnString = returnString.replace("I'm", "You're");
      returnString = returnString.replace("am I", "you are");
      returnString = returnString.replace("my", "salut");
      returnString = returnString.replace("your", "my");
      returnString = returnString.replace("salut", "your");
      returnString = returnString.replace("I", "you");
      returnString = returnString.replace("me", "you");
  // this will check if anything actually change ?
  if (returnString.equals(inputString)) {
    // this is when nothing was mirrored
    int index = random.nextInt(cannedResponses.length);
    return cannedResponses[index];
  } else {
    // something change so return the mirrored version 
    return returnString + "?";
  }

  }

  public static void main(String[] arguments) {

    Conversation myConversation = new Conversation();
    myConversation.chat();
    myConversation.printTranscript();

  }
}
