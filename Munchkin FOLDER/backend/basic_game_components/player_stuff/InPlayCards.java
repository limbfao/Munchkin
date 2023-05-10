package basic_game_components.player_stuff;

import basic_game_components.Card;

import door_cards.*;
import treasure_cards.*;

import java.util.List;
import java.util.ArrayList;

/**
 * This class simulates the player's in play cards, i.e. the card they have layed out infront of them (ex: equipment, active curses, 
 * helpers, etc.).
 */
public class InPlayCards {
    //----------------------------------------------------
    //          INSTANCE VARIABLES
    //----------------------------------------------------

    // The ID number or turn order designation of the player whose in play cards these are.
    private int playerTurnNumber;
    // A list of Card objects to simulate the in play cards.
    private List<Card> inPlayCardsList;
    // The current number of race cards the player has equipped.
    private int numOfEquippedRaces;
    // The limit to the number of races the player can have equipped at once (usually 1, 2 if they have the "Half-Breed" card).
    private int raceCardLimit;
    // Whether or not the player is a human or part-human.
    private boolean isHuman;
    // The current number of class cards the player has equipped.
    private int numOfEquippedClasses;
    // The limit to the number of class cards a player can have equipped at once (normally 1, 2 if they have the "Super Munchkin" card.)
    private int classCardLimit;
    // The number of weapon hands the player has occupied. Value is 1 if the player only has a one-handed weapon, 2 if the player has either
    // a two-handed weapon or 2 one-handed weapons, or 0 if the player has no weapons.
    private int numOfWeaponHandsOccupied;
    // Whether or not the player has headgear equipped.
    private boolean headgearEquipped;
    // Whether or not the player has armor equipped.
    private boolean armorEquipped;
    // Whether or not the player has footgear equipped.
    private boolean footgearEquipped;
    // Whether or not the player has at least one big item equipped.
    private boolean atLeastOneBigItemEquipped;

    //----------------------------------------------------
    //            CONSTRUCTOR(S)
    //----------------------------------------------------

    /**
     * This method constructs an InPlayCards object for the Player class.
     * @param playerTurnNumber The ID number or turn order designation of the player whose in play cards these are.
     */
    public InPlayCards(int playerTurnNumber) {
        this.playerTurnNumber = playerTurnNumber;
        inPlayCardsList = new ArrayList<>();

        numOfEquippedRaces = 0;
        raceCardLimit = 1;
        isHuman = true;
        numOfEquippedClasses = 0;
        classCardLimit = 1;
        numOfWeaponHandsOccupied = 0;
        headgearEquipped = false;
        armorEquipped = false;
        footgearEquipped = false;
        atLeastOneBigItemEquipped = false;

    } // End of constructor method.

    //----------------------------------------------------
    //          METHOD(S)
    //----------------------------------------------------

    //------------------------------------------
    //     DEALING WITH RACE CARDS...
    //------------------------------------------


    /**
     * This method gets the number of races currently equipped.
     * @return The number of races currently equipped.
     */
    public int getNumberOfEquippedRaces() {
        return numOfEquippedRaces;
    }

    /**
     * This method is used to increment the number of equipped races by 1 when a race card is equipped.
     */
    public void incrementNumberOfEquippedRaces() {
        numOfEquippedRaces++;
    }

    /**
     * This method is used to decrement the number of equipped races by 1 when a race card is removed.
     */
    public void decrementNumberOfEquippedRaces() {
        numOfEquippedRaces--;
    }

    /**
     * This method gets the current race card limit (usually 1, 2 if the "Half-Breed" card is equipped).
     * @return The current race card limit.
     */
    public int getRaceCardLimit() {
        return raceCardLimit;
    }

    /**
     * This method is used to increase the race card limit to 2 if the player equips the "Half-Breed" card.
     */
    public void extendRaceCardLimit_HalfBreedEquipped() {
        raceCardLimit = 2;
    }

