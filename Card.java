
public class Card implements Comparable {
	
	//what do all cards have?
	//suit name (Clubs, Diamonds, Spades, Hearts
	//number
	//face number 2-10 + JACK QUEEN KING ACE
	int suit=1;
	int value=2;
	
// SUIT NAMES
public static final int CLUBS = 1;
public static final int DIAMONDS = 2;
public static final int SPADES = 3;
public static final int HEARTS = 4;

// J,K,Q,A AS VALUES AFTER 10
public static final int JACK = 11;
public static final int QUEEN = 12;
public static final int KING = 13;
public static final int ACE = 14;

//if statments for jack king queen ace 4



public Card(){
	
}


public Card(int suit, int value){
	this.suit = suit;
	this.value = value;
}

public int getSuit(){
	return suit;
}

public String getSuitName(){
	if (getSuit() == 1)
		return "Clubs";
	if (getSuit() == 2)
		return "Diamonds";
	if (getSuit() == 3)
		return "Spades";
	else 
		return "Hearts";
}

public String getValueNames(){
	if (getValue() == 11)
		return "Jack";
	if (getValue() == 12)
		return "Queen";
	if (getValue() == 13)
		return "King";
	if (getValue() == 14) 
		return "Ace";
	else 
		return Integer.toString(getValue());
				
	
}

public int getValue(){
	return value;
}

public String toString(){
	
	return (getValueNames() + " of " + getSuitName()) +"\n";
	
}
	
public static void main (String [] args){
	
	Card e = new Card (3,1);
	System.out.print(e.toString());
}


@Override
public int compareTo(Object o) {
	Card c = (Card) o;
	if (c.getSuit() != this.getSuit()) {
		return 1;
	}
	else{
		if(c.getValue() < this.getValue()){
			return 1;
		}
		if(c.getValue() > this.getValue())
			return -1;
		else
			return 0;
	}
	// TODO Auto-generated method stub
	
}

}
