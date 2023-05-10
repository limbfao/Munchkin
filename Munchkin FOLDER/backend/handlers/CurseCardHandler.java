package handlers;

import basic_game_components.Card;
import basic_game_components.Die;
import basic_game_components.player_stuff.Player;
import basic_game_components.player_stuff.InPlayCards;

import door_cards.ClassCard;
import door_cards.RaceCard;
import treasure_cards.ItemCard;

import java.util.List;
import java.util.ArrayList;

public class CurseCardHandler {

    private List<Integer> bigItemLocationNumbers;



    public CurseCardHandler() {};

    //----------------------------------------------------
	//			METHOD(S)
	//----------------------------------------------------

    public void handleCurse_NoPlayerChoice(String curseCardName, Player targetPlayer, List<Player> allPlayers, List<Card> doorDiscards) {

        switch(curseCardName) {
            case "Curse! Change Class":
                changeClassCurse_Operation(targetPlayer, doorDiscards);
                return;
            case "Curse! Change Race":
                changeRaceCurse_Operation(targetPlayer, doorDiscards);
                return;
            case "Curse! Change Sex":
                changeSexCurse_Operation(targetPlayer);
                return;
            case "Curse! Chicken On Your Head":
                chickenOnYourHeadCurse_Operation(targetPlayer);
                return;
            case "Curse! Duck Of Doom":
                duckOfDoomCurse_Operation(targetPlayer);
                return;
            //case "Curse! Income Tax":                           PLAYER CHOICE
            //    return;
            //case "Curse! Lose A Big Item":                      PLAYER CHOICE
            //    return;
            case "Curse! Lose A Level":
                LoseLevelCurse_Operation(targetPlayer)
                return;
            //case "Curse! Lose A Small Item":                    PLAYER CHOICE
            //    return;
            case "Curse! Lose The Armor You Are Wearing":
                return;
            case "Curse! Lose The Footgear You Are Wearing":
                return;
            case "Curse! Lose The Headgear You Are Wearing":
                return;
            //case "Curse! Lose Two Cards":                       PLAYER CHOICE
            //    return;
            case "Curse! Lose Your Class":
                return;
            case "Curse! Lose Your Race":
                return;
            case "Curse! Malign Mirror":
                return;
            case "Truly Obnoxious Curse!":
                return;

        } // End of switch statement.

    } // End of handleCurse method.

    //------------------------------------------
    //     OPERATIONS FOR CURSES
    //     THAT DON'T INVOLVE PLAYER CHOICE...
    //------------------------------------------

    /**
     * This utility method runs the operation of the "Curse! Change Class" card. It prints a brief description of the effect that card has in the specific
     * scenario, which may vary (printing used for development and testing purposes).
     * @param targetPlayer The player targeted by the curse.
     * @param doorDiscards The door discard pile.
     * @return A brief description of the effect that card has in the specific scenario, which may vary (used for future development purposes).
     */
    private void changeClassCurse_Operation(Player targetPlayer, List<Card> doorDiscards) {

        InPlayCards inPlayCards = targetPlayer.getInPlayCards();

        int numberOfEquippedClasses = inPlayCards.getNumberOfEquippedClasses();

        // If the player doesn't have a single class card, it has no effect.
        if(numberOfEquippedClasses == 0)
            System.out.println("No effect");

        List<Card> inPlayCardsList = inPlayCards.getInPlayCardsList();
        
        // We can assume the player has at least one class card. Remove all that can be found in their in play cards.
        for(int i = 0; i < inPlayCardsList.size(); i++) {
            Card curCard = inPlayCardsList.get(i);
            if(curCard instanceof RaceCard) {
                inPlayCardsList.remove(i);
                inPlayCards.decrementNumberOfEquippedRaces();
            }

        } // End of while loop.

        // Try to find the first class card available for the replacement. We search from the last index to the first 
        // (top to bottom in this implementation).
        for(int i = doorDiscards.size() - 1; i <= 0; i--) {
             Card curCard = doorDiscards.get(i);
            if(curCard instanceof ClassCard) {
                inPlayCards.addCardToInPlayCards(curCard);
                System.out.println("All class cards removed and replaced with the first one found in the door discards");
            }

        } // End of for loop.

        System.out.println("All class cards removed but no replacement found.");

    } // End of changeClassCurse_Operation utility method.

