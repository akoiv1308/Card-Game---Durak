import java.util. *; // importing library //

class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Hey! What's your name?");
    String name = input.nextLine();
    System.out.println("Welcome to Durak! Are you ready to play, " + name + "? (yes/no)");
    String response = input.nextLine();
    boolean run = true;
    if(response.equalsIgnoreCase("yes")) {
      System.out.println("Ok! You'll now begin. To refresh your memory, please visit this website for the game rules: http://www.gamecabinet.com/rules/Durak.html");
      String[] ranks = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
      String[] suits = {"Clubs", "Hearts", "Spades", "Diamonds"};
      int[] values = {2,3,4,5,6,7,8,9,10,11,12,13,14};
      Deck deck = new Deck(ranks, suits, values);
      System.out.println("\nThis is your deck: \n" + deck.getPlayersDeck());
      Opponent opponent = new Opponent();
      System.out.println("Begin:")
    }
    else {
      System.out.println("Alright, bye!");
    }
  }
}