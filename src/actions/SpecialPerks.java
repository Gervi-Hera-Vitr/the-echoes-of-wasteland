package actions;

import character.PointSystem;

public enum SpecialPerks {
    PICKPOCKET("pick pocket", "Be able to steal undetected!", 5, 0, "Agility"),
    BAREHANDED("Barehanded", "Guns are for weaklings, use your fist or a hammer instead!", 10, 0, "Strength"),
    BETTERBARTERING("Better bartering", "Get something expensive for cheap just like that!", 10, 0, "Charisma"),
    CRITKING("Crit King", "Always hit crits!", 10, 0, "Perception"),
    SILVERTOUNGE("Silvertounge", "Smooth Talk everyone and there mommas!", 5, 0,"Charisma"),
    RADCHILD("Rad Children", "Survive the wasteland with RadAway!", 5, 0, "Endurance"),
    PACKMULE("Packmule", "Show off those muscles!", 5, 0, "Strength"),
    DEADEYE("Deadeye", "Hit all of your targets dead on! no more missing 5 times in a row!", 5, 0, "Perception"),
    WEALTHFINDER("Wealth finder", "Find all that the Wasteland has to offer! besides the RadRoaches.", 5, 0, "Luck"),
    TANKY("Tanky", "", 10, 0, "Endurance"),
    DODGY("Dodgy", "Enemies now have a less chance at hitting you!", 10, 0, "Agility"),
    HACKING("Hacking and cracking", "Hack all of the Computers and Break into all of your neighbors houses!", 5, 0, "Intelligence"),
    CRAFTER("Craft N Scrap", "Scrap and Craft all you want! Armor, Tools, Explosives! You name it!", 10, 0, "Intelligence"),
    SECONDCHANCE("SecondChance", "When on the edge of life and death You choose life.", 10, 0,"Luck"),;

    public final String name;
    public final String description;
    public final int levelRequirement;
    public int lvl;
    String PerkType;

    SpecialPerks(String name, String description, int levelRequirement, int lvl, String perkType ) {
        this.name = name;
        this.description = description;
        this.levelRequirement = levelRequirement;
        this.lvl = lvl;
        this.PerkType = perkType;




    }



    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getLevelRequirement() {
        return levelRequirement;
    }

    @Override
    public String toString() {
        return name + " (Level " + levelRequirement + "): " + description;
    }
}