    /**
     * This method is used to reset the race card limit to 1 if the player loses "Half-Breed" card.
     */
    public void resetRaceCardLimit_HalfBreedRemoved() {
        raceCardLimit = 1;
    }

    /**
     * This method checks to see if a race card can be equipped according to the current number of race cards equipped versus the limit.
     * @return True if race card can be equipped, false if it cannot.
     */
    public boolean checkIf_RaceCardCanBeEquipped() {
        return numOfEquippedRaces < raceCardLimit;
    }

    /**
     * This method is used to check to see if the player is human or not (or half-human, half-something else in the case of "Half-Breed").
     * @return True if the player is human or part-human, false if they are not human at all.
     */
    public boolean checkIfPlayerIsHuman() {
        return isHuman;
    }

    /**
     * This method is used to set whether the player is human or part-human to true or false.
     * @param isHuman True if you're setting the player to human or part-human, false if you are setting the player to non-human.
     */
    public void setIfPlayerIsHuman(boolean isHuman) {
        this.isHuman = isHuman;
    }

    //------------------------------------------
    // End of dealing with race cards methods.
    //------------------------------------------

    
    /**
     * This method gets the number of classes currently equipped.
     * @return The number of classes currently equipped.
     */
    public int getNumberOfEquippedClasses() {
        return numOfEquippedClasses;
    }

    /**
     * This method is used to increment the number of equipped classes by 1 when a class card is equipped.
     */
    public void incrementNumberOfEquippedClasses() {
        numOfEquippedClasses++;
    }

    /**
     * This method is used to decrement the number of equipped classes by 1 when a class card is removed.
     */
    public void decrementNumberOfEquippedClasses() {
        numOfEquippedClasses--;
    }

    /**
     * This method gets the current class card limit (usually 1, 2 if the "Super Munchkin" card is equipped).
     * @return The current class card limit.
     */
    public int getClassCardLimit() {
        return classCardLimit;
    }

    /**
     * This method is used to increase the class card limit to 2 if the player equips the "Super Munchkin" card.
     */
    public void extendClassCardLimit_SuperMunchkinEquipped() {
        classCardLimit = 2;
    }

    /**
     * This method is used to reset the class card limit to 1 if the player loses "Super Munchkin" card.
     */
    public void resetClassCardLimit_SuperMunchkinRemoved() {
        classCardLimit = 1;
    }

    /**
     * This method checks to see if a class card can be equipped according to the current number of class cards equipped versus 
     * the limit.
     * @return True if class card can be equipped, false if it cannot.
     */
    public boolean checkIf_ClassCardCanBeEquipped() {
        return numOfEquippedClasses < classCardLimit;
    }

    //------------------------------------------
    // End of dealing with class cards methods.
    //------------------------------------------

    //------------------------------------------
    //     DEALING WITH ITEM CARDS...
    //------------------------------------------

    /**
     * This method gets the number of weapon hands currently occupied by the player.
     * @return The number of weapon hands currently occupied by the player.
     */
    public int get_NumOfWeaponHandsOccupied() {
        return numOfWeaponHandsOccupied;
    }

    /**
     * This method sets the number of weapon hands currently occupied by the player to a new value.
     * @param numOfWeaponHandsOccupied This method sets the number of weapon hands currently occupied by the player to a new value.
     * Valid values: 1 (x1 1-handed weapon equipped), 2 (x1 2-handed weapon equipped, or x2 1-handed weapons equipped), or 0 (no weapons equipped).
     */
    public void set_NumOfWeaponHandsOccupied(int numOfWeaponHandsOccupied) {
        this.numOfWeaponHandsOccupied = numOfWeaponHandsOccupied;
    }

    /**
     * This method is used to check if headgear is currently equipped.
     * @return True if headgear is currently equipped, false if it is not.
     */
    public boolean checkIf_HeadgearEquipped() {
        return headgearEquipped;
    }

    /**
     * This method is used to set if headgear is currently equipped.
     * @param headgearEquipped Set to true if headgear is equipped, set to false if headgear is removed.
     */
    public void setIf_HeadgearEquipped(boolean headgearEquipped) {
        this.headgearEquipped = headgearEquipped;
    }


