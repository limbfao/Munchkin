package basic_game_components.player_stuff;

import basic_game_components.Die;

/**
 * This class simulates a player in the game of Munchkin.
 */
public class Player {
    //----------------------------------------------------
	//          INSTANCE VARIABLES
    //----------------------------------------------------

    // The player's turn number or turn order designation.
    private int playerTurnNumber;
    // The player's base level (1-10).
    private int level;
    // The player's sex, male or female. Represented as Strings "male" or "female".
    private String sex;
    // The player's combat bonus from equipment and modifier cards like potions, etc.
    private int combatBonus;
    // The player's run away bonus from equipment.
    private int runAwayBonus;
    // The player's current gold amount.
    private int gold;
    // The player's hand.
    private Hand hand;
    // The player's in play cards.
    private InPlayCards inPlayCards;
    // The player's die (when they are rolling it).
    private Die die;

     
    /**
     * This method constructs a Player object to simulate an individual player in the game.
     */
    public Player(int playerTurnNumber, String sex)
    {
        this.playerTurnNumber = playerTurnNumber;
        this.sex = sex;
        // The player starts at level 1 initially.
        level = 1;
        // No combat bonuses until the player equips something or is modified by a usable once card.
        combatBonus = 0;
        // No run away bonuses until the player equips something.
        runAwayBonus = 0;
        // The player has no gold at the beginning of the game.
        gold = 0;

        hand = new Hand(playerTurnNumber);
        inPlayCards = new InPlayCards(playerTurnNumber);
        die = new Die();

    } // End of constructor method.
    
    //----------------------------------------------------
	//          METHOD(S)
    //----------------------------------------------------
    
    /**
     * This method get's the player's turn order designation number.
     * @return The player's turn order designation number.
     */
    public int getPlayerTurnNumber() {
        return playerTurnNumber;
    }

    /**
     * This method get the player's level.
     * @return The player's level.
     */ 
    public int getLevel() {
        return level;
    }

    /**
     * This method is used to modify the player's level by a certain positive or negative amount, either increasing or decreasing it.
     * @param amount The amount by which to modify the player's level (positive or negative).
     */
    public void modifyLevel(int amount) {
        level += amount;
    }

    /**
     * This method sets the player's level to a new value.
     * @param level The player's new level.
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * This method gets the player's sex, "male" or "female".
     * @return The player's sex, "male" or "female".
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method changes the player's sex. It is used for the "Curse! Change Sex" card.
     */
    public void changeSex() {
        if(sex.equals("male"))
            sex = "female";
        else if (sex.equals("female"))
            sex = "male";
    }

    /**
     * This method get the player's combat bonus (from equipment and other cards).
     * @return The player's combat bonus (from equipment and other cards).
     */ 
    public int getCombatBonus() {
        return combatBonus;
    }

    /**
     * This method modifies the player's combat bonus by a positive or negative amount (the addition or removal of equipment and the use of
     * other cards).
     * @param amount The amount by which the player's combat bonus is modified (positive or negative).
     */
    public void modifyCombatBonus(int amount) {
        combatBonus += amount;
    }
    
    /**
     * This method gets the player's run away bonus (from equipment).
     * @return The player's run away bonus (from equipment).
     */ 
    public int getRunAwayBonus() {
        return runAwayBonus;
    }

    /**
     * This method modifies the player's run away bonus by a positive or negative amount (the addition or removal of equipment and the use of
     * other cards).
     * @param amount The amount by which the player's run away bonus is modified (positive or negative).
     */
    public void modifyRunAwayBonus(int amount) {
        runAwayBonus += amount;
    }

    /**
     * This method gets the player's current gold amount.    
     * @return The player's current gold amount.
     */
    public int getGold() {
        return gold;
    }

    /**
     * This method adds a certain amount of gold to the player.
     * @param amount The amount of gold to be added to the player's total gold (use positive values only).
     */
    public void addGold(int amount) {
        gold += amount;
    }

    /**
     * This method gets the player's hand (i.e. the Hand object).
     * @return The player's hand.
     */
    public Hand getHand() {
        return hand;
    }

    /**
     * This method gets the player's in play cards (i.e. the InPlayCards object).
     * @return The player's in play cards.
     */
    public InPlayCards getInPlayCards() {
        return inPlayCards;
    }

    public Die getDie() {
        return die;
    }

} // End of Player class.