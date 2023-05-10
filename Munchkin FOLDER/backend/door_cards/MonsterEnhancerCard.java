package door_cards;

import basic_game_components.Card;

/**
 * This class represents a monster enhancer card in the game of Munchkin.
 */
public class MonsterEnhancerCard extends Card {

    //----------------------------------------------------
	//			INSTANCE VARIABLES
	//----------------------------------------------------

    // The value of the level enhancement the monster enhancer provides to the monster.
    private int levelEnhancementValue;
    // The value of the treasure enhancement the monster modifier provides to the monster.
    private int treasureEnhancementValue;
    
    //----------------------------------------------------
	//			CONSTRUCTOR(S)
	//----------------------------------------------------
    

    /**
     * This method constructs a monster enhancer card in the game.
     * @param name The unique name of the card.
     * @param name The level enhancement value.
     * @param name The treasure enhancement value.
     */
    public MonsterEnhancerCard(String name, int levelEnhancementValue, int treasureEnhancementValue) {
		super(name, "door");
        this.levelEnhancementValue = levelEnhancementValue;
        this.treasureEnhancementValue = treasureEnhancementValue;
    }

    
    //----------------------------------------------------
	//			METHOD(S)
	//----------------------------------------------------

    /**
     * This method gets the level enhancement value provided by the monster enhancer to the monster.
     * @return The level enhancement value provided by the monster enhancer to the monster.
     */
    public int getLevelEnhancementValue() {
        return levelEnhancementValue;
    }
    
    /**
     * This method gets the treasure enhancement value provided by the monster enhancer to the monster.
     * @return The treasure enhancement value provided by the monster enhancer to the monster.
     */

    public int getTreasureEnhancementValue() {
        return treasureEnhancementValue;
    }

} // End of MonsterEnhancerCard class.
