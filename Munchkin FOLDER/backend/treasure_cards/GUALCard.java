package treasure_cards;

import basic_game_components.Card;

/**
 * This class represents a "go up a level" card in the game of Munchkin.
 */
public class GUALCard extends Card {

    //----------------------------------------------------
	//			CONSTRUCTOR(S)
	//----------------------------------------------------

    /**
     * This method constructs a "go up a level" card in the game.
     * @param name The unique name of the card.
     */
    public GUALCard(String name) {
        super(name, "treasure");
    }

} // End of GUALCard class.