package door_cards;

import basic_game_components.Card;

/**
 * This class represents an "other door" card in the game of Munchkin. An "other door" card is a door card that
 * doesn't fall into the other categories of door cards (Class, Curse, Helper, Monster, MonsterEnhancer, Race). They have special
 * properties and descriptions that require a handler class.
 */
public class OtherDoorCard extends Card {

    //----------------------------------------------------
	//			CONSTRUCTOR(S)
	//----------------------------------------------------

    /**
     * This method constructs an "other door" card in the game.
     * @param name The unique name of the card.
     */
    public OtherDoorCard(String name) {
        super(name, "door");
    }
    
} // End of OtherDoorCard class.