    /**
     * This method is used to check if armor is currently equipped.
     * @return True if armor is currently equipped, false if it is not.
     */
    public boolean checkIf_ArmorEquipped() {
        return armorEquipped;
    }

    /**
     * This method is used to set if armor is currently equipped.
     * @param armorEquipped Set to true if armor is equipped, set to false if armor is removed.
     */
    public void setIf_ArmorEquipped(boolean armorEquipped) {
        this.armorEquipped = armorEquipped;
    }

    /**
     * This method is used to check if footgear is currently equipped.
     * @return True if footgear is currently equipped, false if it is not.
     */
    public boolean checkIf_FootgearEquipped() {
        return footgearEquipped;
    }

    /**
     * This method is used to set if footgear is currently equipped.
     * @param footgearEquipped Set to true if footgear is equipped, set to false if headgear is removed.
     */
    public void setIf_FootgearEquipped(boolean footgearEquipped) {
        this.footgearEquipped = footgearEquipped;
    }

    /**
     * This method is used to check if at least one big item is currently equipped.
     * @return True if at least one big item is currently equipped, false if it is not.
     */
    public boolean checkIf_atLeastOneBigItemEquipped() {
        return atLeastOneBigItemEquipped;
    }

    /**
     * This method is used to set if at least one big item is currently equipped.
     * @param headgearEquipped Set to true if headgear is equipped, set to false if headgear is removed.
     */
    public void setIf_AtLeastOneBigItemEquipped(boolean atLeastOneBigItemEquipped) {
        this.atLeastOneBigItemEquipped = atLeastOneBigItemEquipped;
    }

    //------------------------------------------
    // End of dealing with item cards methods.
    //------------------------------------------

    //------------------------------------------
    //     GENERAL IN PLAY CARD METHODS...
    //------------------------------------------

    /**
     * This method is used to get the list implementation of the in play cards (used for specific situations).
     * @return The list implementation of the in play cards.
     */
    public List<Card> getInPlayCardsList() {
        return inPlayCardsList;
    }

    /**
     * This method gets a card from the player's in play cards based on it's card location number (ex: the first card starting from the 
     * left is card 1, etc.). Assume that the cards are all lined up in a straight line, or assume that we start from the first row of
     * cards, finish it, and then go to the next row of cards below, starting from the leftmost again, so on and so forth.
     * @param cardNumber The card number (starting at 1 from the left).
     * @return The card in question.
     */
    public Card getCard_UsingCardLocationNumber(int cardLocationNumber) {
        int index = cardLocationNumber - 1;
        return inPlayCardsList.get(index);
    }

    /**
     * This method adds a new card to the player's in play cards.
     * @param newCard The new card in question.
     */
    public void addCardToInPlayCards(Card newCard) {
        inPlayCardsList.add(newCard);
    }

    /**
     * This method removes a card from the player's in play cards using its card location number (the leftmost card is 1, followed by 2, 3, etc.).
     * It also returns it (used to move it somewhere else).
     * @param cardLocationNumber The card location number (the leftmost card is 1, followed by 2, 3, etc.).
     * @return The card removed.
     */
    public Card removeCard_UsingCardLocationNumber(int cardLocationNumber) {
        int index = cardLocationNumber - 1;
        return inPlayCardsList.remove(index);
    }

    /**
     * This is an overrided toString method to provide a visual representation of the player's in play cards when printing to the console.
     * It display's the player's turn designation number and the names of all the cards in their in play. This is used for development
     * and testing.
     */
    public String toString() {

        String output = "------ Player " + playerTurnNumber + "'s In Play Cards ----------\n";

        for(Card curCard : inPlayCardsList) {
            String curCardName = curCard.getName();
            output += curCardName + "\n";
        }

        output += "------------------------------------------";

        return output;

    } // End of toString method.

} // End of Hand class.