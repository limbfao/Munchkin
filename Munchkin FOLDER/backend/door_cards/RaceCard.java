package door_cards;

import basic_game_components.Card;

/**
 * This class represents a race card in the game of Munchkin.
 */
public class RaceCard extends Card {
    
    //----------------------------------------------------
	  //			    CONSTRUCTOR(S)
	  //----------------------------------------------------
    
    /**
     * This method constructs a race card in the game (ex: Elf, Dwarf, etc.).
     * @param name The unique name of the card.
     */
    public RaceCard(String name) {
		  super(name, "door");   
    }
    

} // End of RaceCard class.