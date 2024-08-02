package actions;

import character.PointSystem;

public enum SpecialPerks {
    PICKPOCKET("pick pocket", "Be able to steal undetected!", 5, 0),
    BAREHANDED("Barehanded", "Guns are for weaklings, use your fist or a hammer instead!", 5, 0),
    BETTERBARTERING("Better bartering", "Get something expensive for cheap just like that!", 5, 0),
    CRITKING("Crit King", "Always hit crits!", 5, 0),
    SILVERTOUNGE("Silvertounge", "Smooth Talk everyone and there mommas!", 5, 0),
    RADCHILD("Rad Children", "cool", 5, 0),
    PACKMULE("Packmule", "cool", 5, 0),
    DEADEYE("Deadeye", "cool", 5, 0),
    WEALTHFINDER("Wealth finder", "cool", 5, 0),
    TANKY("Tanky", "", 5, 0),
    DODGY("Dodgy", "Enemies now have a less chance at hitting you!", 5, 0),
    HACKING("Hacking", "cool", 5, 0),
    CRAFTER("Crafter", "cool", 5, 0),
    SECONDCHANCE("SecondChance", "cool", 5, 0),;

    public final String name;
    public final String description;
    public final int levelRequirement;
    public int lvl;

    SpecialPerks(String name, String description, int levelRequirement, int lvl) {
        this.name = name;
        this.description = description;
        this.levelRequirement = levelRequirement;
        this.lvl = lvl;

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
