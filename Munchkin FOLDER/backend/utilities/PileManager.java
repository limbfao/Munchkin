package utilities;

import basic_game_components.Card;
import door_cards.*;
import treasure_cards.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * This class is used to manage the door and treasure piles of the game. Its operations include initializing the piles, automatically shuffling
 * them, fetching them, and resetting them.
 * 
 * IMPORTANT NOTE: We'll consider the end of each pile list (i.e. the last indices) to be the top of those piles. This is for efficient removal
 * time complexity. This will be the case after shuffling, since we instantiated the cards and added them to their piles in alphabetical order
 * so that it makes more sense upon inspecting the code for this class.
 */
public class PileManager {
    
    // List simulating the door pile.
    private List<Card> doorPile;
    // List simulating the treasure pile.
    private List<Card> treasurePile;

    public PileManager() {
        // Declare empty lists for both piles.
        doorPile = new ArrayList<Card>();
        treasurePile = new ArrayList<Card>();

        //Instantiate both piles, filling both lists with their respective cards (utility methods).
        instantiateDoorPile();
        instantiateTreasurePile();

        // Shuffle the piles.
        shufflePile(doorPile);
        shufflePile(treasurePile);

    } // End of constructor method.

    /**
     * This method gets the door pile (deck of cards containing all door cards in the game).
     * @return The door pile list.
     */
    public List<Card> getDoorPile() {
        return doorPile;
    }

    /**
     * This method is used to return the door discards to the door pile once the pile runs dry (and shuffle the cards).
     * @param doorDiscards The door discards.
     */
    public void returnDiscardsToDoorPile(List<Card> doorDiscards) {

        doorPile.addAll(doorDiscards);
        doorDiscards.clear();
        shufflePile(doorPile);

    } // End of returnDiscardsToDoorPile method.

    /**
     * This method is used to return the treasure discards to the treasure pile once the pile runs dry (and shuffle the cards).
     * @param treasureDiscards The treasure discards.
     */
    public void returnDiscardsToTreasurePile(List<Card> treasureDiscards) {
        
        treasurePile.addAll(treasureDiscards);
        treasureDiscards.clear();
        shufflePile(treasurePile);

    } // End of returnDiscardsToTreasurePile method.

    /**
     * This method gets the treasure pile (deck of cards containing all treasure cards in the game).
     * @return The treasure pile list.
     */
    public List<Card> getTreasurePile() {
        return treasurePile;
    }

