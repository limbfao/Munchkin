package door_cards;

import basic_game_components.Card;

/**
 * This class represents a class card in the game of Munchkin.
 */
public class ClassCard extends Card {
    
    //----------------------------------------------------
    //			CONSTRUCTOR(S)
    //----------------------------------------------------
  
    /**
     * This method constructs a class card in the game (ex: Wizard, Warrior, etc.).
     * @param name The unique name of the card.
     */
    public ClassCard(String name) {
        super(name, "door");
    }

} // End of ClassCard class.