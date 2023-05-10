package treasure_cards;

import basic_game_components.Card;

/**
 * This class represents a helper card in the game of Munchkin.
 */
public class HelperCard extends Card {

    //----------------------------------------------------
    //			CONSTRUCTOR(S)
    //----------------------------------------------------

    /**
     * This method constructs a helper card in the game.
     * @param name The unique name of the card.
     */
    public HelperCard(String name) {
        super(name, "door");
    }
        

} // End oh HelperCard class.