    /**
     * This utility method instantiates the door pile, creating each card object that belongs to it and adding them to the door pile list.
     */
    private void instantiateDoorPile() {

        // Class constructor signatures are provided above each card creation/addition so one could identify what each value in their 
        // constructor correlates to.

        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("3,872 Orcs", 10, 3, 1, false));

        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("Amazon", 8, 2, 1, false));

        // MonsterEnhancerCard(String name, int levelEnhancementValue, int treasureEnhancementValue)
        doorPile.add(new MonsterEnhancerCard("Ancient", 10, 2));

        // MonsterEnhancerCard(String name, int levelEnhancementValue, int treasureEnhancementValue)
        doorPile.add(new MonsterEnhancerCard("Baby", -5, -1));

        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("Bigfoot", 12, 3, 1, false));

        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("Bullrog", 18, 5, 2, false));

        // OtherDoorCard(String name)
        doorPile.add(new OtherDoorCard("Cheat!"));

        // ClassCard(String name)
        doorPile.add(new ClassCard("Cleric"));

        // ClassCard(String name)
        doorPile.add(new ClassCard("Cleric"));

        // ClassCard(String name)
        doorPile.add(new ClassCard("Cleric"));

        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("Crabs", 1, 1, 1, false));
        
        // CurseCard(String name)
        doorPile.add(new CurseCard("Curse! Change Class"));

        // CurseCard(String name)
        doorPile.add(new CurseCard("Curse! Change Race"));

        // CurseCard(String name)
        doorPile.add(new CurseCard("Curse! Change Sex"));

        // CurseCard(String name)
        doorPile.add(new CurseCard("Curse! Chicken On Your Head"));

        // CurseCard(String name)
        doorPile.add(new CurseCard("Curse! Duck Of Doom"));

        // CurseCard(String name)
        doorPile.add(new CurseCard("Curse! Income Tax"));

        // CurseCard(String name)
        doorPile.add(new CurseCard("Curse! Lose A Big Item"));

        // CurseCard(String name)
        doorPile.add(new CurseCard("Curse! Lose A Level"));

        // CurseCard(String name)
        doorPile.add(new CurseCard("Curse! Lose A Level"));
        
        // CurseCard(String name)
        doorPile.add(new CurseCard("Curse! Lose A Small Item"));

        // CurseCard(String name)
        doorPile.add(new CurseCard("Curse! Lose A Small Item"));

        // CurseCard(String name)
        doorPile.add(new CurseCard("Curse! Lose The Armor You Are Wearing"));

        // CurseCard(String name)
        doorPile.add(new CurseCard("Curse! Lose The Footgear You Are Wearing"));

        // CurseCard(String name)
        doorPile.add(new CurseCard("Curse! Lose The Headgear You Are Wearing"));

        // CurseCard(String name)
        doorPile.add(new CurseCard("Curse! Lose Two Cards"));

        // CurseCard(String name)
        doorPile.add(new CurseCard("Curse! Lose Your Class"));

        // CurseCard(String name)
        doorPile.add(new CurseCard("Curse! Lose Your Race"));

        // CurseCard(String name)
        doorPile.add(new CurseCard("Curse! Malign Mirror"));

        // OtherDoorCard(String name)
        doorPile.add(new OtherDoorCard("Divine Intervention"));

        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("Drooling Slime", 1, 1, 1, false));

        // RaceCard(String name)
        doorPile.add(new RaceCard("Dwarf"));

        // RaceCard(String name)
        doorPile.add(new RaceCard("Dwarf"));

        // RaceCard(String name)
        doorPile.add(new RaceCard("Dwarf"));

        // RaceCard(String name)
        doorPile.add(new RaceCard("Elf"));

        // RaceCard(String name)
        doorPile.add(new RaceCard("Elf"));

        // RaceCard(String name)
        doorPile.add(new RaceCard("Elf"));

        // MonsterEnhancerCard(String name, int levelEnhancementValue, int treasureEnhancementValue)
        doorPile.add(new MonsterEnhancerCard("Enraged", 5, 1));

        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("Face Sucker", 8, 2, 1, false));

        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("Floating Nose", 10, 3, 1, false));

        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("Flying Frogs", 2, 1, 1, false));

        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("Gazebo", 8, 2, 1, false));

        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("Gelatinous Octahedron", 2, 1, 1, false));
        
        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("Ghoulfiends", 8, 2, 1, false));

        // OtherDoorCard(String name)
        doorPile.add(new OtherDoorCard("Half-Breed"));

        // OtherDoorCard(String name)
        doorPile.add(new OtherDoorCard("Half-Breed"));

        // RaceCard(String name)
        doorPile.add(new RaceCard("Halfling"));

        // RaceCard(String name)
        doorPile.add(new RaceCard("Halfling"));

        // RaceCard(String name)
        doorPile.add(new RaceCard("Halfling"));

        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("Harpies", 4, 2, 1, false));

        // OtherDoorCard(String name)
        doorPile.add(new OtherDoorCard("Help Me Out Here!"));

        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("Hippogriff", 16, 4, 2, false));

        // MonsterEnhancerCard(String name, int levelEnhancementValue, int treasureEnhancementValue)
        doorPile.add(new MonsterEnhancerCard("Humongous", 10, 2));
        
        // OtherDoorCard(String name)
        doorPile.add(new OtherDoorCard("Illusion"));

        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("Insurance Salesman", 14, 4, 1, false));

        // MonsterEnhancerCard(String name, int levelEnhancementValue, int treasureEnhancementValue)
        doorPile.add(new MonsterEnhancerCard("Intelligent", 5, 1));

        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("King Tut", 16, 4, 2, true));

        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("Lame Goblin", 1, 1, 1, false));

        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("Large Angry Chicken", 2, 1, 1, false));

        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("Lawyers", 6, 2, 1, false));

        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("Leperchaun", 4, 2, 5, false));

        // OtherDoorCard(String name)
        doorPile.add(new OtherDoorCard("Mate"));

        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("Maul Rat", 1, 1, 1, false));

        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("Mr. Bones", 2, 1, 1, true));

        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("Net Troll", 10, 3, 1, false));

        // OtherDoorCard(String name)
        doorPile.add(new OtherDoorCard("Out To Lunch"));

        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("Pit Bull", 2, 1, 1, false));

        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("Platycore", 6, 2, 1, false));

        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("Plutononium Dragon", 20, 5, 2, false));

        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("Potted Plant", 1, 1, 1, false));

        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("Pukachu", 6, 2, 1, false));

        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("Shrieking Geek", 6, 2, 1, false));

        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("Snails On Speed", 4, 2, 1, false));

        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("Squidzilla", 18, 4, 2, false));

        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("Stoned Golem", 14, 4, 1, false));

        // OtherDoorCard(String name)
        doorPile.add(new OtherDoorCard("Super Munchkin"));

        // OtherDoorCard(String name)
        doorPile.add(new OtherDoorCard("Super Munchkin"));

        // ClassCard(String name)
        doorPile.add(new ClassCard("Thief"));

        // ClassCard(String name)
        doorPile.add(new ClassCard("Thief"));

        // ClassCard(String name)
        doorPile.add(new ClassCard("Thief"));

        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("Tongue Demon", 12, 3, 1, false));

        // CurseCard(String name)
        doorPile.add(new CurseCard("Truly Obnoxious Curse!"));

        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("Undead Horse", 4, 2, 1, true));

        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("Unspeakable Awful Indescribable Horror", 14, 4, 1, false));

        // OtherDoorCard(String name)
        doorPile.add(new OtherDoorCard("Wandering Monster"));

        // OtherDoorCard(String name)
        doorPile.add(new OtherDoorCard("Wandering Monster"));

        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("Wannabe Vampire", 12, 3, 1, false));

        // ClassCard(String name)
        doorPile.add(new ClassCard("Warrior"));

        // ClassCard(String name)
        doorPile.add(new ClassCard("Warrior"));

        // ClassCard(String name)
        doorPile.add(new ClassCard("Warrior"));

        // MonsterCard(String name, int level, int treasureReward, int levelReward, boolean isUndead)
        doorPile.add(new MonsterCard("Wight Brothers", 16, 4, 2, true));

        // ClassCard(String name)
        doorPile.add(new ClassCard("Wizard"));

        // ClassCard(String name)
        doorPile.add(new ClassCard("Wizard"));

        // ClassCard(String name)
        doorPile.add(new ClassCard("Wizard"));

    } // End of instatiateDoorPile utility method.

    /**
     * This utility method instantiates the treasure pile, creating each card object that belongs to it and adding them to the treasure pile list.
     */
    private void instantiateTreasurePile() {

        // Class constructor signatures are provided above each card creation/addition so one could identify what each value in their constructor correlates to...

        // GUALCard(String name)
        treasurePile.add(new GUALCard("1,000 Gold Pieces"));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Bad-Ass Bandana", "headgear", 3, 0, "human only", 0, false, 400));

        // GUALCard(String name)
        treasurePile.add(new GUALCard("Boil An Anthill"));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Boots of Butt-Kicking", "footgear", 2, 0, "any", 0, false, 400));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Boots of Running Really Fast", "footgear", 0, 2, "any", 0, false, 400));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Bow With Ribbons", "weapon", 4, 0, "elf only", 2, false, 800));

        // GUALCard(String name)
        treasurePile.add(new GUALCard("Bribe GM With Food"));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Broad Sword", "weapon", 3, 0, "females only", 1, false, 400));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Buckler Of Swashing", "weapon", 2, 0, "any", 1, false, 400));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Chainsaw Of Bloody Dismemberment", "weapon", 3, 0, "any", 2, true, 600));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Cheese Grater of Peace", "weapon", 3, 0, "cleric only", 1, false, 400));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Cloak Of Obscurity", "other", 4, 0, "thief only", 0, false, 600));

        // GUALCard(String name)
        treasurePile.add(new GUALCard("Convenient Addition Error"));

        // OneShotTreasureCard(String name, int combatBonus, int goldValue, boolean isEitherSidePlayable)
        treasurePile.add(new OneShotTreasureCard("Cotion Of Ponfusion", 3, 100, true));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Dagger Of Treachery", "weapon", 3, 0, "thief only", 1, false, 400));

        // OneShotTreasureCard(String name, int combatBonus, int goldValue, boolean isEitherSidePlayable)
        treasurePile.add(new OneShotTreasureCard("Doppleganger", 0, 300, false));

        // OneShotTreasureCard(String name, int combatBonus, int goldValue, boolean isEitherSidePlayable)
        treasurePile.add(new OneShotTreasureCard("Electric Radioactive Acid Potion", 5, 200, true));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Eleven-Foot Pole", "weapon", 1, 0, "any", 2, false, 200));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Flaming Armor", "armor", 2, 0 ,"any", 0, false, 400));

        // OneShotTreasureCard(String name, int combatBonus, int goldValue, boolean isEitherSidePlayable)
        treasurePile.add(new OneShotTreasureCard("Flaming Poison Potion", 3, 100, true));

        // OneShotTreasureCard(String name, int combatBonus, int goldValue, boolean isEitherSidePlayable)
        treasurePile.add(new OneShotTreasureCard("Flask Of Glue", 0, 100, false));

        // OneShotTreasureCard(String name, int combatBonus, int goldValue, boolean isEitherSidePlayable)
        treasurePile.add(new OneShotTreasureCard("Freezing Explosive Potion", 3, 100, true));

        // OneShotTreasureCard(String name, int combatBonus, int goldValue, boolean isEitherSidePlayable)
        treasurePile.add(new OneShotTreasureCard("Friendship Potion", 0, 200, false));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Gentleman's Club", "weapon", 3, 0, "males only", 1, false, 400));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Helm Of Courage", "headgear", 1, 0, "any", 0, false, 200));

        // HelperCard(String name)
        treasurePile.add(new HelperCard("Hireling"));

        // OneShotTreasureCard(String name, int combatBonus, int goldValue, boolean isEitherSidePlayable)
        treasurePile.add(new OneShotTreasureCard("Hoard!", 0, 200, false));

        // OneShotTreasureCard(String name, int combatBonus, int goldValue, boolean isEitherSidePlayable)
        treasurePile.add(new OneShotTreasureCard("Hoard!", 0, 200, false));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Horny Helmet", "headgear", 1, 0, "any", 0, false, 600));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Huge Rock", "weapon", 3, 0, "any", 2, true, 0));

        // OneShotTreasureCard(String name, int combatBonus, int goldValue, boolean isEitherSidePlayable)
        treasurePile.add(new OneShotTreasureCard("Instant Wall", 0, 300, false));

        // OneShotTreasureCard(String name, int combatBonus, int goldValue, boolean isEitherSidePlayable)
        treasurePile.add(new OneShotTreasureCard("Invisibility Potion", 0, 200, false));

        // GUALCard(String name)
        treasurePile.add(new GUALCard("Invoke Obscure Rules"));

        // GUALCard(String name)
        treasurePile.add(new GUALCard("Kill The Hireling"));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Kneepads Of Allure", "other", 0, 0, "not clerics", 0, false, 600));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Leather Armor", "armor", 1, 0, "any", 0, false, 200));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Limburger And Anchovy Sandwich", "other", 3, 0, "halfling only", 0, false, 400));

        // OneShotTreasureCard(String name, int combatBonus, int goldValue, boolean isEitherSidePlayable)
        treasurePile.add(new OneShotTreasureCard("Loaded Die", 0, 300, false));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Mace Of Sharpness", "weapon", 4, 0, "cleric only", 1, false, 600));

        // OneShotTreasureCard(String name, int combatBonus, int goldValue, boolean isEitherSidePlayable)
        treasurePile.add(new OneShotTreasureCard("Magic Lamp", 0, 500, false));

        // OneShotTreasureCard(String name, int combatBonus, int goldValue, boolean isEitherSidePlayable)
        treasurePile.add(new OneShotTreasureCard("Magic Lamp", 0, 500, false));

        // OneShotTreasureCard(String name, int combatBonus, int goldValue, boolean isEitherSidePlayable)
        treasurePile.add(new OneShotTreasureCard("Magic Missile", 5, 300, true));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Mithril Armor", "armor", 3, 0, "not wizard", 0, true, 600));

        // GUALCard(String name)
        treasurePile.add(new GUALCard("Mutilate The Bodies"));

        // OneShotTreasureCard(String name, int combatBonus, int goldValue, boolean isEitherSidePlayable)
        treasurePile.add(new OneShotTreasureCard("Nasty-Tasting Sports Drink", 2, 200, true));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Pantyhouse Of Giant Strength", "other", 3, 0, "not warrior", 0, false, 600));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Pointy Hat Of Power", "heargear", 3, 0, "wizard only", 0, false, 400));

        // OneShotTreasureCard(String name, int combatBonus, int goldValue, boolean isEitherSidePlayable)
        treasurePile.add(new OneShotTreasureCard("Polymorph Potion", 0, 1300, false));

        // GUALCard(String name)
        treasurePile.add(new GUALCard("Potion of General Studliness"));
        
        // OneShotTreasureCard(String name, int combatBonus, int goldValue, boolean isEitherSidePlayable)
        treasurePile.add(new OneShotTreasureCard("Potion of Halitosis", 2, 100, true));

        // OneShotTreasureCard(String name, int combatBonus, int goldValue, boolean isEitherSidePlayable)
        treasurePile.add(new OneShotTreasureCard("Potion of Idiotic Bravery", 2, 100, true));

        // OneShotTreasureCard(String name, int combatBonus, int goldValue, boolean isEitherSidePlayable)
        treasurePile.add(new OneShotTreasureCard("Pretty Balloons", 5, 0, true));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Rapier of Unfairness", "weapon", 3, 0, "elf only", 1, false, 600));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Rat on a Stick", "weapon", 1, 0, "any", 1, false, 0));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Really Impressive Title", "other", 3, 0, "any", 0, false, 0));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Sandals Of Protection", "footgear", 0, 0, "any", 0, false, 700));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Shield of Ubiquity", "weapon", 4, 0, "warrior only", 1, true, 600));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Short Wide Armor", "armor", 3, 0, "dwarf only", 0, false, 400));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Singing & Danching Sword", "other", 2, 0, "not thief", 0, false, 400));

        // OneShotTreasureCard(String name, int combatBonus, int goldValue, boolean isEitherSidePlayable)
        treasurePile.add(new OneShotTreasureCard("Sleep Potion", 2, 100, true));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Slimy Armor", "armor", 1, 0, "any", 0, false, 200));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Sneaky Bastard Sword", "weapon", 2, 0, "any", 1, false, 400));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Spiky Knees", "other", 1, 0, "any", 0, false, 200));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Staff Of Napalm", "weapon", 5, 0, "wizard only", 1, false, 800));

        // OneShotTreasureCard(String name, int combatBonus, int goldValue, boolean isEitherSidePlayable)
        treasurePile.add(new OneShotTreasureCard("Steal A Level", 0, 0, false));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Stepladder", "other", 3, 0, "halfling only", 0, true, 400));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Swiss Army Polearm", "weapon", 4, 0, "human only", 2, true, 600));

        // OneShotTreasureCard(String name, int combatBonus, int goldValue, boolean isEitherSidePlayable)
        treasurePile.add(new OneShotTreasureCard("Transferral Potion", 0, 0, false));

        // ItemCard(String name, String classification, int combatBonus, int runAwayBonus, String usableByRequirement, int handsRequirement, boolean isBig, int goldValue)
        treasurePile.add(new ItemCard("Tuba Of Charm", "weapon", 0, 3, "any", 1, true, 300));

        // OneShotTreasureCard(String name, int combatBonus, int goldValue, boolean isEitherSidePlayable)
        treasurePile.add(new OneShotTreasureCard("Wand Of Dowsing", 0, 1100, false));

        // GUALCard(String name)
        treasurePile.add(new GUALCard("Whine At The GM"));

        // OneShotTreasureCard(String name, int combatBonus, int goldValue, boolean isEitherSidePlayable)
        treasurePile.add(new OneShotTreasureCard("Wishing Ring", 0, 500, false));

        // OneShotTreasureCard(String name, int combatBonus, int goldValue, boolean isEitherSidePlayable)
        treasurePile.add(new OneShotTreasureCard("Wishing Ring", 0, 500, false));

        // OneShotTreasureCard(String name, int combatBonus, int goldValue, boolean isEitherSidePlayable)
        treasurePile.add(new OneShotTreasureCard("Yuppie Water", 2, 100, false));

    } // End of instatiateTreasurePile utility method.

    /**
     * This utility method is used to shuffle a given pile when necessary in the previous methods.
     * @param pile The pile, door or treasure.
     */
    private void shufflePile(List<Card> pile) {
        Collections.shuffle(Arrays.asList(pile));
    }

} // End of PileGenerator class.
