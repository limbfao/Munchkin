package door_cards;

import basic_game_components.Card;

/**
 * This class represents a curse card in the game of Munchkin.
 */
public class CurseCard extends Card {

    //----------------------------------------------------
	//			CONSTRUCTOR(S)
	//----------------------------------------------------

    /**
     * This method constructs a curse card in the game.
     * @param name The unique name of the card.
     */
    public CurseCard(String name) {
        super(name, "door");
    }

} // End of CurseCard class.