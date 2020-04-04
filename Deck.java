import java.util. *;

class Deck {

  // Fields //
  private ArrayList<Card> cards;
  private ArrayList<Card> playersDeck;
  private int size;

  // Constructor //
  public Deck(String[] ranks, String[] suits, int[] values) {
    this.playersDeck = new ArrayList<Card>();
    this.cards = new ArrayList<Card>(); // Initializing field variable //
    // Looping through arrays passed as parameters in the Deck constructor method and adding them consequently to ArrayList called "cards" //
    for(String suit : suits){ 
      for(String rank : ranks){
        // determineValue(rank) - since both for loops are for "suits" and "ranks" array, I added another instance method as a third parameter for a new Card object that represents a card's point value //
        this.cards.add(new Card(rank, suit, determineValue(rank)));
      }
    }
    // assigning variable "size" to the size of the "cards" //
    size = cards.size();
    // calling shuffle method in order to randomly shuffle the deck //
    shuffle();
  }

  // determineValue - an instance method that simply determines the card's point value and returns it //
  public int determineValue(String rank) {
    int value = 0;
    switch(rank) {
      case "2" : return value = 2;
      case "3" : return value = 3;
      case "4" : return value = 4;
      case "5" : return value = 5;
      case "6" : return value = 6;
      case "7" : return value = 7;
      case "8" : return value = 8;
      case "9" : return value = 9;
      case "10" : return value = 10;
      case "J" : return value = 11;
      case "Q" : return value = 12;
      case "K" : return value = 13;
      case "A" : return value = 14;
      // if none of the following is the case, then value of 0 is assigned to the variable value //
      default : return value = 0;
    }
  }

  public ArrayList<Card> getPlayersDeck() {
    for(int i = 0; i < 6; i++) {
      playersDeck.add(cards.get(i));
    }
    return playersDeck;
  }

  public ArrayList<Card> deck() {
    return playersDeck;
  }

  // shuffle - method that shuffles the deck randomly //
  public void shuffle() {
		for (int k = cards.size() - 1; k > 0; k--) { // starting from the index of the last element //
			int howMany = k + 1; // variable responsible for the size of the deck; it is determined by adding one to the variable k which has been set to the size of the deck - 1 //
			int start = 0; // starting from the first element in ArrayList //
			int randPos = (int) (Math.random() * howMany) + start;  // variable that randomly chooses the element of the deck by randomly selecting from the size of the deck //
			Card temp = cards.get(k); // variable temp is temporary variable that get the element at index k //
			cards.set(k, cards.get(randPos)); // element at index k is replaced with random element/value //
			cards.set(randPos, temp); // the element at index randPos is replaced by the temporary variable, temp, which is the element at index k //
		}
	}

  // isEmpty — This method should return true when the size of the deck is 0; false otherwise //
  public boolean isEmpty() {
    if(cards.size() == 0) { // if the deck is empty, return true //
      return true;
    }
    else { // otherwise, return false //
      return false;
    }
  }

  // size — This method returns the number of cards in the deck that are left to be dealt //
  public int size() {
    return cards.size(); // returns deck's size //
  }

  // deal — This method “deals” a card by removing a card from the deck and returning it, if there are any cards in the deck left to be dealt. It returns null if the deck is empty //
  public Card deal() {
    if(cards.size() > 0) { // if deck's size is not empty, then decrease variable size by one and return the element at size's index //
      size--;
      return cards.get(size);
    }
    else { // otherwise, return null //
      return null;
    }
  }

  // Algorithm 2: It would be more efficient to leave the cards in the list. Instead of removing the card, simply decrement the size instance variable and then return the card at size. In this algorithm, the size instance variable does double duty; it determines which card to “deal” and it also represents how many cards in the deck are left to be dealt. This is the algorithm that you should implement.

  public int varSize() { 
    return size; // check the value of instance variable size //
  }

  @Override
  public String toString(){  
    return Arrays.toString(cards.toArray()); // converting ArrayList of cards to string //
	}

}