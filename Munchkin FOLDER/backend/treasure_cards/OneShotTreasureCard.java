package treasure_cards;

import basic_game_components.Card;

/**
 * This class represents a "one shot treasure" card in the game of Munchkin.
 */
public class OneShotTreasureCard extends Card {

    //----------------------------------------------------
	//			INSTANCE VARIABLES
	//----------------------------------------------------

    // The combat bonus the "one shot treasure" provides to its target (if any).
    private int combatBonus;

    // The gold value of the "one shot treasure".
    private int goldValue;

    // Whether or not the "one shot treasure" is playable in either side (i.e. you can use it on either a player or a monster).
    private boolean isEitherSidePlayable;

    //----------------------------------------------------
	//			CONSTRUCTOR(S)
	//----------------------------------------------------

    /**
     * This method constructs a "one shot treasure" in the game.
     * @param name The unique name of the card.
     * @param combatBonus The combat bonus the "one shot treasure" provides to its target (if any).
     * @param goldValue The gold value of the "one shot treasure".
     * @param isEitherSidePlayable Whether or not the "one shot treasure" is playable in either side (i.e. you can use it on either a player or a
     * monster).
     */
    public OneShotTreasureCard(String name, int combatBonus, int goldValue, boolean isEitherSidePlayable) {
        super(name, "treasure");
        this.combatBonus = combatBonus;
        this.goldValue = goldValue;
        this.isEitherSidePlayable = isEitherSidePlayable;
    }

    //----------------------------------------------------
	//			METHOD(S)
	//----------------------------------------------------

    /**
     * This method gets the combat bonus the "one shot treasure" provides to its target (if any).
     * @return The combat bonus the "one shot treasure" provides to its target (if any).
     */
    public int getCombatBonus() {
        return combatBonus;
    }

    /**
     * This method gets the gold value of the "one shot treasure".
     * @return
     */
    public int getGoldValue() {
        return goldValue;
    }

    /**
     * This method checks to see whether or not the "one shot treasure" is playable in either side (i.e. you can use it on either a player or a
     * monster.
     * @return True if the "one shot treasure" is playable in either side, false if it is not playable in either side.
     */
    public boolean checkIfEitherSidePlayableStatus() {
        return isEitherSidePlayable;
    }

} // End of OneShotTreasureCard class.