    /**
     * This utility method runs the operation of the "Curse! Change Race" card. It prints a brief description of the effect that card has in the specific
     * scenario, which may vary (printing used for development and testing purposes).
     * @param targetPlayer The player targeted by the curse.
     * @param doorDiscards The door discard pile.
     * @return A brief description of the effect that card has in the specific scenario, which may vary (used for future development purposes).
     */
    private void changeRaceCurse_Operation(Player targetPlayer, List<Card> doorDiscards) {

        InPlayCards inPlayCards = targetPlayer.getInPlayCards();

        int numberOfEquippedRaces = inPlayCards.getNumberOfEquippedRaces();

        // If the target player doesn't have a single race card, it has no effect.
        if(numberOfEquippedRaces == 0)
        System.out.println("No effect.");

        List<Card> inPlayCardsList = inPlayCards.getInPlayCardsList();
        
        // We can assume the target player has at least one race card. Remove all that can be found in their in play cards.
        for(int i = 0; i < inPlayCardsList.size(); i++) {
            Card curCard = inPlayCardsList.get(i);
            if(curCard instanceof RaceCard) {
                inPlayCardsList.remove(i);
                inPlayCards.decrementNumberOfEquippedRaces();
            }

        } // End of while loop.

        // Try to find the first race card available for the replacement. We search from the last index to the first 
        // (top to bottom in this implementation).
        for(int i = doorDiscards.size() - 1; i <= 0; i--) {
             Card curCard = doorDiscards.get(i);
            if(curCard instanceof RaceCard) {
                inPlayCards.addCardToInPlayCards(curCard);
                System.out.println("All race cards removed and replaced with the first one found in the door discards.");
            }

        } // End of for loop.

        System.out.println("All race cards removed but no replacement found.");

    } // End of changeRaceCurse_Operation utility method.

    /**
     * This utility method runs the operation of the "Curse! Change Sex" card. It prints a brief description of the effect that card has in the specific
     * scenario, which may vary (printing used for development and testing purposes).
     * @param player The player targeted by the curse.
     * @return A brief description of the effect that card has in the specific scenario, which may vary (used for future development purposes).
     */
    private void changeSexCurse_Operation(Player targetPlayer) {

        String prevSex = targetPlayer.getSex();
        targetPlayer.changeSex();
        String newSex = targetPlayer.getSex();

        System.out.println("Player's sex changed from " + prevSex + " to " + newSex + ".");

    } // End of changeSexCurse_Operation utility method.

    /**
     * This utility method runs the operation of the "Curse! Chicken On Your Head" card. It prints a brief description of the effect that card has in the specific
     * scenario, which may vary (printing used for development and testing purposes).
     * @param player The player targeted by the curse.
     * @return A brief description of the effect that card has in the specific scenario, which may vary (used for future development purposes).
     */
    private void chickenOnYourHeadCurse_Operation(Player targetPlayer) {
        Die targetPlayerDie = targetPlayer.getDie();
        targetPlayerDie.setChickenOnYourHead_TrueOrFalse(true);
        System.out.println("Player now has a chicken on their head (-1 to all die rolls).");
    }

    /**
     * This utility method runs the operation of the "Curse! Duck Of Doom" card. It prints a brief description of the effect that card has in the specific
     * scenario, which may vary (printing used for development and testing purposes).
     * @param player The player targeted by the curse.
     * @return A brief description of the effect that card has in the specific scenario, which may vary (used for future development purposes).
     */
    private void duckOfDoomCurse_Operation(Player player) {

        int playerLevel = player.getLevel();

        if(playerLevel <= 2) {
            player.setLevel(1);
            System.out.println("Player's level was 2 or less, so it just got set to 1.");
        }

        player.modifyLevel(-2);
        System.out.println("Player's level reduced by 2.");

    } // End of duckOfDoomCurse_Operation utility method. 

    /**
     * This utility method runs the operation of the "Curse! Lose A Level" card. It prints a brief description of the effect that card has in the specific
     * scenario, which may vary (printing used for development and testing purposes).
     * @param player
     */
    private void LoseLevelCurse_Operation(Player player) {
        int playerLevel = player.getLevel();

        if(playerLevel == 1) {
            player.setLevel(1);
            System.out.println("Player is already the lowest level, 1. No effect.");
        }

        player.modifyLevel(-1);
        System.out.println("Player's level reduced by 1.");

    } // End of LoseALevelCurse_Operation utility method.

    private void LoseArmorCurse_Operation(Player player) {

    } // End of LoseArmorCurse_Operation utility method.

} // End of CurseCardHandler class.