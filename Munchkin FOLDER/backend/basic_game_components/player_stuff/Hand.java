package basic_game_components.player_stuff;

import basic_game_components.Card;
import java.util.List;
import java.util.ArrayList;

/**
 * This class simulates the player's hand.
 */
public class Hand {
    //----------------------------------------------------
    //          INSTANCE VARIABLES
    //----------------------------------------------------

    // The ID number or turn order designation of the player whose hand this is.
    private int playerTurnNumber;
    // A list of Card objects to simulate the hand.
    private List<Card> handList;
    // The limit of cards the player can have by the end of their turn (usually 5, unless they are a dwarf, in which case it is 6).
    private int handLimit;

    //----------------------------------------------------
    //            CONSTRUCTOR(S)
    //----------------------------------------------------

    /**
     * This method constructs a Hand object for the Player class w/ a default limit of 5 cards.
     * @param playerNumber The ID number or turn order designation of the player whose hand this is.
     */
    public Hand(int playerTurnNumber) {
        this.playerTurnNumber = playerTurnNumber;
        handList = new ArrayList<>();
        handLimit = 5;
    }

    //----------------------------------------------------
    //          METHOD(S)
    //----------------------------------------------------

    /**
     * This method gets the hand's current limit.
     * @return The hand's current limit.
     */
    public int getHandLimit() {
        return handLimit;
    }

    /**
     * This method increases the hand limit to 6 (intended for when the player becomes a dwarf).
     */
    public void increaseLimit_BecomeDwarf() {
        handLimit = 6;
    }

    /**
     * This method resets the hand limit to 5 (intended for when the player loses their dwarf race).
     */
    public void resetLimit_NoLongerDwarf() {
        handLimit = 5;
    }

    /**
     * This method gets a card from the player's hand based on it's card location number (ex: the first card starting from the left is card 1, 
     * the one to the right of it is 2, etc.).
     * @param cardNumber The card number (starting at 1 from the left).
     * @return The card in question.
     */
    public Card getCard_UsingCardLocationNumber(int cardLocationNumber) {
        int index = cardLocationNumber - 1;
        return handList.get(index);
    }

    /**
     * This method adds a new card to the player's hand.
     * @param newCard The new card in question.
     */
    public void addCardToHand(Card newCard) {
        handList.add(newCard);
    }

    /**
     * This method checks to see if the player must discard cards from their hand before the end of their turn, i.e. whether or not they
     * currently exceed their hand limit.
     * @return True if they must discard before the end of their turn, false if they don't have to.
     */
    public boolean checkIf_PlayerMustDiscard() {
        return handList.size() > handLimit;
    }

    /**
     * This method searches for a card using its name. If it is found, the card location number is returned. If it is not found, 
     * return 0 (default).
     * @param searchedCardName The card's name.
     * @return The card's location number, if found. If not found, return 0, indicating it was not found in the hand.
     */
    public int searchForCardUsingName_ReturnCardLocationNumber(String searchedCardName) {

        for(int i = 0; i < handList.size(); i++) {

            Card curCard = handList.get(i);
            String curCardName = curCard.getName();

            if(curCardName.equals(searchedCardName)) {
                // The card location number is the index location plus 1, because we start counting from 1 for card location numbers.
                return i + 1;
            }

        } // End of for loop.

        // If it was never found in the for loop above, we return 0 by default, indicating that it was not found in the hand.
        return 0;

    } // End of searchForCardUsingName_ReturnCardLocationNumber method.

    /**
     * This method searches for a card using its type. If it is found, the card location number is returned. If it is not found, 
     * return 0 (default).
     * @param cardType The card's type.
     * @return The card's location number, if found. If not found, return 0, indicating it was not found in the hand.
     */
    public int searchForCardUsingType_ReturnCardLocationNumber(String searchedCardType) {

        for(int i = 0; i < handList.size(); i++) {

            Card curCard = handList.get(i);
            String curCardType = curCard.getType();

            if(curCardType.equals(searchedCardType)) {
                // The card location number is the index location plus 1, because we start counting from 1 for card location numbers.
                return i + 1; 
            }

        } // End of for loop.

        // If it was never found in the for loop above, we return 0 by default, indicating that it was not found in the hand.
        return 0;

    } // End of searchForCardUsingType_ReturnCardLocationNumber method.

    /**
     * This method removes a card from the player's hand using its card location number (the leftmost card is 1, followed by 2, 3, etc.).
     * It also returns it (used to move it somewhere else).
     * @param cardLocationNumber The card location number (the leftmost card is 1, followed by 2, 3, etc.).
     * @return The card removed.
     */
    public Card removeCard_UsingCardLocationNumber(int cardLocationNumber) {
        int index = cardLocationNumber - 1;
        return handList.remove(index);
    }

    /**
     * This is an overrided toString method to provide a visual representation of the player's hand when printing to the console.
     * It display's the player's turn designation number and the names of all the cards in their hand. This is used for development
     * and testing.
     */
    public String toString() {

        String output = "----------- Player " + playerTurnNumber + "'s Hand --------------\n";

        for(Card curCard : handList) {
            String curCardName = curCard.getName();
            output += curCardName + "\n";
        }

        output += "------------------------------------------";

        return output;

    } // End of toString method.

} // End of Hand class.