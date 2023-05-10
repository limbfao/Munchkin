package basic_game_components;

import java.util.Random;

/** 
 * This class simulates a six-sided Die in the game of Munchkin. A Die is used for running away from monsters, deciding turn order before the 
 * game starts, and for all other certain situations that require a Die roll.
 */
public class Die {
    
    //----------------------------------------------------
    //            INSTANCE VARIABLES
    //--------------------------------------------------- -

    // Java's random generator class (used for Die results).
    private Random rand;

    // It's a six-sided Die, so the result is always values 1-6.
    private final int MIN = 1;
    private final int MAX = 6;

    // Whether or not the play is cucrently affected by the "Curse! Chicken On Your Head" card.
    private boolean chickenOnYourHead;

    //----------------------------------------------------
    //            CONSTRUCTOR(S)
    //----------------------------------------------------

    /**
     * This method constructs a Die object.
     */
    public Die() {
        rand = new Random();
        chickenOnYourHead = false;

    }
    
    //----------------------------------------------------
    //            METHOD(S)
    //----------------------------------------------------

    /**
     * This method gets the result of rolling the Die. If the player is affected by an active "Curse! Chicken On Your Head" card, then they get
     * minus 1 to all Die rolls.
     * @param chickenOnYourHead
     * @return The numerical result of the Die roll (usually 1-6).
     */
    public int roll() {
        //If the player is affected by an active "Curse! Chicken On Your Head" card, then they get minus 1 to all Die rolls.

        if (chickenOnYourHead)
            return rand.nextInt(MAX) + MIN - 1;

        return rand.nextInt(MAX) + MIN;
    }

    /**
     * This method is used to set or toggle that the player has a chicken on their head, or doesn't have a chicken on their head (the ""Curse! Chicken On Your Head" card").
     * @param chickenOnYourHead True if the player now has a chicken on their head, false if they now do not.
     */
    public void setChickenOnYourHead_TrueOrFalse(boolean chickenOnYourHead) {
        this.chickenOnYourHead = chickenOnYourHead;
    }


} // End of Die class.