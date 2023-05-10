package treasure_cards;

import basic_game_components.Card;

/**
 * This class represents an item card in the game of Munchkin.
 */
public class ItemCard extends Card {
    
    //----------------------------------------------------
	//			INSTANCE VARIABLES
	//----------------------------------------------------

    // The classification of the item ("weapon", "headgear", "armor", "footgear", "other").
    private String classification;

    // The combat bonus the item provides to the player (if any).
    private int combatBonus;

    // The run away bonus the item provides to the player (if any).
    private int runAwayBonus;

    // Who the item is usable by (examples: "any", "dwarf only", "female only", "not thief", etc.).
    private String usableByRequirement;

    // If the item is a weapon, whether that weapon requires 1 hand or 2 hands (possible values: 1, 2, or 0 if not a weapon).
    private int handsRequirement;

    // A boolean. If true, the item is big. If false, the item is not big (i.e. small).
    private boolean isBig;
    
    // The gold value of the item.
    private int goldValue;

    //----------------------------------------------------
	//			CONSTRUCTOR(S)
	//----------------------------------------------------

    /**
     * This method constructs an item card in the game.
     * @param name The unique name of the card.
     * @param classification The classification of the item ("weapon", "headgear", "armor", "footgear", "other").
     * @param combatBonus The combat bonus the item provides (if any).
     * @param usableByRequirement Who the item is usable by (exs: "any", "dwarf", "female").
     * @param handsRequirement If it's a weapon, whether that weapon requires 1 hand or 2 hands (possible values: 1, 2, or 0 if not a weapon).
     * @param isBig A boolean. If true, the item is big. If false, the item is not big (i.e. small).
     * @param goldValue The gold value of the item.
     */
    public ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue) {
        super(name, "treasure");
        this.classification = classification;
        this.combatBonus = combatBonus;
        this.runAwayBonus = runAwayBonus;
        this.usableByRequirement = usableByRequirement;
        this.handsRequirement = handsRequirement;
        this.isBig = isBig;
        this.goldValue = goldValue;
    }

    //----------------------------------------------------
	//			METHOD(S)
	//----------------------------------------------------

    /**
     * This method gets the item's classification ("weapon", "headgear", "armor", "footgear", or "other").
     * @return The item's classification.
     */
    public String getClassification() {
        return classification;
    }

    /**
     * This method gets the combat bonus the item provides to the player (if any).
     * @return The combat bonus the item provides to the player.
     */
    public int getCombatBonus() {
        return combatBonus;
    }

    public int getRunAwayBonus() {
        return runAwayBonus;
    }

    /**
     * This method gets the "usable by" requirement of the item (examples: "any", "dwarf", "female").
     * @return The "usable by" requirement of the item.
     */
    public String getUsableByRequirement() {
        return usableByRequirement;
    }

    /**
     * This method gets the "hands requirement" of the item, assuming it's a weapon (if the weapon requires 1 hand or 2 hands).
     * @return 1 if 1-handed weapon, 2 if 2-handed weapon, 0 if not a weapon.
     */
    public int getHandsRequirement() {
        return handsRequirement;
    }

    /**
     * This method checks to see if the item is big or small.
     * @return True if the item is big, false if the item is small.
     */
    public boolean checkIfItemIsBig() {
        return isBig;
    }

    /**
     * The method gets the gold value of the item.
     * @return The gold value of the weapon.
     */
    public int getGoldValue() {
        return goldValue;
    }

} // End of ItemCard class.